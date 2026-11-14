package com.projetoconfeitaria.sistemagestao.controller;

import com.projetoconfeitaria.sistemagestao.model.Usuario;
import com.projetoconfeitaria.sistemagestao.repository.UsuarioRepository;
import com.projetoconfeitaria.sistemagestao.security.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "*")
public class AuthController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private PasswordEncoder passwordEncoder; // Criptografia

    @Autowired
    private JwtUtil jwtUtil;

    // ROTA 1: LOGIN REAL NO BANCO
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Map<String, String> credentials) {
        String login = credentials.get("login");
        String senha = credentials.get("senha");

        Optional<Usuario> userOpt = usuarioRepository.findByLogin(login);

        // Se achou o usuário E a senha criptografada bate com a digitada
        if (userOpt.isPresent() && passwordEncoder.matches(senha, userOpt.get().getSenha())) {
            String token = jwtUtil.generateToken(login);
            return ResponseEntity.ok(Map.of(
                "token", token, 
                "nome", userOpt.get().getNome(),
                "mensagem", "Login efetuado com sucesso!"
            ));
        }

        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(Map.of("erro", "Usuário ou senha inválidos!"));
    }

    // ROTA 2: CRIAR NOVA CONTA
    @PostMapping("/cadastro")
    public ResponseEntity<?> cadastrar(@RequestBody Usuario novoUsuario) {
        if (usuarioRepository.findByLogin(novoUsuario.getLogin()).isPresent()) {
            return ResponseEntity.badRequest().body(Map.of("erro", "Este login já está em uso!"));
        }

        // Criptografa a senha antes de salvar
        novoUsuario.setSenha(passwordEncoder.encode(novoUsuario.getSenha()));
        usuarioRepository.save(novoUsuario);

        return ResponseEntity.status(HttpStatus.CREATED).body(Map.of("mensagem", "Usuário cadastrado com sucesso!"));
    }
}
package com.projetoconfeitaria.sistemagestao.repository;

import com.projetoconfeitaria.sistemagestao.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    Optional<Usuario> findByLogin(String login); // Método mágico para buscar pelo login
}
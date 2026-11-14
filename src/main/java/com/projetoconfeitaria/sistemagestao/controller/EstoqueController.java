package com.projetoconfeitaria.sistemagestao.controller;

import com.projetoconfeitaria.sistemagestao.model.Estoque;
import com.projetoconfeitaria.sistemagestao.service.EstoqueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/estoque")
@CrossOrigin(origins = "*")
public class EstoqueController {

    @Autowired
    private EstoqueService service;

    @GetMapping
    public ResponseEntity<List<Estoque>> listar() {
        return ResponseEntity.ok(service.listarTodos());
    }

    @PostMapping
    public ResponseEntity<Estoque> criar(@RequestBody Estoque item) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.salvar(item));
    }

    // NOVA ROTA: Buscar por ID
    @GetMapping("/{id}")
    public ResponseEntity<Estoque> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(service.buscarPorId(id));
    }

    // NOVA ROTA: Atualizar
    @PutMapping("/{id}")
    public ResponseEntity<Estoque> atualizar(@PathVariable Long id, @RequestBody Estoque item) {
        return ResponseEntity.ok(service.atualizar(id, item));
    }

    // NOVA ROTA: Excluir
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable Long id) {
        service.excluir(id);
        return ResponseEntity.noContent().build();
    }
}
package com.projetoconfeitaria.sistemagestao.service;

import com.projetoconfeitaria.sistemagestao.model.Cliente;
import com.projetoconfeitaria.sistemagestao.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository repository;

    public List<Cliente> listarTodos() {
        return repository.findAll();
    }

    public Cliente salvar(Cliente cliente) {
        return repository.save(cliente);
    }

    // NOVO: Busca apenas um cliente pelo ID (para carregar na tela de edição)
    public Cliente buscarPorId(Long id) {
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Cliente não encontrado"));
    }

    // NOVO: Atualiza um cliente existente
    public Cliente atualizar(Long id, Cliente clienteAtualizado) {
        Cliente clienteExistente = buscarPorId(id);
        clienteExistente.setNome(clienteAtualizado.getNome());
        clienteExistente.setTelefone(clienteAtualizado.getTelefone());
        clienteExistente.setEndereco(clienteAtualizado.getEndereco());
        return repository.save(clienteExistente);
    }

    // NOVO: Exclui o cliente do banco de dados
    public void excluir(Long id) {
        repository.deleteById(id);
    }
}
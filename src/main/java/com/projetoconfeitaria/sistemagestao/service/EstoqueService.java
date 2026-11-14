package com.projetoconfeitaria.sistemagestao.service;

import com.projetoconfeitaria.sistemagestao.model.Estoque;
import com.projetoconfeitaria.sistemagestao.repository.EstoqueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class EstoqueService {

    @Autowired
    private EstoqueRepository repository;

    public List<Estoque> listarTodos() {
        return repository.findAll();
    }

    public Estoque salvar(Estoque item) {
        return repository.save(item);
    }

    // NOVO: Busca um ingrediente específico
    public Estoque buscarPorId(Long id) {
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Item não encontrado"));
    }

    // NOVO: Atualiza os dados (quantidade, preço, etc)
    public Estoque atualizar(Long id, Estoque estoqueAtualizado) {
        Estoque existente = buscarPorId(id);
        existente.setNome(estoqueAtualizado.getNome());
        existente.setUnidadeMedida(estoqueAtualizado.getUnidadeMedida());
        existente.setQuantidadeAtual(estoqueAtualizado.getQuantidadeAtual());
        existente.setCustoUnitario(estoqueAtualizado.getCustoUnitario());
        return repository.save(existente);
    }

    // NOVO: Exclui um ingrediente da despensa
    public void excluir(Long id) {
        repository.deleteById(id);
    }
}
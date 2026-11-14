package com.projetoconfeitaria.sistemagestao.service;

import com.projetoconfeitaria.sistemagestao.model.Produto;
import com.projetoconfeitaria.sistemagestao.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository repository;

    public List<Produto> listarTodos() {
        return repository.findAll();
    }

    public Produto salvar(Produto produto) {
        return repository.save(produto);
    }

    // NOVO: Busca um produto específico
    public Produto buscarPorId(Long id) {
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Produto não encontrado"));
    }

    // NOVO: Atualiza os dados do doce
    public Produto atualizar(Long id, Produto produtoAtualizado) {
        Produto produtoExistente = buscarPorId(id);
        produtoExistente.setNome(produtoAtualizado.getNome());
        produtoExistente.setDescricao(produtoAtualizado.getDescricao());
        produtoExistente.setUnidadeMedida(produtoAtualizado.getUnidadeMedida());
        produtoExistente.setPreco(produtoAtualizado.getPreco());
        return repository.save(produtoExistente);
    }

    // NOVO: Exclui o doce do catálogo
    public void excluir(Long id) {
        repository.deleteById(id);
    }
}
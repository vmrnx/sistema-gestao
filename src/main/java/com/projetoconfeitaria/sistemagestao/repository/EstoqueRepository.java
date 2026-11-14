package com.projetoconfeitaria.sistemagestao.repository;

import com.projetoconfeitaria.sistemagestao.model.Estoque;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstoqueRepository extends JpaRepository<Estoque, Long> {
}
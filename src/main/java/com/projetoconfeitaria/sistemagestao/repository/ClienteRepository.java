package com.projetoconfeitaria.sistemagestao.repository;

import com.projetoconfeitaria.sistemagestao.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    // Você pode criar buscas personalizadas aqui no futuro, ex: buscar por nome
}
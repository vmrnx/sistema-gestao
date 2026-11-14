package com.projetoconfeitaria.sistemagestao.model;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Data // O Lombok já cria os Getters e Setters por trás dos panos
@Entity
@Table(name = "clientes")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCliente;

    @Column(nullable = false, length = 100)
    private String nome;

    @Column(nullable = false, length = 20)
    private String telefone;

    @Column(columnDefinition = "TEXT")
    private String endereco;

    @Column(name = "data_cadastro", updatable = false)
    private LocalDateTime dataCadastro;

    @Column(columnDefinition = "boolean default true")
    private Boolean ativo = true;

    @PrePersist
    protected void onCreate() {
        this.dataCadastro = LocalDateTime.now();
    }
}
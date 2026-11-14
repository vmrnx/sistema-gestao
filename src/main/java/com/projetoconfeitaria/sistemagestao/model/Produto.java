package com.projetoconfeitaria.sistemagestao.model;

import jakarta.persistence.*;
import lombok.Data;
import java.math.BigDecimal;

@Data
@Entity
@Table(name = "produtos")
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idProduto;

    @Column(nullable = false, length = 100)
    private String nome;

    @Column(columnDefinition = "TEXT")
    private String descricao;

    @Column(name = "unidade_medida", nullable = false, length = 20)
    private String unidadeMedida; 
    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal preco; 

    @Column(columnDefinition = "boolean default true")
    private Boolean ativo = true;
}
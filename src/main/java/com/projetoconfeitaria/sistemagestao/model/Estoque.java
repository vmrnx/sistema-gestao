package com.projetoconfeitaria.sistemagestao.model;

import jakarta.persistence.*;
import lombok.Data;
import java.math.BigDecimal;

@Data
@Entity
@Table(name = "estoque")
public class Estoque {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idItem;

    @Column(nullable = false, length = 100)
    private String nome; // Ex: Leite Condensado, Farinha, Embalagem

    @Column(name = "unidade_medida", nullable = false, length = 20)
    private String unidadeMedida; // Ex: g, Kg, L, Unidade

    @Column(name = "quantidade_atual", precision = 10, scale = 3)
    private BigDecimal quantidadeAtual = BigDecimal.ZERO;
    
    @Column(name = "custo_unitario", precision = 10, scale = 2)
    private BigDecimal custoUnitario = BigDecimal.ZERO; 
}
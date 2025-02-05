package com.rspoint.rspoint.model;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name="folha_ponto")
public class FolhaPonto {
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id; 

    @ManyToOne
    @JoinColumn(name="funcionario_id", nullable=false)
    private Funcionario funcionario; 

    @Column(nullable=false)
    private Integer mes; 

    @Column(nullable=false)
    private Integer ano; 

    @Column(name="total_horas_trabalhadas")
    private BigDecimal totalHorasTrabalhadas; 

    @Column(name="total_horas_extras")
    private BigDecimal totalHorasExtras;

}

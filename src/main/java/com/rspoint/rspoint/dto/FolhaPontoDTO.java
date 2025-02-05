package com.rspoint.rspoint.dto;

import java.math.BigDecimal;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class FolhaPontoDTO {
    @NotNull(message = "ID do funcionário é obrigatório")
    private Long funcionarioId;
    
    @NotNull(message = "Mês é obrigatório")
    @Min(value = 1, message = "O mês deve ser no mínimo 1")
    @Max(value = 12, message = "O mês deve ser no máximo 12")
    private Integer mes;
    
    @NotNull(message = "Ano é obrigatório")
    @Min(value = 2024, message = "O ano deve ser no mínimo 2024")
    private Integer ano;
    
    @NotNull(message = "Total de horas trabalhadas é obrigatório")
    private BigDecimal totalHorasTrabalhadas;
    
    @NotNull(message = "Total de horas extras é obrigatório")
    private BigDecimal totalHorasExtras;
}
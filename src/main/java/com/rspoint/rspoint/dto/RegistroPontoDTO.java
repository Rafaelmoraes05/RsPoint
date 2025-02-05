package com.rspoint.rspoint.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class RegistroPontoDTO {
    @NotNull(message = "ID do funcionário é obrigatório")
    private Long funcionarioId;
    
    @NotNull(message = "Tipo de registro é obrigatório")
    private String tipoRegistro;
    
    private Double latitude;
    private Double longitude;
}
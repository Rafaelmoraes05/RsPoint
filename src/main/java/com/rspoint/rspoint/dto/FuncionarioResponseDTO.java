package com.rspoint.rspoint.dto;

import java.time.LocalDate;

import lombok.Data;

@Data
public class FuncionarioResponseDTO {

    private Long id;
    private String nome;
    private String cpf;
    private String email;
    private String cargo;
    private LocalDate dataAdmissao;
    private String status;

}

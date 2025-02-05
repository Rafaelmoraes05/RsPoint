package com.rspoint.rspoint.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rspoint.rspoint.model.Funcionario;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {
    boolean existsByCpf(String cpf);
    boolean existsByEmail(String email);
}
package com.rspoint.rspoint.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.rspoint.rspoint.dto.FuncionarioDTO;
import com.rspoint.rspoint.dto.FuncionarioResponseDTO;
import com.rspoint.rspoint.model.Funcionario;
import com.rspoint.rspoint.repository.FuncionarioRepository;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@RequiredArgsConstructor
public class FuncionarioService {
    private final FuncionarioRepository repository;

    public Funcionario salvar(FuncionarioDTO dto) {
        if (repository.existsByCpf(dto.getCpf())) {
            throw new IllegalArgumentException("CPF já cadastrado");
        }
        if (repository.existsByEmail(dto.getEmail())) {
            throw new IllegalArgumentException("Email já cadastrado");
        }
        
        Funcionario funcionario = new Funcionario();
        funcionario.setNome(dto.getNome());
        funcionario.setCpf(dto.getCpf());
        funcionario.setEmail(dto.getEmail());
        funcionario.setCargo(dto.getCargo());
        funcionario.setDataAdmissao(dto.getDataAdmissao());
        
        return repository.save(funcionario);
    }

    public List<FuncionarioResponseDTO> listarTodos() {
        return repository.findAll().stream()
            .map(this::toDTO)
            .collect(Collectors.toList());
    }

    public Funcionario buscarPorId(Long id) {
        return repository.findById(id)
            .orElseThrow(() -> new EntityNotFoundException("Funcionário não encontrado"));
    }

    private FuncionarioResponseDTO toDTO(Funcionario funcionario) {
        FuncionarioResponseDTO dto = new FuncionarioResponseDTO();
        dto.setId(funcionario.getId());
        dto.setNome(funcionario.getNome());
        dto.setCpf(funcionario.getCpf());
        dto.setEmail(funcionario.getEmail());
        dto.setCargo(funcionario.getCargo());
        dto.setDataAdmissao(funcionario.getDataAdmissao());
        dto.setStatus(funcionario.getStatus().toString());
        return dto;
    }
}
package com.rspoint.rspoint.service;

import org.springframework.stereotype.Service;

import com.rspoint.rspoint.dto.FolhaPontoDTO;
import com.rspoint.rspoint.model.FolhaPonto;
import com.rspoint.rspoint.repository.FolhaPontoRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class FolhaPontoService {
    private final FolhaPontoRepository repository;
    private final FuncionarioService funcionarioService;

    public FolhaPonto gerarFolha(FolhaPontoDTO dto) {
        FolhaPonto folha = new FolhaPonto();
        folha.setFuncionario(funcionarioService.buscarPorId(dto.getFuncionarioId()));
        folha.setMes(dto.getMes());
        folha.setAno(dto.getAno());
        folha.setTotalHorasTrabalhadas(dto.getTotalHorasTrabalhadas());
        folha.setTotalHorasExtras(dto.getTotalHorasExtras());
        
        return repository.save(folha);
    }
}
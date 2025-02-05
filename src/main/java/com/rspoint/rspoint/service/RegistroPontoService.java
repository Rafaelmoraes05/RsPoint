package com.rspoint.rspoint.service;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;

import com.rspoint.rspoint.dto.RegistroPontoDTO;
import com.rspoint.rspoint.model.RegistroPonto;
import com.rspoint.rspoint.model.TipoRegistro;
import com.rspoint.rspoint.repository.RegistroPontoRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class RegistroPontoService {
   private final RegistroPontoRepository repository;
   private final FuncionarioService funcionarioService;

   public RegistroPonto registrarPonto(RegistroPontoDTO dto) {
       RegistroPonto registro = new RegistroPonto();
       registro.setFuncionario(funcionarioService.buscarPorId(dto.getFuncionarioId()));
       registro.setDataRegistro(LocalDateTime.now());
       registro.setTipoRegistro(TipoRegistro.valueOf(dto.getTipoRegistro()));
       registro.setLatitude(dto.getLatitude());
       registro.setLongitude(dto.getLongitude());
       
       return repository.save(registro);
   }
}
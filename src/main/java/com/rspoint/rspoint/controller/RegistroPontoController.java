package com.rspoint.rspoint.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rspoint.rspoint.dto.RegistroPontoDTO;
import com.rspoint.rspoint.model.RegistroPonto;
import com.rspoint.rspoint.service.RegistroPontoService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/pontos")
@RequiredArgsConstructor
public class RegistroPontoController {
    private final RegistroPontoService service;

    @PostMapping("/registrar")
    public ResponseEntity<RegistroPonto> registrar(@Valid @RequestBody RegistroPontoDTO dto) {
        return ResponseEntity.ok(service.registrarPonto(dto));
    }
}
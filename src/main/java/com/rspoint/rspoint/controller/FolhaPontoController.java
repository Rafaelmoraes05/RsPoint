package com.rspoint.rspoint.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rspoint.rspoint.dto.FolhaPontoDTO;
import com.rspoint.rspoint.model.FolhaPonto;
import com.rspoint.rspoint.service.FolhaPontoService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/folhas")
@RequiredArgsConstructor
public class FolhaPontoController {
    private final FolhaPontoService service;

    @PostMapping("/gerar")
    public ResponseEntity<FolhaPonto> gerar(@Valid @RequestBody FolhaPontoDTO dto) {
        return ResponseEntity.ok(service.gerarFolha(dto));
    }
}
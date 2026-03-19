package com.naturagarden.controller;

import com.naturagarden.dto.ApiResponse;
import com.naturagarden.dto.PlantaCreateDTO;
import com.naturagarden.dto.PlantaResponseDTO;
import com.naturagarden.dto.PlantaUpdateDTO;
import com.naturagarden.service.PlantaService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.UUID;

@RestController
    @RequestMapping("/plantas")
    @RequiredArgsConstructor
    public class PlantaController {

        private final PlantaService plantaService;

        @PostMapping
        public ResponseEntity<ApiResponse<PlantaResponseDTO>> criar(@RequestBody @Valid PlantaCreateDTO dto) {
            PlantaResponseDTO planta = plantaService.criar(dto);
            ApiResponse<PlantaResponseDTO> response = ApiResponse.<PlantaResponseDTO>builder()
                    .success(true)
                    .message("Planta criada com sucesso")
                    .data(planta)
                    .timestamp(LocalDateTime.now())
                    .build();

            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body(response);
        }

        @GetMapping
        public ResponseEntity<Page<PlantaResponseDTO>> listar(Pageable pageable) {
            Page<PlantaResponseDTO> plantas = plantaService.listar(pageable);
            return ResponseEntity.ok(plantas);
        }

        @GetMapping("/{id}")
        public ResponseEntity<PlantaResponseDTO> buscarPorId(@PathVariable UUID id) {
            PlantaResponseDTO planta = plantaService.buscarPorId(id);
            return ResponseEntity.ok(planta);
        }

        @PutMapping("/{id}")
        public ResponseEntity<PlantaResponseDTO> atualizar(@PathVariable UUID id, @RequestBody @Valid PlantaUpdateDTO dto){
            PlantaResponseDTO planta = plantaService.atualizar(id, dto);
            return ResponseEntity.ok(planta);
        }

        @DeleteMapping("/{id}")
        public ResponseEntity<Void> deletar(@PathVariable UUID id) {
           plantaService.deletar(id);
            return ResponseEntity.noContent().build();
        }
    }


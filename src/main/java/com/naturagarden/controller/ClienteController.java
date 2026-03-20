package com.naturagarden.controller;

import com.naturagarden.dto.ClienteCreateDTO;
import com.naturagarden.dto.ClienteResponseDTO;
import com.naturagarden.dto.ClienteUpdateDTO;
import com.naturagarden.service.ClienteService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/clientes")
@RequiredArgsConstructor
public class ClienteController {
    private final ClienteService clienteService;

    @PostMapping
    public ResponseEntity<ClienteResponseDTO> criar(@RequestBody @Valid ClienteCreateDTO dto){
        ClienteResponseDTO response = clienteService.criar(dto);
        return ResponseEntity.ok(response);
    }

    @GetMapping
    public ResponseEntity<Page<ClienteResponseDTO>> listar(Pageable pageable) {
        Page<ClienteResponseDTO> clientes = clienteService.listar(pageable)
                .map(clienteService::toResponseDTO);
        return ResponseEntity.ok(clientes);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClienteResponseDTO> buscarPorId(@PathVariable UUID id) {
        ClienteResponseDTO response =  clienteService.toResponseDTO(clienteService.buscarPorId(id));
        return ResponseEntity.ok(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ClienteResponseDTO> atualizar(@PathVariable UUID id, @RequestBody @Valid ClienteUpdateDTO dto) {
        ClienteResponseDTO response = clienteService.atualizar(id,dto);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public  ResponseEntity<Void> deletar(@PathVariable UUID id){
        clienteService.deletarCliente(id);
        return ResponseEntity.noContent().build();
    }
}

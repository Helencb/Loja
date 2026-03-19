package com.naturagarden.service;

import com.naturagarden.dto.ClienteCreateDTO;
import com.naturagarden.dto.ClienteResponseDTO;
import com.naturagarden.model.Cliente;
import com.naturagarden.repository.ClienteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.UUID;
@Service
@RequiredArgsConstructor
public class ClienteService extends BaseService<Cliente, UUID> {
    private final ClienteRepository clienteRepository;

    public ResponseEntity<ClienteResponseDTO> criar(ClienteCreateDTO dto) {
        clienteRepository.findByEmail(dto.email())
                .ifPresent(c -> {
                    throw new RuntimeException("Email já cadastrado");
                });
        clienteRepository.findByCpf(dto.cpf())
                .isPresent(c -> {
                    throw new RuntimeException("CPF já cadastrado");
                })
    }
}

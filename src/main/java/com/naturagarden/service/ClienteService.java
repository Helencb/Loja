package com.naturagarden.service;

import com.naturagarden.dto.ClienteCreateDTO;
import com.naturagarden.dto.ClienteResponseDTO;
import com.naturagarden.dto.ClienteUpdateDTO;
import com.naturagarden.mapper.ClienteMapper;
import com.naturagarden.model.Cliente;
import com.naturagarden.repository.ClienteRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class ClienteService extends BaseService<Cliente> {
    private final ClienteRepository clienteRepository;
    private final ClienteMapper clienteMapper;

    public ClienteService(ClienteRepository clienteRepository, ClienteMapper clienteMapper) {
        super(clienteRepository);
        this.clienteRepository = clienteRepository;
        this.clienteMapper = clienteMapper;
    }

    public ClienteResponseDTO toResponseDTO(Cliente cliente) {
        return clienteMapper.toResponseDTO(cliente);
    }

    public ClienteResponseDTO criar(ClienteCreateDTO dto) {
        clienteRepository.findByEmail(dto.email())
                .ifPresent(c -> {
                    throw new RuntimeException("Email já cadastrado");
                });
        clienteRepository.findByCpf(dto.cpf())
                .ifPresent(c -> {
                    throw new RuntimeException("CPF já cadastrado");
                });
        Cliente cliente = clienteMapper.toEntity(dto);
        Cliente salvo = salvar(cliente);
        return clienteMapper.toResponseDTO(salvo);
    }

    public ClienteResponseDTO atualizar(UUID id, ClienteUpdateDTO dto){
        Cliente cliente = buscarPorId(id);
        clienteMapper.updateEntity(dto,cliente);
        Cliente atualizado = salvar(cliente);
        return clienteMapper.toResponseDTO(atualizado);
    }

    public void deletarCliente(UUID id) {
       deletar(id);
    }
}

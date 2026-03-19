package com.naturagarden.repository;

import com.naturagarden.model.Cliente;

import java.util.Optional;
import java.util.UUID;

public interface ClienteRepository extends BaseRepository<Cliente, UUID> {
    Optional<Cliente> findByEmail(String Email);
    Optional<Cliente> findByCpf(String Cpf);
}

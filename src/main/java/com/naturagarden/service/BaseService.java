package com.naturagarden.service;

import com.naturagarden.model.BaseEntity;
import com.naturagarden.repository.BaseRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.UUID;

public abstract class BaseService<T extends BaseEntity> {
    protected final BaseRepository<T> repository;

    protected BaseService(BaseRepository<T> repository){
        this.repository = repository;
    }

    public Page<T> listar(Pageable pageable) {
        return repository.findByDeletedAtIsNull(pageable);
    }

    public T buscarPorId(UUID id) {
        return repository.findByIdAndDeletedAtIsNull(id)
                .orElseThrow(() -> new RuntimeException("Registro não encontrado"));
    }

    public void deletar(UUID id) {
        T entidade = buscarPorId(id);
        repository.delete(entidade);
    }

}

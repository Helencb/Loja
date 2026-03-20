package com.naturagarden.service;

import com.naturagarden.model.BaseEntity;
import com.naturagarden.repository.BaseRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.time.LocalDateTime;
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

    public T salvar(T entidade) {
        return repository.save(entidade);
    }

    public void deletar(UUID id) {
        T entidade = buscarPorId(id);
        entidade.setDeletedAt(LocalDateTime.now());
        repository.save(entidade);
    }

}

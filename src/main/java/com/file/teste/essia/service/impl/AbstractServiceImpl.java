package com.file.teste.essia.service.impl;

import com.file.teste.essia.exception.ErrorCode;
import com.file.teste.essia.exception.NotValidParamsException;
import com.file.teste.essia.exception.ResourceNotFoundException;
import com.file.teste.essia.model.BaseEntity;
import com.file.teste.essia.service.AbstractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

import java.io.Serializable;
import java.util.Optional;
import java.util.function.Supplier;

public abstract class AbstractServiceImpl<R extends JpaRepository<T, Long>, T extends BaseEntity> implements AbstractService<T> {

    @Autowired
    protected R repository;

    @Override
    public Iterable<T> getAll() {
        return repository.findAll();
    }

    @Override
    public T getById(Object id) {
        return repository
                .findById((Long) id)
                .orElseThrow(getNotFoundExceptionSupplier("Cannot find entity by id: " + id));
    }

    @Override
    public T update(Object id, T entity) {
        Optional<T> optionalEntityFromDB = repository.findById((Long) id);
        return optionalEntityFromDB
                .map(e -> saveAndReturnSavedEntity(entity, e))
                .orElseThrow(getNotFoundExceptionSupplier("Cannot update - not exist entity by id: " + id));
    }

    private T saveAndReturnSavedEntity(T entity, T entityFromDB) {
        entity.setId(entityFromDB.getId());
        return repository.save(entity);
    }

    @Override
    public T save(T entity) {
        return repository.save(entity);
    }

    @Override
    public void delete(T entity) {
        Long id = entity.getId();
        if (id == null) {
            throw new NotValidParamsException("Try delete entity without id", ErrorCode.INVALID_PARAMS);
        }

        validateExistingEntityById(id);

        repository.delete(entity);
    }

    @Override
    public void delete(Object id) {
        validateExistingEntityById((Long) id);

        repository.deleteById((Long) id);
    }

    private void validateExistingEntityById(Long id) {
        repository
                .findById(id)
                .orElseThrow(getNotFoundExceptionSupplier("Cannot find entity by id: " + id));
    }

    protected Supplier<ResourceNotFoundException> getNotFoundExceptionSupplier(String message) {
        return () -> new ResourceNotFoundException(message, ErrorCode.OBJECT_NOT_FOUND);
    }
}

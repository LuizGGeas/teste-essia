package com.file.teste.essia.service;

import com.file.teste.essia.exception.ResourceNotFoundException;
import com.file.teste.essia.model.BaseEntity;

public interface AbstractService<T extends BaseEntity> {

    /**
     * Get all entities, if not exist return empty collection
     *
     * @return collection
     */
    Iterable<T> getAll();

    /**
     * Get entity by id, if not exist throw exception {@link ResourceNotFoundException}
     *
     * @param id id
     * @return entity
     */
    T getById(Object id);

    /**
     * Update passed entity from id by passed entity.
     * If not exist entity by id throw exception {@link ResourceNotFoundException}
     *
     * @param id id
     * @param entity entity
     * @return updated entity
     */
    T update(Object id, T entity);

    /**
     * Create new entity
     *
     * @param entity entity
     * @return saved entity
     */
    T save(T entity);

    /**
     * Delete by entity
     *
     * @param entity entity
     */
    void delete(T entity);

    /**
     * Delete by id, if not exist entity by id throw exception {@link ResourceNotFoundException}
     *
     * @param id id
     */
    void delete(Object id);
}

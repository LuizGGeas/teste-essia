package com.file.teste.essia.controller;

import com.file.teste.essia.model.BaseEntity;
import com.file.teste.essia.service.AbstractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public abstract class AbstractController<S extends AbstractService<T>, T extends BaseEntity> {

    @Autowired
    protected S service;

    @GetMapping("/id/{id}")
    public ResponseEntity<T> get(@PathVariable Long id) {

        return ResponseEntity.ok(service.getById(id));
    }

    @GetMapping
    public ResponseEntity<Iterable<T>> get() {

        return ResponseEntity.ok(service.getAll());
    }

    @PostMapping
    public ResponseEntity<T> save(@RequestBody T data) {
        return ResponseEntity.ok(service.save(data));
    }

    @PutMapping("/id/{id}")
    public ResponseEntity<T> update(@PathVariable Long id, @RequestBody T data) {
        return ResponseEntity.ok(service.update(id, data));
    }

    @DeleteMapping("/id/{id}")
    public ResponseEntity.BodyBuilder delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.ok();
    }

    @DeleteMapping()
    public ResponseEntity.BodyBuilder deleteById(@RequestBody T data) {
        service.delete(data);
        return ResponseEntity.ok();
    }
}

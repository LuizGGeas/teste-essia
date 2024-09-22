package com.file.teste.essia.controller;

import com.file.teste.essia.model.BaseEntity;
import com.file.teste.essia.service.AbstractService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public abstract class AbstractController<S extends AbstractService<T>, T extends BaseEntity> {
    
    protected abstract S getService();

    @GetMapping("/{id}")
    public ResponseEntity<T> get(@RequestParam Long id) {

        return ResponseEntity.ok(getService().getById(id));
    }

    @GetMapping
    public ResponseEntity<Iterable<T>> get() {

        return ResponseEntity.ok(getService().getAll());
    }

    @PostMapping
    public ResponseEntity<T> save(@RequestBody T data) {
        return ResponseEntity.ok(getService().save(data));
    }

    @PutMapping("/{id}")
    public ResponseEntity<T> update(@RequestParam Long id, @RequestBody T data) {
        return ResponseEntity.ok(getService().update(id, data));
    }

    @DeleteMapping("/id")
    public ResponseEntity.BodyBuilder delete(@RequestParam Long id) {
        getService().delete(id);
        return ResponseEntity.ok();
    }

    @DeleteMapping()
    public ResponseEntity.BodyBuilder deleteById(@RequestBody T data) {
        getService().delete(data);
        return ResponseEntity.ok();
    }
}

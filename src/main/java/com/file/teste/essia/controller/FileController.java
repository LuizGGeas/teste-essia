package com.file.teste.essia.controller;

import com.file.teste.essia.model.File;
import com.file.teste.essia.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/file")
public class FileController {
    @Autowired
    FileService fileService;

    @GetMapping("/{id}")
    public ResponseEntity<File> get(@RequestParam Long id) {

        return ResponseEntity.ok(fileService.getById(id));
    }

    @GetMapping
    public ResponseEntity<Iterable<File>> get() {

        return ResponseEntity.ok(fileService.getAll());
    }

    @PostMapping
    public ResponseEntity<File> save(@RequestBody File data) {
        return ResponseEntity.ok(fileService.save(data));
    }

    @PutMapping("/{id}")
    public ResponseEntity<File> update(@RequestParam Long id, @RequestBody File data) {
        return ResponseEntity.ok(fileService.update(id, data));
    }

    @DeleteMapping("/id")
    public ResponseEntity.BodyBuilder delete(@RequestParam Long id) {
        fileService.delete(id);
        return ResponseEntity.ok();
    }

    @DeleteMapping()
    public ResponseEntity.BodyBuilder deleteById(@RequestBody File data) {
        fileService.delete(data);
        return ResponseEntity.ok();
    }
}

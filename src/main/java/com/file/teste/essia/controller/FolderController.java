package com.file.teste.essia.controller;

import com.file.teste.essia.model.Folder;
import com.file.teste.essia.service.FolderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/folder")
public class FolderController {

    @Autowired
    private FolderService folderService;

    @GetMapping("/{id}")
    public ResponseEntity<Folder> get(@RequestParam Long id) {

        return ResponseEntity.ok(folderService.getById(id));
    }

    @GetMapping
    public ResponseEntity<Iterable<Folder>> get() {

        return ResponseEntity.ok(folderService.getAll());
    }

    @PostMapping
    public ResponseEntity<Folder> save(@RequestBody Folder data) {
        return ResponseEntity.ok(folderService.save(data));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Folder> update(@RequestParam Long id, @RequestBody Folder data) {
        return ResponseEntity.ok(folderService.update(id, data));
    }

    @DeleteMapping("/id")
    public ResponseEntity.BodyBuilder delete(@RequestParam Long id) {
        folderService.delete(id);
        return ResponseEntity.ok();
    }

    @DeleteMapping()
    public ResponseEntity.BodyBuilder deleteById(@RequestBody Folder data) {
        folderService.delete(data);
        return ResponseEntity.ok();
    }
}

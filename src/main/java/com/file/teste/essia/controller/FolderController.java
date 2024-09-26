package com.file.teste.essia.controller;

import com.file.teste.essia.model.Folder;
import com.file.teste.essia.service.FolderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/folder")
public class FolderController extends AbstractController<FolderService, Folder> {
}

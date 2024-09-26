package com.file.teste.essia.controller;

import com.file.teste.essia.model.File;
import com.file.teste.essia.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/file")
public class FileController extends AbstractController<FileService, File>{
}

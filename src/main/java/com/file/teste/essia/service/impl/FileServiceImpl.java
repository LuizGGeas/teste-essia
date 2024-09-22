package com.file.teste.essia.service.impl;

import com.file.teste.essia.model.File;
import com.file.teste.essia.repository.FileRepository;
import com.file.teste.essia.service.FileService;
import org.springframework.stereotype.Service;

@Service
public class FileServiceImpl extends AbstractServiceImpl<FileRepository, File> implements FileService  {
}

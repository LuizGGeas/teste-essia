package com.file.teste.essia.service.impl;

import com.file.teste.essia.model.Folder;
import com.file.teste.essia.repository.FolderRepository;
import com.file.teste.essia.service.FolderService;
import org.springframework.stereotype.Service;

@Service
public class FolderServiceImpl extends AbstractServiceImpl<FolderRepository, Folder> implements FolderService {
}

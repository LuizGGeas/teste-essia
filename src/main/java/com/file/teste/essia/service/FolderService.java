package com.file.teste.essia.service;

import com.file.teste.essia.model.Folder;
import org.springframework.stereotype.Service;

@Service
public interface FolderService extends AbstractService<Folder> {

    Folder getRootFolder();
}

package com.file.teste.essia.service.impl;

import com.file.teste.essia.exception.ErrorCode;
import com.file.teste.essia.exception.NotValidParamsException;
import com.file.teste.essia.model.Folder;
import com.file.teste.essia.repository.FolderRepository;
import com.file.teste.essia.service.FolderService;
import org.apache.logging.log4j.util.Strings;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class FolderServiceImpl extends AbstractServiceImpl<FolderRepository, Folder> implements FolderService {

    @Override
    public Folder save(Folder entity) {
        if(Objects.isNull(entity.getParentFolder()))
            throw new NotValidParamsException("Pasta precisa de uma raiz", ErrorCode.INVALID_PARAMS);

        if(Strings.isBlank(entity.getName()))
            throw new NotValidParamsException("Pasta precisa de um nome válido", ErrorCode.INVALID_PARAMS);

        return super.save(entity);
    }
}

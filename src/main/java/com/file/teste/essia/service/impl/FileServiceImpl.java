package com.file.teste.essia.service.impl;

import com.file.teste.essia.exception.ErrorCode;
import com.file.teste.essia.exception.NotValidParamsException;
import com.file.teste.essia.model.File;
import com.file.teste.essia.repository.FileRepository;
import com.file.teste.essia.service.FileService;
import org.apache.logging.log4j.util.Strings;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class FileServiceImpl extends AbstractServiceImpl<FileRepository, File> implements FileService  {
    @Override
    public File save(File entity) {
        if(Objects.isNull(entity.getSourceFolder()))
            throw new NotValidParamsException("Pasta precisa de uma raiz", ErrorCode.INVALID_PARAMS);

        if(Strings.isBlank(entity.getName()))
            throw new NotValidParamsException("Pasta precisa de um nome válido", ErrorCode.INVALID_PARAMS);

        return super.save(entity);
    }
}

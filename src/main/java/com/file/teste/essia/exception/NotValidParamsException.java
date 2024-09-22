package com.file.teste.essia.exception;

import java.io.Serial;

public class NotValidParamsException extends BaseException {

    @Serial
    private static final long serialVersionUID = -1066219052235780119L;

    public NotValidParamsException(String message, ErrorCode code) {
        super(message, code);
    }
}

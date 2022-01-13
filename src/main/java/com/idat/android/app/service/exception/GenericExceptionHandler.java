package com.idat.android.app.service.exception;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import com.idat.android.app.service.utils.GenericResponse;
import com.idat.android.app.service.utils.Globals;

@RestControllerAdvice
public class GenericExceptionHandler {
    @ExceptionHandler(Exception.class)
    public GenericResponse<String> genericException(Exception ex) {
        return new GenericResponse<String>("exception", -1, Globals.OPERACION_ERRONEA, ex.getMessage());
    }
}

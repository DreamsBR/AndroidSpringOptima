package com.idat.android.app.service.exception;

import org.hibernate.JDBCException;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.idat.android.app.service.utils.GenericResponse;
import com.idat.android.app.service.utils.Globals;

@RestControllerAdvice
@Order(Ordered.HIGHEST_PRECEDENCE)
public class SpecificExceptionHandler {
    @ExceptionHandler(JDBCException.class)
    public GenericResponse<String> sqlException(JDBCException ex) {
        return new GenericResponse<String>("sql-exception", -1, Globals.OPERACION_ERRONEA, ex.getMessage());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public GenericResponse<String> validException(MethodArgumentNotValidException ex) {
        return new GenericResponse<String>("valid-exception", Globals.RPTA_ERROR, Globals.OPERACION_ERRONEA, ex.getMessage());
    }

    @ExceptionHandler(FileStorageException.class)
    public GenericResponse<String> fileStorageException(FileStorageException ex) {
        return new GenericResponse<String>("file-storage-exception", Globals.RPTA_ERROR, Globals.OPERACION_ERRONEA, ex.getMessage());
    }

    @ExceptionHandler(MyFileNotFoundException.class)
    public GenericResponse<String> myFileNotFoundException(MyFileNotFoundException exception) {
        return new GenericResponse<String>("my-file-not-found-exception", Globals.RPTA_ERROR, Globals.OPERACION_INCORRECTA, exception.getMessage());
    }
}

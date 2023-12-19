package com.library.infra;

import com.library.dtos.ResponseDTO;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ControllerExceptionHandler {
    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity notFound(EntityNotFoundException exception){
        return ResponseEntity.notFound().build();
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity duplicateEntry(DataIntegrityViolationException exception){
        ResponseDTO response = new ResponseDTO("Livro já cadastrado.", 400);
        return ResponseEntity.badRequest().body(response);
    }
    @ExceptionHandler(Exception.class)
    public ResponseEntity generalException(Exception exception){
        ResponseDTO response = new ResponseDTO(exception.getMessage(), 500);
        return ResponseEntity.internalServerError().body(response);
    }
}

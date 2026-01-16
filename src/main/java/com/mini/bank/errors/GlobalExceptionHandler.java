package com.mini.bank.errors;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

   @ExceptionHandler(Exception.class)
   public ResponseEntity<Void> genericException() {
      return ResponseEntity.internalServerError().build();
   }

   @ExceptionHandler(ResourceNotFoundException.class)
   public ResponseEntity<Void> resourceNotFound() {
      return ResponseEntity.notFound().build();
   }

   @ExceptionHandler(TransferNotPermittedException.class)
   public ResponseEntity<Void> transferNotPermitted() {
      return ResponseEntity.unprocessableContent().build();
   }

   @ExceptionHandler(MethodArgumentNotValidException.class)
   public ResponseEntity<Void> methodArgumentNotValid() {
      return ResponseEntity.badRequest().build();
   }

}

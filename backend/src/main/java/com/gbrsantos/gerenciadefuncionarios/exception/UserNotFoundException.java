package com.gbrsantos.gerenciadefuncionarios.exception;

public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(String message) {
    super(message);
    }
}

package br.com.g3.sistemadevagaseng.service.exceptions;

public class ObjectNotFoundException extends RuntimeException {
    public ObjectNotFoundException(String message){
        super(message);
    }

    public ObjectNotFoundException(String message, Throwable cause){
        super(message, cause);
    }
}

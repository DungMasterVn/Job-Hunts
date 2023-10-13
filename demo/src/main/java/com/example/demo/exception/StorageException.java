package com.example.demo.exception;

public class StorageException extends RuntimeException{
//    private static final long serialVersionUUID = 67893748918273L;
    public StorageException(String message){
        super(message);
    }
    public StorageException(String message,Throwable cause){
        super(message,cause);
    }
}

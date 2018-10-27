package com.nc.matsoft.exception;

public class NullConnectionException extends RuntimeException {
    protected static final String DEFAULT_MESSAGE = "Connection with your DataBase is null";

    public NullConnectionException(){
        super(DEFAULT_MESSAGE);
    }
    public NullConnectionException(String operation){
        super((operation != null) ? DEFAULT_MESSAGE + " " + operation : DEFAULT_MESSAGE);
    }
}

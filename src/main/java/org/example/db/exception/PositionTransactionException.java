package org.example.db.exception;

public class PositionTransactionException extends Exception{
    private static final long serialVersionUID =  -3128681006635769411L;
    public PositionTransactionException(String message){
        super(message);
    }
}

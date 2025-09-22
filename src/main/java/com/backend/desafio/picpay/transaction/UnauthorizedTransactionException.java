package com.backend.desafio.picpay.transaction;

public class UnauthorizedTransactionException extends RuntimeException{
    public UnauthorizedTransactionException(String message){
        super(message);
    }
}

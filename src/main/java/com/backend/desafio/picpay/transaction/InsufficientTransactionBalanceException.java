package com.backend.desafio.picpay.transaction;

public class InsufficientTransactionBalanceException extends RuntimeException{
    public InsufficientTransactionBalanceException(String message){
        super(message);
    }
}

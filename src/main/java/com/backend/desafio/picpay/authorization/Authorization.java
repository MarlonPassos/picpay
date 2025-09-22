package com.backend.desafio.picpay.authorization;

public record Authorization(String message) {

    public boolean isAuthorized() {
        return message.equals("Autorizado");
    }
}

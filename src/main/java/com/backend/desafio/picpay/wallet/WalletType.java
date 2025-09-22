package com.backend.desafio.picpay.wallet;

public enum WalletType {
    COMUN(1), LOJISTA(2);

    private int value;

    private WalletType(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}

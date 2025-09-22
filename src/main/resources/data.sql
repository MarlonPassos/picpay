/* Clear WALLETS */
DELETE FROM TRANSACTIONS;

DELETE FROM WALLETS;

/* Insert wallets */

INSERT INTO
    WALLETS (
        ID, FULL_NAME, CPF, EMAIL, "PASSWORD", "TYPE", BALANCE, "VERSION"
    )
VALUES (
        1, 'Maria - User', 12345678900, 'maria@test.com', '123456', 1, 1000.00, 1
    );

INSERT INTO
    WALLETS (
        ID, FULL_NAME, CPF, EMAIL, "PASSWORD", "TYPE", BALANCE, "VERSION"
    )
VALUES (
        2, 'Pedro - Lojista', 12345678901, 'pedro@test.com', '123456', 2, 1000.00, 1
    );

INSERT INTO
    WALLETS (
        ID, FULL_NAME, CPF, EMAIL, "PASSWORD", "TYPE", BALANCE, "VERSION"
    )
VALUES (
        3, 'Carlos - User', 12345678902, 'carlos@test.com', '123456', 1, 1000.00, 1
    );
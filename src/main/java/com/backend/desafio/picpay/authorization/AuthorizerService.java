package com.backend.desafio.picpay.authorization;

import com.backend.desafio.picpay.transaction.Transaction;
import com.backend.desafio.picpay.transaction.UnauthorizedTransactionException;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

@Service
public class AuthorizerService {
    private RestClient restClient;

    public AuthorizerService(RestClient.Builder builder) {
        this.restClient = builder
                .baseUrl("http://localhost:3000/authorization")
                .build();
    }

    public void authorize(Transaction transaction) {
       var response = restClient.get().retrieve().toEntity(Authorization.class);
       if (response.getStatusCode().isError() || !response.getBody().isAuthorized()) {
           throw new UnauthorizedTransactionException("Unauthorized transaction");
       }
    }
}

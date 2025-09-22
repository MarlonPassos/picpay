package com.backend.desafio.picpay.notification;

import com.backend.desafio.picpay.transaction.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

@Service
public class NotificationConsumer {
    private static final Logger LOGGER = LoggerFactory.getLogger(NotificationConsumer.class);
    private RestClient restClient;

    public NotificationConsumer(RestClient.Builder builder) {
        this.restClient = builder
                .baseUrl("http://localhost:3000/notification")
                .build();
    }

    @KafkaListener(topics = "transaction-notification", groupId = "backend-desafio-picpay")
    public void receiveNotification(Transaction transaction) {
        LOGGER.info("Notifying transaction {}...", transaction);

        var response = restClient.get().retrieve().toEntity(Notification.class);

        if (response.getStatusCode().isError() || !response.getBody().message())
            throw new NotificationException("Error notifyng transaction " + transaction);

        LOGGER.info("Notifying has been sent {}...", response.getBody());
    }

}
// 55.22
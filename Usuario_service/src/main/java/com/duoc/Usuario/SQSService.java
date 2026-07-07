package com.duoc.Usuario;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.sqs.SqsClient;
import software.amazon.awssdk.services.sqs.model.SendMessageRequest;

@Service
public class SQSService {

    @Value("${aws.sqs.queue-url}")
    private String queueUrl;

    public void enviarMensaje(String mensaje) {

        SqsClient sqsClient = SqsClient.builder()
                .region(Region.US_EAST_2)
                .build();

        SendMessageRequest request = SendMessageRequest.builder()
                .queueUrl(queueUrl)
                .messageBody(mensaje)
                .build();

        sqsClient.sendMessage(request);

        System.out.println("Mensaje enviado a SQS correctamente.");
    }
}
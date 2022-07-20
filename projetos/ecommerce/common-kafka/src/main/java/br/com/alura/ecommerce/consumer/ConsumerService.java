package br.com.alura.ecommerce.consumer;

import br.com.alura.ecommerce.Message;
import org.apache.kafka.clients.consumer.ConsumerRecord;

import java.io.IOException;

public interface ConsumerService<T> { // metodos padrão de um serviço de consumo
    void parse(ConsumerRecord< String, Message<T>> record) throws IOException;
    String getConsumerGroup();
    String getTopic();
    }
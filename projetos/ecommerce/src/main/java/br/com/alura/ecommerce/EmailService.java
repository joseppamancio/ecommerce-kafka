package br.com.alura.ecommerce;

import org.apache.kafka.clients.consumer.ConsumerRecord;

import java.util.Map;

public class EmailService {

    public static void main(String[] args) {
        var emailService = new EmailService();  // Construtor da Classe
        try(var service = new KafkaService(EmailService.class.getSimpleName(),
                "ECOMMERCE_SEND_EMAIL",
                emailService::parse, //  emailService::parse -> methodReference, invoque essa função para cada record
                String.class,
                Map.of())) { // Nesse service não temos propriedades extras então passamos um mapa vazio.
            service.run();
        }
    }

        // Função que será executada para cada registro
        private void parse(ConsumerRecord < String, String > record){
            System.out.println("---------------------------------------------");
            System.out.println("Send email");
            System.out.println(record.key());
            System.out.println(record.value());
            System.out.println(record.partition());
            System.out.println(record.offset());

            //simulando processamento
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Email sent");
        }
}

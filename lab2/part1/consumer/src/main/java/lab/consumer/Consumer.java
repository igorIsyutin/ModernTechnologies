package lab.consumer;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class Consumer {
    @KafkaListener(topics = "topic1")
    public void listen(String message) {
        System.out.println("Received Messasge: " + message);
    }
}

package lab.consumer;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class Consumer {
    @KafkaListener(topics = "topic2")
    public void listen(String message) {
        System.out.println("Received Messasge: " + message);
    }
}

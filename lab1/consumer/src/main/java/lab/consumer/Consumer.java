package lab.consumer;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class Consumer {
    private KafkaTemplate<String, String> kafkaTemplate;

    public Consumer(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @KafkaListener(topics = "lab1", groupId = "foo")
    public void listen(String message) {
        System.out.println("Received Messasge: " + message);
        kafkaTemplate.send("test", "seconds now: " + message.split(":")[2].substring(0,2));
    }
}

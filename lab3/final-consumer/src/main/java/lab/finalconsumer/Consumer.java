package lab.finalconsumer;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Service;

@Service
public class Consumer {

    @KafkaListener(topics = "finalTopic", groupId = "finalTopicGroup")
    public void listen(ConsumerRecord<String,String> message) {
        System.out.println("Received Message: " + message);
    }
}

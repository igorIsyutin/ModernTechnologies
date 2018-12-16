package lab.consumer;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Service;

@Service
public class Consumer {
    @KafkaListener(topics = "middleTopic", groupId = "middleTopicGroup")
    @SendTo("finalTopic")
    public String listen(ConsumerRecord<String,String> message) {
        System.out.println("Received Message: " + message);

        return "seconds now: " + message.value().split(":")[2].substring(0, 2);
    }
}

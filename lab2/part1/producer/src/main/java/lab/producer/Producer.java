package lab.producer;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.PreDestroy;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@Service
public class Producer {

    private KafkaTemplate<String, String> kafkaTemplate;
    private ScheduledExecutorService executorService = Executors.newSingleThreadScheduledExecutor();

    public Producer(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
        executorService.scheduleAtFixedRate(()->this.sendMessage(LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_TIME)), 0, 5, TimeUnit.SECONDS);
    }

    public void sendMessage(String msg) {
        kafkaTemplate.send("topic1", msg);
    }

    @PreDestroy
    private void destroy(){
        executorService.shutdown();
    }
}

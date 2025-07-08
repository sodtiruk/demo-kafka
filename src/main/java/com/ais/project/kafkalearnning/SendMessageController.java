package com.ais.project.kafkalearnning;

import com.ais.project.kafkalearnning.service.KafkaProducerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/kafka")
@RequiredArgsConstructor
public class SendMessageController {

    private final KafkaProducerService kafkaProducer;

    @GetMapping("/test")
    public String test() {
        return "Kafka is working!";
    }

    @PostMapping("/send")
    public String sendMessage(@RequestParam String message) {
        for (int i = 0; i < 100; i++) {
            kafkaProducer.sendMessage("my-topic", message);
        }
        return "Message sent: " + message + "100 times";
    }

}

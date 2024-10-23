package pet.project.chatapi.chat;

import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pet.project.chatapi.chat.dto.Message;
import pet.project.chatapi.constans.KafkaConstants;
import pet.project.chatapi.exception.WebException;
import pet.project.chatapi.utils.TimeUtils;

import java.util.concurrent.ExecutionException;


@RequiredArgsConstructor
@RestController
@RequestMapping("/chat/api")
public class ChatController {

    private final KafkaTemplate<String, Message> kafkaTemplate;


    @PostMapping(value = "/send")
    public void sendMessage(@RequestBody Message message) {
        message.setTimestamp(TimeUtils.getCurrentDateTime().toString());
        try {
            kafkaTemplate.send(KafkaConstants.KAFKA_TOPIC, message).get();
        } catch (InterruptedException | ExecutionException e) {
            throw new WebException("Error sending a message", e.getMessage());
        }

    }

}

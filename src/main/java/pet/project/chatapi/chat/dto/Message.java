package pet.project.chatapi.chat.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Message {

    private String sender;
    private String content;
    private String timestamp;
}

package pet.project.chatapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Import;
import pet.project.chatapi.db.MyBatisConfig;
import pet.project.chatapi.security.RsaProperties;

@SpringBootApplication
@Import({
        MyBatisConfig.class
})
@EnableConfigurationProperties(RsaProperties.class)
public class ChatApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(ChatApiApplication.class, args);
    }

}

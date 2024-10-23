package pet.project.chatapi.chat.config;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import pet.project.chatapi.chat.dto.Message;

import java.util.HashMap;
import java.util.Map;

@EnableKafka
@Configuration
public class ConsumerConfiguration {

//    @Bean
//    public ConsumerFactory<String, Message> consumerFactory() {
//        return new DefaultKafkaConsumerFactory<>(consumerConfiguration());
//    }
//
//    @Bean
//    public Map<String, Object> consumerConfiguration() {
//        Map<String, Object> properties = new HashMap<>();
//        properties.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, KafkaCons)
//        return properties;
//    }

}

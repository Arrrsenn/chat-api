package pet.project.chatapi.security;


import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.security.crypto.bcrypt.BCrypt;

import java.security.SecureRandom;

@PropertySource("classpath:application.properties")
public class SecurityService {

    @Value("${bcrypt.log.rounds}")
    private int logRounds;
    private final SecureRandom secureRandom;

    public SecurityService(SecureRandom secureRandom) {
        this.secureRandom = secureRandom;
    }

    public String saltPassword(String password) {
        if (StringUtils.isBlank(password)) {
            return null;
        }
        String salt = BCrypt.gensalt(logRounds, secureRandom);
        return BCrypt.hashpw(password, salt);
    }
}

package pet.project.chatapi.security;

import org.springframework.boot.context.properties.ConfigurationProperties;

import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;

@ConfigurationProperties(prefix = "rsa", ignoreInvalidFields = true)
public record RsaProperties(RSAPrivateKey privateKey, RSAPublicKey publicKey) {
}

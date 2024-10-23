package pet.project.chatapi.security;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.oauth2.core.endpoint.OAuth2ParameterNames;
import org.springframework.security.oauth2.jwt.JwtClaimsSet;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.JwtEncoderParameters;
import pet.project.chatapi.db.entity.User;
import pet.project.chatapi.db.repository.UserRepository;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.stream.Collectors;

public class AuthTokenizator {
//    TODO : Создать jwt access и refresh token

    @Value("${jwt.expiration.ms}")
    private long jwtExpirationMs;
    @Value("${jwt.refresh.expiration.ms}")
    private long refreshExpirationMs;

    private final UserRepository userRepository;
    private final JwtEncoder encoder;

    public AuthTokenizator(UserRepository userRepository, JwtEncoder encoder) {
        this.userRepository = userRepository;
        this.encoder = encoder;
    }

    public String generateJwtToken(User user) {
        Instant now = Instant.now();
        String roles = userRepository.getUserRoles(user.getId())
                .stream()
                .map(Enum::name)
                .collect(Collectors.joining(" "));
        JwtClaimsSet claimsSet = JwtClaimsSet.builder()
                .issuedAt(now)
                .expiresAt(now.plus(jwtExpirationMs, ChronoUnit.MILLIS))
                .subject(user.getEmail())
                .claim(OAuth2ParameterNames.CLIENT_ID, user.getId())
                .claim(OAuth2ParameterNames.REFRESH_TOKEN, false)
                .claim(OAuth2ParameterNames.SCOPE, roles)
                .build();
        return this.encoder.encode(JwtEncoderParameters.from(claimsSet)).getTokenValue();
    }
}

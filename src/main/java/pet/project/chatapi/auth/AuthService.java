package pet.project.chatapi.auth;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pet.project.chatapi.auth.dto.SuccessfulAuthResponse;
import pet.project.chatapi.auth.dto.UserAuthorization;
import pet.project.chatapi.auth.dto.UserRegistration;
import pet.project.chatapi.db.entity.User;
import pet.project.chatapi.db.repository.UserRepository;
import pet.project.chatapi.exception.WebException;
import pet.project.chatapi.security.SecurityService;

import java.text.MessageFormat;
import java.util.Optional;

@Slf4j
@Service
public class AuthService {

    private final SecurityService securityService;

    private final UserRepository userRepository;

    public AuthService(SecurityService securityService,
                       UserRepository userRepository) {
        this.securityService = securityService;
        this.userRepository = userRepository;
    }

    //    TODO : Доделать авторизацию пользователя
    public SuccessfulAuthResponse authorization(UserAuthorization userAuth) {
        log.info("Attempted authorization by a user = {}", userAuth.email());
        Optional<User> user = userRepository.getUserByEmail(userAuth.email());
        throw new WebException(MessageFormat.format("Not found user {0}", userAuth.email()));
    }

    //    TODO : Доделать регистрацию пользователя : зависит от @class AuthTokenizator
    public SuccessfulAuthResponse registration(UserRegistration userRegistration) {
        log.info("User registration {}", userRegistration.getEmail());
        Optional<User> userByEmail = userRepository.getUserByEmail(userRegistration.getEmail());
        if (userByEmail.isPresent()) {
//            TODO: временно выбрасываю исключение,
//             после создание логики JWT, добавить access и refresh токены
            throw new WebException
                    (MessageFormat.format("User <{0}> already registered",
                            userRegistration.getEmail())
                    );
        }
        String saltPassword = securityService.saltPassword(userRegistration.getPassword());
        User newUser = new User(null, userRegistration.getName(), userRegistration.getEmail(), saltPassword);
        userRepository.createNewUser(newUser);
//        TODO: будет логика передачи access и refresh токенов
        return null;
    }
}

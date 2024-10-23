package pet.project.chatapi.auth.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record UserAuthorization(
        @Email
        @NotBlank(message = "")
        String email,
        @NotBlank
        String password
) {
}

package pet.project.chatapi.auth.dto;

public record SuccessfulAuthResponse(
        String accessToken,
        String refreshToken,
        String login
) {
}

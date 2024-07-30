package pet.project.chatapi.exception;

public record ErrorDto(String message, String code) {
    public ErrorDto(String message) {
        this(message, null);
    }
}

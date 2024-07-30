package pet.project.chatapi.exception;

public class WebException extends RuntimeException {

    private transient Object[] args;

    public WebException(String message, Object... args) {
        super(message);
        this.args = args;
    }
}

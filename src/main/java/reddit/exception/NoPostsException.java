package reddit.exception;

public class NoPostsException extends RuntimeException {
    public NoPostsException(String message) {
        super(message);
    }
}

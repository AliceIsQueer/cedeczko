public class EmptyStringError extends RuntimeException {
    public EmptyStringError(String errorMessage) {
        super(errorMessage);
    }
}
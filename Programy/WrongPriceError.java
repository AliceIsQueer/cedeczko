public class WrongPriceError extends RuntimeException {
    public WrongPriceError(String errorMessage) {
        super(errorMessage);
    }
}
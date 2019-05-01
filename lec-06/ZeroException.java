public class ZeroException extends Exception {
    protected String message;

    ZeroException() {
        this.message = "Zero Exception";
    }

    ZeroException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}

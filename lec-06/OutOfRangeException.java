public class OutOfRangeException extends RuntimeException {
    private String message;

    OutOfRangeException(){
        this.message = "Range of input is 0~9999";
    }

    OutOfRangeException(String message){
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}

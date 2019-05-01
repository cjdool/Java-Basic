public class SubtractZeroException extends ZeroException {
    SubtractZeroException(){
        this.message = "Subtraction is not allowed to subtract zero";
    }

    SubtractZeroException(String message){
        this.message = message;
    }
}

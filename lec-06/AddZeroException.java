public class AddZeroException extends ZeroException {
    AddZeroException(){
        this.message = "Add is not allowed to add zero";
    }

    AddZeroException(String message){
        this.message = message;
    }
}

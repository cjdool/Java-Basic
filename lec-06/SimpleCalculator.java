public class SimpleCalculator {
    private int result;

    SimpleCalculator(){
        result = 0;
    }

    private void checkinput (int value) throws OutOfRangeException, ZeroException {
        if (value == 0) {
            throw new ZeroException();
        }
        else if (value < 0 || value > 9999){
            throw new OutOfRangeException();
        }
    }

    public void add(int value1, int value2) throws AddZeroException, OutOfRangeException{
        try {
            checkinput(value1);
            checkinput(value2);
            result = value1 + value2;
        } catch (ZeroException e1){
            throw new AddZeroException();
        } catch (OutOfRangeException e2){
            throw new OutOfRangeException();
        }
    }

    public void substract(int value1, int value2) throws SubtractZeroException, OutOfRangeException{
        try {
            checkinput(value1);
            checkinput(value2);
            result = value1 - value2;
        } catch (ZeroException e1) {
            throw new SubtractZeroException();
        } catch (OutOfRangeException e2) {
            throw new OutOfRangeException();
        }
    }

    public void print(){
        System.out.printf("Result: %d\n",result);
    }

    public void reset(){
        result = 0;
    }
}

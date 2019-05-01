import java.util.Scanner;

public class Practice5 {
    public static void main(String[] args) {
        int value1, value2, userinput;
        SimpleCalculator cac = new SimpleCalculator();
        Scanner scn = new Scanner(System.in);
        while (true){
            System.out.print("0. Exit\n1. Addition\n2. Subtract\n3. Print Result\n4. Reset\n");
            userinput = scn.nextInt();
            if (userinput == 0){
                break;
            }
            else if (userinput == 1){
                System.out.print("Input value 1:\n");
                value1 = scn.nextInt();
                System.out.print("Input value 2:\n");
                value2 = scn.nextInt();
                try {
                    cac.add(value1, value2);
                } catch (AddZeroException e1) {
                    System.out.printf("### ERROR ###\n%s\n",e1.getMessage());
                } catch (OutOfRangeException e2) {
                    System.out.printf("### ERROR ###\n%s\n",e2.getMessage());
                }
            }
            else if (userinput == 2){
                System.out.print("Input value 1:\n");
                value1 = scn.nextInt();
                System.out.print("Input value 2:\n");
                value2 = scn.nextInt();
                try {
                    cac.substract(value1, value2);
                } catch (SubtractZeroException e1) {
                    System.out.printf("### ERROR ###\n%s\n",e1.getMessage());
                } catch (OutOfRangeException e2) {
                    System.out.printf("### ERROR ###\n%s\n",e2.getMessage());
                }
            }
            else if (userinput == 3){
                cac.print();
            }
            else if (userinput == 4){
                cac.reset();
            }
            else {
                System.out.print("Wrong Input, you must enter 0 ~ 4 options, Try Again\n");
            }
        }
    }
}

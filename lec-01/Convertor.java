import java.util.Scanner;

public class Convertor {
    public static void main(String[] args) {
        int input;
        String hexresult;
        String octresult;
        String binresult;

        System.out.print("Input number : ");

        Scanner scn = new Scanner(System.in);
        input = scn.nextInt();
        hexresult = Integer.toHexString(input);
        binresult = Integer.toBinaryString(input);
        octresult = Integer.toOctalString(input);

        System.out.print("Input decimal number : ");
        System.out.print(input);
        System.out.print("\n");

        System.out.print("Binary number : ");
        System.out.print(binresult);
        System.out.print("\n");

        System.out.print("Octal number : ");
        System.out.print(octresult);
        System.out.print("\n");

        System.out.print("Hexadecimal number : ");
        System.out.print(hexresult);
        System.out.print("\n");
    }
}

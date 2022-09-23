import java.util.Scanner;
// num1 = a + bi
// num2 = c + di; i^2 = -1
// num1 * num2 = (a + bi) * (c + di);
//             = (a * c) + (a * di) + (bi * c) + (bi * di) 
//             = (a * c) + (a * d)i + (b * c)i + (b * d)i^2
//             = (a * c) + (a * d)i + (b * c)i - (b * d)
//             = (a * c - b * d) + (a * d + b * c)i
public class Q29_Complex_number_multiplication {
    public static String complexNumberMultiply(String num1, String num2) {
        // num1 = a + bi
        // num2 = c + di;
        // res = (a * c - b * d) + (a * d + c * b)i
        int a = Integer.parseInt(num1.substring(0, num1.indexOf('+')));
        int b = Integer.parseInt(num1.substring(num1.indexOf('+') + 1, num1.length() - 1));
        int c = Integer.parseInt(num2.substring(0, num2.indexOf('+')));
        int d = Integer.parseInt(num2.substring(num2.indexOf('+') + 1, num2.length() - 1));
        return "" + (a * c - b * d) + "+" + (a * d + c * b) + "i";
    }

    // ~~~~~~~~~~~~Input Management~~~~~~~~~~~
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String num1 = scn.nextLine();
        String num2 = scn.nextLine();
        scn.close();
        String res = complexNumberMultiply(num1, num2);
        System.out.println(res);
    }
}

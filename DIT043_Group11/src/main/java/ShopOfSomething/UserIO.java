package ShopOfSomething;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.Scanner;

public class UserIO {

    public static String decimalFormat(double price){
        DecimalFormat df = new DecimalFormat("0.00");
        df.setRoundingMode(RoundingMode.DOWN);
        return df.format(price);
    }

    public static double truncateFormat(double mean) {
        return (int)(mean*10)/10.0;
    }

    public static double truncateFormat2(double price){
        return (int)(price*100)/100.0;
    }



    public static final Scanner SCANNER = new Scanner(System.in);

    public static int readInt(){
        return SCANNER.nextInt();
    }

    public static String readStr(){
        String str = SCANNER.next();
        return str;
    }

    public static double readDouble(){
        return SCANNER.nextDouble();
    }
    /*public static String printMessage(String message) {
        System.out.println(message);
    }
    public static void printInt(int number) {
        System.out.println(number);
    }
    public static void printDouble(double number) {
        System.out.println(number);
    } */
}


package ClothingStore;

import java.util.Scanner;

public class Scanner {
    public static int readInt(){
        java.util.Scanner input = new java.util.Scanner(System.in);
        return input.nextInt();
    }
    public static String readStr(){
        java.util.Scanner input = new java.util.Scanner(System.in);
        String str = input.next();
        return str;
    }
    public static double readDouble(){
        java.util.Scanner input = new java.util.Scanner(System.in);
        return input.nextDouble();
    }

    public static void printMessage(String message) {
        System.out.println(message);
    }

    public static void printInt(int number) {
        System.out.println(number);
    }
}

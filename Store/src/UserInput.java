import java.util.Scanner;

public class UserInput {


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
}

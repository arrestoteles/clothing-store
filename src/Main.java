package ClothingStore;

import java.util.Scanner;

public class Main {
    static int[] iDs = new int[1000];
    static String[] names = new String[1000];
    static float[] pricePerUnit = new float[1000];
    static int totalItems = 0;


    public static void main(String[] args){

        printMainMenu();
        mainMenuHandler();


    }
    public static void printMainMenu(){
        System.out.print("Main Menu: Please choose among the options below.\n" +
                "\n" +
                "0. Close System.\n" +
                "1. Open Item options.\n" +
                "2. Open Review options\n" +
                "3. Open Transaction History options.\n" +
                "\n" +
                "Type an option number: ");

    }
    public static void mainMenuHandler(){
        int selection = ClothingStore.Scanner.readInt();
        switch(selection){
            case 0:
                System.out.println("You have chosen: Close system.");
                System.exit(0);
            case 1:
                System.out.println("You have chosen: Open Item options.");
                printOpenItemOptions();
                optionItemHandler();
                break;
            case 2:
                System.out.println("You have chosen: Open Review options.");
                printOpenReviewOptions();
                openReviewHandler();
                break;
            case 3:
                System.out.println("You have chosen: Open Transaction History options.");
                printTransactionHistoryOptions();
                openTransactionHandler();
                break;
        }

    }

    public static void printOpenItemOptions(){
        System.out.print("Item options menu:\n" +
                "0. Return to Main Menu.\n" +
                "1. Create an Item.\n" +
                "2. Remove an Item.\n" +
                "3. Print all registered Items.\n" +
                "4. Buy an Item.\n" +
                "5. Update an item’s name.\n" +
                "6. Update an item’s price.\n" +
                "\n" +
                "Type an option number: ");
    }
    public static void optionItemHandler(){
        int selection = ClothingStore.Scanner.readInt();
        switch (selection){
            case 0:
                System.out.println("You have chosen: Return to Main Menu.");
                printMainMenu();
                mainMenuHandler();
                break;
            case 1:
                System.out.println("You have chosen: Create an Item.");
                createItem(320, "T-Shirt", 450f);
                break;
            case 2:
                System.out.println("You have chosen: Remove an Item.");
                removeItem(200);
                break;
            case 3:
                System.out.println("You have chosen: Print all registered Items. ");
                printAllItems();
                break;
            case 4:
                System.out.println("You have chosen: Buy an Item.");
                buyItem(320, 6);
                break;
            case 5:
                System.out.println("You have chosen: Update an item's name.");
                updateItem(200, "Socks", 49f);
                break;
            case 6:
                System.out.println("You have chosen: Update an item's price.");
                updateItem(200, "Socks", 49f);
                break;
        }
    }

    public static void printOpenReviewOptions(){
        System.out.print("Reviews options menu:\n" +
                "0. Return to Main Menu.\n" +
                "1. Create a review for an Item.\n" +
                "2. Print a specific review of an Item.\n" +
                "3. Print all reviews of an Item.\n" +
                "4. Print mean grade of an Item\n" +
                "5. Print all comments of an Item.\n" +
                "6. Print all registered reviews.\n" +
                "7. Print item(s) with most reviews.\n" +
                "8. Print item(s) with least reviews.\n" +
                "9. Print item(s) with best mean review grade.\n" +
                "10. Print item(s) with worst mean review grade.\n" +
                "\n" +
                "Type an option number: ");
    }
    public static void openReviewHandler(){
        int selection = ClothingStore.Scanner.readInt();
        switch (selection){
            case 0:
                System.out.println("You have chosen: Return to Main Menu.");
                printMainMenu();
                mainMenuHandler();
                break;
            case 1:
                System.out.println("You have chosen: Create a review for an Item.");
                break;
            case 2:
                System.out.println("You have chosen: Print a specific review of an Item.");
                break;
            case 3:
                System.out.println("You have chosen: Print all reviews of an Item");
                break;
            case 4:
                System.out.println("You have chosen: Print mean grade of an Item");
                break;
            case 5:
                System.out.println("You have chosen: Print all comments of an Item");
                break;
            case 6:
                System.out.println("You have chosen: Print all registered reviews.");
                break;
            case 7:
                System.out.println("You have chosen: Print item(s) with most reviews.");
                break;
            case 8:
                System.out.println("You have chosen: Print item(s) with least reviews.");
                break;
            case 9:
                System.out.println("You have chosen: Print item(s) with best mean review grade.");
                break;
            case 10:
                System.out.println("You have chosen: Print item(s) with worst mean review grade.");
                break;
        }
    }

    public static void printTransactionHistoryOptions(){
        System.out.print("Transaction History options menu:\n" +
                "0. Return to Main Menu.\n" +
                "1. Print total profit from all item purchases\n" +
                "2. Print total units sold from all item purchases\n" +
                "3. Print the total number of item transactions made.\n" +
                "4. Print all transactions made.\n" +
                "5. Print the total profit of a specific item.\n" +
                "6. Print the number of units sold of a specific item.\n" +
                "7. Print all transactions of a specific item.\n" +
                "8. Print item with highest profit.\n" +
                "\n" +
                "Type an option number: ");
    }
    public static void openTransactionHandler(){
        int selection = ClothingStore.Scanner.readInt();
        switch (selection){
            case 0:
                System.out.println("You have chosen: Return to Main Menu.");
                printMainMenu();
                mainMenuHandler();
                break;
            case 1:
                System.out.println("You have chosen: Print total profit from all item purchases.");
                break;
            case 2:
                System.out.println("You have chosen: Print total units sold from all item purchases");
                break;
            case 3:
                System.out.println("You have chosen: Print the total number of item transactions made");
                break;
            case 4:
                System.out.println("You have chosen: Print all transactions made.");
                break;
            case 5:
                System.out.println("You have chosen: Print the total profit of a specific item.");
                break;
            case 6:
                System.out.println("You have chosen: Print the number of units sold of a specific item.");
                break;
            case 7:
                System.out.println("You have chosen: Print all transactions of a specific item.");
                break;
            case 8:
                System.out.println("You have chosen: Print item with highest profit.");
                break;

        }
    }



    // A method for checking if an array contains an element(if already exists)
    public static Boolean containsElement(int[] array, int element){
        for(int i = 0; i < 1000; i++) {
            if (array[i] == element) {
                return true;
            }
        }
        return false;
    }

    //Prints all item with valid iD
    public static void printAllItems(){
        for(int i = 0; i < 1000; i++){
            if(iDs[i] != 0){
                printItem(iDs[i],names[i],pricePerUnit[i]);
            }
        }

    }

    //Prints a single item.
    public static void printItem(int iD, String name, float price){
        System.out.println(iD + ": " + name + ". " + price + " SEK.");
    }

    // creates an item if the item is valid and iD does not exist already
    public static boolean createItem(int iD, String name, float price){

        if(!(isItemValid(iD, name, price))){ //if item invalid
            return false;

        }
        if(containsElement(iDs, iD)){ // if iD already exists
            System.out.println("Item " + iD + " already exist");
            return false;
        }
        for(int i = 0; i < 1000; i++){
            if(iDs[i] == 0){
                iDs[i] = iD;
                names[i] = name;
                pricePerUnit[i] = price;
                totalItems++;
                System.out.println("Item " + iD + " was registered successfully.");
                return true;
            }

        }
        System.out.println("Item " + iD +  " could not be created. (Probably full array)");
        return false;
    }

    // checks if item is valid
    public static boolean isItemValid(int iD, String name, float price){
        //Empty iD
        if(!(iD > 0)){
            System.out.println("Invalid data for item." + " (Wrong iD)");
            return false;
        }
        //Empty Name
        if(name.length() == 0){
            System.out.println("Invalid data for item." + " (Wrong name)");
            return false;
        }
        //Invalid price
        if(price <= 0){
            System.out.println("Invalid data for item." + " (Wrong price)");
            return false;
        }
        return true;

    }

    //update item price and name.
    public static boolean updateItem(int iD, String name, float price){
        for(int i = 0; i < 1000; i++){
            if(iDs[i] == iD){
                names[i] = name;
                pricePerUnit[i] = price;
                System.out.println("Item updated successfully.");
                return true;
            }
        }
        System.out.println("Item could not be found!");
        return false;

    }

    //Print a specific item's ID, price and name
    public static boolean printSpecificItem(int iD){
        for(int i = 0; i < 1000; i++){
            if(iDs[i] == iD){
                printItem(iDs[i],names[i],pricePerUnit[i]);
                return true;
            }
        }
        System.out.println("Item could not be found!");
        return false;
    }

    //Remove an item given its iD.
    public static boolean removeItem(int iD){
        for(int i = 0; i < 1000; i++){
            if(iDs[i] == iD){
                iDs[i] = 0;
                names[i] = "";
                pricePerUnit[i] = 0f;
                totalItems--;
                System.out.println("Item " + iD + " was successfully removed.");
                return true;
            }
        }
        System.out.println("Item " + iD + " could not be removed.");
        return false;
    }

    //Buy item with discount at bulk
    public static float buyItem(int iD, int count){
        for(int i = 0; i < 1000; i++){
            if(iDs[i] == iD){
                if (count <= 4){
                    float totalSum = count * pricePerUnit[i];
                    System.out.println("Total price: " + totalSum);
                    return totalSum;
                } else {
                    float totalSum = ((4 * pricePerUnit[i]) + ((count - 4)*(pricePerUnit[i]*0.7f)));
                    System.out.println("Total price with discount: " + totalSum);
                    return totalSum;

                }
            }
        }
        System.out.println("Could not find given iD");
        return -1;
    }
}

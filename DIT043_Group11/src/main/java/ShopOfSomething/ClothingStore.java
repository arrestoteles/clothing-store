package ShopOfSomething;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class ClothingStore {

    ArrayList<Item> items = new ArrayList<Item>();
    ArrayList<Log> history = new ArrayList<Log>();

    public static void main(String[] args){

        ClothingStore store = new ClothingStore();
        store.printMainMenu();
        store.mainMenuHandler();

        }
    public void printMainMenu(){
        String EOL = System.lineSeparator();
        System.out.print("-------------------------------------------" + EOL +
                "Main Menu: Please choose among the options below." + EOL +

                "0. Close System." + EOL +
                "1. Open Item options." + EOL +
                "2. Open Review options" + EOL +
                "3. Open Transaction History options." + EOL +

                "Type an option number: ");

    }
    public void mainMenuHandler(){
        int selection = UserInput.readInt();
        switch(selection){
            case 0:
                System.out.println("You have chosen: Close system.");
                System.exit(0);
            case 1:
                System.out.println("You have chosen: Open ShopOfSomething.Item options.");
                printOpenItemOptions();
                optionItemHandler();
                break;
            case 2:
                System.out.println("You have chosen: Open ShopOfSomething.Review options.");
                printOpenReviewOptions();
                openReviewHandler();
                break;
            case 3:
                System.out.println("You have chosen: Open Transaction History options.");
                printTransactionHistoryOptions();
                openTransactionHandler(); // find better solution that recursion
                break;
            default:
                System.out.print("Invalid option, Please try again: ");
                mainMenuHandler();
        }

    }

    public void printOpenItemOptions() {
        String EOL = System.lineSeparator();
        System.out.print("-------------------------------------------" + EOL +
                "ShopOfSomething.Item options menu: " + EOL +
                "0. Return to Main Menu." + EOL +
                "1. Create an ShopOfSomething.Item." + EOL +
                "2. Remove an ShopOfSomething.Item." + EOL +
                "3. Print all registered Items." + EOL +
                "4. Buy an ShopOfSomething.Item." + EOL +
                "5. Update an item’s name." + EOL +
                "6. Update an item’s price." + EOL +

                "Type an option number: ");
    }
    public void optionItemHandler(){
        while (true){ //never use while(true)
            int selection = UserInput.readInt();
            switch (selection) {
                case 0:
                    System.out.println("You have chosen: Return to Main Menu.");
                    printMainMenu();
                    mainMenuHandler();
                    break;
                case 1:
                    System.out.println("You have chosen: Create an ShopOfSomething.Item.");
                    System.out.println("What is the name of the item? ");
                    String name = UserInput.readStr();
                    System.out.println("What is the price? ");
                    double price = UserInput.SCANNER.nextDouble();
                    UserInput.SCANNER.nextLine();
                    System.out.println("What is your iD? ");
                    String iD = UserInput.readStr();
                    createItem(iD, name, price);
                    printOpenItemOptions();
                    break;
                case 2:
                    System.out.println("You have chosen: Remove an ShopOfSomething.Item.");
                    System.out.println("What item do you want to remove? ");
                    String remove = UserInput.readStr();
                    removeItem(remove);
                    printOpenItemOptions();
                    break;
                case 3:
                    System.out.println("You have chosen: Print all registered Items. ");
                    printAllItems();
                    printOpenItemOptions();
                    break;
                case 4:
                    System.out.println("You have chosen: Buy an ShopOfSomething.Item. ");
                    System.out.println("What item do you want to buy? ");
                    String buyID = UserInput.readStr();
                    System.out.println("How many do you want to buy? ");
                    int count = UserInput.readInt();
                    buyItem(buyID, count);
                    printOpenItemOptions();
                    break;
                case 5:
                    System.out.println("You have chosen: Update an item's name.");
                    System.out.println("ShopOfSomething.Item iD: ");
                    iD = UserInput.readStr();
                    System.out.println("ShopOfSomething.Item name: ");
                    name = UserInput.readStr();
                    updateItemName( iD, name);
                    printOpenItemOptions();
                    break;
                case 6:
                    System.out.println("You have chosen: Update an item's price.");
                    System.out.println("ShopOfSomething.Item iD: ");
                    iD = UserInput.readStr();
                    System.out.println("ShopOfSomething.Item price: ");
                    price = UserInput.readDouble();
                    updateItemPrice( iD, price);
                    printOpenItemOptions();
                    break;
                default:
                    System.out.print("Invalid Option. Please try again: ");
            }
        }
    }

    public void printOpenReviewOptions() {
        String EOL = System.lineSeparator();
        System.out.print("-------------------------------------------\n" + EOL +
                "Reviews options menu:\n" + EOL +
                "0. Return to Main Menu.\n" + EOL +
                "1. Create a review for an ShopOfSomething.Item.\n" + EOL +
                "2. Print a specific review of an ShopOfSomething.Item.\n" + EOL +
                "3. Print all reviews of an ShopOfSomething.Item.\n" + EOL +
                "4. Print mean grade of an ShopOfSomething.Item\n" + EOL +
                "5. Print all comments of an ShopOfSomething.Item.\n" + EOL +
                "6. Print all registered reviews.\n" + EOL +
                "7. Print item(s) with most reviews.\n" + EOL +
                "8. Print item(s) with least reviews.\n" + EOL +
                "9. Print item(s) with best mean review grade.\n" + EOL +
                "10. Print item(s) with worst mean review grade.\n" + EOL +

                "Type an option number: ");
    }
    public void openReviewHandler(){
        int selection = UserInput.readInt();
        switch (selection){
            case 0:
                System.out.println("You have chosen: Return to Main Menu.");
                printMainMenu();
                mainMenuHandler();
                break;
            case 1:
                System.out.println("You have chosen: Create a review for an ShopOfSomething.Item.");
                break;
            case 2:
                System.out.println("You have chosen: Print a specific review of an ShopOfSomething.Item.");
                break;
            case 3:
                System.out.println("You have chosen: Print all reviews of an ShopOfSomething.Item");
                break;
            case 4:
                System.out.println("You have chosen: Print mean grade of an ShopOfSomething.Item");
                break;
            case 5:
                System.out.println("You have chosen: Print all comments of an ShopOfSomething.Item");
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
            default:
                System.out.print("Invalid Option. Please try again: ");
                openReviewHandler();
        }
    }

    public void printTransactionHistoryOptions() {
        String EOL = System.lineSeparator();
        System.out.print("-------------------------------------------" + EOL +
                "Transaction History options menu:" + EOL +
                "0. Return to Main Menu." + EOL +
                "1. Print total profit from all item purchases" + EOL +
                "2. Print total units sold from all item purchases" + EOL +
                "3. Print the total number of item transactions made." + EOL +
                "4. Print all transactions made." + EOL +
                "5. Print the total profit of a specific item." + EOL +
                "6. Print the number of units sold of a specific item." + EOL +
                "7. Print all transactions of a specific item." + EOL +
                "8. Print item with highest profit." + EOL +

                "Type an option number: ");
    }
    public void openTransactionHandler(){
        while (true) {
            int selection = UserInput.readInt();
            switch (selection){
                case 0:
                    System.out.println("You have chosen: Return to Main Menu.");
                    printMainMenu();
                    mainMenuHandler();
                    break;
                case 1:
                    System.out.println("You have chosen: Print total profit from all item purchases.");
                    printProf(totProfAll());
                    printTransactionHistoryOptions();
                    break;
                case 2:
                    System.out.println("You have chosen: Print total units sold from all item purchases");
                    printCount(totCountAll());
                    printTransactionHistoryOptions();

                    break;
                case 3:
                    System.out.println("You have chosen: Print the total number of item transactions made");
                    printPurch(totPurchAll());
                    printTransactionHistoryOptions();
                    break;
                case 4:
                    System.out.println("You have chosen: Print all transactions made.");
                    printAllTransactions();
                    printTransactionHistoryOptions();
                    break;
                case 5:
                    System.out.println("You have chosen: Print the total profit of a specific item.");
                    System.out.println("ShopOfSomething.Item iD: ");
                    String iD = UserInput.readStr();
                    printProf(totProfID(iD));
                    printTransactionHistoryOptions();
                    break;
                case 6:
                    System.out.println("You have chosen: Print the number of units sold of a specific item.");
                    System.out.println("ShopOfSomething.Item iD: ");
                    iD = UserInput.readStr();
                    printCount(totCountID(iD));
                    printTransactionHistoryOptions();
                    break;
                case 7:
                    System.out.println("You have chosen: Print all transactions of a specific item.");
                    System.out.println("ShopOfSomething.Item iD: ");
                    iD = UserInput.readStr();
                    totInfoID(iD);
                    printTransactionHistoryOptions();
                    break;
                case 8:
                    System.out.println("You have chosen: Print item with highest profit.");
                    findHighestSaleItem();
                    printTransactionHistoryOptions();
                    break;
                default:
                    System.out.print("Invalid Option. Please try again: ");
            }
        }
    }


    // A method for checking if an array contains an element(if already exists)
    public boolean containsElement(String item) {
        for (Item i : items) {
            if(i.getiD().equals(item)) {
                return true;
            }
        }
        return false;
    }

    //Prints all item with valid iD
    public String printAllItems(){
       if(items.isEmpty()){
           return "No items registered yet.";
       }
        String message = "All registered items:" + System.lineSeparator();
        for (Item i: items) {
            message += printItem(i.getiD()) + System.lineSeparator();
        }
        return message;
    }


    //Prints a single item.
    public String printItem(String itemID) {
        Item item = findItem(itemID);
        if(item == null){
            return "ShopOfSomething.Item " + itemID + " was not registered yet.";
        }
        String iD = item.getiD();
        String name = item.getName();
        double price = item.getPrice();
        return (iD + ": " + name + ". " + UserInput.decimalFormat(price) + " SEK");
    }

    // creates an item if the item is valid and iD does not exist already
    public String createItem(String iD, String name, double price){
        if(!(isItemValid(iD, name, price))){ //if item invalid
            String message = "Invalid data for item.";
            return message;
        }


        Item item = new Item(iD, name, price);

        if(containsElement(item.getiD())){ // if iD already exists
            String message = "ShopOfSomething.Item " + iD + " already exist";
            return message;
        }

        items.add(item);
        System.out.println("Item:");
        System.out.println(iD);
        return ("ShopOfSomething.Item " + iD + " was registered successfully.");
        //return message;
    }
    // checks if item is valid
    public boolean isItemValid(String iD, String name, double price) {
        //Empty iD
        if((iD.isEmpty())) {
            System.out.println("Invalid data for item." + iD + " (Wrong iD)");
            return false;
        }
        //Empty Name
        if(name.isEmpty()){
            System.out.println("Invalid data for item." + name + " (Wrong name)");
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
    public String updateItemName(String iD, String name) {
        Item item = findItem(iD);
        if(item == null) {
            return ("ShopOfSomething.Item " + iD + " was not registered yet.");
        }else if(name.isEmpty()){
            return "Invalid data for item.";
        }
        item.updateItem(name, item.getPrice());
        return ("ShopOfSomething.Item " + iD +" was updated successfully.");
    }
    public String updateItemPrice(String iD, double price) {
        Item item = findItem( iD);
        if(item == null) {
            return ("ShopOfSomething.Item " + iD + " was not registered yet.");
        } else if(price <= 0){
            return "Invalid data for item.";
        }
        item.updateItem(item.getName(), price);
        return ("ShopOfSomething.Item "+ iD + " was updated successfully.");
    }
    //Print a specific item's ID, price and name
    public boolean printSpecificItem(String iD) {
        Item item = findItem( iD);
        if(item == null) {
            System.out.println("ShopOfSomething.Item " + iD + " could not be found.");
            return false;
        }
        printItem(item.getiD());
        return true;
    }
    //Remove an item given its iD.
    public String removeItem(String iD) {
        Item item = findItem( iD);
        if(item == null) {
            return ("ShopOfSomething.Item " + iD + " could not be removed.");

        }
        items.remove(item);
        return ("ShopOfSomething.Item " + iD + " was successfully removed.");

    }
    public Item findItem(String iD ) {
        for (Item i: items) {
            if(i.getiD().equals(iD)) {
                return i;
            }
        }
        return null;
    }
    //Buy item with discount at bulk
    public double buyItem(String iD, int count) {
        Item item = findItem(iD);
        if (item == null) {
            System.out.println("ShopOfSomething.Item " + iD + " could not be found.");
            return -1;
        }
        double totalSum;
        if (count <= 4) {
            totalSum = count * item.getPrice();
            System.out.println("Total price: " + UserInput.decimalFormat(totalSum));
        } else {
            totalSum = ((4 * item.getPrice()) + ((count - 4) * (item.getPrice() * 0.7f)));
            System.out.println("Total price with discount: " + UserInput.decimalFormat(totalSum));
        }

        history.add(new Log(item.getiD(), count, totalSum));
        return Double.parseDouble(UserInput.decimalFormat(totalSum));
    }
    public double totProfAll() {
        double profit = 0;
        for(Log l: history) {
            profit += l.getPrice();
        } return profit;
    }
    public double totProfID(String iD) {
        double profit = 0;
        for(Log l: history) {
            if (l.getiD().equals(iD)) {
                profit += l.getPrice();
            }
        } return profit;
    }
    public int totCountID(String iD) {
        int count = 0;
        for(Log l: history) {
            if (l.getiD().equals(iD)) {
                count += l.getCount();
            }
        } return count;
    }
    public int totCountAll() {
        int count = 0;
        for(Log l: history) {
            count += l.getCount();
        } return count;
    }
    public int totPurchAll() {
        return history.size();
    }
    public void totInfoID(String iD) {
        boolean exists = false;
        for(Item item:items){
            if(item.getiD().equals(iD)){
                exists = true;
                break;
            }
        }
        if(!exists) {
            System.out.println("ShopOfSomething.Item "+ iD+" was not registered yet.");
            return;
        }


        double profit = 0;
        int count = 0;
        int purchases = 0;

        for (Log l: history) {
            if(l.getiD().equals(iD)) {
                profit += l.getPrice();
                count += l.getCount();
                purchases += 1;
            }
        }
        Item item = findItem(iD);
        System.out.println("Transactions for item: " + iD + " " + item.getName() + " " + item.getPrice() + " SEK");
        if(purchases == 0){
            System.out.println("No transactions have been registered for item "+iD+" yet.");
            return;
        }
        printProf(profit);
        printCount(count);
        printPurch(purchases);
    }
    public void printProf(double profit) {
        System.out.println("Total profit: " + profit + " SEK");
    }
    public void printCount(int count) {
        System.out.println("Total items sold: " + count + " units");
    }
    public void printPurch(int purchases) {
        System.out.println("Total purchases made: " + purchases + " transactions");
    }
    public void printAllTransactions() {
        System.out.println("All purchases made: ");
        printProf(totProfAll());
        printCount(totCountAll());
        printPurch(totPurchAll());
        System.out.println("------------------------------------");
        for(Log l: history){
            l.printTransaction();
        }
        System.out.println("------------------------------------");
    }
    public void findHighestSaleItem() {

        if(items.size() == 0) {
            System.out.println("No items registered yet.");
            return;
        }
        if(history.size() == 0) {
            System.out.println("No items were bought yet.");
            return;
        }


        //Find all unique ids
        Set<String> iDs = new HashSet<String>();
        for (Log l:history){
            iDs.add(l.getiD());
        }
        
        double max = 0;
        //FIND MAX
        for(String iD:iDs) {
            if(totProfID(iD) > max) {
                max = totProfID(iD);
            }
        }

        ArrayList<String> maxProfitableIDS = new ArrayList<>();
        //IF MULTIPLE MAX PROFIT ITEMS > SAVE ALL
        for(String iD:iDs) {
            if(totProfID(iD) == max) {
                maxProfitableIDS.add(iD);
            }
        }


        System.out.println("Most profitable items:");
        System.out.println("Total profit: " + max + " SEK");
        //Run loop incase of multiple max profits
        for(String iD:maxProfitableIDS){
            printItem(iD);
        }
    }
}

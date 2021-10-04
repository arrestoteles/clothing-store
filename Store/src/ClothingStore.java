import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class ClothingStore {

    ArrayList<Item> items = new ArrayList<Item>();
    ArrayList<Log> history = new ArrayList<Log>();
    public static void main(String[] args){

        ClothingStore store = new ClothingStore();
       // store.createItem("ID01","Addidas" , 1750);
        //store.buyItem("ID01",1);
        //store.createItem("ID002","Nike",250);
        //store.buyItem("ID002",4);
        //store.buyItem("ID002",3);
        store.printMainMenu();
       store.mainMenuHandler();


        }
    public void printMainMenu(){
        System.out.print("-------------------------------------------\n"+
                "Main Menu: Please choose among the options below.\n" +
                "\n" +
                "0. Close System.\n" +
                "1. Open Item options.\n" +
                "2. Open Review options\n" +
                "3. Open Transaction History options.\n" +
                "\n" +
                "Type an option number: ");

    }
    public void mainMenuHandler(){
        int selection = UserInput.readInt();
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
                openTransactionHandler(); // find better solution that recursion
                break;
            default:
                System.out.print("Invalid option, Please try again: ");
                mainMenuHandler();
        }

    }

    public void printOpenItemOptions(){
        System.out.print("-------------------------------------------\n"+
                "Item options menu:\n" +
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
    public void optionItemHandler(){
        while (true){
            int selection = UserInput.readInt();
            switch (selection) {
                case 0:
                    System.out.println("You have chosen: Return to Main Menu.");
                    printMainMenu();
                    mainMenuHandler();
                    break;
                case 1:
                    System.out.println("You have chosen: Create an Item.");
                    System.out.println("What is the name of the item? ");
                    String name = UserInput.readStr();
                    System.out.println("What is the price? ");
                    double price = UserInput.SCANNER.nextFloat();
                    UserInput.SCANNER.nextLine();
                    System.out.println("What is your iD? ");
                    String iD = UserInput.readStr();
                    createItem( iD, name, price);
                    printOpenItemOptions();
                    break;
                case 2:
                    System.out.println("You have chosen: Remove an Item.");
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
                    System.out.println("You have chosen: Buy an Item. ");
                    System.out.println("What item do you want to buy? ");
                    String buyID = UserInput.readStr();
                    System.out.println("How many do you want to buy? ");
                    int count = UserInput.readInt();
                    buyItem( buyID, count);
                    printOpenItemOptions();
                    break;
                case 5:
                    System.out.println("You have chosen: Update an item's name.");
                    System.out.println("Item iD: ");
                    iD = UserInput.readStr();
                    System.out.println("Item name: ");
                    name = UserInput.readStr();
                    updateItemName( iD, name);
                    printOpenItemOptions();
                    break;
                case 6:
                    System.out.println("You have chosen: Update an item's price.");
                    System.out.println("Item iD: ");
                    iD = UserInput.readStr();
                    System.out.println("Item price: ");
                    price = UserInput.readDouble();
                    updateItemPrice( iD, price);
                    printOpenItemOptions();
                    break;
                default:
                    System.out.print("Invalid Option. Please try again: ");
            }
        }
    }

    public void printOpenReviewOptions(){
        System.out.print("-------------------------------------------\n"+
                "Reviews options menu:\n" +
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
    public void openReviewHandler(){
        int selection = UserInput.readInt();
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
            default:
                System.out.print("Invalid Option. Please try again: ");
                openReviewHandler();
        }
    }

    public void printTransactionHistoryOptions(){
        System.out.print("-------------------------------------------\n"+
                "Transaction History options menu:\n" +
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
                    System.out.println("Item iD: ");
                    String iD = UserInput.readStr();
                    printProf(totProfID(iD));
                    printTransactionHistoryOptions();
                    break;
                case 6:
                    System.out.println("You have chosen: Print the number of units sold of a specific item.");
                    System.out.println("Item iD: ");
                    iD = UserInput.readStr();
                    printCount(totCountID(iD));
                    printTransactionHistoryOptions();
                    break;
                case 7:
                    System.out.println("You have chosen: Print all transactions of a specific item.");
                    System.out.println("Item iD: ");
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
    public boolean containsElement(Item item){
        for (Item i: items) {
            if(i.getiD().equals(item.getiD())){
                return true;
            }
        }
        return false;
    }

    //Prints all item with valid iD
    public void printAllItems(){
        for (Item i: items) {
            printItem(i);
        }

    }

    //Prints a single item.
    public void printItem(Item item){
        String iD = item.getiD();
        String name = item.getName();
        double price = item.getPrice();
        System.out.println(iD + ": " + name + ". " + price + " SEK.");
    }

    // creates an item if the item is valid and iD does not exist already
    public boolean createItem( String iD, String name, double price){

        if(!(isItemValid(iD, name, price))){ //if item invalid
            return false;

        }
        Item item = new Item(iD, name, price);
        if(containsElement( item)){ // if iD already exists
            System.out.println("Item " + iD + " already exist");
            return false;
        }
        items.add(item);
        System.out.println("Item " + iD + " was registered successfully.");
        return true;
    }

    // checks if item is valid
    public boolean isItemValid(String iD, String name, double price){
        //Empty iD
        if((iD.equals(null))) {
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
    public boolean updateItemName( String iD, String name){
        Item item = findItem( iD);
        if(item == null) {
            System.out.println("Item " + iD + " could not be found.");
            return false;
        }
        item.updateItem(name, item.getPrice());
        System.out.println("Item updated successfully.");
        return true;
    }
    public boolean updateItemPrice( String iD, double price){
        Item item = findItem( iD);
        if(item == null) {
            System.out.println("Item " + iD + " could not be found.");
            return false;
        }
        item.updateItem(item.getName(), price);
        System.out.println("Item updated successfully.");
        return true;
    }

    //Print a specific item's ID, price and name
    public boolean printSpecificItem( String iD){
        Item item = findItem( iD);
        if(item == null) {
            System.out.println("Item " + iD + " could not be found.");
            return false;
        }
        printItem(item);
        return true;
    }

    //Remove an item given its iD.
    public boolean removeItem( String iD){
        Item item = findItem( iD);
        if(item == null) {
            System.out.println("Item " + iD + " could not be removed.");
            return false;
        }
        items.remove(item);
        System.out.println("Item " + iD + " was successfully removed.");
        return true;
    }
    public Item findItem( String iD ) {
        for (Item i: items) {
            if(i.getiD().equals(iD)) {
                return i;
            }
        }
        return null;
    }

    //Buy item with discount at bulk
    public double buyItem( String iD, int count) {
        Item item = findItem(iD);
        if (item == null) {
            System.out.println("Item " + iD + " could not be found.");
            return -1;
        }
        double totalSum;
        if (count <= 4) {
            totalSum = count * item.getPrice();
            System.out.println("Total price: " + totalSum);
        } else {
            totalSum = ((4 * item.getPrice()) + ((count - 4) * (item.getPrice() * 0.7f)));
            System.out.println("Total price with discount: " + totalSum);
        }

        history.add(new Log(item.getiD(), count, totalSum));
        return totalSum;
    }
    public double totProfAll(){
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

    public int totCountAll(){
        int count = 0;
        for(Log l: history) {
            count += l.getCount();
        } return count;
    }

    public int totPurchAll(){
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
        if(!exists){
            System.out.println("Item "+ iD+" was not registered yet.");
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
    public void printProf(double profit){
        System.out.println("Total profit: " + profit + " SEK");
    }
    public void printCount(int count) {
        System.out.println("Total items sold: " + count + " units");
    }
    public void printPurch(int purchases){
        System.out.println("Total purchases made: " + purchases + " transactions");
    }
    public void printAllTransactions(){
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
    public void findHighestSaleItem(){

        if(items.size() == 0){
            System.out.println("No items registered yet.");
            return;
        }
        if(history.size() == 0){
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
        for(String iD:iDs)    {
            if(totProfID(iD) > max){
                max = totProfID(iD);
            }
        }

        ArrayList<String> maxProfitableIDS = new ArrayList<>();
        //IF MULTIPLE MAX PROFIT ITEMS > SAVE ALL
        for(String iD:iDs){
            if(totProfID(iD) == max){
                maxProfitableIDS.add(iD);
            }
        }


        System.out.println("Most profitable items:");
        System.out.println("Total profit: " + max + " SEK");
        //Run loop incase of multiple max profits
        for(String iD:maxProfitableIDS){
            printItem(findItem(iD));
        }





    }
}

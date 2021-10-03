import java.util.ArrayList;

public class ClothingStore {

    ArrayList<Item> items = new ArrayList<Item>();
    public static void main(String[] args){

        ClothingStore store = new ClothingStore();
        store.printMainMenu();
        store.mainMenuHandler();


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
    public void optionItemHandler(){
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
                int iD = UserInput.readInt();
                createItem( iD, name, price);
                printOpenItemOptions();
                optionItemHandler();
                //printAllItems();
                break;
            case 2:
                System.out.println("You have chosen: Remove an Item.");
                System.out.println("What item do you want to remove? ");
                int remove = UserInput.readInt();
                removeItem( remove);
                printOpenItemOptions();
                optionItemHandler();
                break;
            case 3:
                System.out.println("You have chosen: Print all registered Items. ");
                printAllItems();
                printOpenItemOptions();
                optionItemHandler();
                break;
            case 4:
                System.out.println("You have chosen: Buy an Item. ");
                System.out.println("What item do you want to buy? ");
                int buyID = UserInput.readInt();
                System.out.println("How many do you want to buy? ");
                int count = UserInput.readInt();
                buyItem( buyID, count);
                printOpenItemOptions();
                optionItemHandler();
                break;
            case 5:
                System.out.println("You have chosen: Update an item's name.");
                System.out.println("Item iD: ");
                iD = UserInput.readInt();
                System.out.println("Item name: ");
                name = UserInput.readStr();
                updateItemName( iD, name);
                printOpenItemOptions();
                optionItemHandler();
                break;
            case 6:
                System.out.println("You have chosen: Update an item's price.");
                System.out.println("Item iD: ");
                iD = UserInput.readInt();
                System.out.println("Item price: ");
                price = UserInput.readDouble();
                updateItemPrice( iD, price);
                printOpenItemOptions();
                optionItemHandler();
                break;
            default:
                System.out.print("Invalid Option. Please try again: ");
                optionItemHandler();
            }
    }

    public void printOpenReviewOptions(){
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
    public void openTransactionHandler(){
        int selection = UserInput.readInt();
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
            default:
                System.out.print("Invalid Option. Please try again: ");
                openTransactionHandler();
        }
    }


    // A method for checking if an array contains an element(if already exists)
    public boolean containsElement(Item item){
        for (Item i: items) {
            if(i.getiD() == (item.getiD())){
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
        int iD = item.getiD();
        String name = item.getName();
        double price = item.getPrice();
        System.out.println(iD + ": " + name + ". " + price + " SEK.");
    }

    // creates an item if the item is valid and iD does not exist already
    public boolean createItem( int iD, String name, double price){

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
    public boolean isItemValid(int iD, String name, double price){
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
    public boolean updateItemName( int iD, String name){
        Item item = findItem( iD);
        if(item == null) {
            System.out.println("Item " + iD + " could not be found.");
            return false;
        }
        item.updateItem(name, item.getPrice());
        System.out.println("Item updated successfully.");
        return true;
    }
    public boolean updateItemPrice( int iD, double price){
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
    public boolean printSpecificItem( int iD){
        Item item = findItem( iD);
        if(item == null) {
            System.out.println("Item " + iD + " could not be found.");
            return false;
        }
        printItem(item);
        return true;
    }

    //Remove an item given its iD.
    public boolean removeItem( int iD){
        Item item = findItem( iD);
        if(item == null) {
            System.out.println("Item " + iD + " could not be removed.");
            return false;
        }
        items.remove(item);
        System.out.println("Item " + iD + " was successfully removed.");
        return true;
    }
    public Item findItem( int iD ) {
        for (Item i: items) {
            if(i.getiD() == iD) {
                return i;
            }
        }
        return null;
    }

    //Buy item with discount at bulk
    public double buyItem( int iD, int count){
        Item item = findItem( iD);
        if(item == null) {
            System.out.println("Item " + iD + " could not be found.");
            return -1;
        }
        if (count <= 4){
            double totalSum = count * item.getPrice();
            System.out.println("Total price: " + totalSum);
            return totalSum;
        } else {
            double totalSum = ((4 * item.getPrice()) + ((count - 4) * (item.getPrice() * 0.7f)));
            System.out.println("Total price with discount: " + totalSum);
            return totalSum;
        }
    }
}

package ShopOfSomething.controllers;

import ShopOfSomething.models.Item;
import ShopOfSomething.models.Transaction;
import ShopOfSomething.UserIO;

import java.util.ArrayList;

public class ItemController {
    private ArrayList<Item> items;
    private ArrayList<Transaction> transactionhistory;
    public ItemController(ArrayList<Item> items, ArrayList<Transaction> transactionhistory) {
        this.items = items;
        this.transactionhistory = transactionhistory;

    }

    // A method for checking if an array contains an element(if already exists)
    public boolean containsItem(String item) {
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
            return "Item " + itemID + " was not registered yet.";
        } else {
            String iD = item.getiD();
            String name = item.getName();
            double price = item.getPrice();
            return (iD + ": " + name + ". " + UserIO.decimalFormat(price) + " SEK");
        }
    }

    // creates an item if the item is valid and iD does not exist already
    public String createItem(String iD, String name, double price){
        if(!(isItemValid(iD, name, price))){ //if item invalid
            String message = "Invalid data for item.";
            return message;
        }

        Item item = new Item(iD, name, price);

        if(containsItem(item.getiD())){ // if iD already exists
            String message = "Item " + iD + " already exist";
            return message;
        }

        items.add(item);
        System.out.println("Item:");
        System.out.println(iD);
        return ("Item " + iD + " was registered successfully.");
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
            return ("Item " + iD + " was not registered yet.");
        }else if(name.isEmpty()){
            return "Invalid data for item.";
        }
        item.updateItem(name, item.getPrice());
        return ("Item " + iD +" was updated successfully.");
    }

    public String updateItemPrice(String iD, double price) {
        Item item = findItem( iD);
        if(item == null) {
            return ("Item " + iD + " was not registered yet.");
        } else if(price <= 0){
            return "Invalid data for item.";
        }
        item.updateItem(item.getName(), price);
        return ("Item "+ iD + " was updated successfully.");
    }

    //Print a specific item's ID, price and name
    public String printSpecificItem(String iD) {
        Item item = findItem( iD);
        if(item == null) {
            return ("Item " + iD + " could not be found.");

        }
        return printItem(item.getiD());
    }

    //Remove an item given its iD.
    public String removeItem(String iD) {
        Item item = findItem( iD);
        if(item == null) {
            return ("Item " + iD + " could not be removed.");

        }
        items.remove(item);
        return ("Item " + iD + " was successfully removed.");

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
            System.out.println("Item " + iD + " could not be found.");
            return -1;
        }
        double totalSum;
        if (count <= 4) {
            totalSum = count * item.getPrice();
            System.out.println("Total price: " + UserIO.decimalFormat(totalSum));
        } else {
            totalSum = ((4 * item.getPrice()) + ((count - 4) * (item.getPrice() * 0.7)));
            System.out.println("Total price with discount: " + UserIO.decimalFormat(totalSum));
        }

        transactionhistory.add(new Transaction(item.getiD(), count, totalSum));
        return UserIO.truncateFormat2(totalSum);
    }

}

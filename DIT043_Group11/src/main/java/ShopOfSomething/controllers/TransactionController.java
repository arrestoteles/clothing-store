package ShopOfSomething.controllers;

import ShopOfSomething.models.Item;
import ShopOfSomething.models.Transaction;
import ShopOfSomething.UserIO;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class TransactionController {
    private ArrayList<Item> items;
    private ArrayList<Transaction> transactionhistory;
    private ItemController itemController;

    public TransactionController(ArrayList<Item> items, ArrayList<Transaction> transactionhistory, ItemController itemController) {
        this.items = items;
        this.transactionhistory = transactionhistory;
        this.itemController = itemController;
    }

    public double getTotalProfit() {
        double profit = 0;
        for(Transaction l: transactionhistory) {
            profit += Double.parseDouble(UserIO.decimalFormat(l.getPrice()));
        } return Double.parseDouble(UserIO.decimalFormat(profit));
    }

    public double getProfit(String iD) {
        double profit = 0;
        for(Transaction l: transactionhistory) {
            if (l.getiD().equals(iD)) {
                profit += Double.parseDouble(UserIO.decimalFormat(l.getPrice()));
            }
        } return Double.parseDouble(UserIO.decimalFormat(profit));
    }

    public int getUnitsSolds(String iD) {
        int count = 0;
        for(Transaction l: transactionhistory) {
            if (l.getiD().equals(iD)) {
                count += l.getCount();
            }
        } return count;
    }

    public int getTotalUnitsSold() {
        int count = 0;
        for(Transaction l: transactionhistory) {
            count += l.getCount();
        } return count;
    }

    public int getTotalTransactions() {
        return transactionhistory.size();
    }

    public String printItemTransactions(String iD) {
        boolean exists = false;
        for(Item item:items){
            if(item.getiD().equals(iD)){
                exists = true;
                break;
            }
        }
        if(!exists) {
            return ("Item "+ iD+" was not registered yet.");

        }


        double profit = 0;
        int count = 0;
        int purchases = 0;

        for (Transaction l: transactionhistory) {
            if(l.getiD().equals(iD)) {
                profit += l.getPrice();
                count += l.getCount();
                purchases += 1;
            }
        }
        String message = "";
        Item item = itemController.findItem(iD);
        message += iD + ": " + item.getName() + ". " + UserIO.decimalFormat(item.getPrice()) + " SEK" + System.lineSeparator();
        for (Transaction l: transactionhistory) {
            if(l.getiD().equals(iD)) {
                message += iD + ": " + l.getCount() + " item(s). " + UserIO.decimalFormat(l.getPrice()) + " SEK" + System.lineSeparator();

            }
        }
        //Item item = findItem(iD);
        //message += iD + ": " + item.getName() + ". " + item.getPrice() + " SEK" + System.lineSeparator();
        if(purchases == 0){
            message += ("No transactions have been registered for item "+iD+" yet.");

        }
        printProf(profit);
        printCount(count);
        printPurch(purchases);
        return "Transactions for item: " + message;
    }

    public String printProf(double profit) {
        return ("Total profit: " + UserIO.decimalFormat(profit) + " SEK" + System.lineSeparator());
    }

    public String printCount(int count) {
        return ("Total items sold: " + count + " units" + System.lineSeparator());
    }

    public String printPurch(int purchases) {
        return ("Total purchases made: " + purchases + " transactions" + System.lineSeparator());
    }

    public String printAllTransactions() {
        String message = "All purchases made: " + System.lineSeparator() + printProf(getTotalProfit()) +
                printCount(getTotalUnitsSold()) + printPurch(getTotalTransactions()) + ("------------------------------------") +
                System.lineSeparator();

        for(Transaction l: transactionhistory){
            message += l.printTransaction();
        }

        return message + ("------------------------------------") + System.lineSeparator();

    }

    public String printMostProfitableItems() {

        if(items.size() == 0) {
            return ("No items registered yet.");
        }
        if(transactionhistory.size() == 0) {
            return ("No items were bought yet.");
        }

        //Find all unique ids
        Set<String> iDs = new HashSet<String>();
        for (Transaction l: transactionhistory){
            iDs.add(l.getiD());
        }

        double max = 0;
        //FIND MAX
        for(String iD:iDs) {
            if(getProfit(iD) > max) {
                max = getProfit(iD);
            }
        }

        ArrayList<String> maxProfitableIDS = new ArrayList<>();
        //IF MULTIPLE MAX PROFIT ITEMS > SAVE ALL
        for(String iD:iDs) {
            if(getProfit(iD) == max) {
                maxProfitableIDS.add(iD);
            }
        }

        //Run loop incase of multiple max profits
        for(String iD:maxProfitableIDS){
            System.out.println(" Most profitable items: ");
            System.out.println(" Total profit: " + UserIO.decimalFormat(max) + " SEK");

            return "Most profitable items: " + System.lineSeparator() +
                    "Total profit: " + UserIO.decimalFormat(max) + " SEK" + System.lineSeparator() +
                    itemController.printItem(iD) + System.lineSeparator();
        }
        return null;
    }
}

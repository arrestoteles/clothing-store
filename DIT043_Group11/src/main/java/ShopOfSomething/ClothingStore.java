package ShopOfSomething;

import java.util.*;

public class ClothingStore {

    ArrayList<Items> items = new ArrayList<>();
    ArrayList<Transactions> transactionhistory = new ArrayList<>();

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
                "4. Open Employee options." + EOL +
                EOL +

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
                openTransactionHandler();
                break;
            case 4:
                System.out.println("You have chosen: Open Employee options.");
                printEmployeeMenu();
                break;
            default:
                System.out.print("Invalid option, Please try again: ");
                mainMenuHandler();
        }

    }

    public void printOpenItemOptions() {
        String EOL = System.lineSeparator();
        System.out.print("-------------------------------------------" + EOL +
                "Item options menu: " + EOL +
                "0. Return to Main Menu." + EOL +
                "1. Create an Item." + EOL +
                "2. Remove an Item." + EOL +
                "3. Print all registered Items." + EOL +
                "4. Buy an Item." + EOL +
                "5. Update an item’s name." + EOL +
                "6. Update an item’s price." + EOL +
                "7. Print a specific item." + EOL +
                EOL +

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
                    System.out.println("You have chosen: Create an Item.");
                    System.out.println("What is the name of the item? ");
                    String name = UserInput.readStr();
                    System.out.println("What is the price? ");
                    double price = UserInput.SCANNER.nextDouble();
                    UserInput.SCANNER.nextLine();
                    System.out.println("What is your iD? ");
                    String iD = UserInput.readStr();
                    System.out.println(createItem(iD, name, price));
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
                    buyItem(buyID, count);
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
                case 7:
                    System.out.println("You have chosen: Print a specific item.");
                    System.out.println("itemID: ");
                    iD = UserInput.readStr();
                    System.out.println(printSpecificItem(iD));
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
                "Reviews options menu: " + EOL +
                "0. Return to Main Menu. " + EOL +
                "1. Create a review for an Item. " + EOL +
                "2. Print a specific review of an Item. " + EOL +
                "3. Print all reviews of an Item. " + EOL +
                "4. Print mean grade of an Item " + EOL +
                "5. Print all comments of an Item. " + EOL +
                "6. Print all registered reviews. " + EOL +
                "7. Print item(s) with most reviews. " + EOL +
                "8. Print item(s) with least reviews. " + EOL +
                "9. Print item(s) with best mean review grade. " + EOL +
                "10. Print item(s) with worst mean review grade. " + EOL +
                EOL +

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
                EOL +

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
                    printProf(getTotalProfit());
                    printTransactionHistoryOptions();
                    break;
                case 2:
                    System.out.println("You have chosen: Print total units sold from all item purchases");
                    printCount(getTotalUnitsSold());
                    printTransactionHistoryOptions();

                    break;
                case 3:
                    System.out.println("You have chosen: Print the total number of item transactions made");
                    printPurch(getTotalTransactions());
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
                    printProf(getProfit(iD));
                    printTransactionHistoryOptions();
                    break;
                case 6:
                    System.out.println("You have chosen: Print the number of units sold of a specific item.");
                    System.out.println("Item iD: ");
                    iD = UserInput.readStr();
                    printCount(getUnitsSolds(iD));
                    printTransactionHistoryOptions();
                    break;
                case 7:
                    System.out.println("You have chosen: Print all transactions of a specific item.");
                    System.out.println("Item iD: ");
                    iD = UserInput.readStr();
                    printItemTransactions(iD);
                    printTransactionHistoryOptions();
                    break;
                case 8:
                    System.out.println("You have chosen: Print item with highest profit.");
                    printMostProfitableItems();
                    printTransactionHistoryOptions();
                    break;
                default:
                    System.out.print("Invalid Option. Please try again: ");
            }
        }
    }

    public void printEmployeeMenu() {
        String EOL = System.lineSeparator();
        System.out.println("Employee options menu: " + EOL +
                "0. Return to Main Menu." + EOL +
                "1. Create an employee (Regular Employee). " + EOL +
                "2. Create an employee (Manager). " + EOL +
                "3. Create an employee (Director). " + EOL +
                "4. Create an employee (Intern). " + EOL +
                "5. Remove an employee. " + EOL +
                "6. Print specific employee. " + EOL +
                "7. Print all registered employees. " + EOL +
                "8. Print the total expense with net salary. " + EOL +
                "9. Print all employees sorted by gross salary. " + EOL +
                EOL +

                "Type an option number:");

    }
    public void openEmployeeHandler() {
        int selection = UserInput.readInt();
        switch (selection) {
            case 0:
                System.out.println("Return to Main Menu.");
                printMainMenu();
                mainMenuHandler();
                break;
            case 1:
                System.out.println("Create an employee (Regular Employee).");
                break;
            case 2:
                System.out.println("Create an employee (Manager).");
            case 3:
                System.out.println("Create an employee (Director).");
            case 4:
                System.out.println("Create an employee (Intern).");
            case 5:
                System.out.println("Remove an employee.");
            case 6:
                System.out.println("Print specific employee.");
            case 7:
                System.out.println("Print all registered employees.");
            case 8:
                System.out.println("Print the total expense with net salary.");
            case 9:
                System.out.println("Print all employees sorted by gross salary.");
            default:
                System.out.println("Invalid Option. Please try again: ");
        }
    }



    // A method for checking if an array contains an element(if already exists)
    public boolean containsItem(String item) {
        for (Items i : items) {
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
        for (Items i: items) {
            message += printItem(i.getiD()) + System.lineSeparator();
        }
        return message;
    }

    //Prints a single item.
    public String printItem(String itemID) {
        Items item = findItem(itemID);
        if(item == null){
            return "Item " + itemID + " was not registered yet.";
        } else {
            String iD = item.getiD();
            String name = item.getName();
            double price = item.getPrice();
            return (iD + ": " + name + ". " + UserInput.decimalFormat(price) + " SEK");
        }
    }

    // creates an item if the item is valid and iD does not exist already
    public String createItem(String iD, String name, double price){
        if(!(isItemValid(iD, name, price))){ //if item invalid
            String message = "Invalid data for item.";
            return message;
        }

        Items item = new Items(iD, name, price);

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
        Items item = findItem(iD);
        if(item == null) {
            return ("Item " + iD + " was not registered yet.");
        }else if(name.isEmpty()){
            return "Invalid data for item.";
        }
        item.updateItem(name, item.getPrice());
        return ("Item " + iD +" was updated successfully.");
    }


    public String updateItemPrice(String iD, double price) {
        Items item = findItem( iD);
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
        Items item = findItem( iD);
        if(item == null) {
            return ("Item " + iD + " could not be found.");

        }
        return printItem(item.getiD());
    }


    //Remove an item given its iD.
    public String removeItem(String iD) {
        Items item = findItem( iD);
        if(item == null) {
            return ("Item " + iD + " could not be removed.");

        }
        items.remove(item);
        return ("Item " + iD + " was successfully removed.");

    }
    public Items findItem(String iD ) {
        for (Items i: items) {
            if(i.getiD().equals(iD)) {
                return i;
            }
        }
        return null;
    }
    //Buy item with discount at bulk
    public double buyItem(String iD, int count) {
        Items item = findItem(iD);
        if (item == null) {
            System.out.println("Item " + iD + " could not be found.");
            return -1;
        }
        double totalSum;
        if (count <= 4) {
            totalSum = count * item.getPrice();
            System.out.println("Total price: " + UserInput.decimalFormat(totalSum));
        } else {
            totalSum = ((4 * item.getPrice()) + ((count - 4) * (item.getPrice() * 0.7)));
            System.out.println("Total price with discount: " + UserInput.decimalFormat(totalSum));
        }

        transactionhistory.add(new Transactions(item.getiD(), count, totalSum));
        return Double.parseDouble(UserInput.decimalFormat(totalSum));
    }
    public double getTotalProfit() {
        double profit = 0;
        for(Transactions l: transactionhistory) {
            profit += Double.parseDouble(UserInput.decimalFormat(l.getPrice()));
        } return Double.parseDouble(UserInput.decimalFormat(profit));
    }


    public double getProfit(String iD) {
        double profit = 0;
        for(Transactions l: transactionhistory) {
            if (l.getiD().equals(iD)) {
                profit += Double.parseDouble(UserInput.decimalFormat(l.getPrice()));
            }
        } return Double.parseDouble(UserInput.decimalFormat(profit));
    }


    public int getUnitsSolds(String iD) {
        int count = 0;
        for(Transactions l: transactionhistory) {
            if (l.getiD().equals(iD)) {
                count += l.getCount();
            }
        } return count;
    }


    public int getTotalUnitsSold() {
        int count = 0;
        for(Transactions l: transactionhistory) {
            count += l.getCount();
        } return count;
    }


    public int getTotalTransactions() {
        return transactionhistory.size();
    }


    public String printItemTransactions(String iD) {
        boolean exists = false;
        for(Items item:items){
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

        for (Transactions l: transactionhistory) {
            if(l.getiD().equals(iD)) {
                profit += l.getPrice();
                count += l.getCount();
                purchases += 1;
            }
        }
        String message = "";
        Items item = findItem(iD);
        message += iD + ": " + item.getName() + ". " + UserInput.decimalFormat(item.getPrice()) + " SEK" + System.lineSeparator();
        for (Transactions l: transactionhistory) {
            if(l.getiD().equals(iD)) {
                message += iD + ": " + l.getCount() + " item(s). " + UserInput.decimalFormat(l.getPrice()) + " SEK" + System.lineSeparator();

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
        return ("Total profit: " + UserInput.decimalFormat(profit) + " SEK" + System.lineSeparator());
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

        for(Transactions l: transactionhistory){
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
        for (Transactions l: transactionhistory){
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
            System.out.println(" Total profit: " + UserInput.decimalFormat(max) + " SEK");

            return "Most profitable items: " + System.lineSeparator() +
                    "Total profit: " + UserInput.decimalFormat(max) + " SEK" + System.lineSeparator() +
                    printItem(iD) + System.lineSeparator();
        }
        return null;
    }


    public String reviewItem(String itemID, String reviewComment, int reviewGrade) {
        String message;
        if (reviewGrade < 0 || reviewGrade > 5) {
            System.out.println("Invalid value for grade");
            message = "Grade values must be between 1 and 5.";
        } else if (findItem(itemID) == null) {
            message = "Item " + itemID + " not found.";
        } else {
                findItem(itemID).reviewsList.add(new Reviews(itemID, reviewGrade, reviewComment));
                message = "Your item review was registered successfully.";
            }
        return message;
    }


    public String reviewItem(String itemID, int reviewGrade) {
        String message;
        if (reviewGrade < 0 || reviewGrade > 5) {
            System.out.println("Invalid value for grade");
            message = "Grade values must be between 1 and 5.";
        } else if (findItem(itemID) == null) {
            message = "Item " + itemID + " not found.";
        } else {
            findItem(itemID).reviewsList.add(new Reviews(itemID, reviewGrade));
            message = "Your item review was registered successfully.";
        }
        return message;
        }


    public String getItemCommentsPrinted(String itemID) {
        String EOL = System.lineSeparator();
        StringBuilder message = new StringBuilder();
        for (Items item : items) {
            for (Reviews reviews : item.reviewsList) {
                message.append(reviews.getComment()).append(EOL);
            }
        }
        return message.toString();
    }


    public List<String> getItemComments(String itemID) {
        List<String> commentList = new ArrayList<>();
        Items item = findItem(itemID);
        if (item.reviewsList == null) {
            return commentList;
        }
        for (Reviews reviews : item.reviewsList) {
            if (reviews.getComment() != null && !reviews.getComment().isEmpty()) {
                commentList.add(reviews.getComment());
            }
        }
        return commentList;
    }


    public double getItemMeanGrade(String itemID) {
        double meanGrade = 0.00;
        Items item = findItem(itemID);
        if (item.reviewsList.isEmpty()) {
            return 0.00;
        } else {
            for (Reviews reviews : item.reviewsList) {
                meanGrade += reviews.getGrade();
            }
        }
        return UserInput.truncateFormat(meanGrade / item.reviewsList.size());
    }


    public int getNumberOfReviews(String itemID) {
        Items item = findItem(itemID);
        return item.reviewsList.size();
    }


    public String getPrintedItemReview(String itemID, int reviewNumber) {
        Items item = findItem(itemID);
        String currentReview = "";
        if (item.reviewsList.size() < 1) {
            currentReview = "Item " + item.getName() + " has not been reviewed yet.";
        } else if (reviewNumber < 1 || reviewNumber > item.reviewsList.size()) {
            int revNum = item.reviewsList.size();
            currentReview = "Invalid review number. Choose between 1 and " + revNum + ".";
        } else {
            currentReview += item.reviewsList.get(reviewNumber - 1);
        }
        return currentReview;
    }


    public String getPrintedReviews(String itemID) {
        String EOL = System.lineSeparator();
        String reviewOutput = "";
        Items item = findItem(itemID);
        if (item == null) {
            reviewOutput = "Item " + itemID + " was not registered yet.";
        } else {
            reviewOutput = "Review(s) for " + item + EOL;
            if (item.reviewsList.isEmpty()) {
                reviewOutput += "The item " + item.getName() + " has not been reviewed yet.";
                }
            for (Reviews reviews : item.reviewsList) {
                reviewOutput += reviews + EOL;
            }
        }
        return reviewOutput;
    }


    public String printMostReviewedItems() {
        String EOL = System.lineSeparator();
        int max = 0;
        for (Items item : items) {
            if (item.reviewsList.size() > max) {
                max = item.reviewsList.size();
            }
        }

        String count = "Most reviews: " + max + " review(s) each." + EOL;

        if (items.isEmpty()) {
            count = "No items registered yet.";
        } else {
            int num = 0;
            for (Items item : items) {
                if (!item.reviewsList.isEmpty()) {
                    num += 1;
                }
            }
            if (num > 0) {
                for (Items item : items) {
                    if (item.reviewsList.size() == max) {
                        count += item + EOL;
                    }
                }
            } else {
                count = "No items were reviewed yet.";
            }
        }
        return count;
    }


    public List<String> getMostReviewedItems() {
        int max = 0;
        for (Items item : items) {
            if (item.reviewsList.size() > max) {
                max = item.reviewsList.size();
            }
        }
        ArrayList<String> maxReviews = new ArrayList<>();
        for (Items item : items) {
            if (item.reviewsList.size() == max) {
                maxReviews.add(item.getiD());
            }
        }
        return maxReviews;
    }


    public List<String> getLeastReviewedItems() {
        int min = Integer.MAX_VALUE;
        for (Items item : items) {
            if (item.reviewsList.size() < min && item.reviewsList.size() > 0) {
                min = item.reviewsList.size();
            }
        }
        ArrayList<String> minReviews = new ArrayList<>();
        for (Items item : items) {
            if (item.reviewsList.size() == min) {
                minReviews.add(item.getiD());
            }
        }
        return minReviews;
    }


    public String printLeastReviewedItems() {
        String EOL = System.lineSeparator();
        int min = Integer.MAX_VALUE;
        for (Items item : items) {
            if (item.reviewsList.size() < min && item.reviewsList.size() > 0) {
                min = item.reviewsList.size();
            }
        }
        String count = "Least reviews: " + min + " review(s) each." + EOL;

        if (items.isEmpty()) {
            count = "No items registered yet.";
        } else {
            int num = 0;
            for (Items item : items) {
                if (!item.reviewsList.isEmpty()) {
                    num += 1;
                }
            }
            if (num > 0) {
                for (Items item : items) {
                    if (item.reviewsList.size() == min) {
                        count += item + EOL;
                    }
                }
            } else {
                count = "No items were reviewed yet.";
            }
        }
        return count;
    }


    public String printWorseReviewedItems() {
        String EOL = System.lineSeparator();
        String message;
        double meanGrade = 5.00;
        String meanGradeStr = "";
        String storeStr = "";
        String newStr = "";

        if (items.isEmpty()) {
            message = "No items registered yet.";
        } else {
            int num = 0;
            for (Items item : items) {
                if (!item.reviewsList.isEmpty()) {
                    num += 1;
                }
            }
            if (num > 0) {
                message = "Items with worst mean reviews:" + EOL + "Grade: ";
                for (Items item : items) {
                    if (getItemMeanGrade(item.getiD()) <= meanGrade && getItemMeanGrade(item.getiD()) != 0.00) {
                        newStr = item.getiD();
                    }
                }
                meanGrade = getItemMeanGrade(newStr);
                meanGradeStr += getItemMeanGrade(newStr);
                for (Items item : items) {
                    if (getItemMeanGrade(item.getiD()) <= meanGrade && getItemMeanGrade(item.getiD()) != 0.00) {
                        meanGrade = getItemMeanGrade(item.getiD());
                        storeStr += item.getiD() + ": " + item.getName() + ". " + UserInput.decimalFormat(item.getPrice()) + " SEK" + EOL;
                    }
                }
                message += meanGradeStr + EOL + storeStr;
            } else {
                message = "No items were reviewed yet.";
            }
        }
        return message;
    }


    public String printBestReviewedItems() {
        String EOL = System.lineSeparator();
        String message = "Items with best mean reviews:" + EOL;
        double meanGrade = 0.00;
        String meanGradeStr = "";
        String storeStr = "";

        if (items.isEmpty()) {
            message = "No items registered yet.";
        } else {
            int num = 0;
            for (Items item : items) {
                if (!item.reviewsList.isEmpty()) {
                    num += 1;
                }
            }
            if (num > 0) {
                for (Items item : items) {
                    if (getItemMeanGrade(item.getiD()) >= meanGrade) {
                        meanGradeStr = "Grade: " + getItemMeanGrade(item.getiD());
                        meanGrade = getItemMeanGrade(item.getiD());
                        storeStr += item.getiD() + ": " + item.getName() + ". " + UserInput.decimalFormat(item.getPrice()) + " SEK" + EOL;
                    }
                }
                message += meanGradeStr + EOL + storeStr;
            } else {
                message = "No items were reviewed yet.";
            }
        }
        return message;
    }


    public List<String> getWorseReviewedItems() {
        ArrayList<String> worstReviews = new ArrayList<>();
        double min = 5.00;
        for (Items item : items) {
            double currentNum = getItemMeanGrade(item.getiD());
            if (currentNum <= min && currentNum != 0.00) {
                worstReviews.add(item.getiD());
            }
        }
        Collections.reverse(worstReviews);
        if (items.isEmpty()) {
            worstReviews.clear();
        } else {
            String tempID = worstReviews.get(0);
            worstReviews.clear();
            for(Items item : items) {
                double currentNum = getItemMeanGrade(item.getiD());
                if (currentNum <= getItemMeanGrade(tempID) && currentNum != 0.00) {
                    worstReviews.add(item.getiD());
                }
            }
        }
        return worstReviews;
    }


    public List<String> getBestReviewedItems() {
        ArrayList<String> bestReviews = new ArrayList<>();
        double max = 0.00;
        int count = 1;

        // check to see if reviewslist is empty or not
        for (Items item : items) {
            if (item.reviewsList.size() > 0) {
                count += 1;
            } else {
                count += 0;
            }
        }

        // if reviewslist not empty add ID to ArrayList, else clear ArrayList
        if (count > 0) {
            for (Items item : items) {
                double currentNum = getItemMeanGrade(item.getiD());
                if (currentNum >= max) {
                    bestReviews.add(item.getiD());
                    max = currentNum;
                }
            }
        } else {
            bestReviews.clear();
        }
        return bestReviews;
    }


    public String printAllReviews() {
        String EOL = System.lineSeparator();
        String message;
        if (items.isEmpty()) {
            message = "No items registered yet.";
        } else {
            int count = 0;
            for (Items item : items) {
                if (item.reviewsList.size() > 0) {
                    count += 1;
                } else {
                    count += 0;
                }
            }
            if (count < 1) {
                message = "No items were reviewed yet.";
            } else {
                message = "All registered reviews:" + EOL +
                        "------------------------------------" + EOL;
                for (Items item : items) {
                    if (!item.reviewsList.isEmpty()) {
                        message += getPrintedReviews(item.getiD()) + "------------------------------------" + EOL;
                    }
                }
            }
        }
        return message;
    }
}

package ShopOfSomething;

import ShopOfSomething.controllers.EmployeeController;
import ShopOfSomething.controllers.ItemController;
import ShopOfSomething.controllers.ReviewController;
import ShopOfSomething.controllers.TransactionController;
import ShopOfSomething.models.Item;
import ShopOfSomething.models.Transaction;

import java.util.ArrayList;

public class MainMenu {
    private static MainMenu mainMenu;
    private ItemController items;
    private TransactionController transactions;
    private ReviewController reviews;
    private EmployeeController employees;

    public MainMenu() {
        ArrayList<Item> items = new ArrayList<>();
        ArrayList<Transaction> transactionhistory = new ArrayList<>();
        this.items = new ItemController(items, transactionhistory);
        this.transactions = new TransactionController(items, transactionhistory, this.items);
        this.reviews = new ReviewController(items, this.items);
        this.employees = new EmployeeController();
    }

    public static void main(String[] args) {

        mainMenu = new MainMenu();
        mainMenu.printMainMenu();
        mainMenu.mainMenuHandler();

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

    public void mainMenuHandler() {
        int selection = UserIO.readInt();
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
                openEmployeeHandler();
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

    public void optionItemHandler() {
        while (true){ //never use while(true)
            int selection = UserIO.readInt();
            switch (selection) {
                case 0:
                    System.out.println("You have chosen: Return to Main Menu.");
                    printMainMenu();
                    mainMenuHandler();
                    break;
                case 1:
                    System.out.println("You have chosen: Create an Item.");
                    System.out.println("What is the name of the item? ");
                    String name = UserIO.readStr();
                    System.out.println("What is the price? ");
                    double price = UserIO.SCANNER.nextDouble();
                    UserIO.SCANNER.nextLine();
                    System.out.println("What is your iD? ");
                    String iD = UserIO.readStr();
                    System.out.println(items.createItem(iD, name, price));
                    printOpenItemOptions();
                    break;
                case 2:
                    System.out.println("You have chosen: Remove an Item.");
                    System.out.println("What item do you want to remove? ");
                    String remove = UserIO.readStr();
                    items.removeItem(remove);
                    printOpenItemOptions();
                    break;
                case 3:
                    System.out.println("You have chosen: Print all registered Items. ");
                    items.printAllItems();
                    printOpenItemOptions();
                    break;
                case 4:
                    System.out.println("You have chosen: Buy an Item. ");
                    System.out.println("What item do you want to buy? ");
                    String buyID = UserIO.readStr();
                    System.out.println("How many do you want to buy? ");
                    int count = UserIO.readInt();
                    items.buyItem(buyID, count);
                    printOpenItemOptions();
                    break;
                case 5:
                    System.out.println("You have chosen: Update an item's name.");
                    System.out.println("Item iD: ");
                    iD = UserIO.readStr();
                    System.out.println("Item name: ");
                    name = UserIO.readStr();
                    items.updateItemName( iD, name);
                    printOpenItemOptions();
                    break;
                case 6:
                    System.out.println("You have chosen: Update an item's price.");
                    System.out.println("Item iD: ");
                    iD = UserIO.readStr();
                    System.out.println("Item price: ");
                    price = UserIO.readDouble();
                    items.updateItemPrice( iD, price);
                    printOpenItemOptions();
                    break;
                case 7:
                    System.out.println("You have chosen: Print a specific item.");
                    System.out.println("itemID: ");
                    iD = UserIO.readStr();
                    System.out.println(items.printSpecificItem(iD));
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

    public void openReviewHandler() {
        int selection = UserIO.readInt();
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

    public void openTransactionHandler() {
        while (true) {
            int selection = UserIO.readInt();
            switch (selection){
                case 0:
                    System.out.println("You have chosen: Return to Main Menu.");
                    printMainMenu();
                    mainMenuHandler();
                    break;
                case 1:
                    System.out.println("You have chosen: Print total profit from all item purchases.");
                    transactions.printProf(transactions.getTotalProfit());
                    printTransactionHistoryOptions();
                    break;
                case 2:
                    System.out.println("You have chosen: Print total units sold from all item purchases");
                    transactions.printCount(transactions.getTotalUnitsSold());
                    printTransactionHistoryOptions();

                    break;
                case 3:
                    System.out.println("You have chosen: Print the total number of item transactions made");
                    transactions.printPurch(transactions.getTotalTransactions());
                    printTransactionHistoryOptions();
                    break;
                case 4:
                    System.out.println("You have chosen: Print all transactions made.");
                    transactions.printAllTransactions();
                    printTransactionHistoryOptions();
                    break;
                case 5:
                    System.out.println("You have chosen: Print the total profit of a specific item.");
                    System.out.println("Item iD: ");
                    String iD = UserIO.readStr();
                    transactions.printProf(transactions.getProfit(iD));
                    printTransactionHistoryOptions();
                    break;
                case 6:
                    System.out.println("You have chosen: Print the number of units sold of a specific item.");
                    System.out.println("Item iD: ");
                    iD = UserIO.readStr();
                    transactions.printCount(transactions.getUnitsSolds(iD));
                    printTransactionHistoryOptions();
                    break;
                case 7:
                    System.out.println("You have chosen: Print all transactions of a specific item.");
                    System.out.println("Item iD: ");
                    iD = UserIO.readStr();
                    transactions.printItemTransactions(iD);
                    printTransactionHistoryOptions();
                    break;
                case 8:
                    System.out.println("You have chosen: Print item with highest profit.");
                    transactions.printMostProfitableItems();
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
        String EOL = System.lineSeparator();
        while (true) {
            int selection = UserIO.readInt();
            switch (selection) {
                case 0:
                    System.out.println("Return to Main Menu.");
                    printMainMenu();
                    mainMenuHandler();
                    break;
                case 1:
                    System.out.println("Create an employee (Regular Employee).");
                    System.out.print("Name of employee: ");
                    String name = UserIO.readStr();
                    System.out.print("What is the ID: ");
                    String empID = UserIO.readStr();
                    System.out.println("What is the gross salary: ");
                    double salary = UserIO.readDouble();
                    try {
                        employees.createEmployee(name, empID, salary);
                    } catch (Exception e) {
                        System.out.println(e.getMessage() + EOL);
                        printEmployeeMenu();
                        break;
                    }
                    printEmployeeMenu();
                    break;
                case 2:
                    System.out.println("Create an employee (Manager).");
                    System.out.print("Name of employee: ");
                    name = UserIO.readStr();
                    System.out.print("What is the ID: ");
                    empID = UserIO.readStr();
                    System.out.println("What is the gross salary: ");
                    salary = UserIO.readDouble();
                    System.out.println("Degree: ");
                    String degree = UserIO.readStr();
                    try {
                        System.out.println(employees.createEmployee(name, empID, salary, degree));
                    } catch (Exception e) {
                        System.out.println(e.getMessage() + EOL);
                        printEmployeeMenu();
                        break;
                    }
                    printEmployeeMenu();
                    break;
                case 3:
                    System.out.println("Create an employee (Director).");
                    System.out.print("Name of employee: ");
                    name = UserIO.readStr();
                    System.out.print("What is the ID: ");
                    empID = UserIO.readStr();
                    System.out.println("What is the gross salary: ");
                    salary = UserIO.readDouble();
                    System.out.println("Degree: ");
                    degree = UserIO.readStr();
                    System.out.println("Department: ");
                    String dept = UserIO.readStr();
                    try {
                        System.out.println(employees.createEmployee(name, empID, salary, degree, dept));
                    } catch (Exception e) {
                        System.out.println(e.getMessage() + EOL);
                        printEmployeeMenu();
                        break;
                    }
                    printEmployeeMenu();
                    break;
                case 4:
                    System.out.println("Create an employee (Intern).");
                    System.out.print("Name of employee: ");
                    name = UserIO.readStr();
                    System.out.print("What is the ID: ");
                    empID = UserIO.readStr();
                    System.out.println("What is the gross salary: ");
                    salary = UserIO.readDouble();
                    System.out.println("GPA: ");
                    int gpa = UserIO.readInt();
                    try {
                        System.out.println(employees.createEmployee(name, empID, salary, gpa));
                    } catch (Exception e) {
                        System.out.println(e.getMessage() + EOL);
                        printEmployeeMenu();
                        break;
                    }
                    printEmployeeMenu();
                    break;
                case 5:
                    System.out.println("Remove an employee.");
                    System.out.println("ID of employee to remove: ");
                    empID = UserIO.readStr();
                    try {
                        System.out.println(employees.removeEmployee(empID));
                    } catch (Exception e) {
                        System.out.println(e.getMessage() + EOL);
                        printEmployeeMenu();
                        break;
                    }
                    printEmployeeMenu();
                    break;
                case 6:
                    System.out.println("Print specific employee.");
                    System.out.println("Employee ID: ");
                    empID = UserIO.readStr();
                    try {
                        System.out.println(employees.printSpecificEmployee(empID));
                    } catch (Exception e) {
                        System.out.println(e.getMessage() + EOL);
                        printEmployeeMenu();
                        break;
                    }
                    printEmployeeMenu();
                    break;
                case 7:
                    System.out.println("Print all registered employees.");
                    try {
                        System.out.println(employees.printAllEmployees());
                    } catch (Exception e) {
                        System.out.println(e.getMessage() + EOL);
                        printEmployeeMenu();
                        break;
                    }
                    printEmployeeMenu();
                    break;
                case 8:
                    System.out.println("Print the total expense with net salary.");
                    try {
                        System.out.println(employees.printTotalExpenses());
                    } catch (Exception e) {
                        System.out.println(e.getMessage() + EOL);
                        printEmployeeMenu();
                        break;
                    }
                    printEmployeeMenu();
                    break;
                case 9:
                    System.out.println("Print all employees sorted by gross salary.");
                    try {
                        System.out.println(employees.printEmployeesBySalary());
                    } catch (Exception e) {
                        System.out.println(e.getMessage() + EOL);
                        printEmployeeMenu();
                        break;
                    }
                    printEmployeeMenu();
                    break;
                default:
                    System.out.println("Invalid Option. Please try again: ");
                    printEmployeeMenu();
                    break;
            }
        }
    }

}

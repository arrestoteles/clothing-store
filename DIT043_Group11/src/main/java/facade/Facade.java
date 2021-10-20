package facade;

import ShopOfSomething.controllers.ItemController;
import ShopOfSomething.controllers.ReviewController;
import ShopOfSomething.controllers.TransactionController;
import ShopOfSomething.models.Item;
import ShopOfSomething.models.Transaction;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Facade {

    private ItemController items;
    private TransactionController transactions;
    private ReviewController reviews;


    // This class only has the skeleton of the methods used by the test.
    // You must fill in this class with your own code. You can (and should) create more classes
    // that implement the functionalities listed in the Facade and in the Test Cases.

    public Facade(){
        ArrayList<Item> items = new ArrayList<>();
        ArrayList<Transaction> transactionhistory = new ArrayList<>();
        this.items = new ItemController(items, transactionhistory);
        this.transactions = new TransactionController(items, transactionhistory, this.items);
        this.reviews = new ReviewController(items, this.items);
    }

    public String createItem(String itemID, String itemName, double unitPrice){
        return items.createItem(itemID, itemName, unitPrice);
    }

    public String printItem(String itemID) {
        return items.printItem(itemID);
    }

    public String removeItem(String itemID) {
        return items.removeItem(itemID);
    }

    public boolean containsItem(String itemID) {
        return items.containsItem(itemID);
    }

    public double buyItem(String itemID, int amount) {
        return items.buyItem(itemID, amount);
    }

    public String reviewItem(String itemID, String reviewComment, int reviewGrade) {
        return reviews.reviewItem(itemID, reviewComment, reviewGrade);
    }

    public String reviewItem(String itemID, int reviewGrade) {
        return reviews.reviewItem(itemID, reviewGrade);
    }

    public String getItemCommentsPrinted(String itemID) {
        return reviews.getItemCommentsPrinted(itemID);
    }

    public List<String> getItemComments(String itemID) {
        return reviews.getItemComments(itemID);
    }

    public double getItemMeanGrade(String itemID) {
        return reviews.getItemMeanGrade(itemID);
    }

    public int getNumberOfReviews(String itemID) {
        return reviews.getNumberOfReviews(itemID);
    }

    public String getPrintedItemReview(String itemID, int reviewNumber) {
        return reviews.getPrintedItemReview(itemID, reviewNumber);
    }

    public String getPrintedReviews(String itemID) {
        return reviews.getPrintedReviews(itemID);
    }

    public String printMostReviewedItems() {
        return reviews.printMostReviewedItems();
    }

    public List<String> getMostReviewedItems() {
        return reviews.getMostReviewedItems();
    }

    public List<String> getLeastReviewedItems() {
        return reviews.getLeastReviewedItems();
    }

    public String printLeastReviewedItems() {
        return reviews.printLeastReviewedItems();
    }

    public double getTotalProfit() {
        return transactions.getTotalProfit();
    }

    public String printItemTransactions(String itemID) {
        return transactions.printItemTransactions(itemID);
    }

    public int getTotalUnitsSold() {
        return transactions.getTotalUnitsSold();
    }

    public int getTotalTransactions() {
        return transactions.getTotalTransactions();
    }

    public double getProfit(String itemID) {
        return transactions.getProfit(itemID);
    }

    public int getUnitsSolds(String itemID) {
        return transactions.getUnitsSolds(itemID);
    }

    public String printAllTransactions() {
        return transactions.printAllTransactions();
    }

    public String printWorseReviewedItems() {
        return reviews.printWorseReviewedItems();
    }

    public String printBestReviewedItems() {
        return reviews.printBestReviewedItems();
    }

    public List<String> getWorseReviewedItems() {
        return reviews.getWorseReviewedItems();
    }

    public List<String> getBestReviewedItems() {
        return reviews.getBestReviewedItems();
    }

    public String printAllReviews() {
        return reviews.printAllReviews();
    }

    public String updateItemName(String itemID, String newName) {
        return items.updateItemName(itemID, newName);
    }

    public String updateItemPrice(String itemID, double newPrice) {
        return items.updateItemPrice(itemID, newPrice);
    }

    public String printAllItems() {
        return items.printAllItems();
    }

    public String printMostProfitableItems() {
        return transactions.printMostProfitableItems();
    }

    public String createEmployee(String employeeID, String employeeName, double grossSalary) throws Exception {
        return "";
    }

    public String printEmployee(String employeeID) throws Exception {
        return "";
    }

    public String createEmployee(String employeeID, String employeeName, double grossSalary, String degree) throws Exception {
        return "";
    }

    public String createEmployee(String employeeID, String employeeName, double grossSalary, int gpa) throws Exception {
        return "";
    }

    public double getNetSalary(String employeeID) throws Exception {
        return -1.0;
    }

    public String createEmployee(String employeeID, String employeeName, double grossSalary, String degree, String dept) throws Exception {
        return "";
    }

    public String removeEmployee(String empID) throws Exception {
        return "";
    }

    public String printAllEmployees() throws Exception {
        return "";
    }

    public double getTotalNetSalary() throws Exception {
        return -1.0;
    }

    public String printSortedEmployees() throws Exception {
        return "";
    }

    public String updateEmployeeName(String empID, String newName) throws Exception {
        return "";
    }

    public String updateInternGPA(String empID, int newGPA) throws Exception {
        return "";
    }

    public String updateManagerDegree(String empID, String newDegree) throws Exception {
        return "";
    }

    public String updateDirectorDept(String empID, String newDepartment) throws Exception {
        return "";
    }

    public String updateGrossSalary(String empID, double newSalary) throws Exception {
        return "";
    }

    public Map<String, Integer> mapEachDegree() throws Exception {
        return null;
    }

    public String promoteToManager(String empID, String degree) throws Exception {
        return "";

    }

    public String promoteToDirector(String empID, String degree, String department) throws Exception {
        return "";
    }

    public String promoteToIntern(String empID, int gpa) throws Exception {
        return "";
    }
}

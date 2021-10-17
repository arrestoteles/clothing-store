package facade;

import ShopOfSomething.ClothingStore;

import java.util.List;
import java.util.Map;

public class Facade {

    ClothingStore store = new ClothingStore();

    // This class only has the skeleton of the methods used by the test.
    // You must fill in this class with your own code. You can (and should) create more classes
    // that implement the functionalities listed in the Facade and in the Test Cases.

    public Facade(){

    }

    public String createItem(String itemID, String itemName, double unitPrice){
        return store.createItem(itemID, itemName, unitPrice);
    }

    public String printItem(String itemID) {
        return store.printItem(itemID);
    }

    public String removeItem(String itemID) {
        return store.removeItem(itemID);
    }

    public boolean containsItem(String itemID) {
        return store.containsItem(itemID);
    }

    public double buyItem(String itemID, int amount) {
        return store.buyItem(itemID, amount);
    }

    public String reviewItem(String itemID, String reviewComment, int reviewGrade) {
        return store.reviewItem(itemID, reviewComment, reviewGrade);
    }

    public String reviewItem(String itemID, int reviewGrade) {
        return store.reviewItem(itemID, reviewGrade);
    }

    public String getItemCommentsPrinted(String itemID) {
        return store.getItemCommentsPrinted(itemID);
    }

    public List<String> getItemComments(String itemID) {
        return store.getItemComments(itemID);
    }

    public double getItemMeanGrade(String itemID) {
        return store.getItemMeanGrade(itemID);
    }

    public int getNumberOfReviews(String itemID) {
        return store.getNumberOfReviews(itemID);
    }

    public String getPrintedItemReview(String itemID, int reviewNumber) {
        return store.getPrintedItemReview(itemID, reviewNumber);
    }

    public String getPrintedReviews(String itemID) {
        return store.getPrintedReviews(itemID);
    }

    public String printMostReviewedItems() {
        return store.printMostReviewedItems();
    }

    public List<String> getMostReviewedItems() {
        return store.getMostReviewedItems();
    }

    public List<String> getLeastReviewedItems() {
        return store.getLeastReviewedItems();
    }

    public String printLeastReviewedItems() {
        return store.printLeastReviewedItems();
    }

    public double getTotalProfit() {
        return store.getTotalProfit();
    }

    public String printItemTransactions(String itemID) {
        return store.printItemTransactions(itemID);
    }

    public int getTotalUnitsSold() {
        return store.getTotalUnitsSold();
    }

    public int getTotalTransactions() {
        return store.getTotalTransactions();
    }

    public double getProfit(String itemID) {
        return store.getProfit(itemID);
    }

    public int getUnitsSolds(String itemID) {
        return store.getUnitsSolds(itemID);
    }

    public String printAllTransactions() {
        return store.printAllTransactions();
    }

    public String printWorseReviewedItems() {
        return store.printWorseReviewedItems();
    }

    public String printBestReviewedItems() {
        return store.printBestReviewedItems();
    }

    public List<String> getWorseReviewedItems() {
        return store.getWorseReviewedItems();
    }

    public List<String> getBestReviewedItems() {
        return store.getBestReviewedItems();
    }

    public String printAllReviews() {
        return store.printAllReviews();
    }

    public String updateItemName(String itemID, String newName) {
        return store.updateItemName(itemID, newName);
    }

    public String updateItemPrice(String itemID, double newPrice) {
        return store.updateItemPrice(itemID, newPrice);
    }

    public String printAllItems() {
        return store.printAllItems();
    }

    public String printMostProfitableItems() {
        return store.printMostProfitableItems();
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

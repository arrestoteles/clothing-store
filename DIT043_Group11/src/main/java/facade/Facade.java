package facade;

import ShopOfSomething.ClothingStore;
import java.util.List;

public class Facade {

    //ArrayList<Item> items = new ArrayList<>();
    ClothingStore store = new ClothingStore();

    // This class only has the skeleton of the methods used by the test.
    // You must fill in this class with your own code. You can (and should) create more classes
    // that implement the functionalities listed in the Facade and in the Test Cases.

    public Facade(){

    }

    public String createItem(String itemID, String itemName, double unitPrice) {
        return store.createItem(itemID, itemName, unitPrice);
    }

    public String printItem(String itemID) {
        return store.printItem(itemID);
    }

    public String removeItem(String itemID) {
        return store.removeItem(itemID);
    }

    public boolean containsItem(String itemID) {
        return store.containsElement(itemID);
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
        return store.printMostRevieweditemList();
    }

    public List<String> getMostReviewedItems() {
        return store.getMostRevieweditemList();
    }

    public List<String> getLeastReviewedItems() {
        return store.getLeastRevieweditemList();
    }

    public String printLeastReviewedItems() {
        return store.printLeastRevieweditemList();
    }

    public double getTotalProfit() {
        return store.totProfAll();
    }

    public String printItemTransactions(String itemID) {
        return store.totInfoID(itemID);
    }

    public int getTotalUnitsSold() {
        return store.totCountAll();
    }

    public int getTotalTransactions() {
        return store.totPurchAll();
    }

    public double getProfit(String itemID) {
        return store.totProfID(itemID);
    }

    public int getUnitsSolds(String itemID) {
        return store.totCountID(itemID);
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
        return store.findHighestSaleItem();
    }
}
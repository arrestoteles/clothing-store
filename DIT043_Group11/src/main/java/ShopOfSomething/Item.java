package ShopOfSomething;

import java.util.ArrayList;
import java.util.List;

public class Item {

    private String iD;
    private String name;
    private double price;
    public List<ShopOfSomething.Review> reviewList = new ArrayList<>();


    public Item(String iD, String name, double price) {
        this.iD = iD;
        this.name = name;
        this.price = price;
    }

    // do we need this constructor?
    public Item(String iD, String name, double price, ArrayList<ShopOfSomething.Review> reviewList) {
        this.iD = iD;
        this.name = name;
        this.price = price;
        this.reviewList = reviewList;
    }

    public String toString() {
        return this.iD +": " + this.name + ". " + ShopOfSomething.UserInput.decimalFormat(this.price) + " SEK";
    }

    public String getiD() {
        return iD;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public void updateItem(String name, double price) {
        this.name = name;
        this.price = price;
    }
}

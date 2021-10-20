package ShopOfSomething;

import java.util.ArrayList;
import java.util.List;

public class Items {

    private String iD;
    private String name;
    private double price;
    public List<Reviews> reviewsList = new ArrayList<>();


    public Items(String iD, String name, double price) {
        this.iD = iD;
        this.name = name;
        this.price = price;
    }

    // do we need this constructor?
    public Items(String iD, String name, double price, ArrayList<Reviews> reviewsList) {
        this.iD = iD;
        this.name = name;
        this.price = price;
        this.reviewsList = reviewsList;
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

    public List<Reviews> getReviewsList() {
        return reviewsList;
    }

    public void updateItem(String name, double price) {
        this.name = name;
        this.price = price;
    }
}

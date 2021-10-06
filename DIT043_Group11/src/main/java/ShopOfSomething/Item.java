package ShopOfSomething;

import java.util.ArrayList;

public class Item {
    String iD;
    String name;
    double price;
    ArrayList<Review> reviews = new ArrayList<Review>();
    ArrayList<Log> transactions = new ArrayList<Log>();

    public Item(String iD, String name, double price) {
        this.iD = iD;
        this.name = name;
        this.price = price;
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

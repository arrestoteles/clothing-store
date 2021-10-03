public class Item {
    public int iD;
    public String name;
    public double price;

    public Item(int iD, String name, double price) {
        this.iD = iD;
        this.name = name;
        this.price = price;
    }

    public int getiD() {
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

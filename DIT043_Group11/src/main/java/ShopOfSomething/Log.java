package ShopOfSomething;

public class Log {
    String iD;
    int count;
    double price;

    public Log(String iD, int count, double price) {
        this.iD = iD;
        this.count = count;
        this.price = price;
    }
    public String printTransaction(){
        return (String.valueOf(iD) +
                ": " + String.valueOf(count) +
                " item(s). " +
                String.valueOf(UserInput.decimalFormat(price)) +
                " SEK" + System.lineSeparator());
    }

    public String getiD() {
        return iD;
    }

    public int getCount() {
        return count;
    }

    public double getPrice() {
        return price;
    }
}

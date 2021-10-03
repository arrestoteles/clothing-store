public class Log {
    String iD;
    int count;
    double price;

    public Log(String iD, int count, double price) {
        this.iD = iD;
        this.count = count;
        this.price = price;
    }
    public void printTransaction(){
        System.out.println(String.valueOf(iD) +
                " : " + String.valueOf(count) +
                " item(s). " +
                String.valueOf(price) +
                " SEK");
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

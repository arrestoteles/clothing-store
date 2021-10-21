package ShopOfSomething.models.employees;


import ShopOfSomething.UserIO;

public class Employee {
    protected String ID;
    private String name;
    private double grossSalary;

    public Employee(String ID, String name, double grossSalary) {
        this.ID = ID;
        this.name = name;
        this.grossSalary = grossSalary;

    }

    public String getID() {
        return ID;
    }

    public String getName() {
        return name;
    }

    public double getBaseSalary() {
        return UserIO.truncateFormat2(grossSalary);
    }

    public double getGrossSalary() {
        return UserIO.truncateFormat2(grossSalary);
    }

    public double getNetSalary() {
        return UserIO.truncateFormat2(0.9 * getGrossSalary());
    }

    public String toString() {
        return (name + "'s gross salary is " + UserIO.decimalFormat(getGrossSalary()) +
                " SEK per month.");
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setGrossSalary(double grossSalary) {
        this.grossSalary = grossSalary;
    }


}
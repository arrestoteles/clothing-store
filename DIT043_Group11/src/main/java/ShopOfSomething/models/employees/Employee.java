package ShopOfSomething.models.employees;


public class Employee {
    private String ID;
    private String name;
    private double grossSalary;
    private double netSalary;


    public Employee(String ID, String name, double grossSalary) {
        this.ID = ID;
        this.name = name;
        this.grossSalary = grossSalary;
        this.netSalary = grossSalary * 0.90;
    }

    public String getID() {
        return ID;
    }

    public String getName() {
        return name;
    }

    public double getGrossSalary() {
        return grossSalary;
    }

    public double getNetSalary() {
        return netSalary;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setGrossSalary(double grossSalary) {
        this.grossSalary = grossSalary;
    }

    @Override
    public String toString() {
        return this.ID + this.name + this.grossSalary + this.netSalary;
    }
}

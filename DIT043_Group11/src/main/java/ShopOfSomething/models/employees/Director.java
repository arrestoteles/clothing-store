package ShopOfSomething.models.employees;

public class Director extends Manager {
    private double updateGrossSalary;

    public Director(String ID, String name, double grossSalary, String degree, double updatedGrossSalary) {
        super(ID, name, (grossSalary + 5000), degree);
        this.updateGrossSalary = updatedGrossSalary;
    }

    public double getUpdateGrossSalary() {
        return updateGrossSalary;
    }

    public void setUpdateGrossSalary(double updateGrossSalary) {
        this.updateGrossSalary = updateGrossSalary;
    }



}


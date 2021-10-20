package ShopOfSomething.models.employees;

public class Manager extends Employee {
    private String degree;

    public Manager(String ID, String name, double grossSalary, String degree) {
        super(ID, name, grossSalary);
        this.degree = degree;
    }

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    public double updateGrossSalary() {
        if (this.degree == "BSc.") {
            double updatedSal = getGrossSalary() * 1.10;
            return updatedSal;
        } else if (this.degree == "MSc.") {
            double updatedSal = getGrossSalary() * 1.20;
            return updatedSal;
        } else if (this.degree == "PhD.") {
            double updatedSal = getGrossSalary() * 1.35;
            return updatedSal;
        } else {
            return getGrossSalary();
        }
    }
}

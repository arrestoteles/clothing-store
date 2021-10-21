package ShopOfSomething.models.employees;

public class Manager extends Employee {
    private String degree;

    public Manager(String ID, String name, double grossSalary, String degree) {
        super(ID, name, grossSalary);
        this.degree = degree;
    }

    @Override
    public double getGrossSalary() {
        return super.getGrossSalary() * bonus();
    }

    public String getDegree() {
        return degree;
    }

    public double bonus() {
        switch(degree) {
            case "BSc":
                return 1.1;
            case "MSc":
                return 1.2;
            case "PhD":
                return 1.35;
            default:
                return 1;

        }
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    @Override
    public String toString() {
        return degree + " " + super.toString();
    }
}

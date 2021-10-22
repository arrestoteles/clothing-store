package ShopOfSomething.models.employees;

public class Manager extends Employee {
    private String degree;

    public Manager(String ID, String name, double grossSalary, String degree) throws Exception {
        super(ID, name, grossSalary);
        if (!degree.equals("BSc") && !degree.equals("MSc") && !degree.equals("PhD")) {
            throw new Exception("Degree must be one of the options: BSc, MSc or PhD.");
        }
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

    public void setDegree(String degree) throws Exception {
        if (!degree.equals("BSc") && !degree.equals("MSc") && !degree.equals("PhD")) {
            throw new Exception("Degree must be one of the options: BSc, MSc or PhD.");
        }
        this.degree = degree;
    }

    @Override
    public String toString() {
        return degree + " " + super.toString();
    }
}

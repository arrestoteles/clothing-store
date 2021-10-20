package ShopOfSomething.models.employees;

public class Intern extends Employee {
    private int GPA;

    public Intern(String ID, String name, double grossSalary, int GPA) {
        super(ID, name, grossSalary);
        this.GPA = GPA;
        if (GPA <= 5) {
            this.setGrossSalary(0.00);
        } else if (GPA < 8) {
            this.setGrossSalary(grossSalary);
        } else {
            this.setGrossSalary(grossSalary + 1000);
        }
    }
}

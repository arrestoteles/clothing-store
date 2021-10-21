package ShopOfSomething.models.employees;

public class Intern extends Employee {
    private int GPA;

    public Intern(String ID, String name, double grossSalary, int GPA) {
        super(ID, name, grossSalary);
        this.GPA = GPA;
    }

    @Override
    public double getGrossSalary() {
        if(GPA < 5) {
            return 0;
        } else if(GPA < 8) {
            return super.getGrossSalary();
        } else {
            return super.getGrossSalary() + 1000;
        }
    }

    @Override
    public double getNetSalary() {
        return getGrossSalary();
    }

    @Override
    public String toString() {
        return super.toString() + " GPA: " + GPA;
    }

    public void setGPA(int GPA) {
        this.GPA = GPA;
    }

}
package ShopOfSomething.models.employees;

public class Intern extends Employee {
    private int GPA;

    public Intern(String ID, String name, double grossSalary, int GPA) throws Exception {
        super(ID, name, grossSalary);

        if(GPA < 0){
            throw new Exception(GPA + " outside range. Must be between 0-10.");
        }else if (GPA > 10){
            throw new Exception(GPA + " outside range. Must be between 0-10.");
        }
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

    public void setGPA(int GPA) throws Exception {
        if (GPA < 0) {
            throw new Exception(GPA + " outside range. Must be between 0-10.");
        } else if (GPA > 10)
            throw new Exception(GPA + " outside range. Must be between 0-10.");
        this.GPA = GPA;
    }

}
package ShopOfSomething.models.employees;

import ShopOfSomething.UserIO;

public class Director extends Manager {
    private String department;

    public Director(String ID, String name, double grossSalary, String degree, String department) {
        super(ID, name, grossSalary, degree);
        this.department = department;

    }

    @Override
    public double getGrossSalary() {
        return super.getGrossSalary() + 5000;
    }

    public double getNetSalary() {
        if(getGrossSalary() < 30000) {
            return super.getNetSalary();
        } else if(getGrossSalary() < 50000) {
            return UserIO.truncateFormat2(0.8 * getGrossSalary());
        } else {
            return UserIO.truncateFormat2(0.8 * 30000) + (0.6* (getGrossSalary() - 30000));
        }
    }

    @Override
    public String toString() {
        String EOL = System.lineSeparator();
        return super.toString() + " Dept: " + department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

}


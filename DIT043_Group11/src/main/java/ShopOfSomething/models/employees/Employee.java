package ShopOfSomething.models.employees;


import java.util.ArrayList;

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

    ArrayList<Employee> employees = new ArrayList<>();


    public String getID() {
        return ID;
    }

    public String getName() {
        return name;
    }

    public double getGrossSalary() {
        return grossSalary;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setGrossSalary(double grossSalary) {
        this.grossSalary = grossSalary;
    }

    public String createEmployee(String employeeID, String employeeName, double grossSalary) throws Exception {
        if (employees.contains(employeeID)) {
            return "No employee has been registered yet.";
        } else {
            employees.add(new Employee(employeeID, employeeName, grossSalary));
            return "Employee" + employeeID + "was registered successfully.";
        }
    }

    public String printEmployee(String employeeID) throws Exception {
        return "";
    }

    public String createEmployee(String employeeID, String employeeName, double grossSalary, String degree) throws Exception {
        return "Employee" + employeeID + "was registered successfully.";
    }

    public String createEmployee(String employeeID, String employeeName, double grossSalary, int gpa) throws Exception {
        return "Employee" + employeeID + "was registered successfully.";
    }
}

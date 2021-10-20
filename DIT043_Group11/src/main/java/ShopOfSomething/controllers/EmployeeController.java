package ShopOfSomething.controllers;

import ShopOfSomething.UserIO;
import ShopOfSomething.models.employees.Employee;
import ShopOfSomething.models.employees.Manager;

import java.util.ArrayList;
import java.util.Map;

public class EmployeeController {
    ArrayList<Employee> employees = new ArrayList<>();


    public String createEmployee(String employeeID, String employeeName, double grossSalary) throws Exception {
        if (containsEmployee(employeeID)) {
            return employeeName + "’s gross salary is " + grossSalary + " SEK per month.";
        } else {
            employees.add(new Employee(employeeID, employeeName, grossSalary));
            return "Employee " + employeeID + " was registered successfully.";
        }
    }

    public String printEmployee(String employeeID) throws Exception {
        String message = "";
        String currentName;
        double currentGrossSalary;

        if (employees.isEmpty()) {
            throw new Exception("Employee " + employeeID + " was not registered yet.");
        } else {
            Employee employee = findEmployee(employeeID);
            currentName = employee.getName();
            currentGrossSalary = employee.getGrossSalary();
            message += currentName + "'s gross salary is " + UserIO.decimalFormat(currentGrossSalary) + " SEK per month.";
        }
        return message;
    }

    public String createEmployee(String employeeID, String employeeName, double grossSalary, String degree) throws Exception {
        String message;
        if (containsEmployee(employeeID)) {
            message = degree + employeeName + "’s gross salary is " + updateGrossSalary() + " SEK per month.";
        } else {
            employees.add(new Manager(employeeID, employeeName, grossSalary, degree));
            message = "Employee " + employeeID + " was registered successfully.";
        }
        return message;
    }


    public String createEmployee(String employeeID, String employeeName, double grossSalary, int gpa) throws Exception {
        return "Employee" + employeeID + "was registered successfully.";
    }

    public boolean containsEmployee(String ID) {
        for (Employee employee : employees) {
            if (employee.getID().equals(ID))
                return true;
        }
        return false;
    }

    public Employee findEmployee(String employeeID) throws Exception {
        for (Employee employee : employees) {
            if (employee.getID().equals(employeeID)) {
                return employee;
            }
        }
        throw new Exception("Employee " + employeeID + " was not registered yet.");
    }

    public double getNetSalary(String employeeID) throws Exception {
        Employee eID = findEmployee(employeeID);
        return eID.getNetSalary();
    }

    public String createEmployee(String employeeID, String employeeName, double grossSalary, String degree, String dept) throws Exception {
        return "";
    }

    public String removeEmployee(String empID) throws Exception {
        String message;
        Employee employee = findEmployee(empID);
        if (employee.getID() == null) {
            throw new Exception("Employee " + empID + " was not registered yet.");
        } else {
            employees.remove(employee);
            message = "Employee " + empID + " was successfully removed.";
        }
        return message;
    }

    public String printAllEmployees() throws Exception {
        String EOL = System.lineSeparator();
        String message = "All registered employees:" + EOL;

        for (Employee employee : employees) {
            message += employee.getName() + "'s gross salary is " + UserIO.decimalFormat(employee.getGrossSalary()) + " SEK per month." + EOL;
        }

        return message;
    }

    public double getTotalNetSalary() throws Exception {
        return -1.0;
    }

    public String printSortedEmployees() throws Exception {
        return "";
    }

    public String updateEmployeeName(String empID, String newName) throws Exception {
        return "";
    }

    public String updateInternGPA(String empID, int newGPA) throws Exception {
        return "";
    }

    public String updateManagerDegree(String empID, String newDegree) throws Exception {
        return "";
    }

    public String updateDirectorDept(String empID, String newDepartment) throws Exception {
        return "";
    }

    public String updateGrossSalary() throws Exception {
        return "";
    }

    public Map<String, Integer> mapEachDegree() throws Exception {
        return null;
    }

    public String promoteToManager(String empID, String degree) throws Exception {
        return "";

    }

    public String promoteToDirector(String empID, String degree, String department) throws Exception {
        return "";
    }

    public String promoteToIntern(String empID, int gpa) throws Exception {
        return "";
    }
}



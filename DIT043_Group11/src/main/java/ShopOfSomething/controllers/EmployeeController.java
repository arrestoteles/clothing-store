package ShopOfSomething.controllers;

import ShopOfSomething.UserIO;
import ShopOfSomething.models.employees.Director;
import ShopOfSomething.models.employees.Employee;
import ShopOfSomething.models.employees.Intern;
import ShopOfSomething.models.employees.Manager;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class EmployeeController {
    ArrayList<Employee> employees = new ArrayList<>();


    public String createEmployee(String iD, String name, double grossSalary) {
        Employee employee = new Employee(iD, name, grossSalary);
        if(employeeExist(employee.getID())) {
            String message = name + "'s gross salary is " + grossSalary + " SEK per month.";
            return message;
        }
        employees.add(employee);
        String message = "Employee " + iD + " was registered successfully.";
        return message;
    }

    public String printSpecificEmployee(String iD) {
        Employee employee = findEmployee(iD);
        if(employee == null) {
            return ("Employee with " + iD + " does not exist. ");
        }
        return employee.toString();
    }

    public String createEmployee(String employeeID, String employeeName, double grossSalary, String degree) throws Exception {
        Employee employee = new Manager(employeeID, employeeName, grossSalary, degree);
        if(employeeExist(employee.getID())) {
            String message = employee.toString();
            return message;
        }
        employees.add(employee);
        String message = "Employee " + employeeID + " was registered successfully.";
        return message;
    }

    public String createEmployee(String employeeID, String employeeName, double grossSalary, int gpa) throws Exception {
        Employee employee = new Intern(employeeID, employeeName, grossSalary, gpa);
        if(employeeExist(employee.getID())) {
            String message = employee.toString();
            return message;
        }
        employees.add(employee);
        String message = "Employee " + employeeID + " was registered successfully.";
        return message;
    }

    public boolean employeeExist(String iD) {
        for (Employee e: employees) {
            if(e.getID().equals(iD)) {
                return true;
            }
        }
        return false;
    }

    public Employee findEmployee(String iD) {
        for (Employee i: employees) {
            if(i.getID().equals(iD)) {
                return i;
            }
        }
        return null;
    }

    public double getNetSalary(String employeeID) throws Exception {
        Employee eID = findEmployee(employeeID);
        return eID.getNetSalary();
    }

    public String createEmployee(String employeeID, String employeeName, double grossSalary, String degree, String dept) throws Exception {
        Employee employee = new Director(employeeID, employeeName, grossSalary, degree, dept);
        if(employeeExist(employee.getID())) {
            String message = employee.toString();
            return message;
        }
        employees.add(employee);
        String message = "Employee " + employeeID + " was registered successfully.";
        return message;
    }

    public String removeEmployee(String empID) throws Exception {
        Employee employee = findEmployee(empID);
        if (!employeeExist(empID)) {
            throw new Exception("Employee " + empID + " was not registered yet.");
        } else {
            employees.remove(employee);
            return  "Employee " + empID + " was successfully removed.";
        }

    }

    public String printAllEmployees() {
        String EOL = System.lineSeparator();
        String message = "All registered employees:" + EOL;
        for (Employee i: employees) {
            message += i.toString() + EOL;
        }
        return message;
    }

    public double printTotalExpenses() {
        String EOL = System.lineSeparator();
        double expenses = 0;
        for (Employee i: employees) {
            expenses += i.getNetSalary();
        }
        return UserIO.truncateFormat2(expenses);
    }

    public String printEmployeesBySalary() {
        String EOL = System.lineSeparator();
        HashMap<Double,Employee> map = new HashMap<Double, Employee>();
        for (Employee i: employees) {
            map.put(i.getGrossSalary(), i);
        }
        TreeMap<Double, Employee> tree = new TreeMap<Double, Employee>();
        tree.putAll(map); // Tree's always sort.
        String output = "";
        for (Map.Entry<Double, Employee> entry: tree.entrySet()) {
            output += entry.getValue().toString() + EOL;
        }
        return "Employees sorted by gross salary (ascending order):" + EOL + output;
    }

    public String updateEmployeeName(String empID, String newName) throws Exception {
        Employee employee = findEmployee(empID);
        if(employee == null) {
            return ("Employee " + empID + " was not registered yet.");
        }else if(newName.isEmpty()){
            return "Invalid data for item.";
        }
        employee.setName(newName);
        return ("Employee " + empID +" was updated successfully");
    }

    public String updateInternGPA(String empID, int newGPA) throws Exception {
        Employee employee = findEmployee(empID);
        if(empID == null) {
            throw new Exception("Employee not found");
        }
        else if(!(employee instanceof Intern)) {
            throw new Exception("Intern not found");
        }
        ((Intern)employee).setGPA(newGPA);
        return ("Employee " + empID +" was updated successfully");
    }

    public String updateManagerDegree(String empID, String newDegree) throws Exception {
        Employee employee = findEmployee(empID);
        if(empID == null) {
            throw new Exception("Employee not found");
        }
        else if(!(employee instanceof Manager)) {
            throw new Exception("Manager not found");
        }
        ((Manager)employee).setDegree(newDegree);
        return ("Employee " + empID +" was updated successfully");
    }

    public String updateDirectorDept(String empID, String newDepartment) throws Exception {
        Employee employee = findEmployee(empID);
        if(empID == null) {
            throw new Exception("Employee not found");
        }
        else if(!(employee instanceof Director)) {
            throw new Exception("Director not found");
        }
        ((Director)employee).setDepartment(newDepartment);
        return ("Employee " + empID +" was updated successfully");
    }


    public String updateGrossSalary(String empID, double newSalary) throws Exception {
        Employee employee = findEmployee(empID);
        if(empID == null) {
            throw new Exception("Employee not found");
        }
        employee.setGrossSalary(newSalary);
        return "Employee " + empID + " was updated successfully";

    }

    public Map<String, Integer> mapEachDegree() throws Exception {
        return null;
    }

    public String promoteToManager(String empID, String degree) throws Exception {
        Employee employee = findEmployee(empID);
        removeEmployee(empID);
        employees.add(employee);
        return empID + " promoted successfully to Manager.";

        /*
        String damonID = "Emp8";
        String expectedMessage = "Emp8 promoted successfully to Manager.";
        String expectedEmployee = "PhD Damon's gross salary is 29835.00 SEK per month.";
        assertEquals(expectedMessage , facade.promoteToManager(damonID, "PhD"));
        assertEquals(expectedEmployee, facade.printEmployee(damonID));
         */
    }

    public String promoteToDirector(String empID, String degree, String department) throws Exception {
        return "";
    }

    public String promoteToIntern(String empID, int gpa) throws Exception {
        return "";
    }
}



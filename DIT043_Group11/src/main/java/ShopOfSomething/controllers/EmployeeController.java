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

    public String createEmployee(String iD, String name, double grossSalary) throws Exception {
        if(!(isEmployeevalid(iD, name, grossSalary))){ //if item invalid
            String message = "Invalid data for item.";
            return message;
        }

        Employee employee = new Employee(iD, name, grossSalary);
        if(employeeExist(employee.getID())) {
            String message = name + "'s gross salary is " + grossSalary + " SEK per month.";
            return message;
        }
        employees.add(employee);
        String message = "Employee " + iD + " was registered successfully.";
        return message;
    }

    public String printSpecificEmployee(String iD) throws Exception {
        Employee employee = findEmployee(iD);
        if(employee == null) {
            throw new Exception("Employee " + iD +" was not registered yet.");
        }
        return employee.toString();
    }

    public String createEmployee(String employeeID, String employeeName, double grossSalary, String degree) throws Exception {
        if(!(isEmployeevalid(employeeID, employeeName, grossSalary))){ //if item invalid
            String message = "Invalid data for item.";
            return message;
        }

        Employee employee = new Manager(employeeID, employeeName, grossSalary, degree);
        if(employeeExist(employee.getID())) {
            throw new Exception("No employees registered yet.");
            //String message = employee.toString();
            //return message;
        }
        employees.add(employee);
        String message = "Employee " + employeeID + " was registered successfully.";
        return message;
    }

    public String createEmployee(String employeeID, String employeeName, double grossSalary, int gpa) throws Exception {
        if(!(isEmployeevalid(employeeID, employeeName, grossSalary))){ //if item invalid
            String message = "Invalid data for item.";
            return message;
        }

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
        for (Employee employee: employees) {
            if(employee.getID().equals(iD)) {
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
        if(employees.isEmpty()){
            throw new Exception("Employee " + employeeID + " was not registered yet.");
        }
        Employee eID = findEmployee(employeeID);
        return eID.getNetSalary();
    }

    public String createEmployee(String employeeID, String employeeName, double grossSalary, String degree, String dept) throws Exception {
        if(!(isEmployeevalid(employeeID, employeeName, grossSalary))){ //if item invalid
            String message = "Invalid data for item.";
            return message;
        }
        Employee employee = new Director(employeeID, employeeName, grossSalary, degree, dept);
        if(employeeExist(employee.getID())) {
            throw new Exception ("No employees registered yet.");
        }

        employees.add(employee);
        String message = "Employee " + employeeID + " was registered successfully.";
        return message;
    }

    public String removeEmployee(String empID) throws Exception {
        Employee employee = findEmployee(empID);
        if (!employeeExist(empID)) {
            throw new Exception("Employee "+ empID +" was not registered yet.");
        } else {
            employees.remove(employee);
            return  "Employee " + empID + " was successfully removed.";
        }

    }

    public String printAllEmployees() throws Exception {
        if(employees.isEmpty()){
            throw new Exception("No employees registered yet.");
        }
        String EOL = System.lineSeparator();
        String message = "All registered employees:" + EOL;
        for (Employee i: employees) {
            message += i.toString() + EOL;
        }
        return message;
    }

    public double printTotalExpenses() throws Exception{
        if(employees.isEmpty()){
            throw new Exception("No employees registered yet.");
        }
        double expenses = 0;
        for (Employee i: employees) {
            expenses += i.getNetSalary();
        }
        return UserIO.truncateFormat2(expenses);
    }

    public String printEmployeesBySalary() throws Exception {
        if(employees.isEmpty()){
            throw new Exception("No employees registered yet.");
        }

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
            throw new Exception ("Employee " + empID + " was not registered yet.");
        }else if(newName.isEmpty()){
            throw new Exception("Name cannot be blank.");
        }
        employee.setName(newName);
        return ("Employee " + empID +" was updated successfully");
    }

    public String updateInternGPA(String empID, int newGPA) throws Exception {
        Employee employee = findEmployee(empID);
        if(empID == null) {
            throw new Exception("Employee " + empID +" was not registered yet.");
        }
        else if(!(employee instanceof Intern)) {
            throw new Exception("Employee " + empID + " was not registered yet.");
        }
        ((Intern)employee).setGPA(newGPA);
        return ("Employee " + empID +" was updated successfully");
    }

    public String updateManagerDegree(String empID, String newDegree) throws Exception {
        Employee employee = findEmployee(empID);
        if(empID == null) {
            throw new Exception("Employee " + empID +" was not registered yet.");
        }
        else if(!(employee instanceof Manager)) {
            throw new Exception("Employee " + empID + " was not registered yet.");
        }
        ((Manager)employee).setDegree(newDegree);
        return ("Employee " + empID +" was updated successfully");
    }

    public String updateDirectorDept(String empID, String newDepartment) throws Exception {
        Employee employee = findEmployee(empID);
        if(empID == null) {
            throw new Exception("Employee " + empID +" was not registered yet.");
        }
        else if(!(employee instanceof Director)) {
            throw new Exception("Employee " + empID +" was not registered yet.");
        }
        ((Director)employee).setDepartment(newDepartment);
        return ("Employee " + empID +" was updated successfully");
    }

    public String updateGrossSalary(String empID, double newSalary) throws Exception {
        Employee employee = findEmployee(empID);
        if(employees.isEmpty()) {
            throw new Exception("Employee " + empID +" was not registered yet.");
        } else if (newSalary <= 0){
            throw new Exception("Salary must be greater than zero.");
        }
        employee.setGrossSalary(newSalary);
        return "Employee " + empID + " was updated successfully";

    }

    public Map<String, Integer> mapEachDegree() throws Exception {
        if(employees.isEmpty()){
            throw new Exception("No employees registered yet.");
        }
        HashMap<String, Integer> mapEachDegree = new HashMap<>();
        int bCount = 0;
        int pCount = 0;
        int mCount = 0;
        for (Employee employee: employees) {
            if(employee instanceof Manager)
                switch (((Manager)employee).getDegree()) {
                    case "BSc":
                        bCount++;
                        break;
                    case "MSc":
                        mCount++;
                        break;
                    case "PhD":
                        pCount++;
                        break;
                }
        }

        if(bCount > 0) {
            mapEachDegree.put("BSc", bCount);
        }
        if (mCount > 0) {
            mapEachDegree.put("MSc", mCount);
        }
        if (pCount > 0) {
            mapEachDegree.put("PhD", pCount);
        }
        return mapEachDegree;
    }

    public String promoteToManager(String empID, String degree) throws Exception {
        Employee employee = findEmployee(empID);
        removeEmployee(empID);
        createEmployee(empID, employee.getName(), employee.getBaseSalary(), degree);
        return empID + " promoted successfully to Manager.";
    }

    public String promoteToDirector(String empID, String degree, String department) throws Exception {
        Employee employee = findEmployee(empID);
        removeEmployee(empID);
        createEmployee(empID, employee.getName(), employee.getBaseSalary(), degree, department);
        return empID + " promoted successfully to Director.";
    }

    public String promoteToIntern(String empID, int gpa) throws Exception {
        Employee employee = findEmployee(empID);
        removeEmployee(empID);
        createEmployee(empID,employee.getName(), employee.getBaseSalary(), gpa);
        return empID + " promoted successfully to Intern.";
    }

    public boolean isEmployeevalid(String iD, String name, double grossSalary) throws Exception {
        //Empty iD
        if((iD.isEmpty())) {
            throw new Exception("ID cannot be blank.");
        }
        //Empty Name
        if(name.isBlank()){
            throw new Exception ("Name cannot be blank.");
        }
        //Invalid price
        if(grossSalary <= 0){
            throw new Exception("Salary must be greater than zero.");
        }
        return true;

    }
}



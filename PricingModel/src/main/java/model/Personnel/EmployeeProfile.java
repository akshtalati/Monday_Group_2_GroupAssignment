/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.Personnel;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author kal bugrara
 */
public class EmployeeProfile extends Profile {

    private String employeeID;
    private String role;
    private List<String> workHistory;

    public EmployeeProfile(Person person, String role) {
        super(person);
        this.employeeID = generateEmployeeID();
        this.role = role != null ? role : "Employee"; // Default role if not specified
        this.workHistory = new ArrayList<>();
    }

    private String generateEmployeeID() {
        // Generate an ID based on some logic (e.g., UUID, incremental ID, etc.)
        return "EMP" + System.currentTimeMillis();
    }

    @Override
    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public void addWorkHistory(String jobTitle) {
        workHistory.add(jobTitle);
    }

    public List<String> getWorkHistory() {
        return workHistory;
    }

    public String getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(String employeeID) {
        this.employeeID = employeeID;
    }

}
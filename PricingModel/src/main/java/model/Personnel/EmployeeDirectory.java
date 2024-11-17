/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.Personnel;

import java.util.ArrayList;

import model.Business.Business;

/**
 *
 * @author kal bugrara
 */
public class EmployeeDirectory {

    private Business business;
    private ArrayList<EmployeeProfile> employeelist;

    public EmployeeDirectory(Business business) {
        this.business = business;
        this.employeelist = new ArrayList<>();
    }

    public EmployeeProfile newEmployeeProfile(Person person, String role) {
        EmployeeProfile employeeProfile = new EmployeeProfile(person, role);
        employeelist.add(employeeProfile);
        return employeeProfile;
    }

    public EmployeeProfile findEmployee(String id) {
        for (EmployeeProfile employeeProfile : employeelist) {
            if (employeeProfile.isMatch(id)) {
                return employeeProfile;
            }
        }
        return null; // Not found after going through the entire list
    }

    public boolean removeEmployee(String id) {
        EmployeeProfile employee = findEmployee(id);
        if (employee != null) {
            employeelist.remove(employee);
            return true;
        }
        return false; // Employee not found
    }

    public boolean updateEmployeeProfile(String id, EmployeeProfile updatedProfile) {
        EmployeeProfile existingProfile = findEmployee(id);
        if (existingProfile != null) {
            int index = employeelist.indexOf(existingProfile);
            employeelist.set(index, updatedProfile);
            return true;
        }
        return false; // Employee not found
    }

    public ArrayList<EmployeeProfile> getAllEmployees() {
        return employeelist;
    }
}
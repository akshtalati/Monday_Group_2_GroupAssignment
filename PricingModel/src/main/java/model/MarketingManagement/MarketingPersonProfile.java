/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.MarketingManagement;

import java.util.ArrayList;

import model.OrderManagement.Order;
import model.Personnel.Person;
import model.Personnel.Profile;


/**
 *
 * @author kal bugrara
 */
public class MarketingPersonProfile extends Profile {
    private ArrayList<Order> salesOrders;
    private String roleTitle;
    private int yearsOfExperience;
    private ArrayList<String> skills;
    private int salesTarget;
    private int salesAchieved;

    public MarketingPersonProfile(Person p, String roleTitle, int yearsOfExperience, int salesTarget) {
        super(p);
        this.salesOrders = new ArrayList<>();
        this.skills = new ArrayList<>();
        this.roleTitle = roleTitle;
        this.yearsOfExperience = yearsOfExperience;
        this.salesTarget = salesTarget;
        this.salesAchieved = 0; // Starts at 0, incremented as sales are made
    }

    public void addSalesOrder(Order o) {
        salesOrders.add(o);
        // Assuming each order contributes to sales achieved; adjust as needed
        salesAchieved += o.getOrderTotal();
    }

    public void addSkill(String skill) {
        if (!skills.contains(skill)) {
            skills.add(skill);
        }
    }

    public void removeSkill(String skill) {
        skills.remove(skill);
    }

    public int calculatePerformance() {
        return (salesTarget > 0) ? (salesAchieved * 100) / salesTarget : 0;
    }

    public String getPerformanceRating() {
        int performance = calculatePerformance();
        if (performance >= 100) return "Excellent";
        else if (performance >= 75) return "Good";
        else if (performance >= 50) return "Satisfactory";
        else return "Needs Improvement";
    }

    public String getSummary() {
        return String.format("Role: %s\nYears of Experience: %d\nSkills: %s\nPerformance: %s",
                roleTitle, yearsOfExperience, skills.toString(), getPerformanceRating());
    }

    @Override
    public String getRole() {
        return "Marketing";
    }

    public String getRoleTitle() {
        return roleTitle;
    }

    public void setRoleTitle(String roleTitle) {
        this.roleTitle = roleTitle;
    }

    public int getYearsOfExperience() {
        return yearsOfExperience;
    }

    public void setYearsOfExperience(int yearsOfExperience) {
        this.yearsOfExperience = yearsOfExperience;
    }

    public int getSalesTarget() {
        return salesTarget;
    }

    public void setSalesTarget(int salesTarget) {
        this.salesTarget = salesTarget;
    }

    public int getSalesAchieved() {
        return salesAchieved;
    }

    public ArrayList<String> getSkills() {
        return skills;
    }

    public ArrayList<Order> getSalesOrders() {
        return salesOrders;
    }
}
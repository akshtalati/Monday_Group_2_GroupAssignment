/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.SalesManagement;

import java.util.ArrayList;

import model.OrderManagement.Order;
import model.Personnel.Person;
import model.Personnel.Profile;

/**
 *
 * @author kal bugrara
 */
public class SalesPersonProfile extends Profile {
    private ArrayList<Order> salesOrders;
    private double salesTarget;
    private double totalSales;

    /**
     * Constructor to initialize a SalesPersonProfile with a person object.
     *
     * @param person the person object representing the salesperson
     */
    public SalesPersonProfile(Person person) {
        super(person); 
        this.salesOrders = new ArrayList<>();
        this.salesTarget = 0.0; // Default target
        this.totalSales = 0.0; // Initialize total sales
    }

    /**
     * Adds a sales order to the salesperson's profile.
     *
     * @param order the sales order to add
     */
    public void addSalesOrder(Order order) {
        salesOrders.add(order);
        totalSales += order.getOrderTotal(); // Assumes Order has a method getOrderTotal()
    }

    /**
     * Gets the list of sales orders associated with the salesperson.
     *
     * @return the list of sales orders
     */
    public ArrayList<Order> getSalesOrders() {
        return salesOrders;
    }

    /**
     * Sets the sales target for the salesperson.
     *
     * @param target the sales target to set
     */
    public void setSalesTarget(double target) {
        this.salesTarget = target;
    }

    /**
     * Gets the sales target of the salesperson.
     *
     * @return the sales target
     */
    public double getSalesTarget() {
        return salesTarget;
    }

    /**
     * Calculates the salesperson's achievement as a percentage of the sales target.
     *
     * @return the percentage of the sales target achieved
     */
    public double getTargetAchievementPercentage() {
        if (salesTarget == 0) {
            return 0; // Avoid division by zero
        }
        return (totalSales / salesTarget) * 100;
    }

    /**
     * Gets the total sales made by the salesperson.
     *
     * @return the total sales amount
     */
    public double getTotalSales() {
        return totalSales;
    }

    /**
     * Finds orders that exceed a specified threshold.
     *
     * @param threshold the threshold value
     * @return a list of orders exceeding the threshold
     */
    public ArrayList<Order> getOrdersAboveThreshold(double threshold) {
        ArrayList<Order> highValueOrders = new ArrayList<>();
        for (Order order : salesOrders) {
            if (order.getOrderTotal() > threshold) {
                highValueOrders.add(order);
            }
        }
        return highValueOrders;
    }

    /**
     * Overrides the getRole method to return the role of the salesperson.
     *
     * @return the role as "Sales"
     */
    @Override
    public String getRole() {
        return "Sales";
    }

    /**
     * Returns a summary of the salesperson's profile.
     *
     * @return a string summarizing the salesperson's details
     */
    @Override
    public String toString() {
        return "SalesPersonProfile{" +
                "name=" + super.getPerson().getFirstName() + 
                super.getPerson().getLastName() +
                ", totalSales=" + totalSales +
                ", salesTarget=" + salesTarget +
                ", achievementPercentage=" + getTargetAchievementPercentage() +
                '}';
    }
}
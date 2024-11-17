/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.OrderManagement;

import java.util.ArrayList;

import model.CustomerManagement.CustomerProfile;
import model.MarketingManagement.MarketingPersonProfile;
import model.SalesManagement.SalesPersonProfile;

/**
 *
 * @author kal bugrara
 */
public class MasterOrderList {
    private ArrayList<Order> orders;
    private MasterOrderReport masterOrderReport;

    // Constructor initializes the orders list
    public MasterOrderList() {
        orders = new ArrayList<>();
    }

    // Method to create a new order with only a CustomerProfile
    public Order newOrder(CustomerProfile customerProfile) {
        Order order = new Order(customerProfile);
        orders.add(order);
        return order;
    }

    // Method to create a new order with both CustomerProfile and SalesPersonProfile
    public Order newOrder(CustomerProfile customerProfile, SalesPersonProfile salesPersonProfile) {
        Order order = new Order(customerProfile, salesPersonProfile);
        orders.add(order);
        return order;
    }

    // Method to create a new order with CustomerProfile, SalesPersonProfile, and MarketingPersonProfile
    public Order newOrder(CustomerProfile customerProfile, SalesPersonProfile salesPersonProfile, MarketingPersonProfile marketingPersonProfile) {
        Order order = new Order(customerProfile, salesPersonProfile, marketingPersonProfile);
        orders.add(order);
        return order;
    }

    // Generates a MasterOrderReport based on the orders list
    public MasterOrderReport generateMasterOrderReport() {
        masterOrderReport = new MasterOrderReport();
        masterOrderReport.generateOrderReport(orders); // Passes the list of orders for report generation
        return masterOrderReport;
    }

    // Calculates the total sales volume from all orders
    public int getSalesVolume() {
        int sum = 0;
        for (Order order : orders) {
            sum += order.getOrderTotal();
        }
        return sum;
    }

    // Retrieves all orders in the list
    public ArrayList<Order> getOrders() {
        return new ArrayList<>(orders);  // Return a copy to prevent external modification
    }

    // Retrieves the number of orders
    public int getOrderCount() {
        return orders.size();
    }
}
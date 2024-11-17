/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.OrderManagement;

import java.util.ArrayList;
import model.CustomerManagement.CustomerProfile;
import model.MarketModel.MarketChannelAssignment;
import model.ProductManagement.Product;
import model.SalesManagement.SalesPersonProfile;
import model.MarketingManagement.MarketingPersonProfile;

/**
 *
 * @author kal bugrara
 */
public class Order {

    private ArrayList<OrderItem> orderItems;         // List of items in the order
    private CustomerProfile customer;                // Customer who placed the order
    private SalesPersonProfile salesperson;          // Salesperson handling the order
    private MarketingPersonProfile marketingPerson;  // Marketing person assigned to the order
    private MarketChannelAssignment mca;             // Marketing channel assignment
    private String status;                           // Status of the order (e.g., "in process", "submitted", "cancelled")

    // Default constructor
    public Order() {
        orderItems = new ArrayList<>();
        status = "in process";
    }

    // Constructor for creating an order with a CustomerProfile
    public Order(CustomerProfile cp) {
        this();
        customer = cp;
        customer.addCustomerOrder(this); // Link the order to the customer
        salesperson = null;
    }

    // Constructor for creating an order with both a CustomerProfile and SalesPersonProfile
    public Order(CustomerProfile cp, SalesPersonProfile ep) {
        this(cp);
        salesperson = ep;
        salesperson.addSalesOrder(this);  // Link the order to the salesperson
    }

    // New constructor to create an order with CustomerProfile, SalesPersonProfile, and MarketingPersonProfile
    public Order(CustomerProfile cp, SalesPersonProfile ep, MarketingPersonProfile mp) {
        this(cp, ep);
        marketingPerson = mp;
        // Add logic here if you need to link the order to the marketing person
        // For example: marketingPerson.addMarketingOrder(this);
    }

    // Adds a new item to the order
    public OrderItem newOrderItem(Product product, int actualPrice, int quantity) {
        OrderItem orderItem = new OrderItem(product, actualPrice, quantity);
        orderItems.add(orderItem);
        return orderItem;
    }

    // Calculates the total cost of the order by summing up the cost of all items
    public int getOrderTotal() {
        int sum = 0;
        for (OrderItem orderItem : orderItems) {
            sum += orderItem.getOrderItemTotal();
        }
        return sum;
    }

    // Calculates the price performance of the order (positive or negative value)
    public int getOrderPricePerformance() {
        int sum = 0;
        for (OrderItem orderItem : orderItems) {
            sum += orderItem.calculatePricePerformance();
        }
        return sum;
    }

    // Counts the number of order items priced above their target
    public int getNumberOfOrderItemsAboveTarget() {
        int count = 0;
        for (OrderItem orderItem : orderItems) {
            if (orderItem.isActualAboveTarget()) {
                count++;
            }
        }
        return count;
    }

    // Checks if the order total is above the total target for all items
    public boolean isOrderAboveTotalTarget() {
        int targetSum = 0;
        for (OrderItem orderItem : orderItems) {
            targetSum += orderItem.getOrderItemTargetTotal();
        }
        return getOrderTotal() > targetSum;
    }

    // Cancels the order by updating the status
    public void cancelOrder() {
        status = "Cancelled";
    }

    // Submits the order by updating the status
    public void submitOrder() {
        status = "Submitted";
    }

    // Getters and Setters
    public CustomerProfile getCustomer() {
        return customer;
    }

    public SalesPersonProfile getSalesperson() {
        return salesperson;
    }

    public MarketingPersonProfile getMarketingPerson() {
        return marketingPerson;
    }

    public String getStatus() {
        return status;
    }

    public ArrayList<OrderItem> getOrderItems() {
        return new ArrayList<>(orderItems);  // Return a copy to prevent external modification
    }
}
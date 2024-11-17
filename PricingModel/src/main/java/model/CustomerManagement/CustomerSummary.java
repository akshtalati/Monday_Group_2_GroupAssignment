/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.CustomerManagement;

import java.util.List;
import model.OrderManagement.Order;

/**
 *
 * @author kal bugrara
 */
public class CustomerSummary {
    private CustomerProfile customerProfile;
    private int totalSpend;
    private int totalOrders;
    private int ordersAboveTarget;
    private int ordersBelowTarget;

    public CustomerSummary(CustomerProfile cp) {
        this.customerProfile = cp;
        this.totalSpend = calculateTotalSpend();
        this.totalOrders = cp.getOrders().size();
        this.ordersAboveTarget = cp.getNumberOfOrdersAboveTotalTarget();
        this.ordersBelowTarget = cp.getNumberOfOrdersBelowTotalTarget();
    }

    private int calculateTotalSpend() {
        int total = 0;
        List<Order> orders = customerProfile.getOrders();
        for (Order order : orders) {
            total += order.getOrderTotal(); // Assuming getOrderTotal gives the total price for the order
        }
        return total;
    }

    public int getTotalSpend() {
        return totalSpend;
    }

    public int getTotalOrders() {
        return totalOrders;
    }

    public int getOrdersAboveTarget() {
        return ordersAboveTarget;
    }

    public int getOrdersBelowTarget() {
        return ordersBelowTarget;
    }

    @Override
    public String toString() {
        return "CustomerSummary{" +
                "customerId=" + customerProfile.getCustomerId() +
                ", totalSpend=" + totalSpend +
                ", totalOrders=" + totalOrders +
                ", ordersAboveTarget=" + ordersAboveTarget +
                ", ordersBelowTarget=" + ordersBelowTarget +
                '}';
    }
}

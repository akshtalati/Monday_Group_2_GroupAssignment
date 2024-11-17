/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.CustomerManagement;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author kal bugrara
 */
public class CustomersReport {
    private ArrayList<CustomerSummary> customerList;

    public CustomersReport() {
        customerList = new ArrayList<>();
    }

    public void addCustomerSummary(CustomerSummary cs) {
        customerList.add(cs);
    }

    // Method to get a list of top customers by total spend
    public List<CustomerSummary> getTopCustomers(int topN) {
        return customerList.stream()
                .sorted(Comparator.comparingInt(CustomerSummary::getTotalSpend).reversed())
                .limit(topN)
                .collect(Collectors.toList());
    }

    // Method to calculate the average number of orders per customer
    public double getAverageOrdersPerCustomer() {
        if (customerList.isEmpty()) return 0;
        
        int totalOrders = customerList.stream()
                .mapToInt(CustomerSummary::getTotalOrders)
                .sum();
        
        return (double) totalOrders / customerList.size();
    }

    // Method to segment customers based on spending (e.g., low, medium, high spenders)
    public String getCustomerSegmentation() {
        int lowThreshold = 100;  // Arbitrary threshold values; adjust as needed
        int highThreshold = 500;
        
        long lowSpenders = customerList.stream()
                .filter(cs -> cs.getTotalSpend() < lowThreshold)
                .count();
        
        long mediumSpenders = customerList.stream()
                .filter(cs -> cs.getTotalSpend() >= lowThreshold && cs.getTotalSpend() <= highThreshold)
                .count();
        
        long highSpenders = customerList.stream()
                .filter(cs -> cs.getTotalSpend() > highThreshold)
                .count();
        
        return "Low Spenders: " + lowSpenders + ", Medium Spenders: " + mediumSpenders + ", High Spenders: " + highSpenders;
    }

    // Optional: Method to get a summary of the report
    @Override
    public String toString() {
        return "CustomersReport{" +
                "totalCustomers=" + customerList.size() +
                ", averageOrdersPerCustomer=" + getAverageOrdersPerCustomer() +
                ", customerSegmentation=" + getCustomerSegmentation() +
                '}';
    }
}
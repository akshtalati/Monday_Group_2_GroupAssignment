/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.CustomerManagement;

import java.util.ArrayList;

import model.MarketModel.Market;
import model.OrderManagement.Order;
import model.Personnel.Person;

/**
 *
 * @author kal bugrara
 */
public class CustomerProfile {
    private ArrayList<Order> orders;
    private ArrayList<Market> markets;
    private Person person;

    public CustomerProfile(Person p) {
        this.person = p;
        this.orders = new ArrayList<>();
        this.markets = new ArrayList<>();
    }

    public int getTotalPricePerformance() {
        int totalPerformance = 0;
        for (Order order : orders) {
            totalPerformance += order.getOrderPricePerformance();
        }
        return totalPerformance;
    }

    public int getNumberOfOrdersAboveTotalTarget() {
        int count = 0;
        for (Order order : orders) {
            if (order.isOrderAboveTotalTarget()) {
                count++;
            }
        }
        return count;
    }

    public int getNumberOfOrdersBelowTotalTarget() {
        int count = 0;
        for (Order order : orders) {
            if (!order.isOrderAboveTotalTarget()) { // Assumes false means below target
                count++;
            }
        }
        return count;
    }

    public boolean isMatch(String id) {
        return person.getPersonId().equals(id);
    }

    public void addCustomerOrder(Order order) {
        orders.add(order);
    }

    @Override
    public String toString() {
        return person.getPersonId();
    }

    public String getCustomerId() {
        return person.getPersonId();
    }

    public Person getPerson() {
        return person;
    }

    public ArrayList<Order> getOrders() {
        return new ArrayList<>(orders); // Return a copy to avoid modification outside the class
    }

    public void addMarket(Market market) {
        markets.add(market);
    }

    public ArrayList<Market> getMarkets() {
        return new ArrayList<>(markets); // Return a copy for encapsulation
    }
    public String getCustomerName() {
        return person.getFirstName();
}
}
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.ProductManagement;

import java.util.ArrayList;

import model.OrderManagement.OrderItem;

/**
 *
 * @author kal bugrara
 */
public class Product {

    private String name;
    private int floorPrice;
    private int ceilingPrice;
    private int targetPrice;
    private ArrayList<OrderItem> orderitems;

    /**
     * Constructor to initialize a product with floor, ceiling, and target prices.
     *
     * @param fp floor price
     * @param cp ceiling price
     * @param tp target price
     */
    public Product(int fp, int cp, int tp) {
        this("", fp, cp, tp); // Calls the other constructor
    }

    /**
     * Constructor to initialize a product with a name, floor price, ceiling price, and target price.
     *
     * @param n product name
     * @param fp floor price
     * @param cp ceiling price
     * @param tp target price
     */
    public Product(String n, int fp, int cp, int tp) {
        this.name = n;
        this.floorPrice = fp;
        this.ceilingPrice = cp;
        this.targetPrice = tp;
        this.orderitems = new ArrayList<>();
    }
    public Product updateProduct(int fp, int cp, int tp) {
        this.floorPrice = fp;
        this.ceilingPrice = cp;
        this.targetPrice = tp;
        return this;
    }

    public int getTargetPrice() {
        return targetPrice;
    }

    public int getFloorPrice() {
        return floorPrice;
    }

    public int getCeilingPrice() {
        return ceilingPrice;
    }

    public void setName(String n) {
        this.name = n;
    }
    
    public int getPrice() {
        // Using targetPrice as the main price for now.
        return targetPrice;
    }
    
    public void addOrderItem(OrderItem oi) {
        orderitems.add(oi);
    }

    public int getNumberOfProductSalesAboveTarget() {
        int count = 0;
        for (OrderItem oi : orderitems) {
            if (oi.isActualAboveTarget()) {
                count++;
            }
        }
        return count;
    }

    public int getNumberOfProductSalesBelowTarget() {
        int count = 0;
        for (OrderItem oi : orderitems) {
            if (oi.isActualBelowTarget()) {
                count++;
            }
        }
        return count;
    }

    public boolean isProductAlwaysAboveTarget() {
        for (OrderItem oi : orderitems) {
            if (!oi.isActualAboveTarget()) {
                return false;
            }
        }
        return true;
    }

    public int getOrderPricePerformance() {
        int totalPerformance = 0;
        for (OrderItem oi : orderitems) {
            totalPerformance += oi.calculatePricePerformance();
        }
        return totalPerformance;
    }
    public int getSalesVolume() {
        int totalVolume = 0;
        for (OrderItem oi : orderitems) {
            totalVolume += oi.getOrderItemTotal();
        }
        return totalVolume;
    }

    @Override
    public String toString() {
        return name;
    }
    public String getProductName() {
     return name;
}
}
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.OrderManagement;

import model.ProductManagement.Product;

/**
 *
 * @author kal bugrara
 */
public class OrderItem {

    private Product selectedProduct;
    private int actualPrice;
    private int quantity;

    /**
     * Constructor to create an order item with a product, price, and quantity.
     * 
     * @param p the product selected for the order item
     * @param paidPrice the actual price paid for each unit
     * @param q the quantity of the product ordered
     */
    public OrderItem(Product p, int paidPrice, int q) {
        selectedProduct = p;
        p.addOrderItem(this); // Link product back to the order item
        quantity = q;
        this.actualPrice = paidPrice;
    }

    public int getOrderItemTotal() {
        return actualPrice * quantity;
    }

    public int getOrderItemTargetTotal() {
        return selectedProduct.getTargetPrice() * quantity;
    }

    public int calculatePricePerformance() {
        return (actualPrice - selectedProduct.getTargetPrice()) * quantity;
    }

    public boolean isActualAboveTarget() {
        return actualPrice > selectedProduct.getTargetPrice();
    }

    public boolean isActualBelowTarget() {
        return actualPrice < selectedProduct.getTargetPrice();
    }

    public boolean isActualATTarget() {
        return actualPrice == selectedProduct.getTargetPrice();
    }

    // Getter for the selected product
    public Product getSelectedProduct() {
        return selectedProduct;
    }

    // Getter for the actual price
    public int getActualPrice() {
        return actualPrice;
    }

    // Getter for the quantity of the product ordered
    public int getQuantity() {
        return quantity;
    }
}
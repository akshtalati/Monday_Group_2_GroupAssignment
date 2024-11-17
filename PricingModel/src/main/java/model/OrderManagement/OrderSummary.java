/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.OrderManagement;

/**
 *
 * @author kal bugrara
 */
public class OrderSummary {

    private int salesVolume;
    private boolean totalAboveTarget;
    private int orderPricePerformance;
    private int numberOfOrderItemsAboveTarget;

    /**
     * Constructs an OrderSummary based on an Order.
     * 
     * @param order the order to summarize
     */
    public OrderSummary(Order order) {
        this.salesVolume = order.getOrderTotal();
        this.totalAboveTarget = order.isOrderAboveTotalTarget();
        this.orderPricePerformance = order.getOrderPricePerformance();
        this.numberOfOrderItemsAboveTarget = order.getNumberOfOrderItemsAboveTarget();
    }

    /**
     * Gets the total sales volume of the order.
     * 
     * @return the sales volume
     */
    public int getSalesVolume() {
        return salesVolume;
    }

    /**
     * Checks if the total sales volume is above the target.
     * 
     * @return true if the order total is above target, false otherwise
     */
    public boolean isTotalAboveTarget() {
        return totalAboveTarget;
    }

    /**
     * Gets the price performance of the order.
     * 
     * @return the price performance (profit or loss) of the order
     */
    public int getOrderPricePerformance() {
        return orderPricePerformance;
    }

    /**
     * Gets the number of order items with a price above target.
     * 
     * @return the count of order items above target price
     */
    public int getNumberOfOrderItemsAboveTarget() {
        return numberOfOrderItemsAboveTarget;
    }

    /**
     * Calculates the overall profit of the order based on price performance.
     * 
     * @return the overall profit of the order
     */
    public int getOrderProfit() {
        return orderPricePerformance;
    }
}
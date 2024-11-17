
package model.OrderManagement;

import java.util.ArrayList;

/**
 *
 * @author kal bugrara
 */
public class MasterOrderReport {
    private ArrayList<OrderSummary> ordersummarylist;

    // Constructor initializes the ordersummarylist
    public MasterOrderReport() {
        ordersummarylist = new ArrayList<>();
    }

    // Generates the report by creating OrderSummary objects for each Order in the list
    public void generateOrderReport(ArrayList<Order> orders) {
        ordersummarylist.clear(); // Clear previous summaries if regenerating the report
        for (Order order : orders) {
            OrderSummary orderSummary = new OrderSummary(order);
            ordersummarylist.add(orderSummary);
        }
    }

    // Returns the most profitable order based on the profit of each OrderSummary
    public OrderSummary getTopProfitableOrder() {
        if (ordersummarylist.isEmpty()) return null;

        OrderSummary currentTopOrder = ordersummarylist.get(0);

        for (OrderSummary orderSummary : ordersummarylist) {
            if (orderSummary.getOrderProfit() > currentTopOrder.getOrderProfit()) {
                currentTopOrder = orderSummary;
            }
        }
        return currentTopOrder;
    }

    // Retrieves the list of order summaries
    public ArrayList<OrderSummary> getOrderSummaries() {
        return new ArrayList<>(ordersummarylist);  // Return a copy to prevent external modification
    }
}

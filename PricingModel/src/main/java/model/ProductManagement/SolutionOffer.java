/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.ProductManagement;

import java.util.ArrayList;

import model.MarketModel.MarketChannelAssignment;

/**
 *
 * @author kal bugrara
 */
public class SolutionOffer {
    
    private ArrayList<Product> products;   // List of products in the offer
    private int price;                     // Price of the offer
    private MarketChannelAssignment marketChannelComb; // Market channel assignment for this offer

    public SolutionOffer(MarketChannelAssignment marketChannelComb) {
        this.marketChannelComb = marketChannelComb;
        this.products = new ArrayList<>();
    }

    public SolutionOffer(MarketChannelAssignment marketChannelComb, int initialPrice) {
        this.marketChannelComb = marketChannelComb;
        this.price = initialPrice;
        this.products = new ArrayList<>();
    }


    public void addProduct(Product product) {
        products.add(product);
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getPrice() {
        return price;
    }

    public ArrayList<Product> getProducts() {
        return new ArrayList<>(products); // Return a copy to preserve encapsulation
    }

    public MarketChannelAssignment getMarketChannelAssignment() {
        return marketChannelComb;
    }

    public int calculateTotalProductPrice() {
        int total = 0;
        for (Product product : products) {
            total += product.getPrice(); 
        }
        return total;
    }


    @Override
    public String toString() {
        return "SolutionOffer [marketChannelComb=" + marketChannelComb + ", price=" + price 
                + ", totalProducts=" + products.size() + "]";
    }
}
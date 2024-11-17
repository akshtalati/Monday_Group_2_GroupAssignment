/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.ProductManagement;

/**
 *
 * @author kal bugrara
 */

//this class will extract summary data from the product
public class ProductSummary {
   private Product subjectProduct;
    private int numberOfSalesAboveTarget;
    private int numberOfSalesBelowTarget;
    private int productPricePerformance; // Total profit/loss above/below target, can be negative
    private int actualSalesVolume;
    private int rank; // Product ranking, to be implemented later

    public ProductSummary(Product product) {
        this.subjectProduct = product;
        this.numberOfSalesAboveTarget = product.getNumberOfProductSalesAboveTarget();
        this.numberOfSalesBelowTarget = product.getNumberOfProductSalesBelowTarget();
        this.productPricePerformance = product.getOrderPricePerformance();
        this.actualSalesVolume = product.getSalesVolume();
        this.rank = 0; // Default rank, can be updated later
    }

    public int getSalesRevenues() {
        return actualSalesVolume;
    }

    public int getNumberAboveTarget() {
        return numberOfSalesAboveTarget;
    }

    public int getProductPricePerformance() {
        return productPricePerformance;
    }

    public int getNumberBelowTarget() {
        return numberOfSalesBelowTarget;
    }

    public boolean isProductAlwaysAboveTarget() {
        return subjectProduct.isProductAlwaysAboveTarget();
    }

    /**
     * Gets the rank of the product.
     *
     * @return the rank of the product
     */
    public int getRank() {
        return rank;
    }

    /**
     * Sets the rank of the product.
     *
     * @param rank the rank to set
     */
    public void setRank(int rank) {
        this.rank = rank;
    }

    /**
     * Returns a string representation of the product summary.
     *
     * @return a summary of the product's performance
     */
    @Override
    public String toString() {
        return "ProductSummary{" +
                "product=" + subjectProduct +
                ", numberOfSalesAboveTarget=" + numberOfSalesAboveTarget +
                ", numberOfSalesBelowTarget=" + numberOfSalesBelowTarget +
                ", productPricePerformance=" + productPricePerformance +
                ", actualSalesVolume=" + actualSalesVolume +
                ", rank=" + rank +
                '}';
    }
}
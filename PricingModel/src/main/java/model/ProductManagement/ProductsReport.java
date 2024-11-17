/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.ProductManagement;

import java.util.ArrayList;

/**
 *
 * @author kal bugrara
 */
public class ProductsReport {

    private ArrayList<ProductSummary> productSummaryList;

    public ProductsReport() {
        productSummaryList = new ArrayList<>();
    }

    public void addProductSummary(ProductSummary productSummary) {
        productSummaryList.add(productSummary);
    }

    public ProductSummary getTopProductAboveTarget() {
        ProductSummary topProduct = null;

        for (ProductSummary productSummary : productSummaryList) {
            if (topProduct == null || productSummary.getNumberAboveTarget() > topProduct.getNumberAboveTarget()) {
                topProduct = productSummary; // New highest total sales above target
            }
        }
        return topProduct;
    }
    public ArrayList<ProductSummary> getProductsAlwaysAboveTarget() {
        ArrayList<ProductSummary> productsAlwaysAboveTarget = new ArrayList<>();

        for (ProductSummary productSummary : productSummaryList) {
            if (productSummary.isProductAlwaysAboveTarget()) {
                productsAlwaysAboveTarget.add(productSummary);
            }
        }
        return productsAlwaysAboveTarget;
    }

    public ArrayList<ProductSummary> getAllProductSummaries() {
        return new ArrayList<>(productSummaryList);
    }

    @Override
    public String toString() {
        StringBuilder report = new StringBuilder("Products Report:\n");
        for (ProductSummary productSummary : productSummaryList) {
            report.append(productSummary.toString()).append("\n");
        }
        return report.toString();
    }
}
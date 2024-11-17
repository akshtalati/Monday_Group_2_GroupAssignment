/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.Supplier;

import java.util.ArrayList;
import java.util.Optional;

import model.ProductManagement.Product;
import model.ProductManagement.ProductCatalog;
import model.ProductManagement.ProductSummary;
import model.ProductManagement.ProductsReport;

/**
 *
 * @author kal bugrara
 */
public class Supplier {
    private String name;
    private ProductCatalog productCatalog;
    private ProductsReport productsReport;

    /**
     * Constructor to initialize a supplier with a name.
     *
     * @param name the name of the supplier
     */
    public Supplier(String name) {
        this.name = name;
        this.productCatalog = new ProductCatalog(); // Default product catalog
    }

    /**
     * Generates a performance report for the supplier's product catalog.
     *
     * @return the generated ProductsReport
     */
    public ProductsReport prepareProductsReport() {
        productsReport = productCatalog.generateProductPerformanceReport();
        return productsReport;
    }

    /**
     * Retrieves a list of products that have always performed above the target.
     *
     * @return a list of ProductSummary objects
     */
    public ArrayList<ProductSummary> getProductsAlwaysAboveTarget() {
        if (productsReport == null) {
            productsReport = prepareProductsReport();
        }
        return productsReport.getProductsAlwaysAboveTarget();
    }

    /**
     * Adds a new product to the supplier's catalog.
     *
     * @param name the name of the product
     * @param floorPrice the floor price of the product
     * @param ceilingPrice the ceiling price of the product
     * @param targetPrice the target price of the product
     */
    public void addProduct(String name, int floorPrice, int ceilingPrice, int targetPrice) {
        productCatalog.newProduct(name, floorPrice, ceilingPrice, targetPrice);
    }

    /**
     * Finds a product by name in the supplier's catalog.
     *
     * @param productName the name of the product to find
     * @return an Optional containing the product if found, otherwise empty
     */
    public Optional<Product> findProductByName(String productName) {
        return productCatalog.findProductByName(productName);
    }

    /**
     * Removes a product by name from the supplier's catalog.
     *
     * @param productName the name of the product to remove
     * @return true if the product was removed, false otherwise
     */
    public boolean removeProductByName(String productName) {
        return productCatalog.removeProductByName(productName);
    }

    /**
     * Gets the name of the supplier.
     *
     * @return the supplier's name
     */
    public String getName() {
        return name;
    }

    /**
     * Gets the product catalog managed by the supplier.
     *
     * @return the product catalog
     */
    public ProductCatalog getProductCatalog() {
        return productCatalog;
    }

    @Override
    public String toString() {
        return "Supplier{" +
                "name='" + name + '\'' +
                ", productCatalog=" + productCatalog +
                '}';
    }
    public String getSupplierName() {
        return name;
    }
}
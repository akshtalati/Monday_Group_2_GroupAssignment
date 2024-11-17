/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.ProductManagement;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Optional;

/**
 *
 * @author kal bugrara
 */
public class ProductCatalog {

    private String type;
    private ArrayList<Product> products;

    /**
     * Constructor to create a product catalog with a specified type.
     *
     * @param type the type of products in this catalog
     */
    public ProductCatalog(String type) {
        this.type = type;
        this.products = new ArrayList<>();
    }

    /**
     * Default constructor, initializes catalog with "unknown" type.
     */
    public ProductCatalog() {
        this("unknown");
    }

    public Product newProduct(int fp, int cp, int tp) {
        Product product = new Product(fp, cp, tp);
        products.add(product);
        return product;
    }

    /**
     * Creates and adds a new product with a specified name to the catalog.
     *
     * @param name product name
     * @param fp floor price
     * @param cp ceiling price
     * @param tp target price
     * @return the created Product
     */
    public Product newProduct(String name, int fp, int cp, int tp) {
        Product product = new Product(name, fp, cp, tp);
        products.add(product);
        return product;
    }

    /**
     * Generates a performance report for all products in the catalog.
     *
     * @return a ProductsReport containing summaries of each product's performance
     */
    public ProductsReport generateProductPerformanceReport() {
        ProductsReport productsReport = new ProductsReport();
        for (Product product : products) {
            ProductSummary productSummary = new ProductSummary(product);
            productsReport.addProductSummary(productSummary);
        }
        return productsReport;
    }

    /**
     * Retrieves the list of all products in the catalog.
     *
     * @return a list of products
     */
    public ArrayList<Product> getProductList() {
        return new ArrayList<>(products); // Returning a copy for encapsulation
    }

    /**
     * Finds a product by its name.
     *
     * @param name the name of the product to search for
     * @return an Optional containing the found product, or empty if not found
     */
    public Optional<Product> findProductByName(String name) {
        return products.stream().filter(product -> product.toString().equals(name)).findFirst();
    }

    /**
     * Removes a product from the catalog by its name.
     *
     * @param name the name of the product to remove
     * @return true if the product was removed, false if not found
     */
    public boolean removeProductByName(String name) {
        Iterator<Product> iterator = products.iterator();
        while (iterator.hasNext()) {
            Product product = iterator.next();
            if (product.toString().equals(name)) {
                iterator.remove();
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return "ProductCatalog{" +
                "type='" + type + '\'' +
                ", products=" + products +
                '}';
    }
}
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.Business;

import model.Business.Business;
import model.CustomerManagement.CustomerDirectory;
import model.CustomerManagement.CustomerProfile;
import model.MarketingManagement.MarketingPersonDirectory;
import model.MarketingManagement.MarketingPersonProfile;
import model.OrderManagement.MasterOrderList;
import model.OrderManagement.Order;
import model.OrderManagement.OrderItem;
import model.Personnel.EmployeeDirectory;
import model.Personnel.EmployeeProfile;
import model.Personnel.Person;
import model.Personnel.PersonDirectory;
import model.ProductManagement.Product;
import model.ProductManagement.ProductCatalog;
import model.SalesManagement.SalesPersonDirectory;
import model.SalesManagement.SalesPersonProfile;
import model.Supplier.Supplier;
import model.Supplier.SupplierDirectory;
import model.UserAccountManagement.UserAccount;
import model.UserAccountManagement.UserAccountDirectory;

/**
 *
 * @author kal bugrara
 */
//public class ConfigureABusiness {
//
//    public static Business initialize() {
//        // Create a new business
//        Business business = new Business("Business1");
//
//        // Supplier Directory
//        SupplierDirectory supplierDirectory = business.getSupplierDirectory();
//        for (int i = 1; i <= 5; i++) {
//            Supplier supplier = supplierDirectory.newSupplier("Supplier " + i);
//
//            // Product Catalog for each supplier
//            ProductCatalog productCatalog = supplier.getProductCatalog();
//            for (int j = 1; j <= 10; j++) {
//                // Use newProduct method to add products
//                String productName = "Product " + j;
//                int floorPrice = generateRandomPrice();
//                int ceilingPrice = floorPrice + 10; // Ensure ceiling price > floor price
//                int targetPrice = (floorPrice + ceilingPrice) / 2; // Target price is the average
//                productCatalog.newProduct(productName, floorPrice, ceilingPrice, targetPrice);
//            }
//        }
//
//        // Customer Directory
//        CustomerDirectory customerDirectory = business.getCustomerDirectory();
//        for (int i = 1; i <= 10; i++) {
//            customerDirectory.newCustomerProfile("Customer " + i);
//        }
//
//        // Master Order List
//        MasterOrderList masterOrderList = business.getMasterOrderList();
//        for (Supplier supplier : supplierDirectory.getSupplierList()) {
//            for (Product product : supplier.getProductCatalog().getProductList()) {
//                for (int i = 1; i <= 10; i++) {
//                    // Create an order for each product
//                    Order order = masterOrderList.newOrder();
//                    CustomerProfile randomCustomer = getRandomCustomer(customerDirectory);
//                    order.setCustomer(randomCustomer);
//
//                    // Add an order item
//                    int quantity = generateRandomQuantity();
//                    double price = product.getTargetPrice(); // Use target price for the order item
//                    order.addOrderItem(product, quantity, price);
//                }
//            }
//        }
//
//        return business;
//    }
//
//    // Helper to generate a random price
//    private static int generateRandomPrice() {
//        return 50 + (int) (Math.random() * 100); // Random price between 50 and 150
//    }
//
//    // Helper to generate a random quantity
//    private static int generateRandomQuantity() {
//        return 1 + (int) (Math.random() * 10); // Random quantity between 1 and 10
//    }
//
//    // Helper to get a random customer
//    private static CustomerProfile getRandomCustomer(CustomerDirectory customerDirectory) {
//        int randomIndex = (int) (Math.random() * customerDirectory.getCustomerList().size());
//        return customerDirectory.getCustomerList().get(randomIndex);
//    }
//}
public class ConfigureABusiness {

    public static Business initialize() {
        // Create a new business
        Business business = new Business("Business1");

        // Initialize Person Directory
        PersonDirectory personDirectory = business.getPersonDirectory();

        // Supplier Directory
        SupplierDirectory supplierDirectory = business.getSupplierDirectory();
        for (int i = 1; i <= 5; i++) {
            Supplier supplier = supplierDirectory.newSupplier("Supplier " + i);

            // Product Catalog for each supplier
            ProductCatalog productCatalog = supplier.getProductCatalog();
            for (int j = 1; j <= 10; j++) {
                // Add products using newProduct method
                String productName = "Product " + j;
                int floorPrice = generateRandomPrice();
                int ceilingPrice = floorPrice + 10; // Ensure ceiling price > floor price
                int targetPrice = (floorPrice + ceilingPrice) / 2; // Target price is the average
                productCatalog.newProduct(productName, floorPrice, ceilingPrice, targetPrice);
            }
        }

        // Customer Directory
        CustomerDirectory customerDirectory = business.getCustomerDirectory();
        for (int i = 1; i <= 10; i++) {
            // Create a new person for each customer
            Person person = personDirectory.newPerson("Customer " + i); // Assuming `newPerson` exists
            // Add the person as a customer
            customerDirectory.newCustomerProfile(person);
        }

        // Master Order List
       MasterOrderList masterOrderList = business.getMasterOrderList();


        // Validate necessary directories
        if (supplierDirectory == null || supplierDirectory.getSupplierList().isEmpty()) {
           throw new IllegalStateException("Supplier directory is empty or not initialized.");
        }
        if (customerDirectory == null || customerDirectory.getAllCustomers().isEmpty()) {
           throw new IllegalStateException("Customer directory is empty or not initialized.");
        }

        // Iterate through suppliers and their products
        for (Supplier supplier : supplierDirectory.getSupplierList()) {
         for (Product product : supplier.getProductCatalog().getProductList()) {
                for (int i = 1; i <= 10; i++) {
                  // Get a random customer for the order
                  CustomerProfile randomCustomer = getRandomCustomer(customerDirectory);
                  if (randomCustomer == null) {
                     throw new IllegalStateException("No customers available to assign to orders.");
                 }

            // Create a new order for the customer
            Order order = masterOrderList.newOrder(randomCustomer);

            // Add an order item with validated quantity and price
            int quantity = generateRandomQuantity();
            if (quantity <= 0) {
                throw new IllegalArgumentException("Generated quantity must be greater than zero.");
            }

            double price = product.getTargetPrice(); // Use target price for the order item
            if (price <= 0) {
                throw new IllegalArgumentException("Product target price must be greater than zero.");
            }

            order.newOrderItem(product, (int) price, quantity); // Cast price to int as `OrderItem` expects int price

            // Optional: Submit the order
            order.submitOrder();
        }
    }
}

return business;
    }

    // Helper to generate a random price
    private static int generateRandomPrice() {
        return 50 + (int) (Math.random() * 100); // Random price between 50 and 150
    }

    // Helper to generate a random quantity
    private static int generateRandomQuantity() {
        return 1 + (int) (Math.random() * 10); // Random quantity between 1 and 10
    }

    // Helper to get a random customer
    private static CustomerProfile getRandomCustomer(CustomerDirectory customerDirectory) {
        int randomIndex = (int) (Math.random() * customerDirectory.getAllCustomers().size());
        return customerDirectory.getAllCustomers().get(randomIndex);
    }
}
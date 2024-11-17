/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.Supplier;

import java.util.ArrayList;
import java.util.Optional;

/**
 *
 * @author kal bugrara
 */
public class SupplierDirectory {

    private final ArrayList<Supplier> suppliers;

    /**
     * Constructor to initialize an empty supplier directory.
     */
    public SupplierDirectory() {
        suppliers = new ArrayList<>();
    }

    /**
     * Creates and adds a new supplier to the directory.
     *
     * @param name the name of the new supplier
     * @return the newly created Supplier
     */
    public Supplier newSupplier(String name) {
        Supplier supplier = new Supplier(name);
        suppliers.add(supplier);
        return supplier;
    }

    /**
     * Finds a supplier by their name.
     *
     * @param name the name of the supplier to find
     * @return an Optional containing the Supplier if found, otherwise empty
     */
    public Optional<Supplier> findSupplierByName(String name) {
        return suppliers.stream()
                .filter(supplier -> supplier.getName().equalsIgnoreCase(name))
                .findFirst();
    }

    /**
     * Updates the name of an existing supplier.
     *
     * @param currentName the current name of the supplier
     * @param newName the new name to update
     * @return true if the supplier was updated successfully, false otherwise
     */
    public boolean updateSupplierName(String currentName, String newName) {
        Optional<Supplier> supplierOptional = findSupplierByName(currentName);
        if (supplierOptional.isPresent()) {
            Supplier supplier = supplierOptional.get();
            supplier = new Supplier(newName); // Create a new Supplier with the updated name
            return true;
        }
        return false;
    }

    /**
     * Returns a copy of the list of all suppliers.
     *
     * @return a list of suppliers
     */
    public ArrayList<Supplier> getSupplierList() {
        return new ArrayList<>(suppliers); // Return a copy to ensure encapsulation
    }

    /**
     * Removes a supplier from the directory by name.
     *
     * @param name the name of the supplier to remove
     * @return true if the supplier was removed successfully, false otherwise
     */
    public boolean removeSupplierByName(String name) {
        return suppliers.removeIf(supplier -> supplier.getName().equalsIgnoreCase(name));
    }

    @Override
    public String toString() {
        return "SupplierDirectory{" +
                "suppliers=" + suppliers +
                '}';
    }
}
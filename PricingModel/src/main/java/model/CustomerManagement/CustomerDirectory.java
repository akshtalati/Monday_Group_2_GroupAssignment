/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.CustomerManagement;

import java.util.ArrayList;
import java.util.Optional;
import model.Business.Business;
import model.Personnel.Person;

/**
 *
 * @author kal bugrara
 */
public class CustomerDirectory {

    private Business business;
    private ArrayList<CustomerProfile> customerlist;

    public CustomerDirectory(Business d) {
        this.business = d;
        this.customerlist = new ArrayList<>();
    }

    public CustomerProfile newCustomerProfile(Person p) {
        CustomerProfile cp = new CustomerProfile(p);
        customerlist.add(cp);
        return cp;
    }

    public Optional<CustomerProfile> findCustomer(String id) {
        for (CustomerProfile cp : customerlist) {
            if (cp.isMatch(id)) {
                return Optional.of(cp);
            }
        }
        return Optional.empty(); // Return Optional if not found
    }

    public boolean removeCustomer(String id) {
        Optional<CustomerProfile> customer = findCustomer(id);
        if (customer.isPresent()) {
            customerlist.remove(customer.get());
            return true;
        }
        return false;
    }

    public ArrayList<CustomerProfile> getAllCustomers() {
        return new ArrayList<>(customerlist); // Return a copy to prevent modification
    }

    public CustomersReport generateCustomerPerformanceReport() {
        CustomersReport customersReport = new CustomersReport();
        for (CustomerProfile cp : customerlist) {
            CustomerSummary cs = new CustomerSummary(cp);
            customersReport.addCustomerSummary(cs);
        }
        return customersReport;
    }
}
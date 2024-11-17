/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.SalesManagement;

import java.util.ArrayList;

import model.Business.Business;
import model.Personnel.Person;

/**
 *
 * @author kal bugrara
 */
public class SalesPersonDirectory {

    private Business business;
    private ArrayList<SalesPersonProfile> salespersonList;

    public SalesPersonDirectory(Business business) {
        this.business = business;
        this.salespersonList = new ArrayList<>();
    }

    public SalesPersonProfile newSalesPersonProfile(Person person) {
        SalesPersonProfile salesPersonProfile = new SalesPersonProfile(person);
        salespersonList.add(salesPersonProfile);
        return salesPersonProfile;
    }

    public SalesPersonProfile findSalesPerson(String id) {
        for (SalesPersonProfile salesPerson : salespersonList) {
            if (salesPerson.isMatch(id)) {
                return salesPerson;
            }
        }
        return null; // Not found
    }

    public boolean removeSalesPerson(String id) {
        SalesPersonProfile salesPerson = findSalesPerson(id);
        if (salesPerson != null) {
            salespersonList.remove(salesPerson);
            return true;
        }
        return false;
    }

    public ArrayList<SalesPersonProfile> getSalespersonList() {
        return salespersonList;
    }

    public Business getBusiness() {
        return business;
    }

    public int getSalesPersonCount() {
        return salespersonList.size();
    }

    @Override
    public String toString() {
        return "SalesPersonDirectory{" +
                "business=" + business +
                ", salespersonList=" + salespersonList +
                '}';
    }
}
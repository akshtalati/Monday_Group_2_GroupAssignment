/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.Personnel;

import java.util.ArrayList;

/**
 *
 * @author kal bugrara
 */
public class PersonDirectory {

    private ArrayList<Person> personList;

    // Constructor initializing the person list
    public PersonDirectory() {
        personList = new ArrayList<>();
    }

    // Method to add a new person with only ID
    public Person newPerson(String id) {
        Person p = new Person(id);
        personList.add(p);
        return p;
    }

    // Method to add a new person with additional attributes
    public Person newPerson(String id, String firstName, String lastName, String email, String phoneNumber) {
        Person p = new Person(id, firstName, lastName, email, phoneNumber);
        personList.add(p);
        return p;
    }

    // Method to find a person by their ID
    public Person findPerson(String id) {
        for (Person p : personList) {
            if (p.isMatch(id)) {
                return p;
            }
        }
        return null; // Not found after going through the whole list
    }

    // Method to remove a person by their ID
    public boolean removePerson(String id) {
        Person personToRemove = findPerson(id);
        if (personToRemove != null) {
            personList.remove(personToRemove);
            return true;
        }
        return false; // Person with the specified ID was not found
    }

    // Method to get the list of all persons
    public ArrayList<Person> getPersonList() {
        return personList;
    }
}
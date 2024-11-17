/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.Personnel;

/**
 *
 * @author kal bugrara
 */
public class Person {

    private String id;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;

    // Constructor with only ID
    public Person(String id) {
        this.id = id;
    }

    // Constructor with additional attributes
    public Person(String id, String firstName, String lastName, String email, String phoneNumber) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    // Getter for ID
    public String getPersonId() {
        return id;
    }

    // Getters and Setters for additional attributes
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    // Checks if the given ID matches this person's ID
    public boolean isMatch(String id) {
        return this.id.equals(id);
    }

    @Override
    public String toString() {
        return "ID: " + id + ", Name: " + firstName + " " + lastName;
    }
}
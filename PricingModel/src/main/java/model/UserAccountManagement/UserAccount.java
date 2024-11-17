/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.UserAccountManagement;

import model.Personnel.Profile;

/**
 *
 * @author kal bugrara
 */
public class UserAccount {

    private Profile profile;
    private String username;
    private String password;

    /**
     * Constructor to initialize a user account.
     *
     * @param profile the profile associated with the user account
     * @param username the username
     * @param password the password (should ideally be hashed)
     */
    public UserAccount(Profile profile, String username, String password) {
        if (profile == null || username == null || username.isEmpty() || password == null || password.isEmpty()) {
            throw new IllegalArgumentException("Invalid arguments for creating UserAccount");
        }
        this.profile = profile;
        this.username = username;
        this.password = password; // Consider hashing the password
    }

    /**
     * Gets the unique ID of the person associated with the profile.
     *
     * @return the person ID
     */
    public String getPersonId() {
        return profile.getPerson().getPersonId();
    }

    /**
     * Checks if the given person ID matches the associated person's ID.
     *
     * @param id the ID to match
     * @return true if the ID matches, false otherwise
     */
    public boolean isMatch(String id) {
        return getPersonId().equals(id);
    }

    /**
     * Validates the username and password for this user account.
     *
     * @param username the username to validate
     * @param password the password to validate
     * @return true if the username and password are correct, false otherwise
     */
    public boolean isValidUser(String username, String password) {
        return this.username.equalsIgnoreCase(username) && this.password.equals(password);
    }

    /**
     * Retrieves the role of the profile associated with the user account.
     *
     * @return the role as a string
     */
    public String getRole() {
        return profile.getRole();
    }

    /**
     * Retrieves the profile associated with the user account.
     *
     * @return the profile object
     */
    public Profile getAssociatedPersonProfile() {
        return profile;
    }

    @Override
    public String toString() {
        return "UserAccount{" +
                "username='" + username + '\'' +
                ", role='" + getRole() + '\'' +
                '}';
    }
}
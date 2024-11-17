/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.UserAccountManagement;

import java.util.ArrayList;
import java.util.List;

import model.Personnel.Profile;

/**
 *
 * @author kal bugrara
 */
public class UserAccountDirectory {

    private List<UserAccount> userAccounts;

    /**
     * Constructor to initialize the user account directory.
     */
    public UserAccountDirectory() {
        userAccounts = new ArrayList<>();
    }

    /**
     * Creates a new user account and adds it to the directory.
     *
     * @param profile the profile associated with the user account
     * @param username the username
     * @param password the password
     * @return the created UserAccount object
     * @throws IllegalArgumentException if inputs are null or invalid
     */
    public UserAccount newUserAccount(Profile profile, String username, String password) {
        if (profile == null || username == null || username.isEmpty() || password == null || password.isEmpty()) {
            throw new IllegalArgumentException("Profile, username, and password must not be null or empty");
        }
        UserAccount userAccount = new UserAccount(profile, username, password);
        userAccounts.add(userAccount);
        return userAccount;
    }

    /**
     * Finds a user account by the person's ID.
     *
     * @param personId the ID of the person
     * @return the matching UserAccount, or null if not found
     */
    public UserAccount findUserAccount(String personId) {
        if (personId == null || personId.isEmpty()) {
            return null;
        }
        for (UserAccount userAccount : userAccounts) {
            if (userAccount.isMatch(personId)) {
                return userAccount;
            }
        }
        return null; // Not found
    }

    /**
     * Authenticates a user account based on username and password.
     *
     * @param username the username
     * @param password the password
     * @return the authenticated UserAccount, or null if credentials are invalid
     */
    public UserAccount authenticateUser(String username, String password) {
        if (username == null || password == null) {
            return null;
        }
        for (UserAccount userAccount : userAccounts) {
            if (userAccount.isValidUser(username, password)) {
                return userAccount;
            }
        }
        return null; // Not found
    }

    /**
     * Retrieves the list of all user accounts.
     *
     * @return the list of UserAccount objects
     */
    public List<UserAccount> getUserAccounts() {
        return userAccounts;
    }

    /**
     * Removes a user account by the person's ID.
     *
     * @param personId the ID of the person whose account needs to be removed
     * @return true if the account was successfully removed, false otherwise
     */
    public boolean removeUserAccount(String personId) {
        UserAccount userAccount = findUserAccount(personId);
        if (userAccount != null) {
            userAccounts.remove(userAccount);
            return true;
        }
        return false; // Account not found
    }

    @Override
    public String toString() {
        return "UserAccountDirectory{" +
                "userAccounts=" + userAccounts +
                '}';
    }
}
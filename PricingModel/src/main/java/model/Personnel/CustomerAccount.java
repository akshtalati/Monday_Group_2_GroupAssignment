/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.Personnel;
import java.time.LocalDate;
/**
 *
 * @author kal bugrara
 */
public class CustomerAccount {

    private String accountId;
    private String customerName;
    private String email;
    private String phoneNumber;
    private AccountStatus accountStatus;
    private LocalDate createdDate;
    private LocalDate updatedDate;

    public enum AccountStatus {
        ACTIVE, SUSPENDED, CLOSED
    }

    /**
     * Constructor to create a new customer account.
     * 
     * @param accountId Unique identifier for the account
     * @param customerName Name of the account holder
     * @param email Contact email of the customer
     * @param phoneNumber Contact number of the customer
     */
    public CustomerAccount(String accountId, String customerName, String email, String phoneNumber) {
        this.accountId = accountId;
        this.customerName = customerName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.accountStatus = AccountStatus.ACTIVE;
        this.createdDate = LocalDate.now();
        this.updatedDate = LocalDate.now();
    }

    /**
     * Updates customer details.
     * 
     * @param customerName Updated name of the account holder
     * @param email Updated email of the account holder
     * @param phoneNumber Updated phone number of the account holder
     */
    public void updateAccountDetails(String customerName, String email, String phoneNumber) {
        this.customerName = customerName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.updatedDate = LocalDate.now();
    }

    /**
     * Suspends the account.
     */
    public void suspendAccount() {
        this.accountStatus = AccountStatus.SUSPENDED;
        this.updatedDate = LocalDate.now();
    }

    /**
     * Reactivates a suspended account.
     */
    public void reactivateAccount() {
        if (this.accountStatus == AccountStatus.SUSPENDED) {
            this.accountStatus = AccountStatus.ACTIVE;
            this.updatedDate = LocalDate.now();
        }
    }

    /**
     * Closes the account.
     */
    public void closeAccount() {
        this.accountStatus = AccountStatus.CLOSED;
        this.updatedDate = LocalDate.now();
    }

    // Getters and setters for accessing the fields
    public String getAccountId() {
        return accountId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public AccountStatus getAccountStatus() {
        return accountStatus;
    }

    public LocalDate getCreatedDate() {
        return createdDate;
    }

    public LocalDate getUpdatedDate() {
        return updatedDate;
    }
}
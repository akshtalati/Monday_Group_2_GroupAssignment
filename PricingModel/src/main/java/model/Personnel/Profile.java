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
public abstract class Profile {

    private Person person; // Encapsulated `person` field for better encapsulation


    public Profile(Person p) {
        this.person = p;
    }

    public abstract String getRole();

    public Person getPerson() {
        return person;
    }

 
    public boolean isMatch(String id) {
        return person.getPersonId().equals(id);
    }
}
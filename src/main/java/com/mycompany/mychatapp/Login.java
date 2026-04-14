/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mychatapp;

/**
 *
 * @author Garfield
 */
import java.util.HashMap;
import java.util.Map;

public class Login {

    private final Map<String, String> userDatabase = new HashMap<>();

    public Login() {
        // Constructor initializes the user database
    }

    public boolean register(String firstName, String lastName, String username, String password, String phone) {
        if (firstName.isEmpty() || lastName.isEmpty() || username.isEmpty() || password.isEmpty() || phone.isEmpty()) {
            return false;
        }

        // Check if username is already taken
        if (userDatabase.containsKey(username)) {
            return false;
        }

        // Validate phone number format
        if (!phone.matches("^\\+27\\d{9}$")) {
            return false;
        }

        // Save username and password
        userDatabase.put(username, password);
        return true;
    }

    public boolean loginUser(String username, String password) {
        return userDatabase.containsKey(username) && userDatabase.get(username).equals(password);
    }

    // These methods are no longer needed unless you want to implement them individually
    public boolean validateUsername(String username) {
        return username.matches("^[a-zA-Z][a-zA-Z0-9_]*$");
    }

    public boolean validatePassword(String password) {
        return password.length() >= 6;
    }

    public boolean validateCellNumber(String phone) {
        return phone.matches("^\\+27\\d{9}$");
    }
}

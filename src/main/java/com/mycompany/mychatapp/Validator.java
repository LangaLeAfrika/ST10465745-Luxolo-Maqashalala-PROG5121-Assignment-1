/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mychatapp;

/**
 *
 * @author Garfield
 */
public class Validator {

    // Validates that the username is at least 4 characters and only contains letters and digits
    public static boolean isValidUsername(String username) {
        return username != null && username.length() >= 4 && username.matches("[A-Za-z0-9]+");
    }

    // Validates that the password is at least 8 characters and contains at least one letter and one digit
    public static boolean isValidPassword(String password) {
        return password != null &&
               password.length() >= 8 &&
               password.matches(".*[A-Za-z].*") &&
               password.matches(".*\\d.*");
    }

    // Validates South African phone numbers starting with +27 and 11 digits in total
    public static boolean isValidPhoneNumber(String phoneNumber) {
        return phoneNumber != null && phoneNumber.matches("\\+27\\d{9}");
    }
}

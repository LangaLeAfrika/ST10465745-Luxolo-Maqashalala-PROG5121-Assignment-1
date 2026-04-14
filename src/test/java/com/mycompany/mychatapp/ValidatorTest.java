/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Garfield
 */
package com.mycompany.mychatapp;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ValidatorTest {

    // Phone Number Tests
    @Test
    public void testValidPhoneNumber() {
        assertTrue(Validator.isValidPhoneNumber("+27812345678"));
        assertTrue(Validator.isValidPhoneNumber("+27712345678"));
    }

    @Test
    public void testInvalidPhoneNumber() {
        assertFalse(Validator.isValidPhoneNumber("0812345678"));
        assertFalse(Validator.isValidPhoneNumber("+2781234567"));
        assertFalse(Validator.isValidPhoneNumber("+278123456789"));
        assertFalse(Validator.isValidPhoneNumber("+2781234abc8"));
        assertFalse(Validator.isValidPhoneNumber(null));
    }

    // Username Tests
    @Test
    public void testValidUsername() {
        assertTrue(Validator.isValidUsername("John123"));
        assertTrue(Validator.isValidUsername("Alice2024"));
    }

    @Test
    public void testInvalidUsername() {
        assertFalse(Validator.isValidUsername("Jo"));              // Too short
        assertFalse(Validator.isValidUsername(""));                // Empty
        assertFalse(Validator.isValidUsername(null));              // Null
        assertFalse(Validator.isValidUsername("John!@#"));         // Special characters
    }

    // Password Tests
    @Test
    public void testValidPassword() {
        assertTrue(Validator.isValidPassword("Pass1234"));         // Assuming min length & alphanum
        assertTrue(Validator.isValidPassword("SecurePass01"));
    }

    @Test
    public void testInvalidPassword() {
        assertFalse(Validator.isValidPassword("pass"));            // Too short
        assertFalse(Validator.isValidPassword("12345678"));        // Only numbers
        assertFalse(Validator.isValidPassword("password"));        // Only letters
        assertFalse(Validator.isValidPassword(""));                // Empty
        assertFalse(Validator.isValidPassword(null));              // Null
    }
}

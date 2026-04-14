package com.mycompany.mychatapp;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Garfield
 */
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LoginTest {

    @Test
    public void testRegistrationAndLoginSuccess() {
        Login login = new Login();
        boolean registered = login.register("Garfield", "Smith", "Garfield123", "secret123", "+27812345678");
        assertTrue(registered);

        boolean loggedIn = login.loginUser("Garfield123", "secret123");
        assertTrue(loggedIn);
    }

    @Test
    public void testDuplicateRegistrationFails() {
        Login login = new Login();
        login.register("User", "One", "user1", "pass123", "+27811111111");
        boolean secondAttempt = login.register("User", "Two", "user1", "pass123", "+27822222222");
        assertFalse(secondAttempt); // Username already taken
    }

    @Test
    public void testLoginFailsWithWrongPassword() {
        Login login = new Login();
        login.register("User", "One", "user1", "correctpass", "+27811111111");
        assertFalse(login.loginUser("user1", "wrongpass"));
    }

    @Test
    public void testLoginFailsWithUnregisteredUser() {
        Login login = new Login();
        assertFalse(login.loginUser("nonexistent", "whatever"));
    }
}

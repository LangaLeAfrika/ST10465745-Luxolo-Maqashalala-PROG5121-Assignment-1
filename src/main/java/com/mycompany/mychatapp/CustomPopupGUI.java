/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mychatapp;

/**
 *
 * @author Garfield Ref:ChatGBT when asked to run my code from popup instead of OUTPUT
 */
import javax.swing.*;
import java.awt.*;

public class CustomPopupGUI {
   
    private static final Color BACKGROUND_COLOR = new Color(234,66,66);
    private static final Color FOREGROUND_COLOR = Color.WHITE;
    private static final Color FIELD_BACKGROUND = new Color(255, 182, 193);
    private static final Color FIELD_FOREGROUND = Color.MAGENTA;
    private static final Font CUSTOM_FONT = new Font("Arial", Font.PLAIN, 14);
    private static final Color CUSTOM_COLOR = Color.CYAN;

    public static void main(String[] args) {
        // Set UI defaults
        UIManager.put("Panel.background", CUSTOM_COLOR);
        UIManager.put("OptionPane.background", CUSTOM_COLOR);
        UIManager.put("OptionPane.messageForeground", FOREGROUND_COLOR);
        UIManager.put("Button.background", FIELD_BACKGROUND);
        UIManager.put("Button.foreground", FOREGROUND_COLOR);
        UIManager.put("Label.foreground", FOREGROUND_COLOR);
        UIManager.put("OptionPane.font", CUSTOM_FONT);
        UIManager.put("Button.font", CUSTOM_FONT);

        showRegistrationForm();
    }

    public static void showRegistrationForm() {
        while (true) {
            JPanel panel = new JPanel(new GridLayout(0, 1));
            panel.setBackground(BACKGROUND_COLOR);

            JTextField firstNameField = createStyledTextField();
            JTextField lastNameField = createStyledTextField();
            JTextField usernameField = createStyledTextField();
            JPasswordField passwordField = createStyledPasswordField();
            JTextField phoneField = createStyledTextField();

            panel.add(createStyledLabel("First Name:"));
            panel.add(firstNameField);
            panel.add(createStyledLabel("Last Name:"));
            panel.add(lastNameField);
            panel.add(createStyledLabel("Username (must start with a letter):"));
            panel.add(usernameField);
            panel.add(createStyledLabel("Password (at least 6 characters):"));
            panel.add(passwordField);
            panel.add(createStyledLabel("Cell Phone Number (e.g., +27812345678):"));
            panel.add(phoneField);

            int result = JOptionPane.showConfirmDialog(null, panel,
                    "Register New User", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

            if (result == JOptionPane.OK_OPTION) {
                String firstName = firstNameField.getText();
                String lastName = lastNameField.getText();
                String username = usernameField.getText();
                String password = new String(passwordField.getPassword());
                String phone = phoneField.getText();

                if (!username.matches("^[a-zA-Z][a-zA-Z0-9_]*$")) {
                    showError("Invalid username. It must start with a letter and contain only letters, numbers, or underscores.");
                    continue;
                }

                if (password.length() < 6) {
                    showError("Password must be at least 6 characters.");
                    continue;
                }

                showInfo("Registration successful. Welcome, " + firstName + "!");
                showLoginDialog(username, password);
                break;
            } else {
                showWarning("Registration cancelled.");
                break;
            }
        }
    }

    public static void showLoginDialog(String correctUsername, String correctPassword) {
        JPanel loginPanel = new JPanel(new GridLayout(0, 1));
        loginPanel.setBackground(BACKGROUND_COLOR);

        JTextField loginUsername = createStyledTextField();
        JPasswordField loginPassword = createStyledPasswordField();

        loginPanel.add(createStyledLabel("Username:"));
        loginPanel.add(loginUsername);
        loginPanel.add(createStyledLabel("Password:"));
        loginPanel.add(loginPassword);

        int result = JOptionPane.showConfirmDialog(null, loginPanel,
                "Login", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

        if (result == JOptionPane.OK_OPTION) {
            String enteredUsername = loginUsername.getText();
            String enteredPassword = new String(loginPassword.getPassword());

            if (enteredUsername.equals(correctUsername) && enteredPassword.equals(correctPassword)) {
                showInfo("Login successful. Welcome back!");
                promptForMessage();
            } else {
                showError("Incorrect username or password.");
                showLoginDialog(correctUsername, correctPassword);
            }
        } else {
            showWarning("Login cancelled.");
        }
    }

    public static void promptForMessage() {
        JTextArea messageArea = new JTextArea(5, 30);
        messageArea.setBackground(FIELD_BACKGROUND);
        messageArea.setForeground(FIELD_FOREGROUND);
        messageArea.setCaretColor(FOREGROUND_COLOR);
        messageArea.setFont(CUSTOM_FONT);

        JScrollPane scrollPane = new JScrollPane(messageArea);
        scrollPane.getViewport().setBackground(FIELD_BACKGROUND);

        int messageResult = JOptionPane.showConfirmDialog(null, scrollPane,
                "ChatApp - Enter your message", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

        if (messageResult == JOptionPane.OK_OPTION) {
            String message = messageArea.getText();
            if (message != null && !message.trim().isEmpty()) {
                showInfo("You entered: " + message + "\nMessage sent.");
            }
        }
    }

    // Helper methods for consistency
    private static JLabel createStyledLabel(String text) {
        JLabel label = new JLabel(text);
        label.setForeground(FOREGROUND_COLOR);
        label.setFont(CUSTOM_FONT);
        return label;
    }

    private static JTextField createStyledTextField() {
        JTextField field = new JTextField();
        field.setBackground(FIELD_BACKGROUND);
        field.setForeground(FIELD_FOREGROUND);
        field.setCaretColor(FOREGROUND_COLOR);
        field.setFont(CUSTOM_FONT);
        return field;
    }

    private static JPasswordField createStyledPasswordField() {
        JPasswordField field = new JPasswordField();
        field.setBackground(FIELD_BACKGROUND);
        field.setForeground(FIELD_FOREGROUND);
        field.setCaretColor(FOREGROUND_COLOR);
        field.setFont(CUSTOM_FONT);
        return field;
    }

    private static void showError(String message) {
        JOptionPane.showMessageDialog(null, message, "Input Error", JOptionPane.ERROR_MESSAGE);
    }

    private static void showInfo(String message) {
        JOptionPane.showMessageDialog(null, message, "Success", JOptionPane.INFORMATION_MESSAGE);
    }

    private static void showWarning(String message) {
        JOptionPane.showMessageDialog(null, message, "Cancelled", JOptionPane.WARNING_MESSAGE);
    }
}

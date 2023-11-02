/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.cohort;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;

/**
 *
 * @author taoltech
 */
public class UserController {
    
    Connection connection;

    public UserController(Connection connection) {
        this.connection = connection;
    }
    
    public void createTable() {   
        try {
            Statement statement = connection.createStatement();
            boolean isCreated = statement.execute("CREATE TABLE users ("
                    + "name VARCHAR(100),"
                    + "gender VARCHAR(16),"
                    + "email VARCHAR(100)"
                    + ")");
            
        } 
        catch (Exception e) {
            System.out.println("E: " + e.getMessage());
        }
    }
    
    public void createUser(String name, String gender, String email) {
        try {
            Statement statement = connection.createStatement();
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO users (name, gender, email) VALUES (?,?,?)");
            
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, gender);
            preparedStatement.setString(3, email);
            
            preparedStatement.execute();
            
//            
//            statement.execute("INSERT INTO users(name, gender, email) VALUES (" + name + ","
//                    + gender + ","
//                    + email + ")");
        } catch (Exception e) {
            System.out.println("E: " + e.getMessage());
        }
    }
}

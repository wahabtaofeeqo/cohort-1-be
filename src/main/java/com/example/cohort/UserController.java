/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.cohort;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author taoltech
 */
public class UserController {
    
    private Connection connection;

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
            String sql = "INSERT INTO users (name, gender, email) VALUES (?,?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, gender);
            preparedStatement.setString(3, email);
            
            preparedStatement.execute();
        } 
        catch (Exception e) {
            System.out.println("E: " + e.getMessage());
        }
    }
    
    
    public void loadUsers() {
        try {
            String sql = "SELECT * FROM users";
            Statement statement = connection.createStatement();
            
            List<String> list = new  ArrayList<>();
            ResultSet resultSet = statement.executeQuery(sql);
            
            while (resultSet.next()) {
                String name = resultSet.getString("name");
                list.add(name);
            }
            
            System.out.println("Names: " + Arrays.asList(list).toString());
        } 
        catch (Exception e) {
            System.out.println("E: " + e.getMessage());
        }
    }
}

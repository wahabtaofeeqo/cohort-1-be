/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.cohort;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author taoltech
 */
public class DBConnection {
    
    public static Connection connect() {
        try {
            String username = "root";
            String url = "jdbc:mysql://localhost:3306/test";
    
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            // System.out.println("Connected");
            return DriverManager.getConnection(url, username, "");
        } 
        catch (Exception e) {
            System.out.println("E: " + e.getMessage());
        }
        
        return null;
    }
}

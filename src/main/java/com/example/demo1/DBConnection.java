package com.example.demo1;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
    private static final String url="jdbc:mysql://localhost:3307/e_Social";
    private static  final String name="root";
    private static final String pwd="Samira12";

    public static Connection  geConnection()throws Exception{
        return DriverManager.getConnection(url,name,pwd);
    }
}

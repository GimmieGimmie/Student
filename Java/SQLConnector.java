package com.jdbclearning.util;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SQLConnector {

        public static Connection createConnection(){

            Connection con = null;
            final String DB_NAME = "hospital";
            final String Driver = "com.mysql.cj.jdbc.Driver";

            final String DB_URL = "jdbc:mysql://localhost:3306/hospital";
            final String DB_USERNAME = "root";
            final String DB_PASSWORD = "keptof303";

            try{

                Class.forName("com.mysql.cj.jdbc.Driver");
                con = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);

            }catch (ClassNotFoundException | SQLException e){
                e.printStackTrace();
            }

            return con;
        }
}

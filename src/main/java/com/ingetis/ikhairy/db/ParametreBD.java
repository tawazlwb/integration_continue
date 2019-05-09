package com.ingetis.ikhairy.db;

import java.sql.*;

public class ParametreBD {

    // Proprietes

    private static final String url = "jdbc:mysql://localhost/northwind";
    private static final String user = "root";
    private static final String pass = "";
    private static final String driver = "com.mysql.jdbc.Driver";
    // Construct

    // Getteurs
    public static String getUrl() {
        return url;
    }

    public static String getUser() {
        return user;
    }

    public static String getPass() {
        return pass;
    }

    public static String getDriver() {
        return driver;
    }

    public static ResultSet executerSelect(String query) throws SQLException {
        Connection cnx = null;
        ResultSet rs = null;
        Statement st = null;
        try {
            Class.forName(driver);
            cnx = DriverManager.getConnection(url, user, pass);
            st = cnx.createStatement();
            rs = st.executeQuery(query);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return rs;
    }
    
    public static int executerUpdate(String query) throws SQLException {
        Connection cnx = null;
        int rs = 0;
        Statement st = null;
        try {
            Class.forName(driver);
            cnx = DriverManager.getConnection(url, user, pass);
            st = cnx.createStatement();
            rs = st.executeUpdate(query);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return rs;
    }
    
    public static int executerInsert(String query) throws SQLException {
        Connection cnx = null;
        int rs = 0, id = 0;
        Statement st = null;
        try {
            Class.forName(driver);
            cnx = DriverManager.getConnection(url, user, pass);
            st = cnx.createStatement();
            rs = st.executeUpdate(query);
            
            if (rs == 0) {
                throw new SQLException("Creating user failed, no rows affected.");
            }

            try (ResultSet generatedKeys = st.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    id = generatedKeys.getInt(1);
                }
                else {
                    throw new SQLException("Creating user failed, no ID obtained.");
                }
            }
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return id;
    }

}

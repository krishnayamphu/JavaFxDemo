package com.example.javafxdemo.dao;

import com.example.javafxdemo.dbhelpers.ConnectDB;
import com.example.javafxdemo.Contact;

import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ContactDao {
    private static Connection con;

    public static ArrayList<Contact> getAllContacts() {
        ArrayList<Contact> contacts = new ArrayList<>();
        try {
            con = ConnectDB.connect();
            String sql = "SELECT * FROM contacts";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                contacts.add(new Contact(rs.getInt("id"), rs.getString("name"), rs.getString("mobile")));
            }
        } catch (SQLException ex) {
        } finally {
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return contacts;
    }

    public static void addContact(Contact contact) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/aptech", "root", "");
            String sql = "INSERT INTO contacts (name,mobile) VALUES(?,?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, contact.getName());
            ps.setString(2, contact.getMobile());
            ps.executeUpdate();
        } catch (ClassNotFoundException | SQLException ex) {
            System.err.println(ex);
            ;
        }
    }

    public static void deleteContact(int id) {
        try {
            con = ConnectDB.connect();
            String sql = "DELETE FROM contacts WHERE id=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.err.println(ex);
        }
    }

    public static void updateContact(Contact contact) {
        try {
            con = ConnectDB.connect();
            String sql = "UPDATE contacts SET name=?, mobile=? WHERE id=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, contact.getName());
            ps.setString(2, contact.getMobile());
            ps.setInt(3, contact.getId());
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.err.println(ex);
        }

    }
}


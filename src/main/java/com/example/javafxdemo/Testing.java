package com.example.javafxdemo;

import com.example.javafxdemo.dao.ContactDao;

import java.util.ArrayList;

public class Testing {
    public static void main(String[] args) {
        ArrayList<Contact> contacts=ContactDao.getAllContacts();
        for(Contact c:contacts){
            System.out.println(c.getName());
        }
    }
}

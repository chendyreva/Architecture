package com.company.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Client {
    public static void main(String[] args) throws SQLException {
        Connection conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/new_db?createDatabaseIfNotExist=true&character",
                "root", "root");
        UserRepository userRepository = new UserRepository(conn);

//        userRepository.insert(new User(4,"user4", "pass1"));
//        userRepository.insert(new User(5, "user5", "pass2"));
//        userRepository.insert(new User(6, "user6", "pass3"));

        System.out.println(userRepository.findByLogin("user1"));
        System.out.println(userRepository.findByLogin("user1"));
        System.out.println(userRepository.findByLogin("user1"));

        conn.setAutoCommit(false);
        userRepository.insert(new User(77,"user77","pass1"));
        conn.commit();
    }
}

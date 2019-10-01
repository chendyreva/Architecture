package com.company.repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserRepository {

    private final static User NULL_USER = new User(-1,"", "");

    private final Connection conn;

    private Map<Integer, User> userIdentifyMap = new HashMap<>();

    public UserRepository(Connection conn) throws SQLException {
        this.conn = conn;
        createTableIfNotExists(conn);
    }

    public void insert(User user) throws SQLException {
        try (PreparedStatement stmt = conn.prepareStatement(
                "insert into users(login, password) values (?, ?);",  Statement.RETURN_GENERATED_KEYS)) {
            stmt.setString(1, user.getLogin());
            stmt.setString(2, user.getPassword());
            stmt.execute();
            ResultSet rs = stmt.getGeneratedKeys();
            if(rs.next()) {
                int id = rs.getInt(1);
                User createdUser = findById(id);
                userIdentifyMap.put(id, createdUser);
            }
        }
    }


    public User findById(Integer id) throws SQLException {
        User user = userIdentifyMap.get(id);
        if(user != null) {
            return user;
        }
        try(PreparedStatement stmt = conn.prepareStatement(
                "select id, login, password from users where id = ?")) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                user = new User(rs.getInt(1), rs.getString(2), rs.getString(3));
                return user;
            }
        }
        return NULL_USER;
    }

    public User findByLogin(String login) throws SQLException {
        try (PreparedStatement stmt = conn.prepareStatement(
                "select id, login, password from users where login = ?")) {
            stmt.setString(1, login);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                User user = userIdentifyMap.get(rs.getInt(1));
                if(user != null) {
                    return user;
                }
            }
        }
        return NULL_USER;
    }

    public List<User> getAllUsers() throws SQLException {
        List<User> res = new ArrayList<>();
        try (Statement stmt = conn.createStatement()) {
            ResultSet rs = stmt.executeQuery("select id, login, password from users");

            while (rs.next()) {
                res.add(new User(rs.getInt(1), rs.getString(2), rs.getString(3)));
            }
        }
        return res;
    }

    private void createTableIfNotExists(Connection conn) throws SQLException {
        try (Statement stmt = conn.createStatement()) {
            stmt.execute("create table if not exists users (\n" +
                    "\tid int auto_increment primary key,\n" +
                    "    login varchar(25),\n" +
                    "    password varchar(25),\n" +
                    "    unique index uq_login(login)\n" +
                    ");");
        }
    }
}
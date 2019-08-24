package ru.geekbrains.server.auth;

import ru.geekbrains.server.User;

import java.util.HashMap;
import java.util.Map;

public class AuthServiceImpl implements AuthService {

    public Map<String, String> users = new HashMap<>();

    public AuthServiceImpl() {
        users.put("Ivan", "123");
        users.put("Petr", "345");
        users.put("Julia", "789");
    }

    @Override
    public boolean authUser(User user) {
        String pwd = users.get(user.getLogin());
        return pwd != null && pwd.equals(user.getPassword());
    }
}
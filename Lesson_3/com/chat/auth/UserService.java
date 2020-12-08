package com.chat.auth;

import com.chat.entity.User;
import com.chat.server.DataSource;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;

public class UserService implements Service<User>{
    @Override
    public Collection<User> findAll() {
        Connection connection = DataSource.getConnection();

        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM users");

            Collection<User> users = new ArrayList<>();
            while (resultSet.next()) {
                users.add(
                        new User(
                                resultSet.getInt("id"),
                                resultSet.getString("nickname")
//                                resultSet.getString("email"),
//                                resultSet.getString("password")
                        )
                );
            }
            return users;
        } catch (SQLException throwables) {
            throw new RuntimeException("SWW during User find all", throwables);
        }
    }

    @Override
    public int save(User user) {
                Connection connection = DataSource.getConnection();

        try {
            PreparedStatement statement = connection.prepareStatement(
                    "INSERT INTO users (nickname) VALUES (?)"
            );
            statement.setString(1, user.getNickname());
            return statement.executeUpdate();
        } catch (SQLException throwables) {
            throw new RuntimeException("SWW during User save", throwables);
        }
    }
}

    //    @Override
//    public static int save(T o) {
//        Connection connection = DataSource.getConnection();
//
//        try {
//            PreparedStatement statement = connection.prepareStatement(
//                    "INSERT INTO users (nickname) VALUES (?)"
//            );
//            statement.setString(1, user.getNickname());
//            return statement.executeUpdate();
//        } catch (SQLException throwables) {
//            throw new RuntimeException("SWW during User save", throwables);
//        }
//    }

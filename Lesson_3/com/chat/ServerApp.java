package com.chat;

import com.chat.server.ChatServer;
import com.chat.server.DataSource;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ServerApp {
    public static void main(String[] args) {
//        DataSource.getConnection();
        Connection connection = null;

        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/chat",
                    "root",
                    "");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        new ChatServer();

    }
}

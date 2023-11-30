package com.controller.bootweb.demo.shardtable;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ShardTableDemo {

    private static final String DB_URL = "jdbc:mysql://localhost:3306/main_db";
    private static final String USER = "username";
    private static final String PASSWORD = "password";

    public static void main(String[] args) {
        // 假设有一个用户ID为1001的用户需要插入
        long userId = 1001;

        // 计算分表偏移量
        int shardTableOffset = calculateShardTableOffset(userId);

        // 获取数据库连接
        try (Connection connection = DriverManager.getConnection(DB_URL, USER, PASSWORD)) {
            // 插入数据
            insertUserData(connection, userId, shardTableOffset);

            // 查询数据
            queryUserData(connection, userId, shardTableOffset);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static int calculateShardTableOffset(long userId) {
        // 假设分表的数量为3
        int numberOfShardTables = 3;
        return (int) (userId % numberOfShardTables);
    }

    private static void insertUserData(Connection connection, long userId, int shardTableOffset) throws SQLException {
        String tableName = "user_" + shardTableOffset; // 假设表名为 user_0, user_1, user_2

        String sql = "INSERT INTO " + tableName + " (user_id, username) VALUES (?, ?)";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setLong(1, userId);
            preparedStatement.setString(2, "user_" + userId);

            int affectedRows = preparedStatement.executeUpdate();
            System.out.println("Inserted " + affectedRows + " row(s) into " + tableName);
        }
    }

    private static void queryUserData(Connection connection, long userId, int shardTableOffset) throws SQLException {
        String tableName = "user_" + shardTableOffset;

        String sql = "SELECT * FROM " + tableName + " WHERE user_id = ?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setLong(1, userId);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    System.out.println("User ID: " + resultSet.getLong("user_id") +
                            ", Username: " + resultSet.getString("username"));
                }
            }
        }
    }
}

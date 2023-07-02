package com.student.jdbc;

import com.student.common.Common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectJdbc {
private static Connection connection;
public static Connection connection(){
    try {
        connection = DriverManager.getConnection(Common.MYSQL_URL,Common.MYSQL_USERNAME,Common.MYSQL_PASSWORD);
        return connection;
    } catch (SQLException e) {
        throw new RuntimeException(e);
    }
}
}

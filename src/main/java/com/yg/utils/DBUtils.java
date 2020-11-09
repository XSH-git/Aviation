package com.yg.utils;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class DBUtils {

    private static final Properties PROPERTIES = new Properties();
    private static final ThreadLocal<Connection> threadLocal = new ThreadLocal<>();
    //获取德鲁伊连接池
    private static DruidDataSource druidDataSource;


    static {                                                      // 代指src目录下文件
        InputStream is = DBUtils.class.getResourceAsStream("/db.properties");
        try {
            PROPERTIES.load(is);
            Class.forName(PROPERTIES.getProperty("driver"));

            //创建Druid连接池
            druidDataSource = (DruidDataSource) DruidDataSourceFactory.createDataSource(PROPERTIES);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // 获取数据源
    public static DataSource getDataSource() {
        return druidDataSource;
    }

    // 获取连接
    public static Connection getConnection() {
        Connection connection = threadLocal.get();
//        Connection connection = null;
        try {
            if (connection == null) {
                connection = DriverManager.getConnection(PROPERTIES.getProperty("url"), PROPERTIES.getProperty("username"), PROPERTIES.getProperty("password"));
                threadLocal.set(connection);
            }
            //connection = DriverManager.getConnection(PROPERTIES.getProperty("url"), PROPERTIES.getProperty("username"), PROPERTIES.getProperty("password"));
        } catch (Exception e) {
            e.printStackTrace();
        }

        return connection;
    }

    //开启事务
    public static void begin() {
        try {
            Connection connection = getConnection();
            connection.setAutoCommit(false);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //提交事务
    public static void commit() {
        Connection connection = null;
        try {
            connection = getConnection();
            connection.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeAll(connection, null, null);
        }
    }

    //回滚
    public static void rollBack() {
        Connection connection = null;
        try {
            connection = getConnection();
            connection.rollback();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeAll(connection, null, null);
        }
    }

    // 释放资源
    public static void closeAll(Connection conn, Statement sm, ResultSet resultSet) {
        try {
            if (resultSet != null) {
                resultSet.close();
            }
            if (sm != null) {
                sm.close();
            }
            if (conn != null) {
                conn.close();
                threadLocal.remove();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

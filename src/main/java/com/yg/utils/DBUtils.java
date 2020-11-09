package com.yg.utils;

import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

/**
 * 工具类
 * @author XSH
 *
 */
public class DBUtils {



    private static final Properties PROPERTIES = new Properties();
    private static final ThreadLocal<Connection> threadlocal = new ThreadLocal<Connection>();

    static {
        try {
            //1.加载驱动
            //第一次调用进行加载，之后只进行检查操作
            InputStream is = DBUtils.class.getClassLoader().getResourceAsStream("jdbc.properties");//复用类加载流
            PROPERTIES.load(is);
            Class.forName(PROPERTIES.getProperty("driver"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() {
        Connection connection = threadlocal.get();
        try {
            //2.连接mysql
            if (connection == null) {
                String url = PROPERTIES.getProperty("url");
                String user = PROPERTIES.getProperty("username");
                String password = PROPERTIES.getProperty("password");
                connection = DriverManager.getConnection(url, user, password);
                threadlocal.set(connection);
                System.out.println("connection重新装填");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        System.out.println("此时的connection" + connection);
        return connection;
    }

    //开启事务
    public static void begin() {
        try {
            Connection connection = getConnection();
            connection.setAutoCommit(false);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

    //提交事务
    public static void commit() {
        Connection connection = getConnection();
        try {
            connection.commit();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            closeAll(connection,null,null);
        }

    }

    //回滚
    public static void rollback() {
        Connection connection = getConnection();
        try {
            connection.rollback();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            closeAll(connection,null,null);
        }

    }

    public static void closeAll(Connection connection, Statement statement, ResultSet resultSet) {
        try {
            if (connection != null) {
                connection.close();
                System.out.println("connection关闭");
            }
            if (statement != null) {
                statement.close();
                System.out.println("statement关闭");
            }
            if (resultSet != null) {
                resultSet.close();
                threadlocal.remove();
                System.out.println("connection关闭" + threadlocal.get());
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

}


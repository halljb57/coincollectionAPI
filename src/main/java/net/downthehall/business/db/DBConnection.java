package net.downthehall.business.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by joseph on 4/27/2014.
 */
public class DBConnection
{
    // ******************************************************** Setup Singleton
    private static DBConnection ourInstance = new DBConnection();
    private static Connection conn;
    // **********************************************************************************
    /*private static String url = "jdbc:mysql://127.0.0.1:33060/homestead";
    private static String user = "homestead";//Username of database
    private static String pass = "secret";//Password of database*/
    // **********************************************************************************
    private static String url = "jdbc:mysql://192.168.11.10:3306/coincollection?autoReconnect=true&useSSL=false";
    private static String user = "halljb57";//Username of database
    private static String pass = "jH14490196";//Password of database

    public DBConnection()
    {
        ourInstance = this;
    }

    public static DBConnection getInstance()
    {
        return ourInstance;
    }

    public static Connection connect() throws SQLException
    {
        try
        {
//            Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
            Class.forName("com.mysql.jdbc.Driver").newInstance();
//            System.out.println("DATABASE OPEN");
        } catch (ClassNotFoundException cnfe)
        {
            System.err.println("Error: " + cnfe.getMessage());
        } catch (InstantiationException ie)
        {
            System.err.println("Error: " + ie.getMessage());
        } catch (IllegalAccessException iae)
        {
            System.err.println("Error: " + iae.getMessage());
        }
        conn = DriverManager.getConnection(url, user, pass);
        return conn;
    }

    public static Connection getConnection() throws SQLException, ClassNotFoundException
    {
        if (conn != null && !conn.isClosed())
        {
            return conn;
        }
        connect();
        return conn;
    }

    public static void close(Connection connection)
    {
        try
        {
            if (connection != null)
            {
                connection.close();
            }
        } catch (SQLException e)
        {
            e.printStackTrace();
        }
    }
}

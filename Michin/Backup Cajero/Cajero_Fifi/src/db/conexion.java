package db;

import java.io.FileInputStream;
import java.sql.*;
import java.util.Properties;


public class conexion
{
    private static db.conexion conexion = null;

    private Connection con;

    private conexion()
    {
        Properties conProperties = new Properties();

        try
        {
            conProperties.load(new FileInputStream("data/conexion.properties"));

            String url = conProperties.getProperty("url");
            String user = conProperties.getProperty("user");
            String password = conProperties.getProperty("password");

            con = DriverManager.getConnection(url, user, password);

            System.out.println("Entre a Conexion y estoy Conectado A: " + url +"\n");

        }
        catch (Exception e)

        {
            e.printStackTrace();
        }
    }

    public static db.conexion getInstance()
    {
        if(conexion == null)
        {
            conexion = new conexion();
        }

        return conexion;
    }

    public ResultSet executeQuery(String sql)
    {
        Statement st = null;
        ResultSet rs = null;
        try
        {
            st = con.createStatement();
            rs = st.executeQuery(sql);
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        return rs;
    }

    public int executeUpdate(String sql)
    {
        int res = 0;
        Statement st = null;

        try
        {
            st = con.createStatement();
            res = st.executeUpdate(sql);
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }

        return res;
    }

}

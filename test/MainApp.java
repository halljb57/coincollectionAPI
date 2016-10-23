import net.downthehall.business.db.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MainApp
{
    private Connection conn;
    private Statement stmt;
    private ResultSet rs;
    private PreparedStatement ps;

    public MainApp()
    {
        findNameById(2);
        findById(4);
        myTest();
    }

    public String findNameById(int colId)
    {
        String newID;
        try
        {
            conn = DBConnection.connect();
            ps = conn.prepareStatement("SELECT * FROM collection_names WHERE collection_id = ?");
            ps.setInt(1, colId);
            rs = ps.executeQuery();

            rs.next();
            newID = rs.getString("collection_name");
//            System.out.println("collection_Name: " + rs.getString("collection_name"));
            //System.out.println("collection_Names " + rs.getString("collection_Name"));
//            CoinAttributesModel.getInstance().setCollectionId(String.valueOf(rs.getInt("collection_Id")));
        } catch (SQLException e)
        {
            e.printStackTrace();
            throw new RuntimeException(e);
        } finally
        {
            DBConnection.close(conn);
        }

        System.out.println("findNameById collection Name is : " + newID);
        return newID;
    }

    // *********************************************************************************************************
    public String findById(int colId)
    {
        List<String> collectionList = new ArrayList();

        try
        {
            conn = DBConnection.connect();
            ps = conn.prepareStatement("SELECT * FROM collection_names WHERE collection_id = ?");
            ps.setInt(1, colId);
            rs = ps.executeQuery();
            while (rs.next())
            {
                collectionList.add(rs.getString("collection_id"));
                collectionList.add(rs.getString("collection_name"));
                collectionList.add(rs.getString("country_id"));
                collectionList.add(rs.getString("comments"));
            }

        } catch (SQLException e)
        {
            e.printStackTrace();
            throw new RuntimeException(e);
        } finally
        {
            DBConnection.close(conn);
        }

        System.out.println("findById selected collection is : " + collectionList);
        return String.valueOf(collectionList);
    }

    private List<String> myTest()
    {

        List<String> collectionList = new ArrayList();
        try
        {
            conn = DBConnection.connect();
            stmt = conn.createStatement();
            rs = stmt.executeQuery("SELECT collection_Name FROM collection_names");
            while (rs.next())
            {
                collectionList.add(rs.getString("collection_Name"));
            }
        } catch (SQLException e)
        {
            e.printStackTrace();
            throw new RuntimeException(e);
        } finally
        {
            DBConnection.close(conn);
        }

        System.out.println("List by name: " + collectionList);
        return collectionList;
    }

    public static void main(String[] args)
    {
        new MainApp();
    }
}
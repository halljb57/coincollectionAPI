import net.downthehall.business.db.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;
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
        findById(2);
//        findCoinsById(11);
//        UpDateTableId(13);
        deleteTable_Id();
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

    // ************************************************************************ Collection Name
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

    // ************************************************************************ Coins
    public Object[] findCoinsById(int colId)
    {
        Collection<String> coinsList = new ArrayList();

        try
        {
            conn = DBConnection.connect();
            ps = conn.prepareStatement("SELECT * FROM coins WHERE denomination_series_id = ?");
            ps.setInt(1, colId);
            rs = ps.executeQuery();
            while (rs.next())
            {
                        coinsList.add(rs.getString("coin_id"));
                        coinsList.add(rs.getString("mint_year"));
                        coinsList.add(rs.getString("mintage_for_circulation"));
                        coinsList.add(rs.getString("mintage_of_proofs"));
                        coinsList.add(rs.getString("denomination_series_id"));
                        coinsList.add(rs.getString("mint_mark"));
                        coinsList.add(rs.getString("designer"));
                        coinsList.add(rs.getString("diameter"));
                        coinsList.add(rs.getString("metal_content"));
                        coinsList.add(rs.getString("weight"));
                        coinsList.add(rs.getString("edge"));
                        coinsList.add(rs.getString("notes"));
            }

        } catch (SQLException e)
        {
            e.printStackTrace();
            throw new RuntimeException(e);
        } finally
        {
            DBConnection.close(conn);
        }

        System.out.println("findById selected coins is : " + coinsList);
//        System.out.println("findById selected coins is : " + Arrays.toString(coinsList.toArray()));
        return coinsList.toArray();
    }

    // ************************************************************************
    // ************************************ DELETE TABLE_ID FROM SHOW_TABLE
    public void deleteTable_Id()
    {
        try
        {

            conn = DBConnection.connect();
            ps = conn.prepareStatement("DELETE FROM show_coins WHERE denomination_series_id > 0;");
            int count = ps.executeUpdate();

        } catch (SQLException e)
        {
            e.printStackTrace();
            throw new RuntimeException(e);
        } finally
        {
            DBConnection.close(conn);
            int colId = 14;
            UpDateTableId(colId);
        }
    }

    // ******* COPY TABLE_ID FROM MAIN TABLE AND PASTE IT IN SHOW_TABLE
    private void UpDateTableId(int colId)
    {
        try
        {
            conn = DBConnection.connect();
            ps = conn.prepareStatement(
                    "INSERT INTO show_coins SELECT * FROM coins WHERE denomination_series_id = ?");
            ps.setInt(1, colId);
            ps.executeUpdate();
        } catch (SQLException e)
        {
            e.printStackTrace();
            throw new RuntimeException(e);
        } finally
        {
            DBConnection.close(conn);
        }
    }
    // ************************************************************************

    public static void main(String[] args)
    {
        new MainApp();
    }
}
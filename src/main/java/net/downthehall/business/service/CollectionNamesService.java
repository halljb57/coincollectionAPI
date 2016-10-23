package net.downthehall.business.service;

import net.downthehall.business.db.DBConnection;
import net.downthehall.business.interfaces.ICollectionNamesService;
import net.downthehall.business.model.vo.CollectionNames;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: joseph
 * Date: 11/14/13
 * Time: 7:24 PM
 * To change this template use File | Settings | File Templates.
 */
public class CollectionNamesService implements ICollectionNamesService
{
    private Connection conn;
    private Statement stmt;
    private ResultSet rs;
    private PreparedStatement ps;

    private String collectionName;

    // ******************************************************************************************
    public List<CollectionNames> findAll()
    {
        List<CollectionNames> collectionNamesList = new ArrayList();
        try
        {
            conn = DBConnection.connect();
            stmt = conn.createStatement();
            rs = stmt.executeQuery("SELECT * FROM collection_names");
            while (rs.next())
            {
                collectionNamesList.add(processRow(rs));
            }
        } catch (SQLException e)
        {
            e.printStackTrace();
//            throw new RuntimeException(e);
        } finally
        {
            DBConnection.close(conn);
        }
        return collectionNamesList;
    }

    // ******************************************************************************************
    public String findIdByName()
    {
        int newID;
        try
        {
            conn = DBConnection.connect();
            ps = conn.prepareStatement("SELECT * FROM collection_names WHERE collection_name = ?");
            ps.setString(1, getCollectionName());
            rs = ps.executeQuery();
            rs.next();
            newID = rs.getInt("collection_id");
            System.out.println("collection_ID " + rs.getInt("collection_id"));
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
        return String.valueOf(newID);
    }

    // ******************************************************************************************
    public List<String> findById(int id)
    {
        String newID;
        List<String> collectionList = new ArrayList();

        try
        {
            conn = DBConnection.connect();
            ps = conn.prepareStatement("SELECT * FROM collection_names WHERE collection_id = ?");
            ps.setInt(1, id);
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

        System.out.println("collection Name is : " + collectionList);
        return collectionList;
    }

    // ******************************************************************************************

    /**
     * Get a list of condition objects
     *
     * @return countryList
     */
    public List<String> findCollection()
    {
        List<String> collectionList = new ArrayList();
        try
        {
            conn = DBConnection.connect();
            stmt = conn.createStatement();
            rs = stmt.executeQuery("SELECT collection_name FROM collection_names");
            while (rs.next())
            {
                collectionList.add(rs.getString("collection_name"));
            }
        } catch (SQLException e)
        {
            e.printStackTrace();
            throw new RuntimeException(e);
        } finally
        {
            DBConnection.close(conn);
        }
        return collectionList;
    }

    // ******************************************************************************************
    public CollectionNames create(CollectionNames collectionNames)
    {
        try
        {
            conn = DBConnection.connect();
            ps = conn.prepareStatement(
                    "INSERT INTO collection_names (" +
                    "collection_name, country_id, comments " +
                    "VALUES (?, ?, ?, ?)",
                    new String[]{"ID"});
            ps.setString(1, collectionNames.getCollection_name());
            ps.setInt(2, collectionNames.getCountry_id());
            ps.setString(3, collectionNames.getComments());

            ps.executeUpdate();
            rs = ps.getGeneratedKeys();
            rs.next();
            // Update the id in the returned object. This is important as this value must be returned to the client.
            int id = rs.getInt(1);
            collectionNames.setCollection_id(id);
        } catch (Exception e)
        {
            e.printStackTrace();
            throw new RuntimeException(e);
        } finally
        {
            DBConnection.close(conn);
            System.out.println("Saving now");
        }
        return collectionNames;
    }

    // ******************************************************************************************
    public CollectionNames update(CollectionNames collectionNames)
    {
        try
        {
            conn = DBConnection.connect();
            ps = conn.prepareStatement(
                    "UPDATE collection_names SET collection_name=?, country_id=?, comments=?" +
                    "WHERE collection_id=?");
            ps.setString(1, collectionNames.getCollection_name());
            ps.setInt(2, collectionNames.getCountry_id());
            ps.setString(3, collectionNames.getComments());

            ps.setInt(4, collectionNames.getCollection_id());
            ps.executeUpdate();
        } catch (SQLException e)
        {
            e.printStackTrace();
            throw new RuntimeException(e);
        } finally
        {
            DBConnection.close(conn);
        }
        return collectionNames;
    }

    // ******************************************************************************************
    public boolean remove(int id)
    {
        try
        {
            conn = DBConnection.connect();
            ps = conn.prepareStatement("DELETE FROM collection_names WHERE collection_id=?");
            ps.setInt(1, id);
            int count = ps.executeUpdate();
            return count == 1;
        } catch (Exception e)
        {
            e.printStackTrace();
            throw new RuntimeException(e);
        } finally
        {
            DBConnection.close(conn);
        }
    }

    // ******************************************************************************************
    protected CollectionNames processRow(ResultSet rs) throws SQLException
    {
        CollectionNames collectionNames = new CollectionNames();
        collectionNames.setCollection_id(rs.getInt("collection_id"));
        collectionNames.setCollection_name(rs.getString("collection_name"));
        collectionNames.setCountry_id(rs.getInt("country_id"));
        collectionNames.setComments(rs.getString("comments"));
        return collectionNames;
    }

    public String getCollectionName()
    {
        return collectionName;
    }

    public void setCollectionName(String collectionName)
    {
        this.collectionName = collectionName;
    }
}

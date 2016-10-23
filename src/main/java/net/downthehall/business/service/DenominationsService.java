package net.downthehall.business.service;

import net.downthehall.business.db.DBConnection;
import net.downthehall.business.interfaces.IDenominationsService;
import net.downthehall.business.model.vo.Denominations;

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
public class DenominationsService implements IDenominationsService
{
    private Connection conn;
    private Statement stmt;
    private ResultSet rs;
    private PreparedStatement ps;

    // ******************************************************************************************
    public List<Denominations> findAll()
    {
        List<Denominations> denominationsList = new ArrayList();
        try
        {
            conn = DBConnection.connect();
            stmt = conn.createStatement();
            rs = stmt.executeQuery("SELECT * FROM denominations");
            while (rs.next())
            {
                denominationsList.add(processRow(rs));
            }
        } catch (SQLException e)
        {
            e.printStackTrace();
            throw new RuntimeException(e);
        } finally
        {
            DBConnection.close(conn);
        }
        return denominationsList;
    }

    // ******************************************************************************************

    @Override
    public List<String> findById(int id)
    {
        return null;
    }

    // ******************************************************************************************
    public List<String> findByName()
    {
        List<String> denominationsList = new ArrayList();
        try
        {
            conn = DBConnection.connect();
            stmt = conn.createStatement();
            rs = stmt.executeQuery("SELECT * FROM denominations");
            while (rs.next())
            {
                denominationsList.add(rs.getString("country"));
                System.out.println("Name ID is " + rs.getInt("country_id"));
            }
        } catch (SQLException e)
        {
            e.printStackTrace();
            throw new RuntimeException(e);
        } finally
        {
            DBConnection.close(conn);
        }
        return denominationsList;
    }

    // ******************************************************************************************
    public Denominations create(Denominations denominations)
    {
        try
        {
            conn = DBConnection.connect();
            ps = conn.prepareStatement("INSERT INTO denominations (denomination, country_id) VALUES (?, ?)",
                                       new String[]{"ID"});
            ps.setString(1, denominations.getDenomination());
            ps.setInt(2, denominations.getCountry_id());

            ps.executeUpdate();
            rs = ps.getGeneratedKeys();
            rs.next();
            // Update the id in the returned object. This is important as this value must be returned to the client.
            int id = rs.getInt(1);
            denominations.setDenominations_id(id);
        } catch (Exception e)
        {
            e.printStackTrace();
            throw new RuntimeException(e);
        } finally
        {
            DBConnection.close(conn);
        }
        return denominations;
    }

    // ******************************************************************************************
    public Denominations update(Denominations denominations)
    {
        try
        {
            conn = DBConnection.connect();
            ps = conn.prepareStatement("UPDATE denominations SET denomination=?, country_id=? WHERE denomination=?");
            ps.setString(1, denominations.getDenomination());
            ps.setInt(2, denominations.getCountry_id());

            ps.setInt(3, denominations.getDenominations_id());
            ps.executeUpdate();
        } catch (SQLException e)
        {
            e.printStackTrace();
            throw new RuntimeException(e);
        } finally
        {
            DBConnection.close(conn);
        }
        return denominations;
    }

    // ******************************************************************************************
    public boolean remove(int id)
    {
        /*try
        {
            conn = DBConnection.connect();
            ps = conn.prepareStatement("DELETE FROM denominations WHERE denomination=?");
            ps.setInt(1, denominations.getDenominations_id());
            int count = ps.executeUpdate();
            return count == 1;
        } catch (Exception e)
        {
            e.printStackTrace();
            throw new RuntimeException(e);
        } finally
        {
            DBConnection.close(conn);
        }*/
        return false;
    }

    // ******************************************************************************************
    protected Denominations processRow(ResultSet rs) throws SQLException
    {
        Denominations denominations = new Denominations();
        denominations.setDenominations_id(rs.getInt("denominations_id"));
        denominations.setDenomination(rs.getString("denomination"));
        denominations.setCountry_id(rs.getInt("country_id"));
        return denominations;
    }
}

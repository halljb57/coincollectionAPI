package net.downthehall.business.service;

import net.downthehall.business.db.DBConnection;
import net.downthehall.business.interfaces.IDenominationsSeriesService;
import net.downthehall.business.model.vo.DenominationSeries;

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
public class DenominationsSeriesService implements IDenominationsSeriesService
{
    private Connection conn;
    private Statement stmt;
    private ResultSet rs;
    private PreparedStatement ps;
    private int denominationSeries_id;

    // ******************************************************************************************
    public List<DenominationSeries> findAll()
    {
        List<DenominationSeries> denominationSeriesList = new ArrayList();
        try
        {
            conn = DBConnection.connect();
            stmt = conn.createStatement();
            rs = stmt.executeQuery("SELECT * FROM denominations_series");
            while (rs.next())
            {
                denominationSeriesList.add(processRow(rs));
            }
        } catch (SQLException e)
        {
            e.printStackTrace();
            throw new RuntimeException(e);
        } finally
        {
            DBConnection.close(conn);
        }
        return denominationSeriesList;
    }

    // ******************************************************************************************

    @Override
    public List<String> findById(int id)
    {
        return null;
    }

    // ******************************************************************************************
    public void findNameById()
    {
        try
        {
            conn = DBConnection.connect();
            ps = conn.prepareStatement("SELECT * FROM denominations_series WHERE denomination_series_id = ?");
            ps.setInt(1, getDenominationSeries_id());
            rs = ps.executeQuery();
            //System.out.println("\n" + "From DenominationsSeriesService Denomination_series_id " + rs.getInt("denomination_series_id"));
//            CoinAttributes.setDenominationSeries(rs.getString("denomination_series"));
        } catch (SQLException e)
        {
            e.printStackTrace();
            throw new RuntimeException(e);
        } finally
        {
            DBConnection.close(conn);
        }
    }

    // ******************************************************************************************
    public List<String> findByName()
    {
        List<String> denominationSeriesList = new ArrayList();
        try
        {
            conn = DBConnection.connect();
            stmt = conn.createStatement();
            rs = stmt.executeQuery("SELECT * FROM denominations_series");
            while (rs.next())
            {
                denominationSeriesList.add(rs.getString("country"));
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
        return denominationSeriesList;
    }

    // ******************************************************************************************
    public DenominationSeries create(DenominationSeries denominationSeries)
    {
        try
        {
            conn = DBConnection.connect();
            ps = conn.prepareStatement(
                    "INSERT INTO denominations_series (denomination_series, denominations_id) VALUES (?, ?)",
                    new String[]{"ID"});
            ps.setString(1, denominationSeries.getDenomination_series());
            ps.setInt(2, denominationSeries.getDenominations_id());

            ps.executeUpdate();
            rs = ps.getGeneratedKeys();
            rs.next();
            // Update the id in the returned object. This is important as this value must be returned to the client.
            int id = rs.getInt(1);
            denominationSeries.setDenomination_series_id(id);
        } catch (Exception e)
        {
            e.printStackTrace();
            throw new RuntimeException(e);
        } finally
        {
            DBConnection.close(conn);
        }
        return denominationSeries;
    }

    // ******************************************************************************************
    public DenominationSeries update(DenominationSeries denominationSeries)
    {
        try
        {
            conn = DBConnection.connect();
            ps = conn.prepareStatement(
                    "UPDATE denominations_series SET denomination_series=?, denominations_id=? WHERE denomination_series_id=?");
            ps.setString(1, denominationSeries.getDenomination_series());
            ps.setInt(2, denominationSeries.getDenominations_id());

            ps.setInt(3, denominationSeries.getDenomination_series_id());
            ps.executeUpdate();
        } catch (SQLException e)
        {
            e.printStackTrace();
            throw new RuntimeException(e);
        } finally
        {
            DBConnection.close(conn);
        }
        return denominationSeries;
    }

    // ******************************************************************************************
    public boolean remove(int id)
    {
        /*try
        {
            conn = DBConnection.connect();
            ps = conn.prepareStatement("DELETE FROM denomination_series WHERE denomination_series_id=?");
            ps.setInt(1, denominationSeries.getDenomination_series_id());
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
    protected DenominationSeries processRow(ResultSet rs) throws SQLException
    {
        DenominationSeries denominationSeries = new DenominationSeries();
        denominationSeries.setDenomination_series_id(rs.getInt("denomination_series_id"));
        denominationSeries.setDenomination_series(rs.getString("denomination_series"));
        denominationSeries.setDenominations_id(rs.getInt("denominations_id"));
        return denominationSeries;
    }

    // ******************************************************************************************

    public int getDenominationSeries_id()
    {
        return denominationSeries_id;
    }

    public void setDenominationSeries_id(int denominationSeries_id)
    {
        this.denominationSeries_id = denominationSeries_id;
    }
}

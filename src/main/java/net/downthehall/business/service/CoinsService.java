package net.downthehall.business.service;

import net.downthehall.business.db.DBConnection;
import net.downthehall.business.interfaces.ICoinsService;
import net.downthehall.business.model.vo.Coins;

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
public class CoinsService implements ICoinsService
{
    private Connection conn;
    private Statement stmt;
    private ResultSet rs;
    private PreparedStatement ps;

    // ******************************************************************************************
    public List<Coins> findAll()
    {
        List<Coins> coinsList = new ArrayList();
        try
        {
            conn = DBConnection.connect();
            stmt = conn.createStatement();
            rs = stmt.executeQuery("SELECT * FROM coins");
            while (rs.next())
            {
                coinsList.add(processRow(rs));
            }
        } catch (SQLException e)
        {
            e.printStackTrace();
            throw new RuntimeException(e);
        } finally
        {
            DBConnection.close(conn);
        }
        return coinsList;
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
        List<String> coinsList = new ArrayList();
        try
        {
            conn = DBConnection.connect();
            stmt = conn.createStatement();
            rs = stmt.executeQuery("SELECT * FROM coins");
            while (rs.next())
            {
                coinsList.add(rs.getString("country"));
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
        return coinsList;
    }

    // ******************************************************************************************
    public Coins create(Coins coins)
    {
        try
        {
            conn = DBConnection.connect();
            ps = conn.prepareStatement(
                    "INSERT INTO coins (" +
                    "mint_year, mintage_for_circulation, mintage_of_proofs," +
                    "denomination_series_id, mint_mark, designer, " +
                    "diameter, metal_content, weight, edge, notes) " +
                    "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)",
                    new String[]{"ID"});
            ps.setString(1, coins.getMint_year());
            ps.setInt(2, coins.getMintage_for_circulation());
            ps.setInt(3, coins.getMintage_of_proofs());
            ps.setInt(4, coins.getDenomination_series_id());
            ps.setString(5, coins.getMint_mark());
            ps.setString(6, coins.getDesigner());
            ps.setString(7, coins.getDiameter());
            ps.setString(8, coins.getMetal_content());
            ps.setString(9, coins.getWeight());
            ps.setString(10, coins.getEdge());
            ps.setString(11, coins.getNotes());

            ps.executeUpdate();
            rs = ps.getGeneratedKeys();
            rs.next();
            // Update the id in the returned object. This is important as this value must be returned to the client.
            int id = rs.getInt(1);
            coins.setCoin_id(id);
        } catch (Exception e)
        {
            e.printStackTrace();
            throw new RuntimeException(e);
        } finally
        {
            DBConnection.close(conn);
        }
        return coins;
    }

    // ******************************************************************************************
    public Coins update(Coins coins)
    {
        try
        {
            conn = DBConnection.connect();
            ps = conn.prepareStatement(
                    "UPDATE coins SET mint_year=?, mintage_for_circulation=?, mintage_of_proofs=?, " +
                    "denomination_series_id=?, mint_mark=?, designer=?, " +
                    "diameter=?, metal_content=?, weight=?, edge=?, notes=?" +
                    "WHERE coin_id=?");
            ps.setString(1, coins.getMint_year());
            ps.setInt(2, coins.getMintage_for_circulation());
            ps.setInt(3, coins.getMintage_of_proofs());
            ps.setInt(4, coins.getDenomination_series_id());
            ps.setString(5, coins.getMint_mark());
            ps.setString(6, coins.getDesigner());
            ps.setString(7, coins.getDiameter());
            ps.setString(8, coins.getMetal_content());
            ps.setString(8, coins.getWeight());
            ps.setString(10, coins.getEdge());
            ps.setString(11, coins.getNotes());

            ps.setInt(12, coins.getCoin_id());
            ps.executeUpdate();
        } catch (SQLException e)
        {
            e.printStackTrace();
            throw new RuntimeException(e);
        } finally
        {
            DBConnection.close(conn);
        }
        return coins;
    }

    // ******************************************************************************************
    public boolean remove(int id)
    {
        /*try
        {
            conn = DBConnection.connect();
            ps = conn.prepareStatement("DELETE FROM coins WHERE coin_id=?");
            ps.setInt(1, coins.getCoin_id());
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
    protected Coins processRow(ResultSet rs) throws SQLException
    {
        Coins coins = new Coins();
        coins.setCoin_id(rs.getInt("coin_id"));
        coins.setMint_year(rs.getString("mint_year"));
        coins.setMintage_for_circulation(rs.getInt("mintage_for_circulation"));
        coins.setMintage_of_proofs(rs.getInt("mintage_of_proofs"));
        coins.setDenomination_series_id(rs.getInt("denomination_series_id"));
        coins.setMint_mark(rs.getString("mint_mark"));
        coins.setDesigner(rs.getString("designer"));
        coins.setDiameter(rs.getString("diameter"));
        coins.setMetal_content(rs.getString("metal_content"));
        coins.setWeight(rs.getString("weight"));
        coins.setEdge(rs.getString("edge"));
        coins.setNotes(rs.getString("notes"));
        return coins;
    }
}

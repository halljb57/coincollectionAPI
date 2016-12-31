package net.downthehall.business.service;

import net.downthehall.business.db.DBConnection;
import net.downthehall.business.interfaces.IShowCoinsService;
import net.downthehall.business.model.vo.ShowCoins;

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
public class ShowCoinsService implements IShowCoinsService
{
    private Connection conn;
    private Statement stmt;
    private ResultSet rs;
    private PreparedStatement ps;

    // ************************************************************************ Fine All
    public List<ShowCoins> findAll()
    {
        List<ShowCoins> coinsList = new ArrayList();
        try
        {
            conn = DBConnection.connect();
            stmt = conn.createStatement();
            rs = stmt.executeQuery("SELECT * FROM show_coins");
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

    // ************************************************************************ Find By Name
    public List<String> findByName()
    {
        List<String> coinsList = new ArrayList();
        try
        {
            conn = DBConnection.connect();
            stmt = conn.createStatement();
            rs = stmt.executeQuery("SELECT * FROM show_coins");
            while (rs.next())
            {
                coinsList.add(rs.getString("country"));
                System.out.println("Name ID is " + rs.getInt("country_Id"));
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

    // ************************************************************************ Find Coins List By Id
    // ************************************ DELETE TABLE_ID FROM SHOW_TABLE
    public void findCoinsListById(int id)
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
            UpDateInTableId(id);
        }
    }
    // ******* COPY TABLE_ID FROM MAIN TABLE AND PASTE IT IN SHOW_TABLE
    public void UpDateInTableId(int colId)
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

    // ************************************************************************ Create
    public ShowCoins create(ShowCoins showCoins)
    {
        try
        {
            conn = DBConnection.connect();
            ps = conn.prepareStatement(
                    "INSERT INTO showCoins (" +
                    "mint_Year, detail, mintage_For_Circulation, mintage_Of_Proofs, " +
                    "denomination_Series_Id, mint_Mark, designer, " +
                    "diameter, metal_Content, weight, edge, notes) " +
                    "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)",
                    new String[]{"ID"});
            ps.setString(1, showCoins.getMint_Year());
            ps.setString(2, showCoins.getDetail());
            ps.setString(3, showCoins.getMintage_For_Circulation());
            ps.setString(4, showCoins.getMintage_Of_Proofs());
            ps.setInt(5, showCoins.getDenomination_Series_Id());
            ps.setString(6, showCoins.getMint_Mark());
            ps.setString(7, showCoins.getDesigner());
            ps.setString(8, showCoins.getDiameter());
            ps.setString(9, showCoins.getMetal_Content());
            ps.setString(10, showCoins.getWeight());
            ps.setString(11, showCoins.getEdge());
            ps.setString(12, showCoins.getNotes());

            ps.executeUpdate();
            rs = ps.getGeneratedKeys();
            rs.next();
            // Update the id in the returned object. This is important as this value must be returned to the client.
            int id = rs.getInt(1);
            showCoins.setCoin_Id(id);
        } catch (Exception e)
        {
            e.printStackTrace();
            throw new RuntimeException(e);
        } finally
        {
            DBConnection.close(conn);
        }
        return showCoins;
    }

    // ******************************************************************************************
    public ShowCoins update(ShowCoins showCoins)
    {
        try
        {
            conn = DBConnection.connect();
            ps = conn.prepareStatement(
                    "UPDATE showCoins SET mint_Year=?, detail=?, mintage_For_Circulation=?, mintage_Of_Proofs=?, " +
                    "denomination_Series_Id=?, mint_Mark=?, designer=?, " +
                    "diameter=?, metal_Content=?, weight=?, edge=?, notes=?" +
                    "WHERE coin_Id=?");
            ps.setString(1, showCoins.getMint_Year());
            ps.setString(2, showCoins.getDetail());
            ps.setString(3, showCoins.getMintage_For_Circulation());
            ps.setString(4, showCoins.getMintage_Of_Proofs());
            ps.setInt(5, showCoins.getDenomination_Series_Id());
            ps.setString(6, showCoins.getMint_Mark());
            ps.setString(7, showCoins.getDesigner());
            ps.setString(8, showCoins.getDiameter());
            ps.setString(9, showCoins.getMetal_Content());
            ps.setString(10, showCoins.getWeight());
            ps.setString(11, showCoins.getEdge());
            ps.setString(12, showCoins.getNotes());

            ps.setInt(13, showCoins.getCoin_Id());
            ps.executeUpdate();
        } catch (SQLException e)
        {
            e.printStackTrace();
            throw new RuntimeException(e);
        } finally
        {
            DBConnection.close(conn);
        }
        return showCoins;
    }

    // ******************************************************************************************
    public void remove(int id)
    {
        try
        {
            conn = DBConnection.connect();
            ps = conn.prepareStatement("DELETE FROM show_coins WHERE coin_Id=?");
            ps.setInt(1, id);
            int count = ps.executeUpdate();
//            return count == 1;
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
    protected ShowCoins processRow(ResultSet rs) throws SQLException
    {
        ShowCoins showCoins = new ShowCoins();
        showCoins.setCoin_Id(rs.getInt("coin_Id"));
        showCoins.setMint_Year(rs.getString("mint_Year"));
        showCoins.setDetail(rs.getString("detail"));
        showCoins.setMintage_For_Circulation(rs.getString("mintage_For_Circulation"));
        showCoins.setMintage_Of_Proofs(rs.getString("mintage_Of_Proofs"));
        showCoins.setDenomination_Series_Id(rs.getInt("denomination_Series_Id"));
        showCoins.setMint_Mark(rs.getString("mint_Mark"));
        showCoins.setDesigner(rs.getString("designer"));
        showCoins.setDiameter(rs.getString("diameter"));
        showCoins.setMetal_Content(rs.getString("metal_Content"));
        showCoins.setWeight(rs.getString("weight"));
        showCoins.setEdge(rs.getString("edge"));
        showCoins.setNotes(rs.getString("notes"));
        return showCoins;
    }
}

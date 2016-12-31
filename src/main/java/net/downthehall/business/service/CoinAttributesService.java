package net.downthehall.business.service;

import net.downthehall.business.db.DBConnection;
import net.downthehall.business.interfaces.ICoinAttributesService;
import net.downthehall.business.model.vo.CoinAttributes;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by joseph on 8/1/2014.
 */
public class CoinAttributesService implements ICoinAttributesService
{
    private Connection conn;
    private Statement stmt;
    private ResultSet rs;
    private PreparedStatement ps;

    // ******************************************************************************************
    public Collection<CoinAttributes> findAll()
    {
        Collection<CoinAttributes> coinAttributesList = new ArrayList<>();
        try
        {
            conn = DBConnection.getInstance().connect();
            stmt = conn.createStatement();
            rs = stmt.executeQuery("SELECT * FROM coin_attributes");
            while (rs.next())
            {
                coinAttributesList.add(processRow(rs));
            }
        } catch (SQLException e)
        {
            e.printStackTrace();
            throw new RuntimeException(e);
        } finally
        {
            DBConnection.getInstance().close(conn);
        }
        return coinAttributesList;
    }

    // ******************************************************************************************

    @Override
    public List<String> findById(int id)
    {
        return null;
    }

    // ******************************************************************************************
    public Collection<String> findByName()
    {
        Collection<String> coinAttributesList = new ArrayList();
        try
        {
            conn = DBConnection.connect();
            stmt = conn.createStatement();
            rs = stmt.executeQuery("SELECT country FROM coin_attributes");
            while (rs.next())
            {
                coinAttributesList.add(rs.getString("country"));
                //coinAttributesList.add(rs.getString("coinAttributesId"));
                //coinAttributesList.add(rs.getString("country"));
                System.out.println("Name ID is " + rs.getInt("coinAttributesId"));
            }
        } catch (SQLException e)
        {
            e.printStackTrace();
            throw new RuntimeException(e);
        } finally
        {
            DBConnection.close(conn);
        }
        return coinAttributesList;
    }

    // ******************************************************************************************

    /**
     * Get a list of gradeBy objects
     *
     * @return gradeByList
     */
    public Collection<String> findGradeBy()
    {
        Collection<String> gradeByList = new ArrayList();
        try
        {
            conn = DBConnection.connect();
            stmt = conn.createStatement();
            rs = stmt.executeQuery("SELECT grade_by FROM coin_attributes");
            while (rs.next())
            {
                gradeByList.add(rs.getString("grade_by"));
                //System.out.println("Name ID is " + rs.getString("grade_by"));
            }
        } catch (SQLException e)
        {
            e.printStackTrace();
            throw new RuntimeException(e);
        } finally
        {
            DBConnection.close(conn);
        }
        return gradeByList;
    }

    // ******************************************************************************************

    /**
     * Get a list of grade objects
     *
     * @return gradeList
     */
    public Collection<String> findGrade()
    {
        Collection<String> gradeList = new ArrayList();
        try
        {
            conn = DBConnection.connect();
            stmt = conn.createStatement();
            rs = stmt.executeQuery("SELECT grade FROM coin_attributes");
            while (rs.next())
            {
                gradeList.add(rs.getString("grade"));
                //System.out.println("Name ID is " + rs.getString("grade"));
                //System.out.println("Name ID is " + gradeList);
            }
        } catch (SQLException e)
        {
            e.printStackTrace();
            throw new RuntimeException(e);
        } finally
        {
            DBConnection.close(conn);
        }
        return gradeList;
    }

    // ******************************************************************************************

    /**
     * Get a list of serialNumber objects
     *
     * @return serialNumberList
     */
    public Collection<String> findSerialNumber()
    {
        Collection<String> serialNumberList = new ArrayList();
        try
        {
            conn = DBConnection.connect();
            stmt = conn.createStatement();
            rs = stmt.executeQuery("SELECT serial_number FROM coin_attributes");
            while (rs.next())
            {
                serialNumberList.add(rs.getString("serial_number"));
                //System.out.println("Name ID is " + rs.getString("serial_number"));
            }
        } catch (SQLException e)
        {
            e.printStackTrace();
            throw new RuntimeException(e);
        } finally
        {
            DBConnection.close(conn);
        }
        return serialNumberList;
    }

    // ******************************************************************************************

    /**
     * Get a list of catalog objects
     *
     * @return catalogList
     */
    public Collection<String> findCatalog()
    {
        Collection<String> catalogList = new ArrayList();
        try
        {
            conn = DBConnection.connect();
            stmt = conn.createStatement();
            rs = stmt.executeQuery("SELECT catalog_type FROM coin_attributes");
            while (rs.next())
            {
                catalogList.add(rs.getString("catalog_type"));
                //System.out.println("Name ID is " + rs.getString("catalog_type"));
            }
        } catch (SQLException e)
        {
            e.printStackTrace();
            throw new RuntimeException(e);
        } finally
        {
            DBConnection.close(conn);
        }
        return catalogList;
    }

    // ******************************************************************************************

    /**
     * Get a list of condition objects
     *
     * @return conditionList
     */
    public Collection<String> findQuality()
    {
        Collection<String> qualityList = new ArrayList();
        try
        {
            conn = DBConnection.connect();
            stmt = conn.createStatement();
            rs = stmt.executeQuery("SELECT quality FROM coin_attributes");
            while (rs.next())
            {
                qualityList.add(rs.getString("quality"));
                //System.out.println("Name ID is " + rs.getString("quality"));
            }
        } catch (SQLException e)
        {
            e.printStackTrace();
            throw new RuntimeException(e);
        } finally
        {
            DBConnection.close(conn);
        }
        return qualityList;
    }

    // ******************************************************************************************
    public CoinAttributes create(CoinAttributes coinAttributes)
    {
        try
        {
            conn = DBConnection.connect();
            ps = conn.prepareStatement(
                    "INSERT INTO coin_attributes (" +
                    "catalog_type, collection_id, composition, quality, country, " +
                    "current_value, denomination, denomination_series, designer, " +
                    "diameter, edge, grade, grade_by, metal_content, mint, mint_mark, " +
                    "mint_year, mintage_for_circulation, mintage_of_proofs, " +
                    "purchase_date, purchase_from, purchase_price, quantity, " +
                    "serial_number, sold_date, sold_price, sold_to, thickness, notes, weight)" +
                    " VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, " +
                    "?, ?, ?, ?, ?, ?, ?, ?, ?, ?)",
                    new String[]{"ID"});
            ps.setString(1, coinAttributes.getCatalog_type());
            ps.setInt(2, coinAttributes.getCollection_id());
            ps.setString(3, coinAttributes.getComposition());
            ps.setString(4, coinAttributes.getQuality());
            ps.setString(5, coinAttributes.getCountry());
            ps.setString(6, coinAttributes.getCurrent_value());
            ps.setString(7, coinAttributes.getDenomination());
            ps.setString(8, coinAttributes.getDenomination_series());
            ps.setString(9, coinAttributes.getDesigner());
            ps.setString(10, coinAttributes.getDiameter());
            ps.setString(11, coinAttributes.getEdge());
            ps.setString(12, coinAttributes.getGrade());
            ps.setString(13, coinAttributes.getGrade_by());
            ps.setString(14, coinAttributes.getMetal_content());
            ps.setString(15, coinAttributes.getMint());
            ps.setString(16, coinAttributes.getMint_mark());
            ps.setString(17, coinAttributes.getMint_year());
            ps.setInt(18, coinAttributes.getMintage_for_circulation());
            ps.setInt(19, coinAttributes.getMintage_of_proofs());
            ps.setString(20, coinAttributes.getPurchase_date());
            ps.setString(21, coinAttributes.getPurchase_from());
            ps.setString(22, coinAttributes.getPurchase_price());
            ps.setInt(23, coinAttributes.getQuantity());
            ps.setString(24, coinAttributes.getSerial_number());
            ps.setString(25, coinAttributes.getSold_date());
            ps.setString(26, coinAttributes.getSold_price());
            ps.setString(27, coinAttributes.getSold_to());
            ps.setString(28, coinAttributes.getThickness());
            ps.setString(29, coinAttributes.getNotes());
            ps.setString(30, coinAttributes.getWeight());
            ps.executeUpdate();
            rs = ps.getGeneratedKeys();
            rs.next();
            // Update the id in the returned object. This is important as this value must be returned to the client.
            int id = rs.getInt(1);
            coinAttributes.setCoin_attributes_id(id);
        } catch (Exception e)
        {
            e.printStackTrace();
            throw new RuntimeException(e);
        } finally
        {
            DBConnection.close(conn);
            System.out.println("\n" + "Data Saved!!! ");
        }
        return coinAttributes;
    }

    // ******************************************************************************************
    public CoinAttributes update(CoinAttributes coinAttributes)
    {
        try
        {
            conn = DBConnection.connect();
            ps = conn.prepareStatement(
                    "UPDATE coin_attributes SET catalog_type=?, collection_id=?, composition=?, " +
                    "quality=?, country=?, current_value=?, denomination=?, " +
                    "denomination_series=?, designer=?, diameter=?, edge=?, grade=?, " +
                    "grade_by=?, metal_content=?, mint=?, mint_mark=?, mint_year=?, " +
                    "mintage_for_circulation=?, mintage_of_proofs=?, purchase_date=?, " +
                    "purchase_from=?, purchase_price=?, quantity=?, serial_number=?, " +
                    "sold_date=?, sold_price=?, sold_to=?, thickness=?, notes=?, weight=? WHERE coin_attributes_id=?");
            ps.setString(1, coinAttributes.getCatalog_type());
            ps.setInt(2, coinAttributes.getCollection_id());
            ps.setString(3, coinAttributes.getComposition());
            ps.setString(4, coinAttributes.getQuality());
            ps.setString(5, coinAttributes.getCountry());
            ps.setString(6, coinAttributes.getCurrent_value());
            ps.setString(7, coinAttributes.getDenomination());
            ps.setString(8, coinAttributes.getDenomination_series());
            ps.setString(9, coinAttributes.getDesigner());
            ps.setString(10, coinAttributes.getDiameter());
            ps.setString(11, coinAttributes.getEdge());
            ps.setString(12, coinAttributes.getGrade());
            ps.setString(13, coinAttributes.getGrade_by());
            ps.setString(14, coinAttributes.getMetal_content());
            ps.setString(15, coinAttributes.getMint());
            ps.setString(16, coinAttributes.getMint_mark());
            ps.setString(17, coinAttributes.getMint_year());
            ps.setInt(18, coinAttributes.getMintage_for_circulation());
            ps.setInt(19, coinAttributes.getMintage_of_proofs());
            ps.setString(20, coinAttributes.getPurchase_date());
            ps.setString(21, coinAttributes.getPurchase_from());
            ps.setString(22, coinAttributes.getPurchase_price());
            ps.setInt(23, coinAttributes.getQuantity());
            ps.setString(24, coinAttributes.getSerial_number());
            ps.setString(25, coinAttributes.getSold_date());
            ps.setString(26, coinAttributes.getSold_price());
            ps.setString(27, coinAttributes.getSold_to());
            ps.setString(28, coinAttributes.getThickness());
            ps.setString(29, coinAttributes.getNotes());
            ps.setString(30, coinAttributes.getWeight());

            ps.setInt(31, coinAttributes.getCoin_attributes_id());
            ps.executeUpdate();
        } catch (SQLException e)
        {
            e.printStackTrace();
            throw new RuntimeException(e);
        } finally
        {
            DBConnection.close(conn);
//            System.out.println("\n" + "Data Updated CoinAttributes_id " + coinattributes.getCoin_attributes_id());
        }
        return coinAttributes;
    }

    // ******************************************************************************************
    public void remove(int id)
    {
        /*try
        {
            conn = DBConnection.connect();
            ps = conn.prepareStatement("DELETE FROM coin_attributes WHERE coin_attributes_id=?");
            ps.setInt(1, coinAttributes.getCoin_attributes_id());
            int count = ps.executeUpdate();
            return count == 1;
        } catch (Exception e)
        {
            e.printStackTrace();
            throw new RuntimeException(e);
        } finally
        {
            DBConnection.close(conn);
            System.out.println("\n" + "Data Deleted CoinAttributes_id " + coinAttributes.getCoin_attributes_id());
        }*/
//        return false;
    }

    // ******************************************************************************************

    // ******************************************************************************************
    protected CoinAttributes processRow(ResultSet rs) throws SQLException
    {
        CoinAttributes coinAttributes = new CoinAttributes();
        coinAttributes.setCoin_attributes_id(rs.getInt("coin_attributes_id"));
        coinAttributes.setCatalog_type(rs.getString("catalog_type"));
        coinAttributes.setCollection_id(rs.getInt("collection_id"));
        coinAttributes.setComposition(rs.getString("composition"));
        coinAttributes.setQuality(rs.getString("quality"));
        coinAttributes.setCountry(rs.getString("country"));
        coinAttributes.setCurrent_value(rs.getString("current_value"));
        coinAttributes.setDenomination(rs.getString("denomination"));
        coinAttributes.setDenomination_series(rs.getString("denomination_series"));
        coinAttributes.setDesigner(rs.getString("designer"));
        coinAttributes.setDiameter(rs.getString("diameter"));
        coinAttributes.setEdge(rs.getString("edge"));
        coinAttributes.setGrade(rs.getString("grade"));
        coinAttributes.setGrade_by(rs.getString("grade_by"));
        coinAttributes.setMetal_content(rs.getString("metal_content"));
        coinAttributes.setMint(rs.getString("mint"));
        coinAttributes.setMint_mark(rs.getString("mint_mark"));
        coinAttributes.setMint_year(rs.getString("mint_year"));
        coinAttributes.setMintage_for_circulation(rs.getInt("mintage_for_circulation"));
        coinAttributes.setMintage_of_proofs(rs.getInt("mintage_of_proofs"));
        coinAttributes.setPurchase_date(rs.getString("purchase_date"));
        coinAttributes.setPurchase_from(rs.getString("purchase_from"));
        coinAttributes.setPurchase_price(rs.getString("purchase_price"));
        coinAttributes.setQuantity(rs.getInt("quantity"));
        coinAttributes.setSerial_number(rs.getString("serial_number"));
        coinAttributes.setSold_date(rs.getString("sold_date"));
        coinAttributes.setSold_price(rs.getString("sold_price"));
        coinAttributes.setSold_to(rs.getString("sold_to"));
        coinAttributes.setThickness(rs.getString("thickness"));
        coinAttributes.setNotes(rs.getString("notes"));
        coinAttributes.setWeight(rs.getString("weight"));
        return coinAttributes;
    }

    public CoinAttributes persist(CoinAttributes coinAttributes)
    {
        return null;
    }
}

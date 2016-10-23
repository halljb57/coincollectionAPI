package net.downthehall.business.model.vo;

import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * User: joseph
 * Date: 11/14/13
 * Time: 7:11 PM
 * To change this template use File | Settings | File Templates.
 */
public class Coins implements Serializable
{
    private static final long serialVersionUID = 7426789219094038421L;
    // **********************************************************************************
    private int coin_id;
    private String mint_year;
    private int mintage_for_circulation;
    private int mintage_of_proofs;
    private int denomination_series_id;
    private String mint_mark;
    private String designer;
    private String diameter;
    private String metal_content;
    private String weight;
    private String edge;
    private String notes;

    // **********************************************************************************
    public Coins()
    {
    }

    public Coins(int coin_id, String mint_year, int mintage_for_circulation, int mintage_of_proofs,
                 int denomination_series_id, String mint_mark, String designer, String diameter,
                 String metal_content, String weight, String edge, String notes)
    {
        this.coin_id = coin_id;
        this.mint_year = mint_year;
        this.mintage_for_circulation = mintage_for_circulation;
        this.mintage_of_proofs = mintage_of_proofs;
        this.denomination_series_id = denomination_series_id;
        this.mint_mark = mint_mark;
        this.designer = designer;
        this.diameter = diameter;
        this.metal_content = metal_content;
        this.weight = weight;
        this.edge = edge;
        this.notes = notes;
    }

    // **********************************************************************************
    public int getCoin_id()
    {
        return coin_id;
    }

    public void setCoin_id(int coin_id)
    {
        this.coin_id = coin_id;
    }

    public String getMint_year()
    {
        return mint_year;
    }

    public void setMint_year(String mint_year)
    {
        this.mint_year = mint_year;
    }

    public int getMintage_for_circulation()
    {
        return mintage_for_circulation;
    }

    public void setMintage_for_circulation(int mintage_for_circulation)
    {
        this.mintage_for_circulation = mintage_for_circulation;
    }

    public int getMintage_of_proofs()
    {
        return mintage_of_proofs;
    }

    public void setMintage_of_proofs(int mintage_of_proofs)
    {
        this.mintage_of_proofs = mintage_of_proofs;
    }

    public int getDenomination_series_id()
    {
        return denomination_series_id;
    }

    public void setDenomination_series_id(int denomination_series_id)
    {
        this.denomination_series_id = denomination_series_id;
    }

    public String getMint_mark()
    {
        return mint_mark;
    }

    public void setMint_mark(String mint_mark)
    {
        this.mint_mark = mint_mark;
    }

    public String getDesigner()
    {
        return designer;
    }

    public void setDesigner(String designer)
    {
        this.designer = designer;
    }

    public String getDiameter()
    {
        return diameter;
    }

    public void setDiameter(String diameter)
    {
        this.diameter = diameter;
    }

    public String getMetal_content()
    {
        return metal_content;
    }

    public void setMetal_content(String metal_content)
    {
        this.metal_content = metal_content;
    }

    public String getWeight()
    {
        return weight;
    }

    public void setWeight(String weight)
    {
        this.weight = weight;
    }

    public String getEdge()
    {
        return edge;
    }

    public void setEdge(String edge)
    {
        this.edge = edge;
    }

    public String getNotes()
    {
        return notes;
    }

    public void setNotes(String notes)
    {
        this.notes = notes;
    }

    // **********************************************************************************
    @Override
    public String toString()
    {
        return "Coins{" +
               "coin_id=" + coin_id +
               ", mint_year='" + mint_year + '\'' +
               ", mintage_for_circulation=" + mintage_for_circulation +
               ", mintage_of_proofs=" + mintage_of_proofs +
               ", denomination_series_id=" + denomination_series_id +
               ", mint_mark='" + mint_mark + '\'' +
               ", designer='" + designer + '\'' +
               ", diameter='" + diameter + '\'' +
               ", metal_content='" + metal_content + '\'' +
               ", weight='" + weight + '\'' +
               ", edge='" + edge + '\'' +
               ", notes='" + notes + '\'' +
               '}';
    }

    // **********************************************************************************
    // Fields are listed here for type-safety
    public enum Fields
    {
        coin_id, mint_year, mintage_for_circulation, mintage_of_proofs,
        denomination_series_id, mint_mark, designer, diameter,
        metal_content, weight, edge, notes
    }
}

package net.downthehall.business.model.vo;

import java.io.Serializable;

/**
 * Created by joseph on 5/21/2014.
 */
public class CoinAttributes implements Serializable
{
    private static final long serialVersionUID = 2943428701873901625L;

    private int coin_attributes_id;
    private String catalog_type;
    private int collection_id;
    private String composition;
    private String quality;
    private String country;
    private String current_value;
    private String denomination;
    private String denomination_series;
    private String designer;
    private String diameter;
    private String edge;
    private String grade;
    private String grade_by;
    private String metal_content;
    private String mint;
    private String mint_mark;
    private String mint_year;
    private int mintage_for_circulation;
    private int mintage_of_proofs;
    private String purchase_date;
    private String purchase_from;
    private String purchase_price;
    private int quantity;
    private String serial_number;
    private String sold_date;
    private String sold_price;
    private String sold_to;
    private String thickness;
    private String notes;
    private String weight;

    // **********************************************************************************
    public CoinAttributes()
    {
    }

    public CoinAttributes(int coin_attributes_id, String catalog_type, int collection_id, String composition,
                          String quality, String country, String current_value, String denomination,
                          String denomination_series, String designer, String diameter, String edge, String grade,
                          String grade_by, String metal_content, String mint, String mint_mark, String mint_year,
                          int mintage_for_circulation, int mintage_of_proofs, String purchase_date,
                          String purchase_from, String purchase_price, int quantity, String serial_number,
                          String sold_date, String sold_price, String sold_to, String thickness, String notes,
                          String weight)
    {
        this.coin_attributes_id = coin_attributes_id;
        this.catalog_type = catalog_type;
        this.collection_id = collection_id;
        this.composition = composition;
        this.quality = quality;
        this.country = country;
        this.current_value = current_value;
        this.denomination = denomination;
        this.denomination_series = denomination_series;
        this.designer = designer;
        this.diameter = diameter;
        this.edge = edge;
        this.grade = grade;
        this.grade_by = grade_by;
        this.metal_content = metal_content;
        this.mint = mint;
        this.mint_mark = mint_mark;
        this.mint_year = mint_year;
        this.mintage_for_circulation = mintage_for_circulation;
        this.mintage_of_proofs = mintage_of_proofs;
        this.purchase_date = purchase_date;
        this.purchase_from = purchase_from;
        this.purchase_price = purchase_price;
        this.quantity = quantity;
        this.serial_number = serial_number;
        this.sold_date = sold_date;
        this.sold_price = sold_price;
        this.sold_to = sold_to;
        this.thickness = thickness;
        this.notes = notes;
        this.weight = weight;
    }

    // **********************************************************************************
    public int getCoin_attributes_id()
    {
        return coin_attributes_id;
    }

    public void setCoin_attributes_id(int coin_attributes_id)
    {
        this.coin_attributes_id = coin_attributes_id;
    }

    public String getCatalog_type()
    {
        return catalog_type;
    }

    public void setCatalog_type(String catalog_type)
    {
        this.catalog_type = catalog_type;
    }

    public int getCollection_id()
    {
        return collection_id;
    }

    public void setCollection_id(int collection_id)
    {
        this.collection_id = collection_id;
    }

    public String getComposition()
    {
        return composition;
    }

    public void setComposition(String composition)
    {
        this.composition = composition;
    }

    public String getQuality()
    {
        return quality;
    }

    public void setQuality(String quality)
    {
        this.quality = quality;
    }

    public String getCountry()
    {
        return country;
    }

    public void setCountry(String country)
    {
        this.country = country;
    }

    public String getCurrent_value()
    {
        return current_value;
    }

    public void setCurrent_value(String current_value)
    {
        this.current_value = current_value;
    }

    public String getDenomination()
    {
        return denomination;
    }

    public void setDenomination(String denomination)
    {
        this.denomination = denomination;
    }

    public String getDenomination_series()
    {
        return denomination_series;
    }

    public void setDenomination_series(String denomination_series)
    {
        this.denomination_series = denomination_series;
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

    public String getEdge()
    {
        return edge;
    }

    public void setEdge(String edge)
    {
        this.edge = edge;
    }

    public String getGrade()
    {
        return grade;
    }

    public void setGrade(String grade)
    {
        this.grade = grade;
    }

    public String getGrade_by()
    {
        return grade_by;
    }

    public void setGrade_by(String grade_by)
    {
        this.grade_by = grade_by;
    }

    public String getMetal_content()
    {
        return metal_content;
    }

    public void setMetal_content(String metal_content)
    {
        this.metal_content = metal_content;
    }

    public String getMint()
    {
        return mint;
    }

    public void setMint(String mint)
    {
        this.mint = mint;
    }

    public String getMint_mark()
    {
        return mint_mark;
    }

    public void setMint_mark(String mint_mark)
    {
        this.mint_mark = mint_mark;
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

    public String getPurchase_date()
    {
        return purchase_date;
    }

    public void setPurchase_date(String purchase_date)
    {
        this.purchase_date = purchase_date;
    }

    public String getPurchase_from()
    {
        return purchase_from;
    }

    public void setPurchase_from(String purchase_from)
    {
        this.purchase_from = purchase_from;
    }

    public String getPurchase_price()
    {
        return purchase_price;
    }

    public void setPurchase_price(String purchase_price)
    {
        this.purchase_price = purchase_price;
    }

    public int getQuantity()
    {
        return quantity;
    }

    public void setQuantity(int quantity)
    {
        this.quantity = quantity;
    }

    public String getSerial_number()
    {
        return serial_number;
    }

    public void setSerial_number(String serial_number)
    {
        this.serial_number = serial_number;
    }

    public String getSold_date()
    {
        return sold_date;
    }

    public void setSold_date(String sold_date)
    {
        this.sold_date = sold_date;
    }

    public String getSold_price()
    {
        return sold_price;
    }

    public void setSold_price(String sold_price)
    {
        this.sold_price = sold_price;
    }

    public String getSold_to()
    {
        return sold_to;
    }

    public void setSold_to(String sold_to)
    {
        this.sold_to = sold_to;
    }

    public String getThickness()
    {
        return thickness;
    }

    public void setThickness(String thickness)
    {
        this.thickness = thickness;
    }

    public String getNotes()
    {
        return notes;
    }

    public void setNotes(String notes)
    {
        this.notes = notes;
    }

    public String getWeight()
    {
        return weight;
    }

    public void setWeight(String weight)
    {
        this.weight = weight;
    }

    // **********************************************************************************
    @Override
    public String toString()
    {
        return "CoinAttributes{" +
               "coin_attributes_id=" + coin_attributes_id +
               ", catalog_type='" + catalog_type + '\'' +
               ", collection_id=" + collection_id +
               ", composition='" + composition + '\'' +
               ", quality='" + quality + '\'' +
               ", country='" + country + '\'' +
               ", current_value='" + current_value + '\'' +
               ", denomination='" + denomination + '\'' +
               ", denomination_series='" + denomination_series + '\'' +
               ", designer='" + designer + '\'' +
               ", diameter='" + diameter + '\'' +
               ", edge='" + edge + '\'' +
               ", grade='" + grade + '\'' +
               ", grade_by='" + grade_by + '\'' +
               ", metal_content='" + metal_content + '\'' +
               ", mint='" + mint + '\'' +
               ", mint_mark='" + mint_mark + '\'' +
               ", mint_year='" + mint_year + '\'' +
               ", mintage_for_circulation=" + mintage_for_circulation +
               ", mintage_of_proofs=" + mintage_of_proofs +
               ", purchase_date='" + purchase_date + '\'' +
               ", purchase_from='" + purchase_from + '\'' +
               ", purchase_price='" + purchase_price + '\'' +
               ", quantity=" + quantity +
               ", serial_number='" + serial_number + '\'' +
               ", sold_date='" + sold_date + '\'' +
               ", sold_price='" + sold_price + '\'' +
               ", sold_to='" + sold_to + '\'' +
               ", thickness='" + thickness + '\'' +
               ", notes='" + notes + '\'' +
               ", weight='" + weight + '\'' +
               '}';
    }

    // **********************************************************************************
    // Fields are listed here for type-safety
    public enum Fields
    {
        coin_attributes_id, catalog_type, collection_id, composition, country,
        current_value, denomination, denomination_series, designer, diameter,
        edge, grade, grade_by, metal_content, mint, mint_mark, mint_year,
        mintage_for_circulation, mintage_of_proofs, purchase_date, purchase_from,
        purchase_price, quantity, serial_number, sold_date, sold_price, sold_to,
        thickness, notes, weight, quality
    }
}

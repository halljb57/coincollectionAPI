package net.downthehall.business.model.vo;

/**
 * Created with IntelliJ IDEA.
 * User: joseph
 * Date: 11/14/13
 * Time: 7:12 PM
 * To change this template use File | Settings | File Templates.
 */
public class Denominations
{
    private int denominations_id;
    private String denomination;
    private int country_id;

    // **********************************************************************************
    public Denominations()
    {
    }

    public Denominations(int denominations_id, String denomination, int country_id)
    {
        this.denominations_id = denominations_id;
        this.denomination = denomination;
        this.country_id = country_id;
    }

    // **********************************************************************************
    public int getDenominations_id()
    {
        return denominations_id;
    }

    public void setDenominations_id(int denominations_id)
    {
        this.denominations_id = denominations_id;
    }

    public String getDenomination()
    {
        return denomination;
    }

    public void setDenomination(String denomination)
    {
        this.denomination = denomination;
    }

    public int getCountry_id()
    {
        return country_id;
    }

    public void setCountry_id(int country_id)
    {
        this.country_id = country_id;
    }

    // **********************************************************************************
    @Override
    public String toString()
    {
        return "Denominations{" +
               "denominations_id=" + denominations_id +
               ", denomination='" + denomination + '\'' +
               ", country_id=" + country_id +
               '}';
    }

    // **********************************************************************************
    // Fields are listed here for type-safety
    public enum Fields
    {
        denominations_id, denomination, country_id
    }
}

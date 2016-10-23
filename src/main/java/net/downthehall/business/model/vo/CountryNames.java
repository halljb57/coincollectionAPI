package net.downthehall.business.model.vo;

import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * User: joseph
 * Date: 11/14/13
 * Time: 7:10 PM
 * To change this template use File | Settings | File Templates.
 */
public class CountryNames implements Serializable
{
    private static final long serialVersionUID = -8697558710484736376L;
    // **********************************************************************************
    int country_id;
    String country;
    
    // **********************************************************************************
    public CountryNames()
    {
    }

    public CountryNames(int country_id, String country)
    {
        this.country_id = country_id;
        this.country = country;
    }

    // **********************************************************************************
    public int getCountry_id()
    {
        return country_id;
    }

    public void setCountry_id(int country_id)
    {
        this.country_id = country_id;
    }

    public String getCountry()
    {
        return country;
    }

    public void setCountry(String country)
    {
        this.country = country;
    }

    // **********************************************************************************
    @Override
    public String toString()
    {
        return "CountryNames{" +
               "country_id=" + country_id +
               ", country='" + country + '\'' +
               '}';
    }

    // **********************************************************************************
    // Fields are listed here for type-safety
    public enum Fields
    {
        country_id, country
    }
}

package net.downthehall.business.model.vo;

/**
 * Created with IntelliJ IDEA.
 * User: joseph
 * Date: 11/14/13
 * Time: 7:13 PM
 * To change this template use File | Settings | File Templates.
 */
public class DenominationSeries
{
    private int denomination_series_id;
    private String denomination_series;
    private int denominations_id;

    // **********************************************************************************
    public DenominationSeries()
    {
    }

    public DenominationSeries(int denomination_series_id, String denomination_series, int denominations_id)
    {
        this.denomination_series_id = denomination_series_id;
        this.denomination_series = denomination_series;
        this.denominations_id = denominations_id;
    }

    // **********************************************************************************
    public int getDenomination_series_id()
    {
        return denomination_series_id;
    }

    public void setDenomination_series_id(int denomination_series_id)
    {
        this.denomination_series_id = denomination_series_id;
    }

    public int getDenominations_id()
    {
        return denominations_id;
    }

    public void setDenominations_id(int denominations_id)
    {
        this.denominations_id = denominations_id;
    }

    public String getDenomination_series()
    {
        return denomination_series;
    }

    public void setDenomination_series(String denomination_series)
    {
        this.denomination_series = denomination_series;
    }

    // **********************************************************************************
    @Override
    public String toString()
    {
        return "DenominationSeries{" +
               "denomination_series_id=" + denomination_series_id +
               ", denomination_series='" + denomination_series + '\'' +
               ", denominations_id=" + denominations_id +
               '}';
    }

    // **********************************************************************************
    // Fields are listed here for type-safety
    public enum Fields
    {
        denomination_series_id, denomination_series, denominations_id
    }
}

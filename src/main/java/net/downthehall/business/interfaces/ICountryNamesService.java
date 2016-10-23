package net.downthehall.business.interfaces;

import net.downthehall.business.model.vo.CountryNames;

import java.util.Collection;
import java.util.List;

/**
 * Created by halljb57 on 8/15/2015.
 */
public interface ICountryNamesService
{
    Collection<CountryNames> findAll();

    List<String> findById(int id);

    CountryNames create(CountryNames countryNames);

    CountryNames update(CountryNames countryNames);

    boolean remove(int id);
}

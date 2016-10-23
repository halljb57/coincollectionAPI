package net.downthehall.business.interfaces;

import net.downthehall.business.model.vo.DenominationSeries;

import java.util.Collection;
import java.util.List;

/**
 * Created by halljb57 on 8/15/2015.
 */
public interface IDenominationsSeriesService
{
    Collection<DenominationSeries> findAll();

    List<String> findById(int id);

    DenominationSeries create(DenominationSeries denominationSeries);

    DenominationSeries update(DenominationSeries denominationSeries);

    boolean remove(int id);
}

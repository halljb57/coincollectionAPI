package net.downthehall.business.interfaces;

import net.downthehall.business.model.vo.ShowDenominationSeries;

import java.util.Collection;

/**
 * Created by halljb57 on 8/15/2015.
 */
public interface IShowDenominationsSeriesService
{
    Collection<ShowDenominationSeries> findAll();

    ShowDenominationSeries create(ShowDenominationSeries showDenominationSeries);

    ShowDenominationSeries update(ShowDenominationSeries showDenominationSeries);

    boolean remove(ShowDenominationSeries showDenominationSeries);
}

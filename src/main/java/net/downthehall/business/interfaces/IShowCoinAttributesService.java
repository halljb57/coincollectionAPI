package net.downthehall.business.interfaces;

import net.downthehall.business.model.vo.ShowCoinAttributes;

import java.util.Collection;

/**
 * Created by halljb57 on 8/15/2015.
 */
public interface IShowCoinAttributesService
{
    Collection<ShowCoinAttributes> findAll();

    ShowCoinAttributes create(ShowCoinAttributes showCoinAttributes);

    ShowCoinAttributes update(ShowCoinAttributes showCoinAttributes);

    boolean remove(ShowCoinAttributes showCoinAttributes);
}

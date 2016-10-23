package net.downthehall.business.interfaces;

import net.downthehall.business.model.vo.ShowCoins;

import java.util.Collection;

/**
 * Created by halljb57 on 8/15/2015.
 */
public interface IShowCoinsService
{
    Collection<ShowCoins> findAll();

    ShowCoins create(ShowCoins showCoins);

    ShowCoins update(ShowCoins showCoins);

    boolean remove(ShowCoins showCoins);
}

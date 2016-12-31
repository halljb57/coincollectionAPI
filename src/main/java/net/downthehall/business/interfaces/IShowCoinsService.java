package net.downthehall.business.interfaces;

import net.downthehall.business.model.vo.ShowCoins;

import java.util.Collection;
import java.util.List;

/**
 * Created by halljb57 on 8/15/2015.
 */
public interface IShowCoinsService
{
    Collection<ShowCoins> findAll();

    List<String> findByName();

    void findCoinsListById(int id);

    ShowCoins create(ShowCoins showCoins);

    ShowCoins update(ShowCoins showCoins);

    void remove(int id);
}

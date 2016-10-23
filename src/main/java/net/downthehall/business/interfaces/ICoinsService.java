package net.downthehall.business.interfaces;

import net.downthehall.business.model.vo.Coins;

import java.util.Collection;
import java.util.List;

/**
 * Created by halljb57 on 8/15/2015.
 */
public interface ICoinsService
{
    Collection<Coins> findAll();

    List<String> findById(int id);

    Coins create(Coins coins);

    Coins update(Coins coins);

    boolean remove(int id);
}

package net.downthehall.business.interfaces;

import net.downthehall.business.model.vo.CoinAttributes;

import java.util.Collection;
import java.util.List;

/**
 * Created by halljb57 on 8/15/2015.
 */
public interface ICoinAttributesService
{
    Collection<CoinAttributes> findAll();

    List<String> findById(int id);

    CoinAttributes create(CoinAttributes coinAttributes);

    CoinAttributes update(CoinAttributes coinAttributes);

    boolean remove(int id);
}

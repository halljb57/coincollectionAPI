package net.downthehall.business.interfaces;

import net.downthehall.business.model.vo.Denominations;

import java.util.Collection;
import java.util.List;

/**
 * Created by halljb57 on 8/15/2015.
 */
public interface IDenominationsService
{
    Collection<Denominations> findAll();

    List<String> findById(int id);

    Denominations create(Denominations denominations);

    Denominations update(Denominations denominations);

    boolean remove(int id);
}

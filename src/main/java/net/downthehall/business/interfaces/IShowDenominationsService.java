package net.downthehall.business.interfaces;

import net.downthehall.business.model.vo.ShowDenominations;

import java.util.Collection;

/**
 * Created by halljb57 on 8/15/2015.
 */
public interface IShowDenominationsService
{
    Collection<ShowDenominations> findAll();

    ShowDenominations create(ShowDenominations showDenominations);

    ShowDenominations update(ShowDenominations showDenominations);

    boolean remove(ShowDenominations showDenominations);
}

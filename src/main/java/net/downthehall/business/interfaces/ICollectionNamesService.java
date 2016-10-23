package net.downthehall.business.interfaces;

import net.downthehall.business.model.vo.CollectionNames;

import java.util.Collection;
import java.util.List;

/**
 * Created by halljb57 on 8/15/2015.
 */
public interface ICollectionNamesService
{
    Collection<CollectionNames> findAll();

    List<String> findById(int id);

    CollectionNames create(CollectionNames collectionNames);

    CollectionNames update(CollectionNames collectionNames);

    boolean remove(int id);
}

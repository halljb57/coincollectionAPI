package net.downthehall.controller;

import net.downthehall.business.interfaces.ICollectionNamesService;
import net.downthehall.business.service.CollectionNamesService;
import net.downthehall.business.model.vo.CollectionNames;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;


@Path("/collections")
public class CollectionController
{

    ICollectionNamesService collectionNamesService = new CollectionNamesService();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<CollectionNames> getCollection_Name()
    {
        List<CollectionNames> listOfCollectionNames = (List<CollectionNames>) collectionNamesService.findAll();
        return listOfCollectionNames;
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<String> getCollectionNamesById(@PathParam("id") int id)
    {
        return collectionNamesService.findById(id);
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public CollectionNames addCollectionNames(CollectionNames collectionNames)
    {
        return collectionNamesService.create(collectionNames);
    }

    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    public CollectionNames updateCollectionNames(CollectionNames collectionNames)
    {
        return collectionNamesService.update(collectionNames);
    }

    @DELETE
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public void deleteCollectionNames(@PathParam("id") int id)
    {
        collectionNamesService.remove(id);
    }

}

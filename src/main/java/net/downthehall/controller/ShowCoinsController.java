package net.downthehall.controller;

import net.downthehall.business.interfaces.IShowCoinsService;
import net.downthehall.business.model.vo.ShowCoins;
import net.downthehall.business.service.ShowCoinsService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;


@Path("/showCoins")
public class ShowCoinsController
{

    IShowCoinsService showCoinsService = new ShowCoinsService();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<ShowCoins> getShowCoinsId()
    {
        List<ShowCoins> listOfCoins = (List<ShowCoins>) showCoinsService.findAll();
        return listOfCoins;
    }

    @POST
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public void getCoinsListById(@PathParam("id") int id)
    {
        showCoinsService.findCoinsListById(id);
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<String> getCoinsByName(@PathParam("id") int id)
    {
        return showCoinsService.findByName();
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public ShowCoins addCoins(ShowCoins coins)
    {
        return showCoinsService.create(coins);
    }

    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    public ShowCoins updateCoins(ShowCoins coins)
    {
        return showCoinsService.update(coins);
    }

    @DELETE
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public void deleteCoins(@PathParam("id") int id)
    {
        showCoinsService.remove(id);
    }

}

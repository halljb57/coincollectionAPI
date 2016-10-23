package net.downthehall.controller;

import net.downthehall.business.interfaces.ICoinsService;
import net.downthehall.business.model.vo.Coins;
import net.downthehall.business.service.CoinsService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;


@Path("/coins")
public class CoinsController
{

    ICoinsService coinsService = new CoinsService();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Coins> getCoins_id()
    {
        List<Coins> listOfCoins = (List<Coins>) coinsService.findAll();
        return listOfCoins;
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<String> getCoinsById(@PathParam("id") int id)
    {
        return coinsService.findById(id);
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Coins addCoins(Coins coins)
    {
        return coinsService.create(coins);
    }

    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    public Coins updateCoins(Coins coins)
    {
        return coinsService.update(coins);
    }

    @DELETE
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public void deleteCoins(@PathParam("id") int id)
    {
        coinsService.remove(id);
    }

}

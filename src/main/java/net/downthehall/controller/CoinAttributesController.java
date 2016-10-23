package net.downthehall.controller;

import net.downthehall.business.interfaces.ICoinAttributesService;
import net.downthehall.business.model.vo.CoinAttributes;
import net.downthehall.business.service.CoinAttributesService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;


@Path("/coinAttributes")
public class CoinAttributesController
{

    ICoinAttributesService coinAttributesService = new CoinAttributesService();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<CoinAttributes> getCoin_attributes_id()
    {
        List<CoinAttributes> listOfCoinAttributes = (List<CoinAttributes>) coinAttributesService.findAll();
        return listOfCoinAttributes;
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<String> getCoinAttributesById(@PathParam("id") int id)
    {
        return coinAttributesService.findById(id);
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public CoinAttributes addCoinAttributes(CoinAttributes coinAttributes)
    {
        return coinAttributesService.create(coinAttributes);
    }

    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    public CoinAttributes updateCoinAttributes(CoinAttributes coinAttributes)
    {
        return coinAttributesService.update(coinAttributes);
    }

    @DELETE
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public void deleteCoinAttributes(@PathParam("id") int id)
    {
        coinAttributesService.remove(id);
    }

}

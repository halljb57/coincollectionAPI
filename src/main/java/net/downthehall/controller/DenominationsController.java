package net.downthehall.controller;

import net.downthehall.business.interfaces.IDenominationsService;
import net.downthehall.business.model.vo.Denominations;
import net.downthehall.business.service.DenominationsService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;


@Path("/denominations")
public class DenominationsController
{

    IDenominationsService denominationsService = new DenominationsService();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Denominations> getDenomination()
    {
        List<Denominations> listOfDenominations = (List<Denominations>) denominationsService.findAll();
        return listOfDenominations;
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<String> getDenominationsById(@PathParam("id") int id)
    {
        return denominationsService.findById(id);
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Denominations addDenominations(Denominations denominations)
    {
        return denominationsService.create(denominations);
    }

    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    public Denominations updateDenominations(Denominations denominations)
    {
        return denominationsService.update(denominations);
    }

    @DELETE
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public void deleteDenominations(@PathParam("id") int id)
    {
        denominationsService.remove(id);
    }

}

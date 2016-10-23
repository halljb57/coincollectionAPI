package net.downthehall.controller;

import net.downthehall.business.interfaces.IDenominationsSeriesService;
import net.downthehall.business.model.vo.DenominationSeries;
import net.downthehall.business.service.DenominationsSeriesService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;


@Path("/denominationsSeries")
public class DenominationsSeriesController
{

    IDenominationsSeriesService denominationsSeriesService = new DenominationsSeriesService();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<DenominationSeries> getDenomination_series()
    {
        List<DenominationSeries> listOfDenominationsSeries = (List<DenominationSeries>) denominationsSeriesService.findAll();
        return listOfDenominationsSeries;
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<String> getDenominationsSeriesById(@PathParam("id") int id)
    {
        return denominationsSeriesService.findById(id);
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public DenominationSeries addDenominationsSeries(DenominationSeries denominationSeries)
    {
        return denominationsSeriesService.create(denominationSeries);
    }

    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    public DenominationSeries updateDenominationsSeries(DenominationSeries denominationSeries)
    {
        return denominationsSeriesService.update(denominationSeries);
    }

    @DELETE
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public void deleteDenominationsSeries(@PathParam("id") int id)
    {
        denominationsSeriesService.remove(id);
    }

}

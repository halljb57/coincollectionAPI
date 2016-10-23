package net.downthehall.controller;

import net.downthehall.business.interfaces.ICountryNamesService;
import net.downthehall.business.model.vo.CountryNames;
import net.downthehall.business.service.CountryNamesService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;


@Path("/countryNames")
public class CountryNamesController
{

    ICountryNamesService countryNamesService = new CountryNamesService();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<CountryNames> getCountry()
    {
        List<CountryNames> listOfCountryNames = (List<CountryNames>) countryNamesService.findAll();
        return listOfCountryNames;
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<String> getCountryNamesById(@PathParam("id") int id)
    {
        return countryNamesService.findById(id);
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public CountryNames addCountryNames(CountryNames countryNames)
    {
        return countryNamesService.create(countryNames);
    }

    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    public CountryNames updateCountryNames(CountryNames countryNames)
    {
        return countryNamesService.update(countryNames);
    }

    @DELETE
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public void deleteCountryNames(@PathParam("id") int id)
    {
        countryNamesService.remove(id);
    }

}

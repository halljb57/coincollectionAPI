package net.downthehall.controller;

import net.downthehall.bean.Country;
import net.downthehall.service.CountryService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;


@Path("/countries")
public class CountryController
{

    CountryService countryService = new CountryService();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Country> getCountries()
    {
        List<Country> listOfCountries = countryService.getAllCountries();
        return listOfCountries;
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Country getCountryById(@PathParam("id") int id)
    {
        return countryService.getCountry(id);
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Country addCountry(Country country)
    {
        return countryService.addCountry(country);
    }

    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    public Country updateCountry(Country country)
    {
        return countryService.updateCountry(country);
    }

    @DELETE
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public void deleteCountry(@PathParam("id") int id)
    {
        countryService.deleteCountry(id);
    }

}

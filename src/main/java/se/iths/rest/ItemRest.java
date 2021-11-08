package se.iths.rest;

import se.iths.entity.Item;
import se.iths.service.ItemService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.util.List;

/*
Tar emot anrop och skickar vidare till lämplig class
 */

@Path("item")
public class ItemRest {

    @Inject
    ItemService itemService;

    @Path("new")
    @POST //skicka in data till applikationen
    public Response createItem(Item item){
        itemService.createItem(item);
        return Response.ok(item).build();
    }

    @Path("update")
    @PUT
    public Response updateItem(Item item){
        itemService.updateItem(item);
        return Response.ok(item).build();
    }

    @Path("{id}")
    @GET
    public Item getItem (@PathParam("id") Long id){
        return itemService.findItemById(id);
    }

    @Path("getall")
    @GET
    public List<Item> getAllItems(){
        return itemService.getAllItems();
    }
}

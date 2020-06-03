package vu.che.mvcrest.repository;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;

@Path("/repository")
public class Controller {

    private final Service service;

    public Controller() { this.service = new Service(); }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<String> getTableNames() {
        return service.getTableNames();
    }

    @GET
    @Path("/{tableName}")
    @Produces(MediaType.APPLICATION_JSON)
    public String getTable(@PathParam("tableName") String tableName) {
        return service.getTable(tableName);
    }

    @POST
    @Path("/{tableName}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void addToTable(@PathParam("tableName") String tableName) { service.addToTable(tableName); }

}

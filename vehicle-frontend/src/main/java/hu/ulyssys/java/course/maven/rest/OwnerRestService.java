package hu.ulyssys.java.course.maven.rest;

import hu.ulyssys.java.course.maven.entity.Owner;
import hu.ulyssys.java.course.maven.rest.model.OwnerModel;
import hu.ulyssys.java.course.maven.service.OwnerService;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.stream.Collectors;

@Path("/owner")
public class OwnerRestService {
    
    @Inject
    private OwnerService service;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response findAll() {
        return Response.ok(service.getAll().stream().map(this::createModelFromEntity).collect(Collectors.toList())).build();
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response save(OwnerModel model) {
        Owner owner = new Owner();
        owner.setId(model.getId());
        owner.setFirstName(model.getFirstName());
        owner.setLastName(model.getLastName());

        service.add(owner);
        return Response.ok(createModelFromEntity(owner)).build();
    }

    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response update(OwnerModel model) {
        Owner owner = service.findById(model.getId());
        if (owner == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }

        owner.setFirstName(model.getFirstName());
        owner.setLastName(model.getLastName());
        service.update(owner);
        return Response.ok(createModelFromEntity(owner)).build();

    }

    @DELETE
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response delete(@PathParam("id") Long id) {
        Owner Owner = service.findById(id);
        if (Owner == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        service.remove(Owner);
        return Response.ok().build();
    }

    private OwnerModel createModelFromEntity(Owner owner) {
        OwnerModel model = new OwnerModel();
        model.setId(owner.getId());
        model.setFirstName(owner.getFirstName());
        model.setLastName(owner.getLastName());

        return model;
    }
}

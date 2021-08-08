package hu.ulyssys.java.course.maven.rest;

import hu.ulyssys.java.course.maven.converter.EntityToModel;
import hu.ulyssys.java.course.maven.entity.Car;
import hu.ulyssys.java.course.maven.entity.Plane;
import hu.ulyssys.java.course.maven.rest.model.CarModel;
import hu.ulyssys.java.course.maven.rest.model.PlaneModel;
import hu.ulyssys.java.course.maven.service.OwnerService;

import javax.inject.Inject;
import javax.ws.rs.Path;
import java.util.Arrays;
import java.util.stream.Collectors;

@Path("/plane")
public class PlaneRestService extends CoreRestService<Plane, PlaneModel>{

    @Inject
    private OwnerService ownerService;

    @Override
    protected void populateEntityFromModel(Plane entity, PlaneModel model) {
        if (model.getOwnerID() != null) {
            entity.setOwner(ownerService.findById(model.getOwnerID()));
        }
        entity.setManufacturer(model.getManufacturer());
        entity.setType(model.getType());
        entity.setPassengerNumber(model.getPassengerNumber());
    }

    @Override
    protected PlaneModel createModelFromEntity(Plane entity) {
        return Arrays.asList(entity).stream().map(EntityToModel::createPlaneModelFromPlaneEntity).collect(
            Collectors.toList()).stream().findFirst().orElse(null);
    }

    @Override
    protected PlaneModel initNewModel() {
        return new PlaneModel();
    }

    @Override
    protected Plane initNewEntity() {
        return new Plane();
    }
}

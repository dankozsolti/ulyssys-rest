package hu.ulyssys.java.course.maven.rest;

import hu.ulyssys.java.course.maven.entity.Car;
import hu.ulyssys.java.course.maven.entity.Plane;
import hu.ulyssys.java.course.maven.rest.model.CarModel;
import hu.ulyssys.java.course.maven.rest.model.PlaneModel;
import hu.ulyssys.java.course.maven.service.OwnerService;

import javax.inject.Inject;
import javax.ws.rs.Path;

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
        PlaneModel model = initNewModel();
        model.setId(entity.getId());
        model.setManufacturer(entity.getManufacturer());
        model.setType(entity.getType());
        model.setPassengerNumber(entity.getPassengerNumber());
        if (entity.getOwner() != null) {
            model.setOwnerID(entity.getOwner().getId());
        }
        return model;
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

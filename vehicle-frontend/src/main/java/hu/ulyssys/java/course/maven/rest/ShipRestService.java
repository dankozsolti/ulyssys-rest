package hu.ulyssys.java.course.maven.rest;

import hu.ulyssys.java.course.maven.entity.Car;
import hu.ulyssys.java.course.maven.entity.Ship;
import hu.ulyssys.java.course.maven.rest.model.CarModel;
import hu.ulyssys.java.course.maven.rest.model.ShipModel;
import hu.ulyssys.java.course.maven.service.OwnerService;

import javax.inject.Inject;
import javax.ws.rs.Path;

@Path("/ship")
public class ShipRestService extends CoreRestService<Ship, ShipModel>{

    @Inject
    private OwnerService ownerService;

    @Override
    protected void populateEntityFromModel(Ship entity, ShipModel model) {
        if (model.getOwnerID() != null) {
            entity.setOwner(ownerService.findById(model.getOwnerID()));
        }
        entity.setManufacturer(model.getManufacturer());
        entity.setType(model.getType());
        entity.setLicensePlateNumber(model.getLicensePlateNumber());
    }

    @Override
    protected ShipModel createModelFromEntity(Ship entity) {
        ShipModel model = initNewModel();
        model.setId(entity.getId());
        model.setManufacturer(entity.getManufacturer());
        model.setType(entity.getType());
        model.setLicensePlateNumber(entity.getLicensePlateNumber());
        if (entity.getOwner() != null) {
            model.setOwnerID(entity.getOwner().getId());
        }
        return model;
    }

    @Override
    protected ShipModel initNewModel() {
        return new ShipModel();
    }

    @Override
    protected Ship initNewEntity() {
        return new Ship();
    }
}

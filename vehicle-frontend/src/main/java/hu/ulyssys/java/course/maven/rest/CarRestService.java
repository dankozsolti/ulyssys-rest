package hu.ulyssys.java.course.maven.rest;

import hu.ulyssys.java.course.maven.entity.Car;
import hu.ulyssys.java.course.maven.rest.model.CarModel;
import hu.ulyssys.java.course.maven.service.OwnerService;

import javax.inject.Inject;
import javax.ws.rs.Path;

@Path("/car")
public class CarRestService extends CoreRestService<Car, CarModel>{

    @Inject
    private OwnerService ownerService;

    @Override
    protected void populateEntityFromModel(Car entity, CarModel model) {
        if (model.getOwnerID() != null) {
            entity.setOwner(ownerService.findById(model.getOwnerID()));
        }
        entity.setManufacturer(model.getManufacturer());
        entity.setType(model.getType());
        entity.setDoorNumbers(model.getDoorNumbers());
        entity.setLicensePlateNumber(model.getLicensePlateNumber());
    }

    @Override
    protected CarModel createModelFromEntity(Car entity) {
        CarModel model = initNewModel();
        model.setId(entity.getId());
        model.setManufacturer(entity.getManufacturer());
        model.setType(entity.getType());
        model.setDoorNumbers(entity.getDoorNumbers());
        model.setLicensePlateNumber(entity.getLicensePlateNumber());
        if (entity.getOwner() != null) {
            model.setOwnerID(entity.getOwner().getId());
        }
        return model;
    }

    @Override
    protected CarModel initNewModel() {
        return new CarModel();
    }

    @Override
    protected Car initNewEntity() {
        return new Car();
    }

}

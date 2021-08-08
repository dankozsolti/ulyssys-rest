package hu.ulyssys.java.course.maven.rest;

import hu.ulyssys.java.course.maven.converter.EntityToModel;
import hu.ulyssys.java.course.maven.entity.Car;
import hu.ulyssys.java.course.maven.rest.model.CarModel;
import hu.ulyssys.java.course.maven.service.OwnerService;

import javax.inject.Inject;
import javax.ws.rs.Path;
import java.util.Arrays;
import java.util.Optional;
import java.util.stream.Collectors;

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
        return Arrays.asList(entity).stream().map(EntityToModel::createCarModelFromCarEntity).collect(
            Collectors.toList()).stream().findFirst().orElse(null);
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

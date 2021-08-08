package hu.ulyssys.java.course.maven.rest;

import hu.ulyssys.java.course.maven.converter.EntityToModel;
import hu.ulyssys.java.course.maven.entity.Car;
import hu.ulyssys.java.course.maven.entity.Ship;
import hu.ulyssys.java.course.maven.rest.model.CarModel;
import hu.ulyssys.java.course.maven.rest.model.ShipModel;
import hu.ulyssys.java.course.maven.service.OwnerService;

import javax.inject.Inject;
import javax.ws.rs.Path;
import java.util.Arrays;
import java.util.stream.Collectors;

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
        return Arrays.asList(entity).stream().map(EntityToModel::createShipModelFromShipEntity).collect(
            Collectors.toList()).stream().findFirst().orElse(null);
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

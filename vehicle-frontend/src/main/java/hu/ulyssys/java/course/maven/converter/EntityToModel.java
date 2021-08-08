package hu.ulyssys.java.course.maven.converter;

import hu.ulyssys.java.course.maven.entity.Car;
import hu.ulyssys.java.course.maven.entity.Plane;
import hu.ulyssys.java.course.maven.entity.Ship;
import hu.ulyssys.java.course.maven.rest.model.CarModel;
import hu.ulyssys.java.course.maven.rest.model.PlaneModel;
import hu.ulyssys.java.course.maven.rest.model.ShipModel;

public class EntityToModel {
    public static CarModel createCarModelFromCarEntity(Car entity) {
        CarModel model = new CarModel();
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

    public static PlaneModel createPlaneModelFromPlaneEntity(Plane entity) {
        PlaneModel model = new PlaneModel();
        model.setId(entity.getId());
        model.setManufacturer(entity.getManufacturer());
        model.setType(entity.getType());
        model.setPassengerNumber(entity.getPassengerNumber());
        if (entity.getOwner() != null) {
            model.setOwnerID(entity.getOwner().getId());
        }
        return model;
    }

    public static ShipModel createShipModelFromShipEntity(Ship entity) {
        ShipModel model = new ShipModel();
        model.setId(entity.getId());
        model.setManufacturer(entity.getManufacturer());
        model.setType(entity.getType());
        model.setLicensePlateNumber(entity.getLicensePlateNumber());
        if (entity.getOwner() != null) {
            model.setOwnerID(entity.getOwner().getId());
        }
        return model;
    }
}

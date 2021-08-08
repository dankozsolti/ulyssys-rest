package hu.ulyssys.java.course.maven.dao.impl;

import hu.ulyssys.java.course.maven.dao.PlaneDAO;
import hu.ulyssys.java.course.maven.entity.Car;
import hu.ulyssys.java.course.maven.entity.Plane;

import javax.ejb.Stateless;
import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class PlaneDAOImpl extends CoreDAOImpl<Plane> implements PlaneDAO {

    @Override
    protected Class<Plane> getManagedClass() {
        return Plane.class;
    }
}

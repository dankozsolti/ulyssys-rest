package hu.ulyssys.java.course.maven.service;

import hu.ulyssys.java.course.maven.dao.CoreDAO;
import hu.ulyssys.java.course.maven.entity.AbstractEntity;
import hu.ulyssys.java.course.maven.entity.AbstractVehicle;

import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

public abstract class AbstractServiceImpl<T extends AbstractEntity> implements CoreService<T> {
    @Inject
    protected CoreDAO<T> dao;

    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    @Override
    public List<T> getAll() {
        return dao.findAll();
    }

    public List<T> getAllByOwnerId(Long ownerId) {
        return dao.findAllByOwnerId(ownerId);
    }

    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    @Override
    public T findById(Long id) {
        return dao.findById(id);
    }

    @Override
    public void add(T entity) {
        dao.save(entity);
    }

    @Override
    public void remove(T entity) {
        dao.delete(entity.getId());
    }

    @Override
    public void update(T entity) {
        dao.update(entity);
    }

}
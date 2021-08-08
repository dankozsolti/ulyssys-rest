package hu.ulyssys.java.course.maven.service;

import hu.ulyssys.java.course.maven.entity.AbstractEntity;

import java.util.List;

public interface CoreService<T extends AbstractEntity> {
    List<T> getAll();

    List<T> getAllByOwnerId(Long ownerId);

    T findById(Long id);

    void add(T vehicle);

    void remove(T vehicle);

    void update(T vehicle);
}

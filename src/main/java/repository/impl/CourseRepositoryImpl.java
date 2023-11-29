package repository.impl;

import base.repository.impl.BaseEntityRepositoryImpl;
import entity.Course;
import repository.CourseRepository;

import javax.persistence.EntityManager;

@SuppressWarnings("unused")
public class CourseRepositoryImpl extends BaseEntityRepositoryImpl<Course, Integer> implements CourseRepository {

    public CourseRepositoryImpl(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public Class<Course> getEntityClass() {
        return Course.class;
    }

}
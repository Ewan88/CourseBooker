package com.example.CourseBooker.repositories.CourseRepository;

import com.example.CourseBooker.models.Course;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;

public class CourseRepositoryImpl implements CourseRepositoryCustom {

    @Autowired
    EntityManager entityManager;

    @Transactional
    public List<Course> findCourseByCustomer(Long customerID){
        List<Course> results = null;
        Session session = entityManager.unwrap(Session.class);
        try {
            Criteria criteria = session.createCriteria(Course.class);
            criteria.createAlias("bookings", "booking");
            criteria.createAlias("booking.customer", "customer");
            criteria.add(Restrictions.eq("customer.id", customerID));
            results = criteria.list();
        } catch (HibernateException exception) {
            exception.printStackTrace();
        } finally {
            return results;
        }
    }


}

package com.example.CourseBooker.repositories.CustomerRepository;

import com.example.CourseBooker.models.Customer;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;

public class CustomerRepositoryImpl implements CustomerRepositoryCustom {

    @Autowired
    EntityManager entityManager;

    @Transactional
    public List<Customer> findCustomersByCourse(Long courseID){
        List<Customer> results = null;
        Session session = entityManager.unwrap(Session.class);
        try {
            Criteria criteria = session.createCriteria(Customer.class);
            criteria.createAlias("bookings", "booking");
            criteria.createAlias("booking.course", "course");
            criteria.add(Restrictions.eq("course.id", courseID));
            results = criteria.list();
        } catch (HibernateException exception) {
            exception.printStackTrace();
        } finally {
            return results;
        }
    }

    @Transactional
    public List<Customer> findCustomerByTownAndCourse(String town, Long courseID){
        List<Customer> results = null;
        Session session = entityManager.unwrap(Session.class);
        try {
            Criteria criteria = session.createCriteria(Customer.class);
            criteria.createAlias("bookings", "booking");
            criteria.createAlias("booking.course", "course");
            criteria.add(Restrictions.ilike("course.town", town));
            criteria.add(Restrictions.eq("course.id", courseID));
            results = criteria.list();
        } catch (HibernateException exception) {
            exception.printStackTrace();
        } finally {
            return results;
        }
    }

    @Transactional
    public List<Customer> findCustomerOverAgeByTownAndCourse(int age, String town, Long courseID){
        List<Customer> results = null;
        Session session = entityManager.unwrap(Session.class);
        try {
            Criteria criteria = session.createCriteria(Customer.class);
            criteria.createAlias("bookings", "booking");
            criteria.createAlias("booking.course", "course");
            criteria.add(Restrictions.ge("age", age));
            criteria.add(Restrictions.ilike("course.town", town));
            criteria.add(Restrictions.eq("course.id", courseID));
            results = criteria.list();
        } catch (HibernateException exception) {
            exception.printStackTrace();
        } finally {
            return results;
        }
    }

}

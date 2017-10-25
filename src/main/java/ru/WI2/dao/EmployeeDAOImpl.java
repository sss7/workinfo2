package ru.WI2.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import ru.WI2.entity.Employee;

import javax.persistence.NoResultException;
import java.sql.SQLException;
import java.util.List;

public class EmployeeDAOImpl implements EmployeeDAO {
    @Autowired
    private SessionFactory sessionFactory;

    public EmployeeDAOImpl() {
    }

    public EmployeeDAOImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }


    public void create(Employee employee) throws SQLException, NoResultException {

    }

    public Employee readEmployeeById(Integer id, String namedQuerry) throws SQLException, NoResultException {
        return null;
    }

    public Employee readEmployeeById_(Integer id) throws SQLException, NoResultException {
        return null;
    }

    public List<Employee> readAll(String namedQuerry) throws SQLException, NoResultException {
        return null;
    }

    public List<Employee> readAll_() throws SQLException, NoResultException {
        return null;
    }

    public void update(Employee employee) throws SQLException, NoResultException {

    }

    public void delete(Integer id) throws SQLException, NoResultException {

    }
}

package ru.WI2.service;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Service;
import ru.WI2.dao.EmployeeDAO;
import ru.WI2.entity.Employee;
import ru.WI2.util.SessionUtil;

import javax.persistence.NoResultException;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.sql.SQLException;
import java.util.List;

@Service
public class EmployeeService extends SessionUtil implements EmployeeDAO {

    // CREATE
    public void create(Employee employee) throws SQLException, NoResultException {
        openTransactionSession();
        Session session = getSession();
        session.save("Employee", employee);
        closeTransactionSession();
    }

    // READ
    public Employee readEmployeeById(Integer id, String namedQuerry) throws SQLException, NoResultException {
        openTransactionSession();
        Session session = getSession();
        Query query = session.createNamedQuery(namedQuerry);
        query.setParameter("id", id);
        Employee employee = (Employee) query.getSingleResult();
        closeTransactionSession();
        return employee;
    }

    public Employee readEmployeeById_(Integer id) throws SQLException, NoResultException {
        openTransactionSession();
        Session session = getSession();
        Employee employee = (Employee) session.get(Employee.class, id);
        closeTransactionSession();
        return employee;
    }

    public List<Employee> readAll(String namedQuerry) throws SQLException, NoResultException {
        openTransactionSession();
        Session session = getSession();
        Query query = session.createNamedQuery(namedQuerry);
        List<Employee> list = query.list();
        closeTransactionSession();
        return list;
    }

    public List<Employee> readAll_() throws SQLException, NoResultException {
        openTransactionSession();
        Session session = getSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Employee> query = builder.createQuery(Employee.class);
        Root<Employee> employeeRoot = query.from(Employee.class);
        query.select(employeeRoot);
        List<Employee> list = session.createQuery(query).getResultList();
        closeTransactionSession();
        return list;
    }

    // UPDATE
    public void update(Employee employee) throws SQLException, NoResultException {
        openTransactionSession();
        Session session = getSession();
        session.update(employee);
        closeTransactionSession();
    }

    // DELETE
    public void delete(Integer id) throws SQLException, NoResultException {
        Employee employee = readEmployeeById_(id);
        openTransactionSession();
        Session session = getSession();
        session.remove(employee);
        closeTransactionSession();
    }



}
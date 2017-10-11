package ru.WI2.service;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.stereotype.Service;
import ru.WI2.entity.Employee;
import ru.WI2.util.SessionUtil;

import javax.persistence.NoResultException;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.sql.SQLException;
import java.util.List;

@Service
public class EmployeeService extends SessionUtil {

    public Employee getEmployeeById(Integer id, String namedQuerry) throws SQLException, NoResultException {
        openTransactionSession();
        Session session = getSession();
        Query query = session.createNamedQuery(namedQuerry);
        query.setParameter("id", id);
        Employee employee = (Employee) query.getSingleResult();
        closeTransactionSession();
        return employee;
    }

    public Employee getEmployeeById_(Integer id) throws SQLException, NoResultException {
        openTransactionSession();
        Session session = getSession();
        Employee employee = (Employee) session.get(Employee.class, id);
        closeTransactionSession();
        return employee;

    }

    public List<Employee> getAll(String namedQuerry) throws SQLException, NoResultException {
        openTransactionSession();
        Session session = getSession();
        Query query = session.createNamedQuery(namedQuerry);
        List<Employee> list = query.list();
        closeTransactionSession();
        return list;
    }

    public List<Employee> getAll_() throws SQLException, NoResultException {
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



}

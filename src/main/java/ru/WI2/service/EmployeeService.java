package ru.WI2.service;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Service;
import ru.WI2.entity.Employee;
import ru.WI2.util.SessionUtil;

import javax.persistence.NoResultException;
import java.sql.SQLException;

@Service
public class EmployeeService extends SessionUtil {

    public Employee getEmployeeById(Integer id, String namedQuerry) throws SQLException, NoResultException {
        openTransactionSession();
        Session session = getSession();
        Query query = session.createNamedQuery(namedQuerry);
        query.setParameter("id", id);
        Employee obj = (Employee) query.getSingleResult();
        closeTransactionSession();
        return obj;
    }


}

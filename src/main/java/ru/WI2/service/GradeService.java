package ru.WI2.service;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Service;
import ru.WI2.dao.GradeDAO;
import ru.WI2.entity.Grade;
import ru.WI2.util.SessionUtil;

import javax.persistence.NoResultException;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.sql.SQLException;
import java.util.List;

@Service
public class GradeService extends SessionUtil implements GradeDAO {

    public Grade getGradeById(Integer id, String namedQuerry) throws SQLException, NoResultException {
        openTransactionSession();
        Session session = getSession();
        Query query = session.createNamedQuery(namedQuerry);
        query.setParameter("id", id);
        Grade grade = (Grade) query.getSingleResult();
        closeTransactionSession();
        return grade;
    }

    public Grade getGradeById_(Integer id) throws SQLException, NoResultException {
        openTransactionSession();
        Session session = getSession();
        Grade grade = (Grade) session.get(Grade.class, id);
        closeTransactionSession();
        return grade;
    }

    public List<Grade> getAll(String namedQuerry) throws SQLException, NoResultException {
        openTransactionSession();
        Session session = getSession();
        Query query = session.createNamedQuery(namedQuerry);
        List<Grade> list = query.list();
        closeTransactionSession();
        return list;
    }

    public List<Grade> getAll_() throws SQLException, NoResultException {
        openTransactionSession();
        Session session = getSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Grade> query = builder.createQuery(Grade.class);
        Root<Grade> employeeRoot = query.from(Grade.class);
        query.select(employeeRoot);
        List<Grade> list = session.createQuery(query).getResultList();
        closeTransactionSession();
        return list;
    }

}
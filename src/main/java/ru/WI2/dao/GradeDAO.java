package ru.WI2.dao;

import ru.WI2.entity.Grade;

import javax.persistence.NoResultException;
import java.sql.SQLException;
import java.util.List;

public interface GradeDAO {
    public Grade getGradeById(Integer id, String namedQuerry) throws SQLException, NoResultException;

    public Grade getGradeById_(Integer id) throws SQLException, NoResultException;

    public List<Grade> getAll(String namedQuerry) throws SQLException, NoResultException;

    public List<Grade> getAll_() throws SQLException, NoResultException;

}

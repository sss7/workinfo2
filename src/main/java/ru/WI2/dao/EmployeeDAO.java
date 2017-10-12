package ru.WI2.dao;

import ru.WI2.entity.Employee;

import javax.persistence.NoResultException;
import java.sql.SQLException;
import java.util.List;

public interface EmployeeDAO {

    public Employee getEmployeeById(Integer id, String namedQuerry) throws SQLException, NoResultException;

    public Employee getEmployeeById_(Integer id) throws SQLException, NoResultException;

    public List<Employee> getAll(String namedQuerry) throws SQLException, NoResultException;

    public List<Employee> getAll_() throws SQLException, NoResultException;
}

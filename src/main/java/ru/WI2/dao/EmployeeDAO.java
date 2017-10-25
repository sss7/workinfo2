package ru.WI2.dao;

import ru.WI2.entity.Employee;

import javax.persistence.NoResultException;
import java.sql.SQLException;
import java.util.List;

public interface EmployeeDAO {

    public void create(Employee employee) throws SQLException, NoResultException;

    public Employee readEmployeeById(Integer id, String namedQuerry) throws SQLException, NoResultException;

    public Employee readEmployeeById_(Integer id) throws SQLException, NoResultException;

    public List<Employee> readAll(String namedQuerry) throws SQLException, NoResultException;

    public List<Employee> readAll_() throws SQLException, NoResultException;

    public void update(Employee employee) throws SQLException, NoResultException;

    public void delete(Integer id) throws SQLException, NoResultException;

}

package ru.WI2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import ru.WI2.entity.Employee;
import ru.WI2.service.EmployeeService;

import javax.persistence.NoResultException;
import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    private EmployeeService service;

    @Autowired
    public EmployeeController(EmployeeService service) {
        this.service = service;
    }

    // CREATE
    @RequestMapping(method = RequestMethod.POST)
    public void create(@RequestBody Employee employee) throws SQLException, NoResultException {
        service.create(employee);
    }

    // READ
    @RequestMapping(value = "/read/{id}", method = RequestMethod.GET)
    public Employee readEmployeeById(@PathVariable Integer id) throws SQLException, NoResultException {
        return service.readEmployeeById(id, "readEmployeeById");
    }

    @RequestMapping(value = "/read_/{id}", method = RequestMethod.GET)
    public Employee readEmployeeById_(@PathVariable Integer id) throws SQLException, NoResultException {
        return service.readEmployeeById_(id);
    }


    @RequestMapping(value = "/read", method = RequestMethod.GET)
    public List<Employee> readAll() throws SQLException, NoResultException {
        return service.readAll("readAllEmployees");
    }

    @RequestMapping(value = "/read_", method = RequestMethod.GET)
    public List<Employee> readAll_() throws SQLException, NoResultException {
        return service.readAll_();
    }

    // UPDATE
    @RequestMapping(method = RequestMethod.PUT)
    public void update(@RequestBody Employee employee) throws SQLException, NoResultException {
        service.update(employee);
    }

    // DELETE
    @RequestMapping(value = "/remove/{id}", method = RequestMethod.DELETE)
    public void deleteEmployeeById(@PathVariable Integer id) throws SQLException, NoResultException {
        service.delete(id);
    }

}

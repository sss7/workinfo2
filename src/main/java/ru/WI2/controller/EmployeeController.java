package ru.WI2.controller;

import org.springframework.beans.factory.annotation.Autowired;
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

    @RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
    public Employee getEmployeeById(@PathVariable Integer id) throws SQLException, NoResultException {
        return service.getEmployeeById(id, "getEmployeeById");
    }

    @RequestMapping(value = "/get_/{id}", method = RequestMethod.GET)
    public Employee getEmployeeById_(@PathVariable Integer id) throws SQLException, NoResultException {
        return service.getEmployeeById_(id);
    }

    @RequestMapping(value = "/get", method = RequestMethod.GET)
    public List<Employee> getAll() throws SQLException, NoResultException {
        return service.getAll("getAllEmployees");
    }

    @RequestMapping(value = "/get_", method = RequestMethod.GET)
    public List<Employee> getAll_() throws SQLException, NoResultException {
        return service.getAll_();
    }


}

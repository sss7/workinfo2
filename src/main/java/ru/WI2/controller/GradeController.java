package ru.WI2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ru.WI2.entity.Grade;
import ru.WI2.service.GradeService;

import javax.persistence.NoResultException;
import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/grade")
public class GradeController {

    private GradeService service;

    @Autowired
    public GradeController(GradeService service) {
        this.service = service;
    }

    @RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
    public Grade getEmployeeById(@PathVariable Integer id) throws SQLException, NoResultException {
        return service.getGradeById(id, "getGradeById");
    }

    @RequestMapping(value = "/get_/{id}", method = RequestMethod.GET)
    public Grade getGradeById_(@PathVariable Integer id)  throws SQLException, NoResultException {
        return service.getGradeById_(id);
    }

    @RequestMapping(value = "/get", method = RequestMethod.GET)
    public List<Grade> getAll() throws SQLException, NoResultException {
        return service.getAll("getAllGrades");
    }

    @RequestMapping(value = "/get_", method = RequestMethod.GET)
    public List<Grade> getAll_() throws SQLException, NoResultException {
        return service.getAll_();
    }


}

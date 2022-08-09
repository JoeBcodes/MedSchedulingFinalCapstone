package com.techelevator.controller;

import com.techelevator.dao.JdbcOfficeDao;
import com.techelevator.dao.OfficeDao;
import com.techelevator.model.Office;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.sql.DataSource;
import java.util.List;

@RequestMapping("/office")
//@PreAuthorize("isAuthenticated()")
@RestController
public class OfficeController {
    private OfficeDao officeDao;

    public OfficeController(DataSource dataSource) {
        this.officeDao = new JdbcOfficeDao(dataSource);
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    public Office getOfficeInfoById(@PathVariable int id) {
        return officeDao.getOfficeById(id);
    }

    @RequestMapping(path = "", method = RequestMethod.GET)
    public List<Office> getAllOfficeInfo() {
        return officeDao.getAllOffices();
    }
}

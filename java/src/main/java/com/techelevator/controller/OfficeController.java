package com.techelevator.controller;

import com.techelevator.dao.JdbcOfficeDao;
import com.techelevator.dao.OfficeDao;
import com.techelevator.model.Office;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.sql.DataSource;
import javax.validation.Valid;
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

    //Still early stages on updating office info
    @RequestMapping(path = "/{id}/update", method = RequestMethod.PUT)
    public void updateInfoByOfficeId(@Valid @RequestBody Office office, @PathVariable int id) {
        officeDao.updateOfficeInfo(office, id);
    }
}

package com.techelevator.dao;

import com.techelevator.model.Office;

import java.util.List;

public interface OfficeDao {
    Office getOfficeById(int officeId);
    List<Office> getAllOffices();
}

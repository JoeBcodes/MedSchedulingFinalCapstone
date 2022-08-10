package com.techelevator.dao;

import com.techelevator.model.Doctors;

import java.util.List;

public interface DoctorsDao {

    List<Doctors> getAllDoctors();
    List<Doctors> getAllDoctorsByOfficeId(int officeId);
}

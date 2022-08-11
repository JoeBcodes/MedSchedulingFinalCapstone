package com.techelevator.dao;

import com.techelevator.model.Office;

import java.util.List;

public interface OfficeDao {
    Office getOfficeById(int officeId);
    List<Office> getAllOffices();
    void updateOfficeInfo(Office office, int officeId);
    void addDoctorToOffice(int officeId, int doctorId);
    void updateDoctorOffice(int officeId, int doctorId);
    void removeDoctorFromOffice(int officeId, int doctorId);
}

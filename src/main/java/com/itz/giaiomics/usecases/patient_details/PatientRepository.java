package com.itz.giaiomics.usecases.patient_details;


import com.itz.giaiomics.models.PatientDetails;
import com.itz.giaiomics.usecases.patient_details.dao.CreatePatientDao;
import com.itz.giaiomics.usecases.patient_details.pojo.PatientPojo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PatientRepository extends JpaRepository<PatientDetails, Integer> {

    @Query(value = "Select * from PatientDetails where PatientId = ?1",nativeQuery = true)
    PatientDetails findByPatientId(String patientId);

    @Query(value = "select * from PatientDetails where PatientId = ?1 And  IsActive = ?2 ", nativeQuery = true)
    PatientDetails findByPatientIdAndIsActive(String patientId, int i);

    @Query(value = "select * from PatientDetails where IsActive = 1 ", nativeQuery = true)
    List<PatientPojo> findAllPatient();

    @Query(value = "Select * from PatientDetails where PatientId = ?1",nativeQuery = true)
    PatientPojo findByPatient(String patientId);
}

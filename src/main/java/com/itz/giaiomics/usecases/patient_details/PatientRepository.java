package com.itz.giaiomics.usecases.create_patient;


import com.itz.giaiomics.models.PatientDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientRepository extends JpaRepository<PatientDetails, Integer> {

    @Query(value = "Select * from PatientDetails where patientId = ?1",nativeQuery = true)
    PatientDetails findByPatientId(String patientId);
}

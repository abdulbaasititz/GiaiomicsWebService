package com.itz.giaiomics.usecases.create_patient;


import com.itz.giaiomics.usecases.create_patient.dao.CreatePatientDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("${spring.base.path}")
public class PatientController {
    @Autowired
    PatientService patientService;


    @PostMapping("/patient/create-patient")
    public ResponseEntity<?> createPatient(HttpServletRequest request, @RequestBody CreatePatientDao createPatientDao) throws Exception {
        Boolean patient = patientService.createPatient(createPatientDao);
       /* String patient = patientService.createPatients(createPatientDao);*/
        return new ResponseEntity<>(patient, HttpStatus.OK);
    }


}

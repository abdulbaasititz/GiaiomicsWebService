package com.itz.giaiomics.usecases.patient_details;


import com.itz.giaiomics.models.NgxAncestry;
import com.itz.giaiomics.models.PatientDetails;
import com.itz.giaiomics.usecases.patient_details.dao.CreatePatientDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("${spring.base.path}")
public class PatientController {
    @Autowired
    PatientService patientService;


    @PostMapping("/patient/create-patient")
    public ResponseEntity<?> createPatient(HttpServletRequest request, @RequestBody CreatePatientDao createPatientDao) throws Exception {
       /* Boolean patient = patientService.createPatient(createPatientDao);*/
        String createPatient = patientService.createPatients(createPatientDao);
        return new ResponseEntity<>(createPatient, HttpStatus.OK);
    }

    @GetMapping("/get/patient-details")
    public ResponseEntity<?> getAllPatientDetails (HttpServletRequest request) throws Exception {
        List<PatientDetails> patientDetails  = patientService.getAllPatientDetails();
        return new ResponseEntity<>(patientDetails, HttpStatus.OK);
    }
    @PostMapping("/patient/update-patient")
    public ResponseEntity<?> updatePatient (HttpServletRequest request, @RequestBody CreatePatientDao createPatientDao) throws Exception {
        String updatePatient = patientService.updatePatients(createPatientDao);
        return new ResponseEntity<>(updatePatient,HttpStatus.OK);
    }

    @DeleteMapping("/patient/delete-patient")
    public ResponseEntity<?> removePatient(HttpServletRequest request, @RequestParam String patientId) throws Exception {
        String removePatient = patientService.removePatient(patientId);
        return new ResponseEntity<>(removePatient, HttpStatus.OK);
    }

}

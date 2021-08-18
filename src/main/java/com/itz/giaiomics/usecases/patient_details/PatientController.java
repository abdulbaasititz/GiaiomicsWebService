package com.itz.giaiomics.usecases.patient_details;


import com.itz.giaiomics.helpers.common.token.ClaimsDao;
import com.itz.giaiomics.helpers.common.token.ClaimsSet;
import com.itz.giaiomics.models.NgxAncestry;
import com.itz.giaiomics.models.PatientDetails;
import com.itz.giaiomics.usecases.patient_details.dao.CreatePatientDao;
import com.itz.giaiomics.usecases.patient_details.pojo.PatientPojo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

import java.util.List;

@Controller
@RequestMapping("${spring.base.path}")
public class PatientController {
    @Autowired
    PatientService patientService;
    @Autowired
    ClaimsSet claimsSet;

    @GetMapping("/get/all/patient-details")
    public ResponseEntity<?> getAllPatientDetails (HttpServletRequest request) throws Exception {
        List<PatientPojo>  patientDetails  = patientService.getAllPatientDetails();
        return new ResponseEntity<>(patientDetails, HttpStatus.OK);
    }

    @GetMapping("/get/patient-detail-by-id")
    public ResponseEntity<?> getPatientDetail(HttpServletRequest request, @RequestParam String patientId) {
        PatientPojo getPatient = patientService.getPatientDetail(patientId);
        return new ResponseEntity<>(getPatient, HttpStatus.OK);
    }

    @PostMapping("/new/create-patient")
    public ResponseEntity<?> createPatient(HttpServletRequest request, @RequestBody CreatePatientDao createPatientDao) throws Exception {
        ClaimsDao claimsDao = claimsSet.getClaimsDetailsAfterSet(request.getHeader("Authorization"));
       /* Boolean patient = patientService.createPatient(createPatientDao);*/
        String createPatient = patientService.createPatients(createPatientDao,claimsDao.getEid());
        return new ResponseEntity<>(createPatient, HttpStatus.OK);
    }

    @PostMapping("/edit/update-patient")
    public ResponseEntity<?> updatePatient (HttpServletRequest request, @RequestBody CreatePatientDao createPatientDao) throws Exception {
        ClaimsDao claimsDao = claimsSet.getClaimsDetailsAfterSet(request.getHeader("Authorization"));
        String updatePatient = patientService.updatePatients(createPatientDao,claimsDao.getEid());
        return new ResponseEntity<>(updatePatient,HttpStatus.OK);
    }

    @DeleteMapping("/del/delete-patient")
    public ResponseEntity<?> removePatient(HttpServletRequest request, @RequestParam String patientId) throws Exception {
        ClaimsDao claimsDao = claimsSet.getClaimsDetailsAfterSet(request.getHeader("Authorization"));
        String removePatient = patientService.removePatient(patientId,claimsDao.getEid());
        return new ResponseEntity<>(removePatient, HttpStatus.OK);
    }

}

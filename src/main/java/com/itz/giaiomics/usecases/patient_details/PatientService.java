package com.itz.giaiomics.usecases.patient_details;


import com.itz.giaiomics.helpers.common.calc.DateTimeCalc;
import com.itz.giaiomics.models.NgxAncestry;
import com.itz.giaiomics.models.PatientDetails;
import com.itz.giaiomics.usecases.patient_details.dao.CreatePatientDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientService {
    @Autowired
    PatientRepository patientRepository;

    /*public Boolean createPatient(CreatePatientDao createPatientDao) {
        Boolean checkPatientId = checkPatientNumber(createPatientDao.getPatientId());
        if (checkPatientId) {
        *//*    int num = 1;
            num++;
            int num2 = num + 1;
            String id = "NGX00"+num2 ;*//*
            PatientDetails createPatient = new PatientDetails();
            createPatient.setId(0);
            createPatient.setPatientId(createPatientDao.getPatientId());
            createPatient.setEntryDate(createPatientDao.getEntryDate());
            createPatient.setFirstName(createPatientDao.getFirstName());
            createPatient.setLastName(createPatientDao.getLastName());
            createPatient.setDateOfBirth(createPatientDao.getDateOfBirth());
            createPatient.setGender(createPatientDao.getGender());
            createPatient.setSampleId(createPatientDao.getSampleId());
            createPatient.setReportId(createPatientDao.getReportId());
            createPatient.setOrderNo(createPatientDao.getOrderNo());
            createPatient.setOrderReceived(createPatientDao.getOrderReceived());
            createPatient.setSampleType(createPatientDao.getSampleType());
            createPatient.setSampleCollectionDate(createPatientDao.getSampleCollectionDate());
            createPatient.setReportDate(createPatientDao.getReportDate());
            patientRepository.save(createPatient);
            return true;
        } else {
            return false;
        }
    }*/

    private Boolean checkPatientNumber(String patientId) {
        PatientDetails createPatient = patientRepository.findByPatientId(patientId);
        return createPatient == null;
    }

    public String createPatients(CreatePatientDao createPatientDao) {
            Boolean checkPatientId = checkPatientNumber(createPatientDao.getPatientId());
            if (checkPatientId) {
                PatientDetails createPatient = new PatientDetails();
                createPatient.setId(0);
                createPatient.setPatientId(createPatientDao.getPatientId());
                createPatient.setEntryDate(createPatientDao.getEntryDate());
                createPatient.setFirstName(createPatientDao.getFirstName());
                createPatient.setLastName(createPatientDao.getLastName());
                createPatient.setDateOfBirth(createPatientDao.getDateOfBirth());
                createPatient.setGender(createPatientDao.getGender());
                createPatient.setSampleId(createPatientDao.getSampleId());
                createPatient.setReportId(createPatientDao.getReportId());
                createPatient.setOrderNo(createPatientDao.getOrderNo());
                createPatient.setOrderReceived(createPatientDao.getOrderReceived());
                createPatient.setSampleType(createPatientDao.getSampleType());
                createPatient.setSampleCollectionDate(createPatientDao.getSampleCollectionDate());
                createPatient.setReportDate(createPatientDao.getReportDate());
                createPatient.setIsActive(createPatientDao.getIsActive());
                patientRepository.save(createPatient);
                return "PATIENT CREATED SUCCESSFULLY";
            } else {
                return "PATIENT ALREADY EXIST";
            }
        }

    public List<PatientDetails> getAllPatientDetails() throws Exception {
        List<PatientDetails> patientDetails;
        try {
            patientDetails = patientRepository.findAllPatient();
        }catch (Exception e){
            throw new Exception(e);
        }
        return patientDetails;
    }

    public String updatePatients(CreatePatientDao createPatientDao) {
        int patientId = getPatientId(createPatientDao.getPatientId());
        if (patientId != 0) {
            PatientDetails createPatient = new PatientDetails();
            createPatient.setId(patientId);
            createPatient.setPatientId(createPatientDao.getPatientId());
            createPatient.setEntryDate(createPatientDao.getEntryDate());
            createPatient.setFirstName(createPatientDao.getFirstName());
            createPatient.setLastName(createPatientDao.getLastName());
            createPatient.setDateOfBirth(createPatientDao.getDateOfBirth());
            createPatient.setGender(createPatientDao.getGender());
            createPatient.setSampleId(createPatientDao.getSampleId());
            createPatient.setReportId(createPatientDao.getReportId());
            createPatient.setOrderNo(createPatientDao.getOrderNo());
            createPatient.setOrderReceived(createPatientDao.getOrderReceived());
            createPatient.setSampleType(createPatientDao.getSampleType());
            createPatient.setSampleCollectionDate(createPatientDao.getSampleCollectionDate());
            createPatient.setReportDate(createPatientDao.getReportDate());
            createPatient.setIsActive(createPatientDao.getIsActive());
            patientRepository.save(createPatient);
            return "PATIENT UPDATED SUCCESSFULLY";
        } else {
            return "PATIENT UPDATED FAILED";
        }
    }

    private Integer getPatientId(String patientId) {
        PatientDetails patientDetails = patientRepository.findByPatientId(patientId);
        if (patientDetails == null) {
            return 0;
        } else {
            return patientDetails.getId();
        }

    }

    public String removePatient(String patientId) {
        PatientDetails patientDetails = patientRepository.findByPatientIdAndIsActive(patientId, 1);
        if (patientDetails != null) {
            String formattedDate = new DateTimeCalc().getTodayDate();
            patientDetails.setIsActive(0);
            patientDetails.setUpAt(formattedDate);
            patientRepository.save(patientDetails);
            return "PATIENT "+patientId+" UPDATED AS INACTIVE";
        } else {
            return "NO PATIENT FOUND AT "+patientId;
        }
    }
}



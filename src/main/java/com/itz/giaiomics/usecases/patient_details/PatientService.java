package com.itz.giaiomics.usecases.create_patient;


import com.itz.giaiomics.models.PatientDetails;
import com.itz.giaiomics.usecases.create_patient.dao.CreatePatientDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PatientService {
    @Autowired
    PatientRepository patientRepository;


    public Boolean createPatient(CreatePatientDao createPatientDao) {
        Boolean checkPatientId = checkPatientNumber(createPatientDao.getPatientId());
        if (checkPatientId) {
        /*    int num = 1;
            num++;
            int num2 = num + 1;
            String id = "NGX00"+num2 ;*/
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
    }

    private Boolean checkPatientNumber(String patientId) {
        PatientDetails createPatient = patientRepository.findByPatientId(patientId);
        return createPatient == null;
    }

/*    public String createPatients(CreatePatientDao createPatientDao) {
            Boolean checkPatientId = checkPatientNumber(createPatientDao.getPatientId());
            if (checkPatientId) {
                CreatePatient createPatient = new CreatePatient();
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
                return "PATIENT CREATED SUCCESSFULLY";
            } else {
                return "PATIENT-ID EXIST ALREADY";
            }
        }*/
}


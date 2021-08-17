package com.itz.giaiomics.usecases.create_patient.dao;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class CreatePatientDao {
    private String patientId;
    private Date entryDate;
    private String firstName;
    private String lastName;
    private Date dateOfBirth;
    private String gender;
    private String sampleId;
    private String reportId;
    private String orderNo;
    private String orderReceived;
    private String sampleType;
    private String sampleCollectionDate;
    private Date reportDate;
}

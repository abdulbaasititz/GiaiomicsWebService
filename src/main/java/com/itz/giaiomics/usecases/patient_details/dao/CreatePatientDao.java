package com.itz.giaiomics.usecases.patient_details.dao;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter

public class CreatePatientDao {
    private String patientId;
    @JsonFormat(pattern="yyyy-MM-dd")
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
    private Date sampleCollectionDate;
    private Date reportDate;
}
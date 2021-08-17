package com.itz.giaiomics.models;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "PatientDetails")
public class PatientDetails {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="Id")
    private int id;
    @Column(name="PatientId")
    private String patientId;
    @Column(name="EntryDate")
    private Date entryDate;
    @Column(name="FirstName")
    private String firstName;
    @Column(name="LastName")
    private String LastName;
    @Column(name="DateOfBirth")
    private Date dateOfBirth;
    @Column(name="Gender")
    private String gender;
    @Column(name="SampleId")
    private String sampleId;
    @Column(name="ReportId")
    private String reportId;
    @Column(name="OrderNo")
    private String orderNo;
    @Column(name="OrderReceived")
    private String orderReceived;
    @Column(name="SampleType")
    private String sampleType;
    @Column(name="SampleCollectionDate")
    private Date sampleCollectionDate;
    @Column(name="ReportDate")
    private Date reportDate;
    @Column(name="IsActive")
    private int isActive;
    @Column(name="CrAt")
    private String crAt;
    @Column(name="CrBy")
    private String crBy;
    @Column(name="UpAt")
    private String upAt;
    @Column(name="UpBy")
    private String upBy;
}

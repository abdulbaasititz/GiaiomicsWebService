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
    @Column(name="id")
    private int id;
    @Column(name="patientId")
    private String patientId;
    @Column(name="entryDate")
    private Date entryDate;
    @Column(name="firstName")
    private String firstName;
    @Column(name="LastName")
    private String LastName;
    @Column(name="dateOfBirth")
    private Date dateOfBirth;
    @Column(name="gender")
    private String gender;
    @Column(name="sampleId")
    private String sampleId;
    @Column(name="reportId")
    private String reportId;
    @Column(name="orderNo")
    private String orderNo;
    @Column(name="orderReceived")
    private String orderReceived;
    @Column(name="sampleType")
    private String sampleType;
    @Column(name="sampleCollectionDate")
    private Date sampleCollectionDate;
    @Column(name="reportDate")
    private Date reportDate;
    @Column(name="isActive")
    private int isActive;
    @Column(name="crAt")
    private String crAt;
    @Column(name="crBy")
    private String crBy;
    @Column(name="upAt")
    private String upAt;
    @Column(name="upBy")
    private String upBy;
}

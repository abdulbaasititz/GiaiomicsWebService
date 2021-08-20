package com.itz.giaiomics.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "ClientDetails")
public class ClientDetails {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="Id")
    private int id;
    @Column(name="ClientId")
    private int clientId;
    @Column(name="ClientName")
    private int clientName;
    @Column(name="CompanyName")
    private int companyName;
    @Column(name="CompanyLogo")
    private int companyLogo;
    @Column(name="CompanySignature")
    private int companySignature;
    @Column(name="IsActive")
    private int isActive;
    @Column(name="CrAt")
    private int crAt;
    @Column(name="CrBy")
    private int crBy;
    @Column(name="UpAt")
    private int upAt;
    @Column(name="UpBy")
    private int upBy;


}

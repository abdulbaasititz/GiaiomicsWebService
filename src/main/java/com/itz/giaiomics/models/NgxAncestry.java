package com.itz.giaiomics.models;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "NgxAncestry")
public class NgxAncestry {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id")
    private int id;
    @Column(name="category")
    private String category;
    @Column(name="snpRsid")
    private String snpRsid;
    @Column(name="snpName")
    private String snpName;
    @Column(name="riskAllele")
    private String riskAllele;
}

package com.itz.giaiomics.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@Table(name = "PgxAncestry")
public class PgxAncestry {
    @Id
    private int id;
    private String snpRsid;
    private String snpName;
    private String category;
    private String riskAllele;
}

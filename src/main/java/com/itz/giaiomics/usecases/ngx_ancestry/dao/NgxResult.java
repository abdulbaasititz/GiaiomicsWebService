package com.itz.giaiomics.usecases.ngx_ancestry.dao;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class NgxResult {
    private String snpRsid;
    private String snpName;
    private String category;
    private String riskAllele;
    private String yourAllele;
//    private String color;
}

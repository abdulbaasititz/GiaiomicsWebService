package com.itz.giaiomics.usecases.ngx_ancestry;


import com.itz.giaiomics.models.NgxAncestry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NgxAncestryService {
    @Autowired
    NgxAncestryRepository ngxAncestryRepository;

    public List<NgxAncestry> getAllNgxAncestry() throws Exception {
        List<NgxAncestry> ngxAncestries;
        try {
            ngxAncestries = ngxAncestryRepository.findAll();
        }catch (Exception e){
            throw new Exception(e);
        }
        return ngxAncestries;
    }


    public List<NgxAncestry> getAllData() {
        List<NgxAncestry> pgxAncestry = ngxAncestryRepository.findAll();

        return pgxAncestry;
    }
}

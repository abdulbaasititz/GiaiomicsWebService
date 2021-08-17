package com.itz.giaiomics.usecases.pgx_ancestry;

import com.itz.giaiomics.models.PgxAncestry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PgxAncestryService {
    @Autowired
    PgxAncestryRepository pgxAncestryRepository;

    public List<PgxAncestry> getAllData() {
        List<PgxAncestry> pgxAncestry = pgxAncestryRepository.findAll();

        return pgxAncestry;
    }
}

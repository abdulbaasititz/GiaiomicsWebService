package com.itz.giaiomics.usecases.pgx_ancestry;

import com.itz.giaiomics.models.PgxAncestry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/api")
public class PgxAncestryController {
    @Autowired
    PgxAncestryService pgxAncestryService;

    @GetMapping("/all")
    public ResponseEntity<?> getAllPgx() {
        List<PgxAncestry> pgxAncestries = pgxAncestryService.getAllData();
        return new ResponseEntity<>(pgxAncestries, HttpStatus.OK);
    }
}

package com.itz.giaiomics.usecases.ngx_ancestry;


import com.itz.giaiomics.models.NgxAncestry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("${spring.base.path}")
public class NgxAncestryController {
    @Autowired
    NgxAncestryService ngxAncestryService;

    @GetMapping("/get/all-ngx-ancestry")
    public ResponseEntity<?> getAllNgxAncestry (HttpServletRequest request) throws Exception {
        List<NgxAncestry> ngxAncestries  = ngxAncestryService.getAllNgxAncestry();
        return new ResponseEntity<>(ngxAncestries, HttpStatus.OK);
    }
}

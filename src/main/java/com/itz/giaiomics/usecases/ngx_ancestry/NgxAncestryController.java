package com.itz.giaiomics.usecases.ngx_ancestry;


import com.itz.giaiomics.helpers.configs.LoggerConfig;
import com.itz.giaiomics.models.NgxAncestry;
import com.itz.giaiomics.usecases.ngx_ancestry.dao.NgxResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("${spring.base.path}"+"/ngx")
public class NgxAncestryController {
    @Autowired
    NgxAncestryService ngxAncestryService;

    private static String UPLOADED_FOLDER = "E://temp//";

    @GetMapping("/get/all-ngx-ancestry")
    public ResponseEntity<?> getAllNgxAncestry (HttpServletRequest request) throws Exception {
        List<NgxAncestry> ngxAncestries  = ngxAncestryService.getAllNgxAncestry();
        return new ResponseEntity<>(ngxAncestries, HttpStatus.OK);
    }

    @PostMapping("/ngx-upload") // //new annotation since 4.3
    public ResponseEntity<?> ngxFileUpload(@RequestParam String patientId,@RequestParam String clientId,@RequestParam(value = "file") MultipartFile file) throws Exception {
        List<NgxAncestry> ngxAncestries = ngxAncestryService.getAllData();
        List<NgxResult> ngxResults = new ArrayList<>();

        String userDirectory = Paths.get("").toAbsolutePath().toString();

        System.out.println("pathName out = " + userDirectory);

        try {
            // Get the file and save it somewhere
            byte[] bytes = file.getBytes();
            String fileName = userDirectory +"//"+ file.getOriginalFilename();
            Path path = Paths.get(fileName);
            Files.write(path, bytes);
            BufferedReader br = new BufferedReader(new FileReader(fileName));
            try {
                String line;
                while ((line = br.readLine()) != null) {
                    if(line.charAt(0) != '#'){
                        String[] word = line.split("\t");
                        for(int i=0;i<ngxAncestries.size();i++){
                            if(word[0].equals(ngxAncestries.get(i).getSnpRsid())){
                                NgxResult ngxResult = new NgxResult();
                                ngxResult.setSnpRsid(ngxAncestries.get(i).getSnpRsid());
                                ngxResult.setCategory(ngxAncestries.get(i).getCategory());
                                ngxResult.setRiskAllele(ngxAncestries.get(i).getRiskAllele());
                                ngxResult.setSnpName(ngxAncestries.get(i).getSnpName());
                                ngxResult.setYourAllele(word[3]);
                                ngxResults.add(ngxResult);
                                //System.out.println(word);
                                i=ngxAncestries.size();
                            }
                        }
                    }
                }
            } finally {
                br.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(ngxResults, HttpStatus.OK);
    }
}

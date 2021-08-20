package com.itz.giaiomics.usecases.client_details;

import com.itz.giaiomics.usecases.client_details.pojo.ClientPojo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("${spring.base.path}")
public class ClientController {
    @Autowired
    ClientService clientService;

    @GetMapping("/get/all/client-details")
    public ResponseEntity<?> getAllClientDetails (HttpServletRequest request) throws Exception {
        List<ClientPojo>  clientDetails  = clientService.getAllClientDetails();
        Map<String,List> result = new HashMap<>();
        result.put("name",clientDetails);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

}

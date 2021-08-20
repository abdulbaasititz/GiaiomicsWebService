package com.itz.giaiomics.usecases.client_details;

import com.itz.giaiomics.models.NgxAncestry;
import com.itz.giaiomics.usecases.client_details.pojo.ClientPojo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientService {
    @Autowired
    ClientRepository clientRepository;

    public List<ClientPojo> getAllClientDetails() {
        List<ClientPojo> clientPojos = clientRepository.findAllClient();
        return clientPojos;
    }

}

package com.itz.giaiomics.usecases.client_details;

import com.itz.giaiomics.models.ClientDetails;
import com.itz.giaiomics.usecases.client_details.pojo.ClientPojo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClientRepository extends JpaRepository<ClientDetails, Integer> {

    @Query(value = "select * from ClientDetails where IsActive = 1 ", nativeQuery = true)
    List<ClientPojo> findAllClient();

}

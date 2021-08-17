package com.itz.giaiomics.usecases.ngx_ancestry;

import com.itz.giaiomics.models.NgxAncestry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NgxAncestryRepository extends JpaRepository<NgxAncestry, Integer>{



}

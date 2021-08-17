package com.itz.giaiomics.usecases.pgx_ancestry;

import com.itz.giaiomics.models.PgxAncestry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PgxAncestryRepository extends JpaRepository<PgxAncestry, String> {

}

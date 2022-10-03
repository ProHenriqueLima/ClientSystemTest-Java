package com.api.testportifolio.repositories;

import com.api.testportifolio.models.ClientModel;
import com.api.testportifolio.models.TaxRegimeModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface TaxRegimeRepository extends JpaRepository<TaxRegimeModel, Long>
{
}

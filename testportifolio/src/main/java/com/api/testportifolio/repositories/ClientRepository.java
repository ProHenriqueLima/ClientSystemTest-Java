package com.api.testportifolio.repositories;

import com.api.testportifolio.models.ClientModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface ClientRepository extends JpaRepository<ClientModel, Long>
{
    @Query(value = "SELECT u FROM ClientModel u WHERE u.email = :email")
    ClientModel verifyExistedUser(@Param("email") String email);

    @Query(value = "SELECT u FROM ClientModel u WHERE u.cnpj = :cnpj")
    ClientModel verifyExistedClientCnpj(@Param("cnpj") String cnpj);

    @Query(value = "SELECT * FROM tb_customers u WHERE u.active = true",nativeQuery = true)
    Collection<ClientModel> usersActive();

    @Query(value = "SELECT * FROM tb_customers u WHERE u.active = false",nativeQuery = true)
    Collection<ClientModel> usersDisabled();
}

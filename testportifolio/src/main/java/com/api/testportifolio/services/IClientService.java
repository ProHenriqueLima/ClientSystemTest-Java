package com.api.testportifolio.services;

import com.api.testportifolio.models.ClientModel;
import org.springframework.http.ResponseEntity;

public interface IClientService {
    ResponseEntity<Object> saveClient(ClientModel clientModel, Long idTaxRegime);
    ResponseEntity<Object> changeStatusClient(Long id);

}

package com.api.testportifolio.services;

import com.api.testportifolio.models.ClientModel;
import com.api.testportifolio.models.TaxRegimeModel;
import com.api.testportifolio.repositories.ClientRepository;
import com.api.testportifolio.repositories.TaxRegimeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;


@Service
public class ClientService {

    @Autowired
    ClientRepository clientRepository;

    @Autowired
    TaxRegimeRepository taxRegimeRepository;

    public ResponseEntity<Object> saveClient(ClientModel clientModel, Long idTaxRegime)
    {
        if (!verifyEmailClient(clientModel.getEmail())){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("This email is already in use !");
        }
        if (!verifyCnpjClient(clientModel.getCnpj())){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("This cnpj is already in use !");
        }
        if (!taxRegimeRepository.findById(idTaxRegime).isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("This tax regime does not exist !");
        }

        Optional<TaxRegimeModel> taxRegimeModelFind = taxRegimeRepository.findById(idTaxRegime);

        TaxRegimeModel taxRegimeModel = null;

        taxRegimeModel = taxRegimeModelFind.get();

        clientModel.setTaxRegime(taxRegimeModel);
        clientModel.setActive(true);
        clientRepository.save(clientModel);

        return ResponseEntity.status(HttpStatus.CREATED).body(clientModel);
    }

    public ResponseEntity<Object> changeStatusClient(Long id){
        if(!verifyClientExist(id)){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("client does not exist.");
        }
        Optional<ClientModel> clientModelOptional = clientRepository.findById(id);
        ClientModel clientModel = clientModelOptional.get();
        clientModel.setActive(!clientModel.getActive());
        return ResponseEntity.status(HttpStatus.OK).body(clientRepository.save(clientModel));

    }
    private boolean verifyEmailClient(String email)
    {
        ClientModel clientModel = clientRepository.verifyExistedUser(email);
        if (clientModel == null){return true;}
        else {return false;}
    }
    private boolean verifyCnpjClient(String cnpj)
    {
        ClientModel clientModel = clientRepository.verifyExistedClientCnpj(cnpj);
        if (clientModel == null){return true;}
        else {return false;}
    }

    private boolean verifyClientExist(Long id){
        Optional<ClientModel> clientModelTest = clientRepository.findById(id);
        if (!clientModelTest.isPresent()){ return false;}
        else {
            return true;
        }
    }
}

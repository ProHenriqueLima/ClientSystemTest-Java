package com.api.testportifolio.controllers;

import com.api.testportifolio.dtos.ClientRequestDto;
import com.api.testportifolio.models.ClientModel;
import com.api.testportifolio.repositories.ClientRepository;
import com.api.testportifolio.services.ClientService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/api/client")
@CrossOrigin(origins = "*")
public class ClientController {

    @Autowired
    ClientService clientService;

    @Autowired
    ClientRepository clientRepository;

    @PostMapping
    public ResponseEntity<Object> saveClient( @Valid @RequestBody ClientRequestDto clientRequestDto){
        var clientModel = new ClientModel();
        BeanUtils.copyProperties(clientRequestDto , clientModel);
        return clientService.saveClient(clientModel,clientRequestDto.getTaxRegimeId());
    }

    @GetMapping("/all")
    public  ResponseEntity<Object> getAllCustomers(){
        return ResponseEntity.status(HttpStatus.OK).body(clientRepository.findAll());
    }

    @GetMapping("/actives")
    public  ResponseEntity<Object> getCustomersActives(){
        return ResponseEntity.status(HttpStatus.OK).body(clientRepository.usersActive());
    }

    @GetMapping("/disabled")
    public  ResponseEntity<Object> getCustomersDisabled(){
        return ResponseEntity.status(HttpStatus.OK).body(clientRepository.usersDisabled());
    }

    @PutMapping("/modifiedStatus/{id}")
    public  ResponseEntity<Object> putModifiedStatus(@PathVariable(value = "id")Long id){
        return ResponseEntity.status(HttpStatus.OK).body(clientService.changeStatusClient(id));
    }
}

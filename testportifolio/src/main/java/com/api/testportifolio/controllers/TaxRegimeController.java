package com.api.testportifolio.controllers;

import com.api.testportifolio.dtos.ClientRequestDto;
import com.api.testportifolio.models.ClientModel;
import com.api.testportifolio.models.TaxRegimeModel;
import com.api.testportifolio.repositories.ClientRepository;
import com.api.testportifolio.repositories.TaxRegimeRepository;
import com.api.testportifolio.services.ClientService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/api/taxregime")
@CrossOrigin(origins = "*")
public class TaxRegimeController {

    @Autowired
    TaxRegimeRepository taxService;

    @GetMapping("/all")
    public  ResponseEntity<Object> getAllCustomers(){
        return ResponseEntity.status(HttpStatus.OK).body(taxService.findAll());
    }


}

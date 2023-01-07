package com.cloud.galactic.catalog.service.controller;

import com.cloud.galactic.openapi.api.PetApi;
import com.cloud.galactic.openapi.model.Pet;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PetController implements PetApi {

    @Override
    public ResponseEntity<Pet> addPet(Pet pet) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }

}

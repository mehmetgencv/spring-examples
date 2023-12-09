package org.mehmetgenc.springbootapidoc.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.mehmetgenc.springbootapidoc.entity.Pet;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
@RestController
@RequestMapping("api/v1/pet")
@Api(value = "Pet API Documentation")
public class PetController {
    private List<Pet> petList = new ArrayList<>();

    @PostConstruct
    public void init(){
        petList.add(new Pet(1, "Test Pet", new Date()));
    }
    @PostMapping("/addPet")
    @ApiOperation(value = "Add new pet method")
    public ResponseEntity<Pet> add(@RequestBody @ApiParam(value = "") Pet pet){
        petList.add(pet);
        return ResponseEntity.ok(pet);
    }

    @GetMapping("/getAll")
    @ApiOperation(value = "Get all pets method")
    public ResponseEntity<List<Pet>> getAll(){
        return ResponseEntity.ok(petList);
    }
}

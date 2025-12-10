package com.pipocavagas.pipoca.controllers;

import com.pipocavagas.pipoca.model.Enterprise;
import com.pipocavagas.pipoca.repositories.EnterpriseRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;


@RestController
@RequestMapping("/enterprise")
public class EnterpriseController {

    private final EnterpriseRepository enterpriseRepository;
    private final List<Enterprise> enterpriseList = new ArrayList<Enterprise>();

    public  EnterpriseController(EnterpriseRepository repository){
        this.enterpriseRepository = repository;
    }

    @GetMapping
    public ResponseEntity<List<Enterprise>> enterprises(){
        List<Enterprise> enterprises = enterpriseRepository.findAll();
        return ResponseEntity.ok(enterprises);
    }

    @PostMapping
    public ResponseEntity<Void> register(@RequestBody Enterprise enterprise){
        enterpriseRepository.save(enterprise);
        return ResponseEntity.ok().build();
    }

    @PatchMapping
    public ResponseEntity<Void> update (
            @RequestParam Long enterpriseId,
            @RequestBody(required = false) Enterprise  updateEnterpriseDTO){
        Enterprise enterpriseExists = enterpriseList.stream().filter(enterprise -> enterprise.getId().equals(enterpriseId)).findFirst().orElse(null);

        if(enterpriseExists == null){
            return ResponseEntity.notFound().build();
        }

        if(updateEnterpriseDTO.getEmail() != null) {
            enterpriseExists.setEmail(updateEnterpriseDTO.getEmail());
        }

        if(updateEnterpriseDTO.getName() != null){
            enterpriseExists.setName(updateEnterpriseDTO.getName());
        }

        return ResponseEntity.ok().build();
    }

    @DeleteMapping
    public ResponseEntity<Void> delete (@RequestParam Long enterpriseId){
       Optional<Enterprise> enterpriseExists = enterpriseList.stream().filter(enterprise -> enterprise.getId().equals(enterpriseId)).findFirst();
        enterpriseExists.ifPresent(enterpriseList::remove);

        return ResponseEntity.ok().build();
    }
}

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
        Enterprise enterpriseExists = enterpriseRepository.findById(enterpriseId).orElse(null);

        if(enterpriseExists == null){
            throw new Error("Empresa não encontrada");
        }

        if(updateEnterpriseDTO.getName() != null){
            enterpriseExists.setName(updateEnterpriseDTO.getName());
        }

        if(updateEnterpriseDTO.getEmail() != null){
            enterpriseExists.setEmail(updateEnterpriseDTO.getEmail());
        }

        enterpriseRepository.save(enterpriseExists);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping
    public ResponseEntity<Void> delete (@RequestParam Long enterpriseId){
        enterpriseRepository.deleteById(enterpriseId);
        return ResponseEntity.ok().build();
    }
}

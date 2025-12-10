package com.pipocavagas.pipoca.controllers;

import com.pipocavagas.pipoca.model.Enterprise;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/enterprise")
public class enterprise {

    private final List<Enterprise> enterpriseList = new ArrayList<Enterprise>();

    @GetMapping("/")
    public ResponseEntity<List<Enterprise>> enterprises(){
        return ResponseEntity.ok(enterpriseList);
    }

    @PostMapping("/")
    public ResponseEntity<Void> register(@RequestBody Enterprise enterprise){
        enterpriseList.add(enterprise);
        return ResponseEntity.ok().build();
    }

    @PatchMapping("/")
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

    @DeleteMapping("/")
    public ResponseEntity<Void> delete (@RequestParam Long enterpriseId){
        Enterprise enterpriseExists = enterpriseList.stream().filter(enterprise -> enterprise.getId().equals(enterpriseId));

        return ResponseEntity.ok().build();
    }
}

package com.pipocavagas.pipoca.services;

import com.pipocavagas.pipoca.model.Enterprise;
import com.pipocavagas.pipoca.repositories.EnterpriseRepository;

public class EnterpriseService {
    private EnterpriseRepository enterpriseRepository;

    public Enterprise findEnterpriseById(Long enterpriseId){
        return enterpriseRepository.findById(enterpriseId).orElseThrow(() -> new Error("Empresa não encontrada"));
    }

    public void createEnterprise(Enterprise enterpriseDTO){
        enterpriseRepository.save(enterpriseDTO);
    }

    public void updateEnterprise(Long enterpriseId, Enterprise updateEnterpriseDTO){
        enterpriseRepository.findById(enterpriseId).orElseThrow(() ->
            new Error("Empresa não encontrada")
        );

        enterpriseRepository.save(updateEnterpriseDTO);
    }
}

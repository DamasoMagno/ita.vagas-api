package com.pipocavagas.pipoca.services;

import com.pipocavagas.pipoca.model.Enterprise;
import com.pipocavagas.pipoca.repositories.EnterpriseRepository;
import org.springframework.web.ErrorResponseException;

public class EnterpriseServie {
    private EnterpriseRepository enterprise;

    public Enterprise findEnterpriseById(Long enterpriseId){
        Enterprise enterprise1 = enterprise.findById(enterpriseId).orElse(null);

        if(enterprise1 == null){
            throw new Error("Empresa não encontrada");
        }

        return enterprise1;
    }

    public void createEnterprise(Enterprise enterpriseDTO){
        enterprise.save(enterpriseDTO);
    }

    public void updateEnterprise(Long enterpriseId, Enterprise updateEnterpriseDTO){
        enterprise.findById(enterpriseId).orElseThrow(() -> {
            throw new Error("Empresa não encontrada");
        });

        enterprise.save(updateEnterpriseDTO);
    }
}

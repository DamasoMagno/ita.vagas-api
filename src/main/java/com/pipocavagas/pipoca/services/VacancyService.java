package com.pipocavagas.pipoca.services;

import com.pipocavagas.pipoca.model.Vacancy;
import com.pipocavagas.pipoca.repositories.VacancyRepository;

public class VacancyService {
    private VacancyRepository vacancyRepository;

    public Vacancy findVacancyById(Long VacancyId){
        return vacancyRepository.findById(VacancyId).orElseThrow(() -> new Error("Empresa não encontrada"));
    }

    public void createVacancy(Vacancy VacancyDTO){
        vacancyRepository.save(VacancyDTO);
    }

    public void updateVacancy(Long VacancyId, Vacancy updateVacancyDTO){
        vacancyRepository.findById(VacancyId).orElseThrow(() ->
            new Error("Empresa não encontrada")
        );

        vacancyRepository.save(updateVacancyDTO);
    }
}

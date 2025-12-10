package com.pipocavagas.pipoca.repositories;

import com.pipocavagas.pipoca.model.Enterprise;
import org.springframework.data.jpa.repository.JpaRepository;

public abstract class EnterpriseRepository implements JpaRepository<Enterprise, Long> {
}

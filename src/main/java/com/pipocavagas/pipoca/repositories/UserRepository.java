package com.pipocavagas.pipoca.repositories;

import com.pipocavagas.pipoca.model.Enterprise;
import com.pipocavagas.pipoca.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}

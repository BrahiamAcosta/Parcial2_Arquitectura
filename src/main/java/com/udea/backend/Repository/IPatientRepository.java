package com.udea.backend.Repository;

import com.udea.backend.Entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IPatientRepository extends JpaRepository<Patient, Long> {
    Optional<Patient> findPatientByCc(String Cc);
}

package com.udea.backend.Repository;

import com.udea.backend.Entity.MedicalHistory;
import com.udea.backend.Entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IMedicalHistoryRepository extends JpaRepository<MedicalHistory, Long> {
    List<MedicalHistory> findMedicalHistoriesByPatient(Patient patient);
}

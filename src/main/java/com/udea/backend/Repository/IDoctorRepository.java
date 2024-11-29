package com.udea.backend.Repository;

import com.udea.backend.Entity.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IDoctorRepository extends JpaRepository<Doctor, Long> {
    Doctor findDoctorByCedulaProfesional(String cedulaProfesional);
}

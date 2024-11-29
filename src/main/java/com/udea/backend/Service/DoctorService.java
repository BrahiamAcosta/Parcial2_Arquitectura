package com.udea.backend.Service;

import com.udea.backend.Entity.Doctor;
import com.udea.backend.Repository.IDoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DoctorService {
    private final IDoctorRepository doctorRepository;

    public DoctorService(IDoctorRepository doctorRepository){
        this.doctorRepository = doctorRepository;
    }

    public Doctor createDoctor(String nombre, String apellido, String cedulaProfesional, String especialidad){
        Doctor doctor = new Doctor();
        doctor.setNombre(nombre);
        doctor.setApellido(apellido);
        doctor.setCedulaProfesional(cedulaProfesional);
        doctor.setEspecialidad(especialidad);
        return doctorRepository.save(doctor);
    }

    public Doctor doctorByCedulaProfesional(String cedulaProfesional){
        Doctor doctor = doctorRepository.findDoctorByCedulaProfesional(cedulaProfesional);
        if (doctor == null){
            throw new RuntimeException("Doctor not found");
        }
        return doctor;
    }
}

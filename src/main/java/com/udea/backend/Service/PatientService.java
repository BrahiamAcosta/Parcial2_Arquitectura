package com.udea.backend.Service;

import com.udea.backend.Entity.Patient;
import com.udea.backend.Repository.IPatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PatientService {
    private final IPatientRepository patientRepository;

    public PatientService(IPatientRepository patientRepository){
        this.patientRepository = patientRepository;
    }

    public Patient patientByCc(String cc){
        return patientRepository.findPatientByCc(cc).orElseThrow(()->new RuntimeException("Patient not found"));
    }

    public Patient createPatient(String nombre, String apellido, String cc, Integer edad, String genero){
        Patient patient = new Patient();
        patient.setNombre(nombre);
        patient.setApellido(apellido);
        patient.setCc(cc);
        patient.setEdad(edad);
        patient.setGenero(genero);
        return patientRepository.save(patient);
    }
}

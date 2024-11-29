package com.udea.backend.Service;

import com.udea.backend.Entity.Doctor;
import com.udea.backend.Entity.MedicalHistory;
import com.udea.backend.Entity.Patient;
import com.udea.backend.Repository.IMedicalHistoryRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class MedicalHistoryService {
    private final IMedicalHistoryRepository medicalHistoryRepository;
    private final DoctorService doctorService;
    private final PatientService patientService;

    public MedicalHistoryService(IMedicalHistoryRepository medicalHistoryRepository,
                                 DoctorService doctorService,
                                 PatientService patientService) {
        this.medicalHistoryRepository = medicalHistoryRepository;
        this.doctorService = doctorService;
        this.patientService = patientService;
    }


    public List<MedicalHistory> medicalHistoriesByPatientCc(String cedula){
        Patient patient = patientService.patientByCc(cedula);
        List<MedicalHistory> histories = medicalHistoryRepository.findMedicalHistoriesByPatient(patient);
        if (histories.isEmpty()){
            throw new RuntimeException("Medical histories not found");
        }
        return histories;
    }

    public MedicalHistory createMedicalHistory(String patientNombre, String patientApellido,
                                               String patientCc, Integer patientEdad, String patientGenero,
                                               String doctorCedulaProfesional, String motivoConsulta,
                                               String diagnostico, String tratamiento, LocalDate fecha){
        Doctor doctor = doctorService.doctorByCedulaProfesional(doctorCedulaProfesional);
        Patient patient;
        try {
            patient = patientService.patientByCc(patientCc);
        } catch (RuntimeException e){
            patient = patientService.createPatient(patientNombre, patientApellido, patientCc, patientEdad, patientGenero);
        }
        MedicalHistory medicalHistory = new MedicalHistory();
        medicalHistory.setPatient(patient);
        medicalHistory.setDoctor(doctor);
        medicalHistory.setMotivoConsutla(motivoConsulta);
        medicalHistory.setDiagnostico(diagnostico);
        medicalHistory.setTratamiento(tratamiento);
        medicalHistory.setFecha(fecha);

        return medicalHistoryRepository.save(medicalHistory);
    }
}

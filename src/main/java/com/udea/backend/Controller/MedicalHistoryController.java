package com.udea.backend.Controller;

import com.udea.backend.Entity.MedicalHistory;
import com.udea.backend.Service.MedicalHistoryService;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.time.LocalDate;
import java.util.List;

@Controller
public class MedicalHistoryController {
    private final MedicalHistoryService medicalHistoryService;

    public MedicalHistoryController(MedicalHistoryService medicalHistoryService) {
        this.medicalHistoryService = medicalHistoryService;
    }

    @QueryMapping
    public List<MedicalHistory> medicalHistoriesByPatientCc(@Argument String cedula){
        return medicalHistoryService.medicalHistoriesByPatientCc(cedula);
    }

    @MutationMapping
    public MedicalHistory createMedicalHistory(@Argument String patientNombre, @Argument String patientApellido,
                                               @Argument String patientCc, @Argument Integer  patientEdad, @Argument String patientGenero,
                                               @Argument String doctorCedulaProfesional, @Argument String motivoConsulta,
                                               @Argument String diagnostico, @Argument String tratamiento, @Argument String fecha){
        return medicalHistoryService.createMedicalHistory(patientNombre, patientApellido, patientCc, patientEdad, patientGenero,
                doctorCedulaProfesional, motivoConsulta, diagnostico, tratamiento, LocalDate.parse(fecha));
    }
}

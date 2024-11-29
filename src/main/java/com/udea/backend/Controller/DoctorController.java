package com.udea.backend.Controller;

import com.udea.backend.Entity.Doctor;
import com.udea.backend.Service.DoctorService;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.stereotype.Controller;

@Controller
public class DoctorController {
    private final DoctorService doctorService;

    public DoctorController(DoctorService doctorService) {
        this.doctorService = doctorService;
    }

    @MutationMapping
    public Doctor createDoctor(@Argument String nombre, @Argument String apellido, @Argument String cedulaProfesional, @Argument String especialidad){
        return doctorService.createDoctor(nombre, apellido, cedulaProfesional, especialidad);
    }
}

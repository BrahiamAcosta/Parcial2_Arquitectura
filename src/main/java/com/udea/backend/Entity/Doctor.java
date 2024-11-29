package com.udea.backend.Entity;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Doctor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String apellido;
    private String cedulaProfesional;
    private String especialidad;

    @OneToMany(mappedBy = "doctor", cascade = CascadeType.ALL)
    private List<MedicalHistory> medicalHistories;
}

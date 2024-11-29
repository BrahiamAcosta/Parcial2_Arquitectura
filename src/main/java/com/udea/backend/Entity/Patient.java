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
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String apellido;
    private String cc;
    private Integer edad;
    private String genero;

    @OneToMany(mappedBy = "patient", cascade = CascadeType.ALL)
    private List<MedicalHistory> medicalHistories;
}

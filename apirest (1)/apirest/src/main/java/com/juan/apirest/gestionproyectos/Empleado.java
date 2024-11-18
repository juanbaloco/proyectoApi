package com.juan.apirest.gestionproyectos;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "empleados")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Empleado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_empleados")  // Asegúrate de que esto coincida con la BD
    private Long idEmpleado;

    @Column(name = "nombre_empleados")
    private String nombreEmpleado;

    @Column(name = "cargo_empleado")
    private String cargoEmpleado;

    @Column(name = "correo_empleado")
    private String correoEmpleado;

    @Column(name = "lider_proyecto")
    private boolean liderProyecto;

    // Relación con Proyecto
    @ManyToOne
    @JoinColumn(name = "id_proyecto")  
    private Proyecto proyecto;
}

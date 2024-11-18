package com.juan.apirest.gestionproyectos;

public class ProyectoTareaDTO {
    private Long id_proyecto; 
    private String estado;
    private Long id_tarea; 

    // Constructor
    public ProyectoTareaDTO(Long id_proyecto, String estado, Long id_tarea) {
        this.id_proyecto = id_proyecto;
        this.estado = estado;
        this.id_tarea = id_tarea;
    }

    // Getters y setters
    public Long getId_proyecto() {
        return id_proyecto;
    }

    public void setId_proyecto(Long id_proyecto) {
        this.id_proyecto = id_proyecto;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Long getId_tarea() {
        return id_tarea;
    }

    public void setId_tarea(Long id_tarea) {
        this.id_tarea = id_tarea;
    }
}

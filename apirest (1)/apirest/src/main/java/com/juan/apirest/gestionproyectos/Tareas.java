package com.juan.apirest.gestionproyectos;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity

@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tareas")
public class Tareas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_tarea")
    private Long idTarea;

    @Column(name = "nombre_tarea")
    private String nombreTarea;

    @Column(name = "estado")
    private String estado;
    
    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "tipo_tarea")
    private String tipoTarea;

    @Column(name = "fecha_inicio_tarea")
    private String fechaInicioTarea;

    @Column(name = "fecha_entrega_tarea")
    private String fechaEntregaTarea;
    

    // Relación con Proyecto
    @ManyToOne
    @JoinColumn(name = "id_empleado")
    private Empleado empleado;

    @ManyToOne
    @JoinColumn(name = "id_proyecto")
    private Proyecto proyecto;

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion= descripcion;
    }

    public String getTipoTarea() {
        return tipoTarea;
    }
    public void setTipoTarea(String tipoTarea){
        this.tipoTarea= tipoTarea;
    }

    public String getFechaInicioTarea(){
        return fechaInicioTarea;

    }
    public void setFechaInicioTarea(String fechaInicioTarea){
        this.fechaInicioTarea= fechaInicioTarea;
    }

    public String getFechaEntregaTarea(){
        return fechaEntregaTarea;
    
    }
    public void setFechaEntregaTarea(String fechaEntregaTarea){
        this.fechaEntregaTarea= fechaEntregaTarea;
    }
    public String getEstado(){
        return estado;
    }

    public void setEstado(String estado){
        this.estado= estado;
    }

}

package com.juan.apirest.gestionproyectos;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.ColumnResult;
import jakarta.persistence.ConstructorResult;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SqlResultSetMapping;
import jakarta.persistence.Table;

@Entity
@SqlResultSetMapping(
    name = "ProyectoTareaDTOMapping",
    classes = @ConstructorResult(
        targetClass = ProyectoTareaDTO.class,
        columns = {
            @ColumnResult(name = "id_proyecto", type = Long.class),
            @ColumnResult(name = "estado", type = String.class),
            @ColumnResult(name = "id_tarea", type = Long.class)
        }
    )
)

@Table(name = "proyectos")
public class Proyecto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_proyecto")  // Mapea a la columna 'id_proyecto'
    private Long id;

    @Column(name = "nombre_proyecto")
    private String nombreProyecto;

    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "tipo_proyecto")
    private String tipoProyecto;

    @Column(name = "costo_planteado")
    private Float costoPlanteado;

    @Column(name = "costo_final")
    private Float costoFinal;

    @Column(name = "estado")
    private String estado;

    @Column(name = "fecha_inicio")
    private LocalDate fechaInicio;

    @Column(name = "fecha_entrega")
    private LocalDate fechaEntrega;

    @Column(name = "presupuesto_no_usado")
    private Float presupuestoNoUsado;

    @Column(name = "concepto")
    private String concepto;

    // Getters y setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombreProyecto() {
        return nombreProyecto;
    }

    public void setNombreProyecto(String nombreProyecto) {
        this.nombreProyecto = nombreProyecto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getTipoProyecto() {
        return tipoProyecto;
    }

    public void setTipoProyecto(String tipoProyecto) {
        this.tipoProyecto = tipoProyecto;
    }

    public Float getCostoPlanteado() {
        return costoPlanteado;
    }

    public void setCostoPlanteado(Float costoPlanteado) {
        this.costoPlanteado = costoPlanteado;
    }

    public Float getCostoFinal() {
        return costoFinal;
    }

    public void setCostoFinal(Float costoFinal) {
        this.costoFinal = costoFinal;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(LocalDate fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public LocalDate getFechaEntrega() {
        return fechaEntrega;
    }

    public void setFechaEntrega(LocalDate fechaEntrega) {
        this.fechaEntrega = fechaEntrega;
    }

    public Float getPresupuestoNoUsado() {
        return presupuestoNoUsado;
    }

    public void setPresupuestoNoUsado(Float presupuestoNoUsado) {
        this.presupuestoNoUsado = presupuestoNoUsado;
    }

    public String getConcepto() {
        return concepto;
    }

    public void setConcepto(String concepto) {
        this.concepto = concepto;
    }
}

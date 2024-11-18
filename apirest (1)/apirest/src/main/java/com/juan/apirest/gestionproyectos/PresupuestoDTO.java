package com.juan.apirest.gestionproyectos;

public class PresupuestoDTO {

    private float costoFinal;  // El costo final del proyecto
    private String concepto;   // El concepto o descripción del gasto

    // Constructor vacío
    public PresupuestoDTO() {}

    // Constructor con parámetros
    public PresupuestoDTO(Float costoFinal, String concepto) {
        this.costoFinal = costoFinal;
        this.concepto = concepto;
    }

    // Getters y setters
    public Float getCostoFinal() {
        return costoFinal;
    }

    public void setCostoFinal(Float costoFinal) {
        this.costoFinal = costoFinal;
    }

    public String getConcepto() {
        return concepto;
    }

    public void setConcepto(String concepto) {
        this.concepto = concepto;
    }
}


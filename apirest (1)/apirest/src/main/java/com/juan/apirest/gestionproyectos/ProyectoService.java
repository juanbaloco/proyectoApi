package com.juan.apirest.gestionproyectos;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.StoredProcedureQuery;

@Service
public class ProyectoService {

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    private ProyectoRepository proyectoRepository;


    @Autowired
    private JdbcTemplate jdbcTemplate; 
   
    @SuppressWarnings("unchecked")
public List<ProyectoTareaDTO> obtenerProyectosConTareasSinIniciar() {
    StoredProcedureQuery query = entityManager.createStoredProcedureQuery(
        "ejecutarTareasSinIniciar", 
        "ProyectoTareaDTOMapping"
    );
    query.execute();
    return query.getResultList();
    
}
public List<Proyecto> obtenerProyectosAntiguos() {
    String sql = "SELECT id_proyecto, nombre_proyecto, fecha_inicio, fecha_entrega FROM vista_proyectosAntiguos"; // Consulta SQL directa
    return jdbcTemplate.query(sql, (rs, rowNum) -> {
        Proyecto proyecto = new Proyecto();
        proyecto.setId(rs.getLong("id_proyecto")); // Mapeo de id_proyecto
        proyecto.setNombreProyecto(rs.getString("nombre_proyecto")); // Mapeo de nombre_proyecto
        proyecto.setFechaInicio(rs.getDate("fecha_inicio").toLocalDate()); // Mapeo de fecha_inicio
        proyecto.setFechaEntrega(rs.getDate("fecha_entrega").toLocalDate()); // Mapeo de fecha_entrega
        return proyecto;
    });
}

    public Proyecto actualizarPresupuesto(Long id, PresupuestoDTO presupuestoDTO) {
        // Obtener el proyecto existente
        Proyecto proyecto = proyectoRepository.findById(id).orElseThrow(() -> new RuntimeException("Proyecto no encontrado"));
        
        // Actualizar el presupuesto final y el concepto
        proyecto.setCostoFinal(presupuestoDTO.getCostoFinal());
        proyecto.setConcepto(presupuestoDTO.getConcepto());

        // Actualizar el presupuesto disponible
        Float presupuestoNoUsado = proyecto.getPresupuestoNoUsado();
        proyecto.setPresupuestoNoUsado(presupuestoNoUsado - presupuestoDTO.getCostoFinal());

        // Guardar los cambios en la base de datos
        return proyectoRepository.save(proyecto);
    }

    public List<Proyecto> obtenerTodosProyectos() {
        return proyectoRepository.findAll();
    }

    public Proyecto obtenerProyectoPorId(Long id) {
        return proyectoRepository.findById(id).orElseThrow(() -> new RuntimeException("Proyecto no encontrado"));
    }

    public Proyecto crearProyecto(Proyecto proyecto) {
        return proyectoRepository.save(proyecto);
    }

    
    public Proyecto actualizarProyecto(Long id, Proyecto nuevoProyecto) {
        Proyecto proyectoExistente = proyectoRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Proyecto no encontrado"));

        // Actualiza los campos del proyecto con los valores del nuevoProyecto
        proyectoExistente.setNombreProyecto(nuevoProyecto.getNombreProyecto());
        proyectoExistente.setDescripcion(nuevoProyecto.getDescripcion());
        proyectoExistente.setTipoProyecto(nuevoProyecto.getTipoProyecto());
        proyectoExistente.setCostoPlanteado(nuevoProyecto.getCostoPlanteado());
        proyectoExistente.setCostoFinal(nuevoProyecto.getCostoFinal());
        proyectoExistente.setEstado(nuevoProyecto.getEstado());
        proyectoExistente.setFechaInicio(nuevoProyecto.getFechaInicio());
        proyectoExistente.setFechaEntrega(nuevoProyecto.getFechaEntrega());
        proyectoExistente.setPresupuestoNoUsado(nuevoProyecto.getPresupuestoNoUsado());
        proyectoExistente.setConcepto(nuevoProyecto.getConcepto());

        return proyectoRepository.save(proyectoExistente); // Guardar el proyecto actualizado
    }


    public void eliminarProyecto(Long id) {
        Proyecto proyecto = proyectoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Proyecto no encontrado"));

        proyectoRepository.delete(proyecto);
    }
}

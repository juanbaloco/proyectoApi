package com.juan.apirest.gestionproyectos;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.Data;

@Data
@RestController
@RequestMapping("/gestionproyectos")
public class ProyectoController {

    private final ProyectoService proyectoService;

    public ProyectoController(ProyectoService proyectoService) {
        this.proyectoService = proyectoService;
    }

    @GetMapping("/proyectos")
    public ResponseEntity<List<Proyecto>> obtenerTodosProyectos() {
        List<Proyecto> proyectos = proyectoService.obtenerTodosProyectos();
        return new ResponseEntity<>(proyectos, HttpStatus.OK);
    }

    @PostMapping("/proyectos")
    public ResponseEntity<Proyecto> crearProyecto(@RequestBody Proyecto proyecto) {
        Proyecto nuevoProyecto = proyectoService.crearProyecto(proyecto);
        return new ResponseEntity<>(nuevoProyecto, HttpStatus.CREATED);
    }

    @GetMapping("/proyectos/{id}")
    public ResponseEntity<Proyecto> obtenerProyectoPorId(@PathVariable Long id) {
        Proyecto proyecto = proyectoService.obtenerProyectoPorId(id);
        return new ResponseEntity<>(proyecto, HttpStatus.OK);
    }

    @PutMapping("/proyectos/{id}")
    public ResponseEntity<Proyecto> actualizarProyecto(@PathVariable Long id, @RequestBody Proyecto proyecto) {
    Proyecto proyectoActualizado = proyectoService.actualizarProyecto(id, proyecto);
    return ResponseEntity.ok(proyectoActualizado);
    }   

    @DeleteMapping("/proyectos/{id}")
    public ResponseEntity<Void> eliminarProyecto(@PathVariable Long id) {
        proyectoService.eliminarProyecto(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/tareas-sin-iniciar")
    public List<ProyectoTareaDTO> obtenerProyectosConTareasSinIniciar() {
        return proyectoService.obtenerProyectosConTareasSinIniciar();
    }

    @PutMapping("/proyectos/presupuesto/{id}")
    public ResponseEntity<Proyecto> actualizarPresupuesto(@PathVariable Long id, @RequestBody PresupuestoDTO presupuestoDTO) {
        Proyecto proyectoActualizado = proyectoService.actualizarPresupuesto(id, presupuestoDTO);
        return new ResponseEntity<>(proyectoActualizado, HttpStatus.OK);
    }

    @GetMapping("/antiguos")
    public List<Proyecto> obtenerProyectosAntiguos() {
        return proyectoService.obtenerProyectosAntiguos();
    }
}

package com.juan.apirest.gestionproyectos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface TareasRepository extends JpaRepository<Tareas, Long> {

    
}

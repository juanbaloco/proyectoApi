create database db_proyecto;

use db_proyecto;

create table proyectos (
	id_proyecto int not null,
    nombre_proyecto varchar(100),
    descripcion varchar (250),
    tipo_proyecto varchar(200),
    costo_planteado float,
    costo_final float,
    estado varchar(100),
    fecha_inicio date,
    fecha_entrega date,
    primary key (id_proyecto)
);

create table empleados (
	id_empleados int not null,
    nombre_empleados varchar(200),
    cargo_empleado varchar(100),
    correo_empleado varchar(100),
    lider_proyecto boolean,
    id_proyecto int,
    primary key (id_empleados),
    foreign key (id_proyecto) references proyectos(id_proyecto)
);

create table tareas(
	id_tarea int not null,
    id_proyecto int,
    id_empleado int,
    descripcion varchar(200),
    tipo_tarea varchar(100),
    fecha_inicio_tarea date,
    fecha_entrega_tarea date,
    estado varchar(100),
    primary key (id_tarea),
    foreign key (id_proyecto) references proyectos(id_proyecto),
    foreign key (id_empleado) references empleados(id_empleados)
);

insert into proyectos(id_proyecto, nombre_proyecto, descripcion, tipo_proyecto, costo_planteado, costo_final, estado, fecha_inicio, fecha_entrega)
values (1, "Recolección de Datos", "Inicio de la recolección de datos para...", "", 1000000, 800000,  "completado", '2024-10-29','2026-03-25');



insert into proyectos(id_proyecto, nombre_proyecto, descripcion, tipo_proyecto, costo_planteado, costo_final, estado, fecha_inicio, fecha_entrega)
values (2, "Analisis de Datos", "Inicio del analisis de datos para...", "", 15000000, 20000000, "planteado",'2024-08-08' ,'2025-08-09');

insert into proyectos(id_proyecto, nombre_proyecto, descripcion, tipo_proyecto, costo_planteado, costo_final, estado, fecha_inicio, fecha_entrega)
values (3, "Analisis de precios", "Inicio del analisis de precios para...", "", 15000000, 20000000, "planteado",'2024-08-08' ,'2026-08-09');


insert into empleados(id_empleados, nombre_empleados, cargo_empleado, correo_empleado, lider_proyecto, id_proyecto)
values (1, "Juan Carlos", "Auxiliar estadistico",  "juanC@gmail.com", true, 1);

insert into empleados(id_empleados, nombre_empleados, cargo_empleado, correo_empleado, lider_proyecto, id_proyecto)
values (2, "Nicolas", "Auxiliar estadistico",  "Nicolas@gmail.com", false, 1);

insert into empleados(id_empleados, nombre_empleados, cargo_empleado, correo_empleado, lider_proyecto, id_proyecto)
values (3, "Jennifer", "Analista",  "jenni@gmail.com", true, 2);

insert into tareas (id_tarea, id_proyecto, id_empleado, descripcion, tipo_tarea, fecha_inicio_tarea, fecha_entrega_tarea, estado)
values(1, 1, 1, "Entrevistas", "trabajo de campo", '2023-12-12', '2024-09-09', "completado" );

insert into tareas (id_tarea, id_proyecto, id_empleado, descripcion, tipo_tarea, fecha_inicio_tarea, fecha_entrega_tarea, estado)
values(2, 1, 1, "Entrevistas", "trabajo de campo", '2023-05-06', '2024-07-07', "completado" );

insert into tareas (id_tarea, id_proyecto, id_empleado, descripcion, tipo_tarea, fecha_inicio_tarea, fecha_entrega_tarea, estado)
values(3, 2, 3, "Compilación de datos", "trabajo de oficina", '2024-10-29', '2024-11-30', "sin empezar" );


select m.nombre_empleados, p.nombre_proyecto, p.estadoperson
from empleados m inner join proyectos p on m.id_proyecto =  p.id_proyecto
having p.estado = "completado";

select t.descripcion, p.nombre_proyecto
from tareas t inner join proyectos p on t.id_proyecto = p.id_proyecto;

select id_proyecto, nombre_proyecto, estado
from proyectos;

select id_tarea, estado
from tareas;

-- actualizar datos --
update tareas set estado = "empezada" where id_tarea = 3;
update proyectos set fecha_inicio ='2022-12-31' where id_proyecto = 1;
update proyectos set estado = "sin finalizar" where id_proyecto = 2;




 -- vista de proyectos antiguos a 18 meses -- 
create view  vista_proyectosAntiguos as
select id_proyecto,nombre_proyecto,fecha_inicio,fecha_entrega
from proyectos
where datediff(curdate(), fecha_inicio)> 547 ;
select * from vista_proyectosAntiguos;

-- vista general de tablas -- 
select * from tareas;
select * from proyectos;

ALTER TABLE proyectos ADD presupuesto_no_usado FLOAT ;
ALTER TABLE proyectos ADD concepto VARCHAR(100);


-- Llamar al procedimiento para actualizar presupuesto
CALL actualizar_presupuesto(1, 50000, 'Compra de materiales');

-- Verificar los cambios
SELECT * FROM proyectos;

insert into tareas (id_tarea, id_proyecto, id_empleado, descripcion, tipo_tarea, fecha_inicio_tarea, fecha_entrega_tarea, estado)
values(4, 3, 3, "Compilación de datos", "trabajo de oficina", '2024-10-29', '2024-11-30', "sin finalizar" );

update tareas set estado = "sin iniciar" where id_tarea = 1;
 
call ejecutarTareasSinIniciar;
-- acciones que se tuvieron que hacer para la api -- 
SHOW PROCEDURE STATUS WHERE Name = 'ejecutarTareasSinFin';

DESCRIBE proyectos;
ALTER TABLE proyectos MODIFY COLUMN id_proyecto BIGINT NOT NULL AUTO_INCREMENT;
SHOW CREATE TABLE empleados;
SHOW CREATE TABLE tareas;

-- Eliminar la clave foránea en la tabla 'empleados'
ALTER TABLE empleados DROP FOREIGN KEY empleados_ibfk_1;

-- Eliminar la clave foránea en la tabla 'tareas'
ALTER TABLE tareas DROP FOREIGN KEY tareas_ibfk_1;


-- Modificar la columna 'id_proyecto' en la tabla 'proyectos'
ALTER TABLE proyectos MODIFY COLUMN id_proyecto BIGINT NOT NULL AUTO_INCREMENT;



-- Modificar la columna 'id_proyecto' en la tabla 'empleados' a BIGINT
ALTER TABLE empleados MODIFY COLUMN id_proyecto BIGINT;

-- Modificar la columna 'id_proyecto' en la tabla 'tareas' a BIGINT
ALTER TABLE tareas MODIFY COLUMN id_proyecto BIGINT;

-- Crear nuevamente la clave foránea en la tabla 'empleados'
ALTER TABLE empleados
ADD CONSTRAINT empleados_ibfk_1 FOREIGN KEY (id_proyecto) REFERENCES proyectos(id_proyecto);

-- Crear nuevamente la clave foránea en la tabla 'tareas'
ALTER TABLE tareas
ADD CONSTRAINT tareas_ibfk_1 FOREIGN KEY (id_proyecto) REFERENCES proyectos(id_proyecto);

-- Asegúrate de que la columna id_proyecto sea BIGINT y autoincremental
ALTER TABLE proyectos MODIFY COLUMN id_proyecto BIGINT NOT NULL AUTO_INCREMENT;

SELECT * FROM proyectos WHERE id = 1;

ALTER TABLE proyectos DROP COLUMN presupuesto_disponible;


use veterinaria;


insert into hospital_veterinario(nombre) values ('Hospital Alejandro Morera Soto');

-- clientes ------------------------------------------------------------------
insert into cliente(nombre, apellido, direccion, telefono, hospital_id)
	values ('Beto', 'Zumbado', 'Por Plaza Real', 89765542, 1);
    
insert into cliente(nombre, apellido, direccion, telefono, hospital_id)
	values ('JP', 'Quiros', 'Volcán Poas', 88887993, 1);
    
insert into cliente(nombre, apellido, direccion, telefono, hospital_id)
	values ('Pablo Antonio', 'Gabas', 'Alajuela', 84906650, 1);
    
    insert into cliente(nombre, apellido, direccion, telefono, hospital_id)
	values ('Alejandro', 'Alpizar', 'San José', 70895050, 1);


-- Mascotas -------------------------------------------------------------------
insert into mascota(tipo_mascota, nombre_mascota, fecha_nacimiento, cedula_dueño, hospital_id)
	values ('hamster siberano', 'Alex Lopez', '2020-10-12', 1, 1);

insert into mascota(tipo_mascota, nombre_mascota, fecha_nacimiento, cedula_dueño, hospital_id)
	values ('pastor alemán', 'Leo Moreira', '2020-09-11', 1, 1);
    
insert into mascota(tipo_mascota, nombre_mascota, fecha_nacimiento, cedula_dueño, hospital_id)
	values ('zaguate', 'Barlon Sequeira', '2020-02-09', 2, 1);
    
insert into mascota(tipo_mascota, nombre_mascota, fecha_nacimiento, cedula_dueño, hospital_id)
	values ('conejo', 'Patrick Pemberton', '2020-10-10', 2, 1);
    
insert into mascota(tipo_mascota, nombre_mascota, fecha_nacimiento, cedula_dueño, hospital_id)
	values ('Hamster', 'Rolado Fonseca', '2020-09-11', 3, 1);

insert into mascota(tipo_mascota, nombre_mascota, fecha_nacimiento, cedula_dueño, hospital_id)
	values ('Gato', 'Rata Calva', '2020-11-08', 3, 1);
    
insert into mascota(tipo_mascota, nombre_mascota, fecha_nacimiento, cedula_dueño, hospital_id)
	values ('Perro', 'Manchas', '2020-11-12', 4, 1);
-- -----------------------------------------------------------------------------

insert into producto(nombre_prod, descripcion_prod, cantidad_existente)
	values ('collar', 'collar bonito color café', 100);
    
insert into producto(nombre_prod, descripcion_prod, cantidad_existente)
	values ('balance cachorro', 'comida de perro para cachorro', 100);

insert into producto(nombre_prod, descripcion_prod, cantidad_existente)
	values ('casita de perro', 'casita de plástico para perros', 100);

insert into producto(nombre_prod, descripcion_prod, cantidad_existente)
	values ('Premios', 'Premios para perro sabos cordero', 300);
    
insert into producto(nombre_prod, descripcion_prod, cantidad_existente)
	values ('Shampoo Super Perro', 'Shampoo con olor a fresa', 90);
    
insert into producto(nombre_prod, descripcion_prod, cantidad_existente)
	values ('Vacuna contra la rabia', 'casita de plástico para perros', 200);
-- -------------------------------------------------------------------------
insert into factura_compra(fecha, cedula_cliente) values('2021-10-10', 1);
insert into factura_compra(fecha, cedula_cliente) values('2021-10-11', 1);
insert into factura_compra(fecha, cedula_cliente) values('2021-10-12', 1);

insert into factura_compra(fecha, cedula_cliente) values('2021-10-02', 2);
insert into factura_compra(fecha, cedula_cliente) values('2021-11-04', 2);

insert into factura_compra(fecha, cedula_cliente) values('2021-01-03', 3);

insert into factura_compra(fecha, cedula_cliente) values('2021-02-11', 4);
insert into factura_compra(fecha, cedula_cliente) values('2021-05-12', 4);
-- ---------------------------------------------------------------------------

insert into factura_producto(numero_factura, id_producto, cantidad_producto) values (1, 1, 10);
insert into factura_producto(numero_factura, id_producto, cantidad_producto) values (1, 2, 3);
insert into factura_producto(numero_factura, id_producto, cantidad_producto) values (1, 3, 5);

insert into factura_producto(numero_factura, id_producto, cantidad_producto) values (2, 1, 5);
insert into factura_producto(numero_factura, id_producto, cantidad_producto) values (2, 3, 10);
insert into factura_producto(numero_factura, id_producto, cantidad_producto) values (2, 4, 1);

insert into factura_producto(numero_factura, id_producto, cantidad_producto) values (3, 1, 13);
insert into factura_producto(numero_factura, id_producto, cantidad_producto) values (3, 2, 5);

insert into factura_producto(numero_factura, id_producto, cantidad_producto) values (4, 1, 13);
insert into factura_producto(numero_factura, id_producto, cantidad_producto) values (4, 4, 1);

insert into factura_producto(numero_factura, id_producto, cantidad_producto) values (5, 2, 1);
insert into factura_producto(numero_factura, id_producto, cantidad_producto) values (5, 3, 12);
insert into factura_producto(numero_factura, id_producto, cantidad_producto) values (5, 5, 9);

insert into factura_producto(numero_factura, id_producto, cantidad_producto) values (6, 1, 5);
insert into factura_producto(numero_factura, id_producto, cantidad_producto) values (6, 2, 8);

insert into factura_producto(numero_factura, id_producto, cantidad_producto) values (7, 1, 1);
insert into factura_producto(numero_factura, id_producto, cantidad_producto) values (7, 3, 2);

insert into factura_producto(numero_factura, id_producto, cantidad_producto) values (8, 3, 10);
insert into factura_producto(numero_factura, id_producto, cantidad_producto) values (8, 2, 2);
insert into factura_producto(numero_factura, id_producto, cantidad_producto) values (8, 1, 4);
-- ---------------------------------------------------------------------------------------

insert into producto_mascota values(1, 1);
insert into producto_mascota values(2, 1);
insert into producto_mascota values(3, 2);

insert into producto_mascota values(4, 3);
insert into producto_mascota values(5, 4);

insert into producto_mascota values(6, 5);
insert into producto_mascota values(7, 6);

insert into producto_mascota values(8, 7);
-- ---------------------------------------------------------------------------------------
insert into servicio(nombre_servicio) values('consulta rápida');
insert into servicio(nombre_servicio) values('consulta especial');
insert into servicio(nombre_servicio) values('baño');
insert into servicio(nombre_servicio) values('Castrado');
insert into servicio(nombre_servicio) values('Baño especial');
-- ---------------------------------------------------------------------------------------
insert into factura_atencion(fecha, cedula_cliente) values('2021-10-02',1);

insert into factura_atencion(fecha, cedula_cliente) values('2021-05-02',2);

insert into factura_atencion(fecha, cedula_cliente) values('2021-05-02',3);
insert into factura_atencion(fecha, cedula_cliente) values('2021-05-02',3);

insert into factura_atencion(fecha, cedula_cliente) values('2021-05-02',4);
insert into factura_atencion(fecha, cedula_cliente) values('2021-05-02',4);
-- ---------------------------------------------------------------------------------------

insert into factura_atencion_servicio values(1,1);
insert into factura_atencion_servicio values(1,3);

insert into factura_atencion_servicio values(2,2);
insert into factura_atencion_servicio values(2,3);

insert into factura_atencion_servicio values(3,1);
insert into factura_atencion_servicio values(3,4);
insert into factura_atencion_servicio values(3,5);

insert into factura_atencion_servicio values(4,3);
insert into factura_atencion_servicio values(4,4);

insert into factura_atencion_servicio values(5,2);

insert into factura_atencion_servicio values(6,1);
insert into factura_atencion_servicio values(6,5);
-- --------------------------------------------------------

insert into factura_atencion_producto values(1,1);
insert into factura_atencion_producto values(1,2);

insert into factura_atencion_producto values(2,2);
insert into factura_atencion_producto values(2,3);

insert into factura_atencion_producto values(3,1);
insert into factura_atencion_producto values(3,4);
insert into factura_atencion_producto values(3,5);

insert into factura_atencion_producto values(4,4);
insert into factura_atencion_producto values(4,5);

insert into factura_atencion_producto values(5,2);

insert into factura_atencion_producto values(6,1);

insert into veterinario(nombre,
    apellido,
    direccion,
    telefono,
    hospital_id) values ('Luis', 'Marin', 'La catedral', 22222222, 1);
    
insert into especialidades(nombre_esp, veterinario) values ('Tecnico hechado', 1);

insert into horario_atencion(cedula_veterinario,
    dia,
    hora_inicio,
    hora_fin) values (1, 'Martes', '7:00', '11:00');
    
insert into veterinario(nombre,
    apellido,
    direccion,
    telefono,
    hospital_id) values ('Oscar', 'Ramirez', 'Alajuela', 33333333, 1);
    
insert into especialidades(nombre_esp, veterinario) values ('Jugar para atrás', 2);

insert into horario_atencion(cedula_veterinario,
    dia,
    hora_inicio,
    hora_fin) values (2, 'Lunes', '7:00', '11:00');
    


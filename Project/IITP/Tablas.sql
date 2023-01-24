-- Creación de la base veterinaria
drop database if exists veterinaria;
create database veterinaria;
use veterinaria;

-- Hospital (productos y servicios)----------------
drop table if exists hospital_veterinario;
create table hospital_veterinario(
	identificador int auto_increment primary key,
    nombre varchar(100)
);


-- ------------------------------
drop table if exists producto;
create table producto(
	id_prod int auto_increment primary key,
    nombre_prod varchar(100),
    descripcion_prod varchar(100),
    cantidad_existente int
);
-- --------------------------------
drop table if exists servicio;
create table servicio(
	servicio_id int auto_increment primary key,
    nombre_servicio varchar(100)
);



-- ------------------------------------------------
-- Veterinario (especialidades y horario de atención)
drop table if exists veterinario;
create table veterinario(
	cedula int auto_increment primary key,
    nombre varchar(100),
    apellido varchar(100),
    direccion varchar(200),
    telefono long,
    hospital_id int,
    constraint hospital_asociado_fk foreign key(hospital_id)
		references hospital_veterinario(identificador)
);
-- ----------------------------------------
drop table if exists especialidades;
create table especialidades(
	id_esp int auto_increment primary key,
    nombre_esp varchar(100),
    veterinario int,
    constraint vet_fk foreign key (veterinario)
		references veterinario(cedula)
);
-- ----------------------------------------
drop table if exists horario_atencion;
create table horario_atencion(
	id_horario int auto_increment primary key,
	cedula_veterinario int,
    dia varchar(100),
    hora_inicio varchar(100),
    hora_fin varchar(100),
    constraint ced_vet_fk foreign key (cedula_veterinario)
		references veterinario(cedula)
);



-- ------------------------------------------------
-- Cliente (facturas y mascotas)------------------------------
drop table if exists cliente;
create table cliente(
	cedula int auto_increment primary key,
    nombre varchar(100),
    apellido varchar(100),
    direccion varchar(200),
    telefono int,
    hospital_id int,
    constraint cl_hospital_asociado foreign key(hospital_id)
		references hospital_veterinario(identificador)
);
--  Mascotas -----------------------
drop table if exists mascota;
create table mascota(
	id_mascota int auto_increment primary key,
    tipo_mascota varchar(100),
    nombre_mascota varchar(100),
    fecha_nacimiento date,
    cedula_dueño int,
    hospital_id int,
    id_exp int,
    constraint dueño_mascota foreign key(cedula_dueño)
		references cliente(cedula),
	constraint ma_hospital_asociado foreign key(hospital_id)
		references hospital_veterinario(identificador)
);
-- ---------------------------------
drop table if exists factura_compra;
create table factura_compra(
	numero_factura_compra int auto_increment primary key,
    fecha date,
    cedula_cliente int,
    constraint fc_cedula_cliente foreign key(cedula_cliente)
		references cliente(cedula)
);
-- ---------------------------------
drop table if exists producto_mascota;
create table producto_mascota(
	numero_factura int,
    id_mascota int,
	constraint pa_numero_factura foreign key(numero_factura)
		references factura_compra(numero_factura_compra),
	constraint pa_id_mascota foreign key(id_mascota)
		references mascota(id_mascota)
);
-- ---------------------------------
drop table if exists factura_producto;
create table factura_producto(
	numero_factura int,
    id_producto int,
	cantidad_producto int,
    constraint fp_numero_factura foreign key(numero_factura)
		references factura_compra(numero_factura_compra),
	constraint fp_id_producto foreign key(id_producto)
		references producto(id_prod)
);
-- ---------------------------------
drop table if exists factura_atencion;
create table factura_atencion(
	numero_factura_atencion int auto_increment primary key,
    fecha date,
	cedula_cliente int,
    constraint fa_cedula_cliente foreign key(cedula_cliente)
		references cliente(cedula)
);
-- ---------------------------------
drop table if exists factura_atencion_servicio;
create table factura_atencion_servicio(
	numero_factura int,
    servicio_id int,
	constraint fas_numero_factura foreign key(numero_factura)
		references factura_atencion(numero_factura_atencion),
	constraint fas_servicio_id foreign key(servicio_id)
		references servicio(servicio_id)
);
-- ---------------------------------
drop table if exists factura_atencion_producto;
create table factura_atencion_producto(
	numero_factura int,
    producto_id int,
	constraint fap_numero_factura foreign key(numero_factura)
		references factura_atencion(numero_factura_atencion),
	constraint fap_producto_id foreign key(producto_id)
		references producto(id_prod)
);
-- ------------------------------------------------



-- Expedientes mascotas----------------------------

-- -----------------------------------
drop table if exists exp_tratamientos;
create table exp_tratamientos(
	id_exp_tratamiento int auto_increment primary key,
    nombre_tratamiento varchar(100),
    fecha_trat date,
    descripcion_trat varchar(200),
    cedula_vet int,
    id_mascota int,
    constraint cedula_vet_fk foreign key (cedula_vet)
		references veterinario(cedula),
	constraint mascota_id_fk foreign key(id_mascota)
		references mascota(id_mascota)
);
-- -----------------------------------
drop table if exists productos_aplicados;
create table productos_aplicados(
	id_producto int,
	id_tratamiento int,
    constraint id_producto_fk foreign key (id_producto)
		references producto(id_prod),
    constraint id_tratamiento_fk foreign key (id_tratamiento)
		references exp_tratamientos(id_exp_tratamiento)
);
-- -----------------------------------
drop table if exists expediente_productos;
create table expediente_productos(
	id_exp_prod int auto_increment primary key,
    fecha_compra date
);
-- -----------------------------------
drop table if exists exp_productos;
create table exp_productos(
	id_exp_prod int,
    producto_comprado int,
    cantidad_comprada int,
    id_mascota int,
	constraint fk_exp_prod foreign key(id_exp_prod)
		references expediente_productos(id_exp_prod),
	constraint fk_producto_comprado foreign key(producto_comprado)
		references producto(id_prod),
	constraint fk_mascota2 foreign key(id_mascota)
		references mascota(id_mascota)
);

commit;

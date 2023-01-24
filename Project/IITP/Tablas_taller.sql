-- Creación de la base veterinaria
drop database if exists venta_repuestos;
create database venta_repuestos;
use venta_repuestos;


drop table if exists venta_de_repuestos;
create table venta_de_repuestos(
	identificador int auto_increment primary key,
    nombre varchar(100)
);


drop table if exists producto;
create table producto(
	id_prod int auto_increment primary key,
    nombre_prod varchar(100),
    descripcion_prod varchar(200),
    precio long,
    cantidad_existente int
);


drop table if exists administrador;
create table administrador(
	cedula int primary key,
    nombre varchar(100),
    apellido varchar(100),
    email varchar(200),
    contrasena varchar(200),
    venta_id int,
    constraint venta_asociada_fk foreign key(venta_id)
		references venta_de_repuestos(identificador)
);


drop table if exists cliente;
create table cliente(
	cedula int primary key,
    nombre varchar(100),
    apellido varchar(100),
    email varchar(200),
    contrasena varchar(200),
    venta_id int,
    constraint cl_venta_asociada_fk foreign key(venta_id)
		references venta_de_repuestos(identificador)
);


drop table if exists factura_compra;
create table factura_compra(
	numero_factura_compra int auto_increment primary key,
    fecha date,
    cedula_cliente int,
    constraint fc_cedula_cliente foreign key(cedula_cliente)
		references cliente(cedula)
);


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


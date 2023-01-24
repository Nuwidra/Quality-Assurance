use venta_repuestos;

# ----------------------- VENTA ---------------------------------
insert into venta_de_repuestos(nombre) values ('Venta de repuestos Alajuela');

# -----------------------Productos -----------------------------------
insert into producto(nombre_prod, descripcion_prod, precio, cantidad_existente)
	values ('Batería', 'Batería automotríz', 45000, 100);
    
insert into producto(nombre_prod, descripcion_prod, precio, cantidad_existente)
	values ('Rótula', 'Rótula para suspención de Nissan', 20000, 100);

insert into producto(nombre_prod, descripcion_prod, precio, cantidad_existente)
	values ('Bomba de Gasolina', 'Bomba de gasolina Hyundai Elantra', 140000, 100);

insert into producto(nombre_prod, descripcion_prod, precio, cantidad_existente)
	values ('Tapa de válvulas', 'Tapa de válvulas Hyundai Tucson', 60000, 300);
    
insert into producto(nombre_prod, descripcion_prod, precio,  cantidad_existente)
	values ('Fan clutch Mitsubishi', 'Fan clutch de mitsubishi Montero', 50000, 90);
    
insert into producto(nombre_prod, descripcion_prod, precio,  cantidad_existente)
	values ('Bomba de dirección', 'Bomba de dirección hidráulica susuki', 35000, 200);


# -------------------- Administradores ---------------------------------------
insert into administrador(
	cedula,
    nombre,
    apellido,
    email,
    contrasena,
    venta_id) values (208790444, 'Luis', 'Marin', 'luism@gmail.com', 'luis123', 1);
    
insert into administrador(
	cedula,
    nombre,
    apellido,
    email,
    contrasena,
    venta_id) values (208400222, 'Oscar', 'Ramirez', 'oscarr@gmail.com', 'oscar123', 1);

# ----------------------- clientes --------------------------------------------
insert into cliente(cedula, nombre, apellido, email, contrasena, venta_id)
	values (209800222, 'Beto', 'Zumbado', 'betoz@gmail.com', 'beto123', 1);
    
insert into cliente(cedula, nombre, apellido, email, contrasena, venta_id)
	values (208220979, 'JP', 'Quiros', 'jp@gmail.com', 'jp123', 1);
    
insert into cliente(cedula, nombre, apellido, email, contrasena, venta_id)
	values (207770999, 'Nuwidra', 'Quesada', 'nuwidra@gmail.com', 'nuwidra123', 1);
    
insert into cliente(cedula, nombre, apellido, email, contrasena, venta_id)
	values (109990222, 'Lucho', 'Rojas', 'lucho@gmail.com', 'lucho123', 1);
    

# -------------------- facturas ----------------------------------------------
insert into factura_compra(fecha, cedula_cliente) values('2021-10-10', 209800222);
insert into factura_compra(fecha, cedula_cliente) values('2021-10-11', 209800222);

insert into factura_compra(fecha, cedula_cliente) values('2021-10-02', 208220979);
insert into factura_compra(fecha, cedula_cliente) values('2021-11-04', 208220979);

insert into factura_compra(fecha, cedula_cliente) values('2021-01-03', 207770999);
insert into factura_compra(fecha, cedula_cliente) values('2021-01-03', 207770999);

insert into factura_compra(fecha, cedula_cliente) values('2021-04-12', 109990222);
insert into factura_compra(fecha, cedula_cliente) values('2021-01-11', 109990222);



# ------------------------- productos-factura --------------------------------
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


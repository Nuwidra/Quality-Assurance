package com.example.demo;

import com.example.demo.dao.administradorPackage.AdministradorDAO;
import com.example.demo.dao.clientePackage.ClienteDAO;
import com.example.demo.dao.hospitalPackage.ProductoDAO;
import com.example.demo.dao.hospitalPackage.VentaDAO;
import com.example.demo.model.administradorPackage.Administrador;
import com.example.demo.model.clientePackage.Cliente;
import com.example.demo.model.clientePackage.FacturaCompra;
import com.example.demo.model.ventaPackage.Producto;
import com.example.demo.model.ventaPackage.VentaRepuestos;
import com.example.demo.service.aImpl.ClienteServiceImpl;
import com.example.demo.service.clientePackage.ClienteService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.*;


@SpringBootTest
class DemoApplicationTests {


    @Autowired
    private ClienteDAO clienteDAO;

    @Autowired
    private AdministradorDAO administradorDAO;

    @Autowired
    private ProductoDAO productoDAO;

    @Autowired
    private VentaDAO ventaDAO;

    @Test
    @DisplayName("Test de Cliente")
    public void testCliente() {

        Cliente cliente = new Cliente();
        cliente.setCedula(123);
        cliente.setNombre("Juan");
        cliente.setApellido("Perez");
        cliente.setEmail("juanperez@gmail.com");
        cliente.setContrasena("1234");

        Assertions.assertEquals(123, cliente.getCedula());
        Assertions.assertEquals("Juan", cliente.getNombre());
        Assertions.assertEquals("Perez", cliente.getApellido());
        Assertions.assertEquals("juanperez@gmail.com", cliente.getEmail());
        Assertions.assertEquals("1234", cliente.getContrasena());
    }

    @Test
    public void testClienteDAO() {

        Cliente cliente = new Cliente();
        VentaRepuestos ventaRepuestos = new VentaRepuestos();
        ventaRepuestos.setNombre("repuestos 2");
        ventaDAO.save(ventaRepuestos);

        cliente.setCedula(123);
        cliente.setNombre("Juan");
        cliente.setApellido("Perez");
        cliente.setEmail("juanperez@gmail.com");
        cliente.setContrasena("1234");
        cliente.setVentaAsociada(ventaDAO.findById(2).get());
        clienteDAO.save(cliente);

        Assertions.assertEquals(cliente.getCedula(), clienteDAO.getById(123).getCedula());
        Assertions.assertEquals(cliente.getNombre(), clienteDAO.findAll().get(0).getNombre()); // 0 porque el cliente nuevo tomará la posición inicial en la lista
        Assertions.assertEquals(cliente.getApellido(), clienteDAO.findAll().get(0).getApellido());
        Assertions.assertEquals(cliente.getEmail(), clienteDAO.findAll().get(0).getEmail());
        Assertions.assertEquals(cliente.getContrasena(), clienteDAO.findAll().get(0).getContrasena());
    }

    @Test
    public void testAdministrador(){
        Administrador administrador = new Administrador();
        administrador.setCedula(12345);
        administrador.setNombre("Federico");
        administrador.setApellido("Gonzalez");
        administrador.setEmail("fedegon@gmail.com");
        administrador.setContrasena("1234");

        Assertions.assertEquals(12345, administrador.getCedula());
        Assertions.assertEquals("Federico", administrador.getNombre());
        Assertions.assertEquals("Gonzalez", administrador.getApellido());
        Assertions.assertEquals("fedegon@gmail.com", administrador.getEmail());
        Assertions.assertEquals("1234", administrador.getContrasena());
    }

    @Test
    public void testAdministradorDAO() {
        Administrador administrador = new Administrador();
        administrador.setCedula(12345);
        administrador.setNombre("Federico");
        administrador.setApellido("Gonzalez");
        administrador.setEmail("juanperez@gmail.com");
        administrador.setContrasena("12345");
        administrador.setVentaAsociada(ventaDAO.getById(1));

        administradorDAO.save(administrador);

        Assertions.assertEquals(administrador.getCedula(), administradorDAO.getById(12345).getCedula());
        Assertions.assertEquals(administrador.getNombre(), administradorDAO.findAll().get(0).getNombre());
        Assertions.assertEquals(administrador.getApellido(), administradorDAO.findAll().get(0).getApellido());
        Assertions.assertEquals(administrador.getEmail(), administradorDAO.findAll().get(0).getEmail());
        Assertions.assertEquals(administrador.getContrasena(), administradorDAO.findAll().get(0).getContrasena());
    }

    @Test
    public void testProducto(){

        Producto producto = new Producto();
        producto.setNombre_prod("Producto prueba");
        producto.setDescripcion_prod("Producto de prueba lindo y confiable");
        producto.setPrecio_prod(Double.valueOf(100000));
        producto.setCantidad_existente(50);

        Assertions.assertEquals("Producto prueba", producto.getNombre_prod());
        Assertions.assertEquals("Producto de prueba lindo y confiable", producto.getDescripcion_prod());
        Assertions.assertEquals(100000, producto.getPrecio_prod());
        Assertions.assertEquals(50, producto.getCantidad_existente());
    }

    @Test
    public void testProductoDAO(){
        Producto producto = new Producto();
        producto.setNombre_prod("Producto prueba");
        producto.setDescripcion_prod("Producto de prueba lindo y confiable");
        producto.setPrecio_prod(Double.valueOf(100000));
        producto.setCantidad_existente(50);
        productoDAO.save(producto);

        Assertions.assertEquals(producto.getId(), productoDAO.getById(productoDAO.findAll().size()).getId_prod());
        Assertions.assertEquals(producto.getNombre_prod(),
                productoDAO.findAll().get(productoDAO.getById(productoDAO.findAll().size()).getId_prod() - 1).getNombre_prod());

        Assertions.assertEquals(producto.getDescripcion_prod(),
                productoDAO.findAll().get(productoDAO.getById(productoDAO.findAll().size()).getId_prod() - 1).getDescripcion_prod());

        Assertions.assertEquals(producto.getPrecio_prod(),
                productoDAO.findAll().get(productoDAO.getById(productoDAO.findAll().size()).getId_prod() - 1).getPrecio_prod());

        Assertions.assertEquals(producto.getCantidad_existente(),
                productoDAO.findAll().get(productoDAO.getById(productoDAO.findAll().size()).getId_prod() - 1).getCantidad_existente());
    }

    @Test
    public void testFactura() throws ParseException {
        FacturaCompra factura = new FacturaCompra();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        factura.setFecha(sdf.parse("2020-12-12"));
        factura.setCliente(clienteDAO.getById(123));
        List<Producto> productos = productoDAO.findAll();
        productos.remove(0);
        productos.remove(1);
        factura.setProductos_comprados(productos);
        List<Integer> cantidades = new ArrayList<>();
        for (int i = 0; i < productos.toArray().length; i++){
            int cantidad_de_producto = (int) (Math.random() * 30);
            cantidades.add(cantidad_de_producto);
        }
        factura.setCantidad_vendida(cantidades);
    }



    @Test
    public void testLogin() {

    }
}

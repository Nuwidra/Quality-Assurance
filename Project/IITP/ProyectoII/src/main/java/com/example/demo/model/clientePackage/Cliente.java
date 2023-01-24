package com.example.demo.model.clientePackage;

import com.example.demo.model.ventaPackage.VentaRepuestos;
import com.example.demo.model.ventaPackage.Producto;
import com.example.demo.model.abstracts.Usuario;

import javax.persistence.*;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
// =================================================================================================
//Esta anotacion hace saber el tipo de bean, en este caso una entidad
// =================================================================================================
@Entity
@Table(name = "cliente") //Se hace referencia a la tabla en la base de datos
public class Cliente extends Usuario {
    // =================================================================================================
    //Anotacion para hacer las relaciones respectivas de muchos a uno en la base de datos,
    //Con esto spring se encarga de hacer las conexiones respectivas a nivel de java, obentiendo los datos de las distinas tablas
    //en la base de datos
    // =================================================================================================
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "venta_id",nullable = false)
    private VentaRepuestos ventaAsociada;

    @OneToMany(mappedBy = "cliente", fetch = FetchType.EAGER)
    private List<FacturaCompra> facturasCompra;

    // =================================================================================================
    //Gets y setters
    // =================================================================================================
    public VentaRepuestos getVentaAsociada() {
        return ventaAsociada;
    }

    public void setVentaAsociada(VentaRepuestos hospitalAsociado) {
        this.ventaAsociada = hospitalAsociado;
    }

    public List<FacturaCompra> getFacturasCompra() {
        return facturasCompra;
    }

    public void setFacturasCompra(List<FacturaCompra> facturasCompra) {
        this.facturasCompra = facturasCompra;
    }



    //Metodos extra
    // =================================================================================================
    // Metodo para agregar una factura a la lista de facturas del cliente
    // =================================================================================================
    public List<Integer> getFacturasById(){
        List<Integer> facturasId = new ArrayList<>();
        // =================================================================================================
        // Se recorre la lista de facturas del cliente y se obtiene el id de cada una
        // =================================================================================================
        for(FacturaCompra facturaCompra : this.getFacturasCompra()){
            // =================================================================================================
            // Se agrega el id de la factura a la lista de ids
            // =================================================================================================
            facturasId.add(facturaCompra.getNumero_factura_compra());
        }

        return facturasId;
    }
    // =================================================================================================
    // Metodo para agregar una factura a la lista de facturas del cliente
    // =================================================================================================
    public List<Integer> getFacturasCompraById(){
        List<Integer> facturasId = new ArrayList<>();
        // =================================================================================================
        // Se recorre la lista de facturas del cliente y se obtiene el id de cada una
        // =================================================================================================
        for(FacturaCompra facturaCompra : this.getFacturasCompra()){
            // =================================================================================================
            // Se agrega el id de la factura a la lista de ids
            // =================================================================================================
            facturasId.add(facturaCompra.getNumero_factura_compra());
        }

        return facturasId;
    }
    // =================================================================================================
    // Metodo para agregar una factura a la lista de facturas del cliente
    // =================================================================================================
    public List<List<String>> getNombresProductosFacturaCompra(){
        List<List<String>> productosPorFactura = new ArrayList<>();
        List<List<Producto>> productos_de_factura = new ArrayList<>();
        // =================================================================================================
        // Se recorre la lista de facturas del cliente y se obtiene el id de cada una
        // =================================================================================================
        for(FacturaCompra facturaCompra : this.getFacturasCompra()){
            productos_de_factura.add(facturaCompra.getProductos_comprados());
        }
        // =================================================================================================
        // Se recorre la lista de facturas del cliente y se obtiene el id de cada una
        // =================================================================================================
        for(List<Producto> lista_producto : productos_de_factura){
            List<String> nombre_productos = new ArrayList<>();
            // =================================================================================================
            // Se recorre la lista de facturas del cliente y se obtiene el id de cada una
            // =================================================================================================
            for (Producto producto : lista_producto){
                nombre_productos.add(producto.getNombre_prod());
            }
            productosPorFactura.add(nombre_productos);
        }
        return productosPorFactura;
    }
    // =================================================================================================
    // Metodo para agregar una factura a la lista de facturas del cliente
    // =================================================================================================
    public List<String> factura_compra_string(){
        List<String> returnList = new ArrayList<>();
        String stringFactura = null;
        // =================================================================================================
        // Se recorre la lista de facturas del cliente y se obtiene el id de cada una
        // =================================================================================================
        for (Integer factura : this.getFacturasCompraById()) {
            stringFactura = factura + ", ";
            List<String> nombres = new ArrayList<>();
            // =================================================================================================
            // Se inicializa la lista de nombres de productos
            // =================================================================================================
            nombres = this.getNombresProductosFacturaCompra().get((factura-1));
            stringFactura = stringFactura + " " + nombres.toString();
            returnList.add(stringFactura);
        }
        return returnList;
    }



}


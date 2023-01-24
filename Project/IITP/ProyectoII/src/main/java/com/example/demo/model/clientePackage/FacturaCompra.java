package com.example.demo.model.clientePackage;

import com.example.demo.model.abstracts.FacturasInterface;
import com.example.demo.model.ventaPackage.Producto;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
// =================================================================================================
//Esta anotacion hace saber el tipo de bean, en este caso una entidad
// =================================================================================================
@Entity
@Table(name = "factura_compra") //Se hace referencia a la tabla en la base de datos
public class FacturaCompra implements FacturasInterface {
    // =================================================================================================
    //Anotacion para hacer las relaciones respectivas de muchos a uno en la base de datos,
    //Con esto spring se encarga de hacer las conexiones respectivas a nivel de java, obentiendo los datos de las distinas tablas
    //en la base de datos
    // =================================================================================================
    @Id
    @Column(name = "numero_factura_compra")
    private int numero_factura_compra;

    // =================================================================================================
    // Anotacion para hacer las relaciones respectivas de muchos a uno en la base de datos,
    // Con esto spring se encarga de hacer las conexiones respectivas a nivel de java, obentiendo los datos de las distinas tablas
    // en la base de datos
    // =================================================================================================
    @Column(name = "fecha")
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date fecha;
    // =================================================================================================
    // Anotacion para hacer las relaciones respectivas de muchos a uno en la base de datos,
    // Con esto spring se encarga de hacer las conexiones respectivas a nivel de java, obentiendo los datos de las distinas tablas
    // en la base de datos
    // =================================================================================================
    @ElementCollection
    @CollectionTable(name = "factura_producto", joinColumns = @JoinColumn(name = "numero_factura"))
    @Column(name = "cantidad_producto")
    private List<Integer> cantidad_vendida;

    // =================================================================================================
    // Anotacion para hacer las relaciones respectivas de muchos a uno en la base de datos,
    // Con esto spring se encarga de hacer las conexiones respectivas a nivel de java, obentiendo los datos de las distinas tablas
    // en la base de datos
    // =================================================================================================
    @ManyToOne
    @JoinColumn(name="cedula_cliente",nullable = false)
    private Cliente cliente;

    // =================================================================================================
    // Anotacion para hacer las relaciones respectivas de muchos a uno en la base de datos,
    // Con esto spring se encarga de hacer las conexiones respectivas a nivel de java, obentiendo los datos de las distinas tablas
    // en la base de datos
    // =================================================================================================
    @ManyToMany
    @JoinTable(name = "factura_producto",
            joinColumns = @JoinColumn(name = "numero_factura"),
            inverseJoinColumns = @JoinColumn(name = "id_producto"))
    private List<Producto> productos_comprados;
    // =================================================================================================
    //Gets y setters
    // =================================================================================================
    public int getNumeroFacturaCompra() {
        return numero_factura_compra;
    }

    public void setNumeroFacturaCompra(int numero_factura_compra) {
        this.numero_factura_compra = numero_factura_compra;
    }

    public int getNumero_factura_compra() {
        return numero_factura_compra;
    }

    public void setNumero_factura_compra(int numero_factura_compra) {
        this.numero_factura_compra = numero_factura_compra;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public List<Integer> getCantidad_vendida() {
        return cantidad_vendida;
    }

    public void setCantidad_vendida(List<Integer> cantidad_vendida) {
        this.cantidad_vendida = cantidad_vendida;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<Producto> getProductos_comprados() {
        return productos_comprados;
    }

    public void setProductos_comprados(List<Producto> productos_comprados) {
        this.productos_comprados = productos_comprados;
    }

    //Metodos extra
    // =================================================================================================
    //Implementacion de los metodos de la interfaz FacturasInterface
    // =================================================================================================
    @Override
    public String getProductosByName(){
        String productos = "";
        List<String> productos1 = new ArrayList<String>();

        for(Producto producto : this.getProductos_comprados()){
            productos1.add(producto.getNombre_prod());
        }
        return String.join(", ", productos1);
    }
}

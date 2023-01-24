package com.example.demo.model.ventaPackage;

import com.example.demo.model.clientePackage.FacturaCompra;

import javax.persistence.*;
import java.util.List;
// =================================================================================================
//Esta anotacion hace saber el tipo de bean, en este caso una entidad
// =================================================================================================
@Entity
@Table(name = "producto") //Se hace referencia a la tabla en la base de datos
public class Producto {
    // =================================================================================================
    //Anotacion para hacer las relaciones respectivas de muchos a uno en la base de datos,
    //Con esto spring se encarga de hacer las conexiones respectivas a nivel de java, obentiendo los datos de las distinas tablas
    //en la base de datos
    // =================================================================================================
    @Id
    @Column(name = "id_prod", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_prod;

    @Column(name = "nombre_prod")
    private String nombre_prod;

    @Column(name = "descripcion_prod")
    private String descripcion_prod;

    @Column(name = "precio_prod")
    private Double precio_prod;

    @Column(name = "cantidad_existente")
    private int cantidad_existente;

    @ManyToMany(mappedBy = "productos_comprados")
    List<FacturaCompra> facturas_compra_asociada;

    // =================================================================================================
    //Gets y setters
    // =================================================================================================

    public int getId() {
        return id_prod;
    }

    public void setId(int id_prod) {
        this.id_prod = id_prod;
    }

    public int getId_prod() {
        return id_prod;
    }

    public void setId_prod(int id_prod) {
        this.id_prod = id_prod;
    }

    public String getNombre_prod() {
        return nombre_prod;
    }

    public void setNombre_prod(String nombre_prod) {
        this.nombre_prod = nombre_prod;
    }

    public String getDescripcion_prod() {
        return descripcion_prod;
    }

    public void setDescripcion_prod(String descripcion_prod) {
        this.descripcion_prod = descripcion_prod;
    }

    public Double getPrecio_prod() {
        return precio_prod;
    }

    public void setPrecio_prod(Double precio_prod) {
        this.precio_prod = precio_prod;
    }


    public int getCantidad_existente() {
        return cantidad_existente;
    }

    public void setCantidad_existente(int cantidad_existente) {
        this.cantidad_existente = cantidad_existente;
    }

    // =================================================================================================
    // facturas_compra_asociada es una lista de facturas de compra, por lo tanto se hace una relacion de muchos a muchos
    // =================================================================================================
    public List<FacturaCompra> getFacturas_compra_asociada() {
        return facturas_compra_asociada;
    }

    public void setFacturas_compra_asociada(List<FacturaCompra> facturas_compra_asociada) {
        this.facturas_compra_asociada = facturas_compra_asociada;
    }

}

package com.example.demo.model.administradorPackage;


import com.example.demo.model.ventaPackage.VentaRepuestos;
import com.example.demo.model.abstracts.Usuario;

import javax.persistence.*;
// =================================================================================================
// Clase que contiene los atributos de los administradores
// =================================================================================================
@Entity
@Table(name = "administrador")
public class Administrador extends Usuario {
    // =================================================================================================
    // Atributos de la clase
    // =================================================================================================
    @ManyToOne
    @JoinColumn(name = "venta_id",nullable = false)
    private VentaRepuestos ventaAsociada;

    public VentaRepuestos getVentaAsociada() {return ventaAsociada;}
    // =================================================================================================
    // Gets y sets
    // =================================================================================================
    public void setVentaAsociada(VentaRepuestos ventaAsociada) {
        this.ventaAsociada = ventaAsociada;}

}

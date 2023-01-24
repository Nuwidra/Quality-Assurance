package com.example.demo.service.ventaPackage;

import com.example.demo.model.ventaPackage.VentaRepuestos;

import java.util.List;
// =================================================================================================
// Interface para acceder a las operaciones de la base de datos en la entidad de la venta de repuestos
// =================================================================================================
public interface VentaService {

    List<VentaRepuestos> getAllHospitales();

    VentaRepuestos saveHospital(VentaRepuestos ventaRepuestos);

    VentaRepuestos getHospitalById(int identificador);

    VentaRepuestos updateHospital(VentaRepuestos ventaRepuestos);

    void deleteHospital(int identificador);
}

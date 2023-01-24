package com.example.demo.service.clientePackage;

import com.example.demo.model.clientePackage.FacturaCompra;

import java.util.Date;
import java.util.List;
// =================================================================================================
// Interface para acceder a las operaciones de la base de datos en la entidad de la factura de compra de repuestos
// =================================================================================================
public interface FacturaCompraService {
    // =================================================================================================
    // Metodo para obtener todas las facturas de compra
    // =================================================================================================
    List<FacturaCompra> getAllFacturasCompra();

    FacturaCompra saveFactura(FacturaCompra facturaCompra);

    FacturaCompra getFacturaById(int identificador);

    FacturaCompra updateFactura(FacturaCompra facturaCompra);

    void deleteFactura(int identificador);

    List<FacturaCompra> listarPorFechas(Date fecha1, Date fecha2);
}

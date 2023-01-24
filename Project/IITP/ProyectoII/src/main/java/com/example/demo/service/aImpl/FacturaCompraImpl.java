package com.example.demo.service.aImpl;

import com.example.demo.dao.clientePackage.FacturaCompraDAO;
import com.example.demo.model.clientePackage.FacturaCompra;
import com.example.demo.service.clientePackage.FacturaCompraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
// =================================================================================================
// Clase que contiene los atributos de las facturas de compra de repuestos
// =================================================================================================
@Service
public class FacturaCompraImpl implements FacturaCompraService {
    // =================================================================================================
    // Atributos de la clase
    // =================================================================================================
    @Autowired
    private FacturaCompraDAO facturaCompraDAO;

    // =================================================================================================
    // Métodos de la clase para acceder a las operaciones de la base de datos
    // =================================================================================================
    @Override
    public List<FacturaCompra> getAllFacturasCompra() {
        return facturaCompraDAO.findAll();
    }

    @Override
    public FacturaCompra saveFactura(FacturaCompra facturaCompra) {
        return facturaCompraDAO.save(facturaCompra);
    }

    @Override
    public FacturaCompra getFacturaById(int identificador) {
        return facturaCompraDAO.findById(identificador).get();
    }

    @Override
    public FacturaCompra updateFactura(FacturaCompra facturaCompra) {
        return facturaCompraDAO.save(facturaCompra);
    }

    @Override
    public void deleteFactura(int identificador) {
        facturaCompraDAO.deleteById(identificador);
    }
    // =================================================================================================
    // Métodos de lista de facturas de compra
    // =================================================================================================
    @Override
    public List<FacturaCompra> listarPorFechas(Date fecha1, Date fecha2) {
        return facturaCompraDAO.listarPorFechas(fecha1, fecha2);
    }
}

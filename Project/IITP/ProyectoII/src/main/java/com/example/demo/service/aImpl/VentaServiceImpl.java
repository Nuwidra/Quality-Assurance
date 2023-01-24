package com.example.demo.service.aImpl;

import com.example.demo.dao.hospitalPackage.VentaDAO;
import com.example.demo.model.ventaPackage.VentaRepuestos;
import com.example.demo.service.ventaPackage.VentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
// =================================================================================================
// Clase que contiene los atributos de las ventas de repuestos
// =================================================================================================
@Service
public class VentaServiceImpl implements VentaService {

    @Autowired
    private VentaDAO ventaDao;

    @Override
    public List<VentaRepuestos> getAllHospitales() {
       return this.ventaDao.findAll();
    }

    @Override
    public VentaRepuestos saveHospital(VentaRepuestos ventaRepuestos) {
        return this.ventaDao.save(ventaRepuestos);
    }

    @Override
    public VentaRepuestos getHospitalById(int identificador) {
        return this.ventaDao.findById(identificador).get();
    }

    @Override
    public VentaRepuestos updateHospital(VentaRepuestos ventaRepuestos) {
        return this.ventaDao.save(ventaRepuestos);
    }

    @Override
    public void deleteHospital(int identificador) {
        this.ventaDao.deleteById(identificador);

    }
}

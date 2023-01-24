package com.example.demo.service.aImpl;

import com.example.demo.dao.administradorPackage.AdministradorDAO;
import com.example.demo.model.administradorPackage.Administrador;
import com.example.demo.service.administradorPackage.AdministradorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
// =================================================================================================
// Clase que contiene los atributos de los administradores
// =================================================================================================
@Service
public class AdministradorServiceImpl implements AdministradorService {

    @Autowired
    private AdministradorDAO administradorDAO;

    @Override
    public List<Administrador> getAllAdministradores() {
        return administradorDAO.findAll();
    }

    @Override
    public Administrador saveAdministradores(Administrador administrador) {
       return administradorDAO.save(administrador);
    }

    @Override
    public Administrador getAdminById(int cedula) {
        return administradorDAO.findById(cedula).get();
    }

    @Override
    public Administrador updateAdmin(Administrador administrador) {
        return administradorDAO.save(administrador);
    }

    @Override
    public void deleteAdmin(int cedula) {
        administradorDAO.deleteById(cedula);

    }
}

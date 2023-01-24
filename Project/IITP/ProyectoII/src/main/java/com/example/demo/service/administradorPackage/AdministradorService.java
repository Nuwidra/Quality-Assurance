package com.example.demo.service.administradorPackage;

import com.example.demo.model.administradorPackage.Administrador;

import java.util.List;
// =================================================================================================
// Interface para acceder a las operaciones de la base de datos en la entidad del administrador
// =================================================================================================
public interface AdministradorService {

    List<Administrador> getAllAdministradores();

    Administrador saveAdministradores(Administrador administrador);

    Administrador getAdminById(int cedula);

    Administrador updateAdmin(Administrador administrador);

    void deleteAdmin(int cedula);
}

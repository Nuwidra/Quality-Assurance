package com.example.demo.dao.administradorPackage;

import com.example.demo.model.administradorPackage.Administrador;
import org.springframework.data.jpa.repository.JpaRepository;
// =================================================================================================
//DAO para acceder a las operaciones de la base de datos en la entidad de los veterinarios
//Se utiliza la biblioteca de spring JpaRepository para acceder a la base de datos
// =================================================================================================
public interface AdministradorDAO extends JpaRepository<Administrador,Integer> {
}

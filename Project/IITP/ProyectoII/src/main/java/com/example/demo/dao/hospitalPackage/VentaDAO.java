package com.example.demo.dao.hospitalPackage;

import com.example.demo.model.ventaPackage.VentaRepuestos;
import org.springframework.data.jpa.repository.JpaRepository;
// =================================================================================================
//DAO para acceder a las operaciones de la base de datos en la entidad del hospital
//Se utiliza la biblioteca de spring JpaRepository para acceder a la base de datos
// =================================================================================================
public interface VentaDAO extends JpaRepository<VentaRepuestos, Integer> {
}

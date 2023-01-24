package com.example.demo.dao.clientePackage;

import com.example.demo.model.clientePackage.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
// =================================================================================================
//DAO para acceder a las operaciones de la base de datos en la entidad del cliente
//Se utiliza la biblioteca de spring JpaRepository para acceder a la base de datos
// =================================================================================================
@Repository
public interface ClienteDAO extends JpaRepository<Cliente, Integer> {


}

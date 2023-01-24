package com.example.demo.dao.LogIn;


import com.example.demo.model.login.LogInCliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
// =================================================================================================
// Interface para acceder a las operaciones de la base de datos en la entidad del cliente
// =================================================================================================
@Repository
public interface LogInClienteDAO extends JpaRepository<LogInCliente, Integer> {
}

package com.example.demo.service.clientePackage;



import com.example.demo.model.clientePackage.Cliente;

import java.util.List;
// =================================================================================================
// Interface para acceder a las operaciones de la base de datos en la entidad del cliente service
// =================================================================================================
public interface ClienteService {

    List<Cliente> getAllClientes();

    Cliente saveCliente(Cliente cliente);

    Cliente getClienteById(int cedula);

    Cliente updateCliente(Cliente cliente);

    void deleteCliente(int cedula);
}

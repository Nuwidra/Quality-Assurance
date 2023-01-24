package com.example.demo.service.aImpl;

import com.example.demo.dao.clientePackage.ClienteDAO;
import com.example.demo.model.clientePackage.Cliente;
import com.example.demo.service.clientePackage.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
// =================================================================================================
// Clase que contiene los atributos de los clientes
// =================================================================================================
@Service
public class ClienteServiceImpl implements ClienteService {
    // =================================================================================================
    // Atributos
    // =================================================================================================
    @Autowired
    private ClienteDAO clienteDAO;

    // =================================================================================================
    // Métodos para obtener los datos de los clientes
    // =================================================================================================
    @Override
    public List<Cliente> getAllClientes() {
        return clienteDAO.findAll();
    }

    @Override
    public Cliente saveCliente(Cliente cliente) {
        // =================================================================================================
        // Se guarda el cliente
        // =================================================================================================

        return clienteDAO.save(cliente);
    }
    // =================================================================================================
    // Se obtiene el cliente por su identificador
    // =================================================================================================
    @Override
    public Cliente getClienteById(int cedula) {
        return clienteDAO.findById(cedula).get();
    }
    // =================================================================================================
    // Se actualiza el cliente
    // =================================================================================================

    @Override
    public Cliente updateCliente(Cliente cliente) {
        return clienteDAO.save(cliente);
    }
    // =================================================================================================
    // Se elimina el cliente
    // =================================================================================================
    @Override
    public void deleteCliente(int cedula) {
        clienteDAO.deleteById(cedula);
    }
}

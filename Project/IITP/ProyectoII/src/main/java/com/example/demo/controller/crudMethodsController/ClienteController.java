package com.example.demo.controller.crudMethodsController;

import com.example.demo.service.clientePackage.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;


// Controller para manejar las operaciones CRUD de la entidad cliente
@Controller
@RequestMapping
public class ClienteController {
    // =================================================================================================
    //Inyeccion de dependecia para obtener los metodos del cliente
    // =================================================================================================
    @Autowired
    ClienteService clienteService;

    // =================================================================================================
    //Pantalla de select para mostrar todos los clientes
    // =================================================================================================
    @GetMapping("/clientes")
    public String showClientes(Model model){
        // =================================================================================================
        //Se añade al modelo de la vista el select de la base con todos los clientes
        // =================================================================================================
        model.addAttribute("clientes", clienteService.getAllClientes());
        return "crud/cliente/select_cliente";
    }

    // =================================================================================================
    // Pantalla de insert para agregar un cliente
    // =================================================================================================
    @GetMapping("/updateCliente/{id}")
    public String editCliente(@PathVariable("id") int id, Model model){
        model.addAttribute("cliente", clienteService.getClienteById(id));
        return "crud/cliente/update_cliente_form";

    }
}

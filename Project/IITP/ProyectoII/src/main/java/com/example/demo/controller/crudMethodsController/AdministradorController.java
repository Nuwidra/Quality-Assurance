package com.example.demo.controller.crudMethodsController;

import com.example.demo.service.administradorPackage.AdministradorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
// =================================================================================================
// Controller para manejar las operaciones CRUD de los veterinario
// =================================================================================================
@Controller
@RequestMapping
public class AdministradorController {
    // =================================================================================================
    //Inyeccion de dependecia para obtener los metodos de veterinario el cual es un servicio
    // =================================================================================================
    @Autowired
    AdministradorService administradorService;
    // =================================================================================================
    //Pantalla de select para mostrar todos los veterinarios}
    // =================================================================================================
    @GetMapping("/administradores")
    public String showVeterinarios(Model model){
        // =================================================================================================
        //Se añade al modelo de la vista el select de los veterinarios
        // =================================================================================================
        model.addAttribute("administradores", administradorService.getAllAdministradores());
        return "crud/administrador/select_administrador";
    }

}

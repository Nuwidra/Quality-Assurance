package com.example.demo.controller;

// Controller para el menu del crud

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
// =================================================================================================
// Vista cliente controller
// =================================================================================================
@Controller
@RequestMapping
public class VistaClienteController {
    // =================================================================================================
    // Establecer la ruta de la pagina de inicio del cliente
    // =================================================================================================
    @GetMapping("/cliente")
    public String inicio(Model model){
        // =================================================================================================
        // Añaadir el modelo de la vista
        // =================================================================================================
        model.addAttribute("test");
        return "cliente";
    }
}

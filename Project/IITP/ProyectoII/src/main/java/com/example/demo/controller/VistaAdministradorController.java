package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
// =================================================================================================
// Controller para el menu del veterinario
// =================================================================================================
@Controller
@RequestMapping
public class VistaAdministradorController {
    // =================================================================================================
    // Aca se redirecciona a la pagina de inicio del veterinario
    // =================================================================================================
    @GetMapping("/administrador")
    public String inicio(Model model){
        model.addAttribute("test");
        return "admin";
    }
}

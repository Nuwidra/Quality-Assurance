package com.example.demo.controller;


import com.example.demo.service.loginPackage.LogInClienteService;
import com.example.demo.service.ventaPackage.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
// =================================================================================================
// Controller para manejar el login del cliente
// =================================================================================================
@Controller
@RequestMapping
public class VistaLogInClienteController {

    // =================================================================================================
    // Inyeccion de dependecia para obtener los metodos de login
    // =================================================================================================
    @Autowired
    private LogInClienteService logInClienteService;

    // =================================================================================================
    // Inyeccion de dependecia para obtener los metodos de producto
    // =================================================================================================
    @GetMapping("/loginView")
    public String inicio(Model model){
        model.addAttribute("test");
        return "login";
    }
    // =================================================================================================
    // Metodo para manejar el login del cliente
    // =================================================================================================
    @GetMapping("/login")
    public String login(@RequestParam(value = "id", required = true) String idString,
                        @RequestParam(value = "password", required = true) String password, Model model) {
        // =================================================================================================
        // Se convierte el id a entero
        // =================================================================================================
        int id = Integer.parseInt(idString);
        System.out.println(String.valueOf(id) + " " + password);

        // =================================================================================================
        // Se valida el login
        // =================================================================================================
        if (id == 0 || password.equals("")) {
            return "login";
        }
        // =================================================================================================
        // Se valida el login
        // =================================================================================================
        int resultado_login = logInClienteService.getUsertByType(id, password);

        // =================================================================================================
        // Se valida el login en el caso de que sea un cliente
        // =================================================================================================
        if (resultado_login == 0) {
            return "cliente";
            // =================================================================================================
            // Se valida el login en el caso de que sea un admin
            // =================================================================================================
        } else if (resultado_login == 1) {
            return "admin";
        }

        return "login";
    }
}

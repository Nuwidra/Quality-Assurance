package com.example.demo.controller.customMethodsController;


import com.example.demo.service.ventaPackage.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
// =================================================================================================
// Controller para manejar el metodo de listar los productos
// =================================================================================================
@Controller
@RequestMapping
public class ListarProductosController {
    // =================================================================================================
    //Inyeccion para obtener los metodos de producto
    // =================================================================================================
    @Autowired
    private ProductoService productoService;
    // =================================================================================================
    //Pantalla mostrar los productos
    // =================================================================================================
    @GetMapping("/productos_existentes")
    // =================================================================================================
    // Metodo para mostrar los productos
    // =================================================================================================
    public String listDueño(Model model){
        // =================================================================================================
        // se añade al modelo de la vista el select de la base con todos los productos
        // =================================================================================================
        model.addAttribute("pe", productoService.getAllProducto());
        return "post/productos_existentes";
    }


}

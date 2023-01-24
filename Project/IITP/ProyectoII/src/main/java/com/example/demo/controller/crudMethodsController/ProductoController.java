package com.example.demo.controller.crudMethodsController;

import com.example.demo.service.ventaPackage.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
// =================================================================================================
// Controller para manejar las operaciones CRUD de los productos
// =================================================================================================
@Controller
@RequestMapping
public class ProductoController {
    // =================================================================================================
    //Inyeccion de dependecia para obtener los metodos de productos
    // =================================================================================================
    @Autowired
    ProductoService productoService;

    // =================================================================================================
    //Pantalla de select para mostrar todos los productos
    // =================================================================================================
    @GetMapping("/productos")
    public String showVeterinarios(Model model){
        // =================================================================================================
        //Se añade al modelo de la vista el select de la base con todos los productos
        // =================================================================================================
        model.addAttribute("productos", productoService.getAllProducto());
        return "crud/producto/select_producto";
    }

}

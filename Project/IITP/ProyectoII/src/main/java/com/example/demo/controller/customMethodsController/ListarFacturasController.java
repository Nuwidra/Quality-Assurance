package com.example.demo.controller.customMethodsController;


import com.example.demo.model.clientePackage.Cliente;
import com.example.demo.model.clientePackage.FacturaCompra;
import com.example.demo.service.clientePackage.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
// =================================================================================================
// Controller para manejar el metodo de desplegar todas las facturas
// =================================================================================================
@Controller
@RequestMapping
public class ListarFacturasController {
    // =================================================================================================
    //Inyeccion de dependecia para obtener los metodos de cliente
    // =================================================================================================
    @Autowired
    private ClienteService clienteService;
    // =================================================================================================
    //Pantalla para escoger el cliente
    // =================================================================================================
    @GetMapping("/get_cliente")
    public String getCliente(Model model) {
        // =================================================================================================
        // añade al modelo de la vista el select de la base con todos los clientes
        // =================================================================================================
        model.addAttribute("a");
        return "get/escoger_cliente";
    }
    // =================================================================================================
    //Pantalla para que muestra las facturas del cliente respectivo
    // =================================================================================================
    @GetMapping("/escoger_cliente")
    public String showClientes(@RequestParam(value = "id", required = true) int id, Model model) {
        // =================================================================================================
        // En el modelo de la vista se añade el cliente y su lista de facturas
        // =================================================================================================
        if (id == 0) {
            return "get/escoger_cliente";
        }
        // =================================================================================================
        //Se obtiene al cliente en especifico
        // =================================================================================================
        Cliente actual = clienteService.getClienteById(id);
        // =================================================================================================
        //Se obtienen las facturas de compra
        // =================================================================================================
        List<FacturaCompra> facturaCompras = actual.getFacturasCompra();
        // =================================================================================================
        //Se añaden al modelo de la vista
        // =================================================================================================

        model.addAttribute("cliente", actual);
        // =================================================================================================
        // facturas de compra
        // =================================================================================================

        model.addAttribute("factura_compra", facturaCompras);

        return "post/facturas_cliente";
    }
}
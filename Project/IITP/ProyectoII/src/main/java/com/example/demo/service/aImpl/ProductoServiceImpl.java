package com.example.demo.service.aImpl;

import com.example.demo.dao.hospitalPackage.ProductoDAO;
import com.example.demo.model.ventaPackage.Producto;
import com.example.demo.service.ventaPackage.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
// =================================================================================================
// Clase que contiene los atributos de los productos
// =================================================================================================
@Service
public class ProductoServiceImpl implements ProductoService {
    // =================================================================================================
    // Atributos
    // =================================================================================================
    @Autowired
    private ProductoDAO productodao;

    // =================================================================================================
    // Métodos
    // =================================================================================================
    @Override
    public List<Producto> getAllProducto() {
        return productodao.findAll();
    }

    @Override
    public Producto saveProducto(Producto producto) {
        return productodao.save(producto);
    }

    @Override
    public Producto getProductoById(int identificador) {
        return productodao.findById(identificador).get();
    }

    @Override
    public Producto updateProducto(Producto producto) {
        return productodao.save(producto);
    }

    @Override
    public void deleteProducto(int identificador) {
        productodao.deleteById(identificador);

    }
}

package com.example.demo.service.ventaPackage;

import com.example.demo.model.ventaPackage.Producto;

import java.util.List;
// =================================================================================================
// Interface para acceder a las operaciones de la base de datos en la entidad del producto
// =================================================================================================
public interface ProductoService {

    List<Producto> getAllProducto();

    Producto saveProducto(Producto producto);

    Producto getProductoById(int identificador);

    Producto updateProducto(Producto producto);

    void deleteProducto(int identificador);
}

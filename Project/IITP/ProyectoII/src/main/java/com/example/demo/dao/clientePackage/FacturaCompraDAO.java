package com.example.demo.dao.clientePackage;

import com.example.demo.model.clientePackage.FacturaCompra;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;
// =================================================================================================
//DAO para acceder a las operaciones de la base de datos en la entidad de las factuas de compra
//Se utiliza la biblioteca de spring JpaRepository para acceder a la base de datos
// =================================================================================================
public interface FacturaCompraDAO extends JpaRepository<FacturaCompra, Integer> {
    // =================================================================================================
    //Se añade el metodo para listar por fechas, ya que el jpa no implemente este tipo de metodos
    // =================================================================================================
    @Query("from FacturaCompra fa where fa.fecha between :inicio and :fin")
    List<FacturaCompra> listarPorFechas(@Param("inicio") Date inicio,
                                          @Param("fin")Date fin);

}

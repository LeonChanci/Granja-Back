package com.spring.granjaporcina.granja.model.repository;

import com.spring.granjaporcina.granja.model.PorcinoEntity;
import com.spring.granjaporcina.granja.model.interfaces.InformeSumary;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.ListCrudRepository;

import java.util.List;
public interface PorcinoRepository extends ListCrudRepository<PorcinoEntity, Integer> {

    //@Query -> usando JPQL Obtener porcinos con el id del cliente
    //@Query(value = "SELECT por FROM PorcinoEntity por WHERE por.idCliente = :idCliente")
    //ClienteEntity findByIdCliente(@Param("idCliente") String idCliente);

    @Query(value = "SELECT por.id_porcino AS idPorcino, por.edad AS edad, por.peso AS peso," +
            "           cli.id_cliente AS idCliente, cli.nombres AS nombres, cli.apellidos AS apellidos," +
            "           cli.direccion AS direccion, cli.telefono AS telefono," +
            "           raz.id_raza AS idRaza, raz.descripcion AS descripcionRaza," +
            "           ali.id_alimentacion AS idAlimentacion, ali.descripcion AS descripcionAl," +
            "           ali.dosis AS dosis" +
            "       FROM porcino por " +
            "       INNER JOIN cliente cli ON cli.id_cliente = por.id_cliente " +
            "       INNER JOIN raza raz ON raz.id_raza = por.id_raza " +
            "       INNER JOIN alimentacion ali ON ali.id_alimentacion = por.id_alimentacion;", nativeQuery = true)
    List<InformeSumary> findInforme();
}
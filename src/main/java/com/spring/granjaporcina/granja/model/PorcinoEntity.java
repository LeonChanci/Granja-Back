package com.spring.granjaporcina.granja.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "porcino")
@Getter
@Setter
@NoArgsConstructor
public class PorcinoEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_porcino", nullable = false)
    private Integer idPorcino;

    @Column(name = "id_raza", nullable = false, length = 15)
    private String idRaza;

    @Column(name = "id_cliente", nullable = false, length = 15)
    private String idCliente;

    @Column(name = "id_alimentacion", nullable = false, length = 15)
    private String idAlimentacion;

    @Column(name = "edad", nullable = false)
    private Integer edad;

    @Column(name = "peso", nullable = false, columnDefinition = "Decimal(5,2)")
    private Double peso;

    //Tipo de recuperación será Lazing -> No cargar esta relacion sino se usa
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_raza", referencedColumnName = "id_raza", insertable = false, updatable = false)
    @JsonIgnore
    private RazaEntity raza;

    //Tipo de recuperación será Lazing -> No cargar esta relacion sino se usa
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_cliente", referencedColumnName = "id_cliente", insertable = false, updatable = false)
    @JsonIgnore
    private ClienteEntity cliente;

    //Tipo de recuperación será Lazing -> No cargar esta relacion sino se usa
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_alimentacion", referencedColumnName = "id_alimentacion", insertable = false, updatable = false)
    @JsonIgnore
    private AlimentacionEntity alimentacion;
}

package com.spring.granjaporcina.granja.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "alimentacion")
@Getter
@Setter
@NoArgsConstructor
public class AlimentacionEntity {

    @Id
    @Column(name = "id_alimentacion", nullable = false, length = 15)
    private String idAlimentacion;

    @Column(name = "descripcion", nullable = false, length = 60)
    private String descripcionAl;

    @Column(name = "dosis", nullable = false, length = 60)
    private String dosis;
}

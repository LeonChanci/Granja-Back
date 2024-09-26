package com.spring.granjaporcina.granja.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "raza")
@Getter
@Setter
@NoArgsConstructor
public class RazaEntity {

    @Id
    @Column(name = "id_raza", nullable = false, length = 15)
    private String idRaza;

    @Column(name = "descripcion", nullable = false, length = 60)
    private String descripcionRaza;
}

package com.Club.Nautico.Modelo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Barco {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idBarco;

    private String matricula;
    private String nombre;
    private Integer n_Amarre;
    private Double cuota;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "idUsuario")
    private Usuario propietario;

}

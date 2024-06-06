package com.Club.Nautico.Modelo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Salida {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idSalida;

    @Temporal(TemporalType.DATE)
    private Date fecha;

    private String destino;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "idBarco")
    private Barco barco;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "idUsuario")
    private Usuario usuario;
}

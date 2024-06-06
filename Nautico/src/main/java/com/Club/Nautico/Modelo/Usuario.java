package com.Club.Nautico.Modelo;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idUsuario;

    @Column(unique = true)
    private Integer cod_socio;

    @Column(unique = true)
    private Integer cod_patron;

    private String nombre;
    private String apellidos;
    private String email;
}

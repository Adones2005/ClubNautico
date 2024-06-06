package com.Club.Nautico.Repository;

import com.Club.Nautico.Modelo.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario,Integer> {
}

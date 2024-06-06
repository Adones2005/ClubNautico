package com.Club.Nautico.Repository;

import com.Club.Nautico.Modelo.Salida;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SalidaRepository extends JpaRepository<Salida,Integer> {
    List<Salida> findByBarcoIdBarco(Integer id);
}

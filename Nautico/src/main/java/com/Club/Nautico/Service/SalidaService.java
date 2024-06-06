package com.Club.Nautico.Service;

import com.Club.Nautico.Modelo.Salida;

import java.util.List;
import java.util.Optional;

public interface SalidaService {
    List<Salida> getAllSalidas();
    Optional<Salida> getSalidaById(Integer id);
    Salida saveSalida(Salida salida);
    Salida updateSalida(Integer id, Salida updatedSalida);
    void deleteSalida(Integer id);
}


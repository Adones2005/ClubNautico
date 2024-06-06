package com.Club.Nautico.Service;

import com.Club.Nautico.Modelo.Barco;

import java.util.List;
import java.util.Optional;

public interface BarcoService {

    public List<Barco> getAllBarcos();

    public Optional<Barco> getBarcoById(Integer id);

    public Barco updateBarco(Integer id, Barco barco);

    public Barco saveBarco(Barco barco);

    public void deleteBarcoById(Integer id);
}


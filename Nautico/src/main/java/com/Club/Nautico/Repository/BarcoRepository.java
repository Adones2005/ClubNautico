package com.Club.Nautico.Repository;

import com.Club.Nautico.Modelo.Barco;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BarcoRepository extends JpaRepository<Barco, Integer> {
}

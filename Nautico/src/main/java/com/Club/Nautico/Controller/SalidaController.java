package com.Club.Nautico.Controller;

import com.Club.Nautico.Modelo.Salida;
import com.Club.Nautico.Service.SalidaServiceImpl;
import com.Club.Nautico.Exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/salidas")
public class SalidaController {

    @Autowired
    private SalidaServiceImpl salidaServiceImpl;

    @GetMapping
    public ResponseEntity<List<Salida>> getAllSalidas() {
        List<Salida> salidas = salidaServiceImpl.getAllSalidas();
        return ResponseEntity.ok(salidas);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Salida> getSalidaById(@PathVariable Integer id) {
        Salida salida = salidaServiceImpl.getSalidaById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Salida no encontrada con id: " + id));
        return ResponseEntity.ok(salida);
    }

    @PostMapping
    public ResponseEntity<Salida> saveSalida(@RequestBody Salida salida) {
        Salida salidaGuardada = salidaServiceImpl.saveSalida(salida);
        return ResponseEntity.status(HttpStatus.CREATED).body(salidaGuardada);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Salida> updateSalida(@PathVariable Integer id, @RequestBody Salida nuevaSalida) {
        Salida salidaActualizada = salidaServiceImpl.updateSalida(id, nuevaSalida);
        return ResponseEntity.ok(salidaActualizada);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSalida(@PathVariable Integer id) {
        salidaServiceImpl.deleteSalida(id);
        return ResponseEntity.noContent().build();
    }
}

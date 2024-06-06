package com.Club.Nautico.Controller;

import com.Club.Nautico.Modelo.Barco;
import com.Club.Nautico.Service.BarcoServiceImpl;
import com.Club.Nautico.Exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/barcos")
public class BarcoController {

    @Autowired
    private BarcoServiceImpl barcoServiceImpl;

    @GetMapping
    public ResponseEntity<List<Barco>> getAllBarcos() {
        List<Barco> barcos = barcoServiceImpl.getAllBarcos();
        return ResponseEntity.ok(barcos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Barco> getBarcoById(@PathVariable Integer id) {
        Barco barco = barcoServiceImpl.getBarcoById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Barco no encontrado con id: " + id));
        return ResponseEntity.ok(barco);
    }

    @PostMapping
    public ResponseEntity<Barco> createBarco(@RequestBody Barco barco) {
        Barco barcoGuardado = barcoServiceImpl.saveBarco(barco);
        return ResponseEntity.status(HttpStatus.CREATED).body(barcoGuardado);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Barco> updateBarco(@PathVariable Integer id, @RequestBody Barco barcoDetalles) {
        Barco updatedBarco = barcoServiceImpl.updateBarco(id, barcoDetalles);
        return ResponseEntity.ok(updatedBarco);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBarco(@PathVariable Integer id) {
        barcoServiceImpl.deleteBarcoById(id);
        return ResponseEntity.noContent().build();
    }
}

package com.Club.Nautico.Service;

import com.Club.Nautico.Modelo.Barco;
import com.Club.Nautico.Modelo.Salida;
import com.Club.Nautico.Modelo.Usuario;
import com.Club.Nautico.Repository.BarcoRepository;
import com.Club.Nautico.Repository.SalidaRepository;
import com.Club.Nautico.Exception.ResourceNotFoundException;
import com.Club.Nautico.Repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class SalidaServiceImpl implements SalidaService {

    @Autowired
    private SalidaRepository salidaRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private BarcoRepository barcoRepository;


    @Override
    public List<Salida> getAllSalidas() {
        return salidaRepository.findAll();
    }

    @Override
    public Optional<Salida> getSalidaById(Integer id) {
        return salidaRepository.findById(id);
    }

    @Override
    public Salida saveSalida(Salida salida) {
        if (Objects.nonNull(salida.getUsuario())) {
            Usuario usuario = usuarioRepository.findById(salida.getUsuario().getIdUsuario())
                    .orElseThrow(() -> new IllegalArgumentException("El usuario no existe"));

            if (Objects.nonNull(usuario.getCod_patron())) {
                Barco barco = barcoRepository.findById(salida.getBarco().getIdBarco())
                        .orElseThrow(() -> new IllegalArgumentException("El barco no existe"));

                salida.setBarco(barco);
                salida.setUsuario(usuario);

                return salidaRepository.save(salida);
            } else {
                throw new IllegalArgumentException("El usuario no tiene un código de patrón válido.");
            }
        } else {
            throw new IllegalArgumentException("No se puede añadir una salida sin un usuario patrón.");
        }
    }

    @Override
    public Salida updateSalida(Integer id, Salida salidaDetalles) {
        Salida salida = salidaRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("La salida no existe"));

        if (Objects.nonNull(salidaDetalles.getUsuario())) {
            Usuario usuario = usuarioRepository.findById(salidaDetalles.getUsuario().getIdUsuario())
                    .orElseThrow(() -> new IllegalArgumentException("El usuario no existe"));

            if (Objects.nonNull(usuario.getCod_patron())) {
                Barco barco = barcoRepository.findById(salidaDetalles.getBarco().getIdBarco())
                        .orElseThrow(() -> new IllegalArgumentException("El barco no existe"));

                salida.setFecha(salidaDetalles.getFecha());
                salida.setDestino(salidaDetalles.getDestino());
                salida.setBarco(barco);
                salida.setUsuario(usuario);

                return salidaRepository.save(salida);
            } else {
                throw new IllegalArgumentException("El usuario no tiene un código de patrón válido.");
            }
        } else {
            throw new IllegalArgumentException("No se puede actualizar una salida sin un usuario patrón.");
        }
    }


    @Override
    public void deleteSalida(Integer id) {
        if (!salidaRepository.existsById(id)) {
            throw new ResourceNotFoundException("Salida no encontrada con id: " + id);
        }
        salidaRepository.deleteById(id);
    }
}

package com.Club.Nautico.Service;

import com.Club.Nautico.Modelo.Barco;
import com.Club.Nautico.Modelo.Salida;
import com.Club.Nautico.Modelo.Usuario;
import com.Club.Nautico.Repository.BarcoRepository;
import com.Club.Nautico.Repository.SalidaRepository;
import com.Club.Nautico.Repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class BarcoServiceImpl implements BarcoService {

    @Autowired
    BarcoRepository barcoRepository;

    @Autowired
    UsuarioRepository usuarioRepository;

    @Autowired
    SalidaRepository salidaRepository;

    @Override
    public List<Barco> getAllBarcos() {
        return barcoRepository.findAll();
    }

    @Override
    public Optional<Barco> getBarcoById(Integer id) {
        return barcoRepository.findById(id);
    }

    @Override
    public Barco updateBarco(Integer id, Barco barcoDetalles) {
        Barco barco = barcoRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("El barco no existe"));

        if (Objects.nonNull(barcoDetalles.getPropietario())) {

            Usuario propietario = usuarioRepository.findById(barcoDetalles.getPropietario().getIdUsuario())
                    .orElseThrow(() -> new IllegalArgumentException("El usuario no existe"));

            if (Objects.nonNull(propietario.getCod_socio())) {

                barco.setMatricula(barcoDetalles.getMatricula());
                barco.setNombre(barcoDetalles.getNombre());
                barco.setN_Amarre(barcoDetalles.getN_Amarre());
                barco.setCuota(barcoDetalles.getCuota());
                barco.setPropietario(propietario);

                return barcoRepository.save(barco);
            } else {

                throw new IllegalArgumentException("El propietario no tiene un código de socio válido.");
            }
        } else {

            throw new IllegalArgumentException("No se puede actualizar un barco con un propietario nulo.");
        }
    }


    @Override
    public Barco saveBarco(Barco barco) {
        // Verificar si el propietario no es nulo
        if (Objects.nonNull(barco.getPropietario())) {
            // Buscar al propietario en la base de datos
            Usuario propietario = usuarioRepository.findById(barco.getPropietario().getIdUsuario())
                    .orElseThrow(() -> new IllegalArgumentException("El usuario no existe"));

            // Verificar si el código de socio del propietario no es nulo
            if (Objects.nonNull(propietario.getCod_socio())) {
                barco.setPropietario(propietario);


                return barcoRepository.save(barco);
            } else {
                throw new IllegalArgumentException("El propietario no tiene un código de socio válido.");
            }
        } else {
            throw new IllegalArgumentException("No se puede añadir un propietario nulo.");
        }
    }


    @Override
    public void deleteBarcoById(Integer id) {
        Barco barco = barcoRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Barco not found"));

        List<Salida> salidas = salidaRepository.findByBarcoIdBarco(id);
        salidaRepository.deleteAll(salidas);

        // Delete the Barco instance
        barcoRepository.delete(barco);
    }
}


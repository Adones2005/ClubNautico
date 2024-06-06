package com.Club.Nautico.Service;

import com.Club.Nautico.Modelo.Usuario;

import java.util.List;
import java.util.Optional;

public interface UsuarioService {
    List<Usuario> getAllUsuarios();
    Optional<Usuario> getUsuarioById(Integer id);
    Usuario updateUsuario(Integer id, Usuario usuarioDetalles);
    Usuario saveUsuario(Usuario usuario);
    void deleteUsuarioById(Integer id);
}

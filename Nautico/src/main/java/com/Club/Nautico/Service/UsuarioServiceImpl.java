package com.Club.Nautico.Service;

import com.Club.Nautico.Modelo.Usuario;
import com.Club.Nautico.Repository.UsuarioRepository;
import com.Club.Nautico.Exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public List<Usuario> getAllUsuarios() {
        return usuarioRepository.findAll();
    }

    @Override
    public Optional<Usuario> getUsuarioById(Integer id) {
        return usuarioRepository.findById(id);
    }

    @Override
    public Usuario updateUsuario(Integer id, Usuario usuarioDetalles) {
        Usuario usuario = usuarioRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Usuario no encontrado con id: " + id));
        usuario.setNombre(usuarioDetalles.getNombre());
        usuario.setApellidos(usuarioDetalles.getApellidos());
        usuario.setEmail(usuarioDetalles.getEmail());
        usuario.setCod_socio(usuarioDetalles.getCod_socio());
        usuario.setCod_patron(usuarioDetalles.getCod_patron());
        return usuarioRepository.save(usuario);
    }

    @Override
    public Usuario saveUsuario(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    @Override
    public void deleteUsuarioById(Integer id) {
        if (!usuarioRepository.existsById(id)) {
            throw new ResourceNotFoundException("Usuario no encontrado con id: " + id);
        }
        usuarioRepository.deleteById(id);
    }
}

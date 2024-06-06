package com.Club.Nautico.Controller;

import com.Club.Nautico.Modelo.Usuario;
import com.Club.Nautico.Service.UsuarioServiceImpl;
import com.Club.Nautico.Exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioServiceImpl usuarioServiceImpl;

    @GetMapping
    public ResponseEntity<List<Usuario>> getAllUsuarios() {
        List<Usuario> usuarios = usuarioServiceImpl.getAllUsuarios();
        return ResponseEntity.ok(usuarios);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Usuario> getUsuarioById(@PathVariable Integer id) {
        Usuario usuario = usuarioServiceImpl.getUsuarioById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Usuario no encontrado con id: " + id));
        return ResponseEntity.ok(usuario);
    }

    @PostMapping
    public ResponseEntity<Usuario> createUsuario(@RequestBody Usuario usuario) {
        Usuario usuarioGuardado = usuarioServiceImpl.saveUsuario(usuario);
        return ResponseEntity.status(HttpStatus.CREATED).body(usuarioGuardado);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Usuario> updateUsuario(@PathVariable Integer id, @RequestBody Usuario usuarioDetalles) {
        Usuario updatedUsuario = usuarioServiceImpl.updateUsuario(id, usuarioDetalles);
        return ResponseEntity.ok(updatedUsuario);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUsuario(@PathVariable Integer id) {
        usuarioServiceImpl.deleteUsuarioById(id);
        return ResponseEntity.noContent().build();
    }
}

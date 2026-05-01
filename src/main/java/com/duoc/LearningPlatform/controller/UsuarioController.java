package com.duoc.LearningPlatform.controller;

import java.net.URI;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;


import com.duoc.LearningPlatform.model.Usuario;
import com.duoc.LearningPlatform.service.UsuarioService;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Positive;

@RestController
public class UsuarioController {

    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService){
        this.usuarioService = usuarioService;
    }


     //mapeo para obtener todos los usuarios
    @GetMapping("/api/usuarios")
    public ResponseEntity<List<Usuario>> obtenerTodosUsuario() {
        return ResponseEntity.ok(usuarioService.obtenerTodosUsuarios());
    }

    //mapeo para obtencion de usuario por id 
    @GetMapping("/api/usuaios/{id}")
    public ResponseEntity<Usuario> obtenerUsuarioPorId(@PathVariable @Positive long id) {
        return usuarioService.obtenerUsuarioPorId(id).map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
    }

    //mapeo para registrar usuario
    @PostMapping("/api/usuarios")
    public ResponseEntity<Usuario> registrarUsuario(@Valid @RequestBody Usuario usuario) {
        Usuario usuarioCreado = usuarioService.registrarUsuario(usuario);
        URI ruta = ServletUriComponentsBuilder.fromCurrentRequest()
            .path("/{id}")
            .buildAndExpand(usuarioCreado.getId())
            .toUri();
        return ResponseEntity.created(ruta).body(usuarioCreado);
    }

    // mapeo para modificacion de usuario
    @PutMapping("/api/usuarios/{id}")
    public ResponseEntity<Usuario> actualizarUsuario(@Valid @PathVariable @Positive Long id, @Valid @RequestBody Usuario usuario) {
        return usuarioService.modificarUsuario(id, usuario).map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
    }
    
    // mapeo para eliminar usuario 
    @DeleteMapping("/api/usuarios/{id}")
    public ResponseEntity<Void> eliminarUsuario(@PathVariable @Positive Long id){
        return usuarioService.eliminarUsuario(id)
        ? ResponseEntity.noContent().build()
        : ResponseEntity.notFound().build();
    }
    
}

package com.duoc.LearningPlatform.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.duoc.LearningPlatform.model.Usuario;
import com.duoc.LearningPlatform.repository.UsuarioRepository;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository){
        this.usuarioRepository = usuarioRepository;
    }

    //Obtencion de todos los usuarios
    public List<Usuario> obtenerTodosUsuarios() {
        return usuarioRepository.findAll();
    }

    //obtiene usuarios mediante id
    public Optional<Usuario> obtenerUsuarioPorId(Long id) {
      return usuarioRepository.findById(id);
    }
    
    // Agregar usuario
    public Usuario registrarUsuario(Usuario usuario){
        return usuarioRepository.save(usuario);
    }

    //Modificar usuario por id
    public Optional<Usuario> modificarUsuario(long id, Usuario usuario){
        if(usuarioRepository.existsById(id)){
            usuario.setId(id);
            return Optional.of(usuarioRepository.save(usuario));
        }
        return Optional.empty();
    }

    // Borrar usuario por id
    public Boolean eliminarUsuario(long id){
        if(!usuarioRepository.existsById(id)){
            return false;
        }
        usuarioRepository.deleteById(id);
        return true;
    }

}

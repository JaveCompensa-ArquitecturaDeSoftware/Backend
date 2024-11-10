package proj.arqui.serviciousuario.servicios;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import proj.arqui.serviciousuario.dtos.UsuarioDTO;
import proj.arqui.serviciousuario.entidades.Usuario;
import proj.arqui.serviciousuario.repositorios.RepositorioUsuario;

@Service
public class ServicioUsuario {
    RepositorioUsuario usuariorepositorio;
    ModelMapper modelMapper;

    @Autowired
    ServicioUsuario(RepositorioUsuario usuariorepositorio, ModelMapper modelMapper){
        this.usuariorepositorio = usuariorepositorio;
        this.modelMapper = modelMapper;
    }

    public UsuarioDTO get(Long id){
        Optional<Usuario>UsuarioOpt = usuariorepositorio.findById(id);
        UsuarioDTO UsuarioDTO = null;
        if(UsuarioOpt.isPresent()){
            Usuario usu = UsuarioOpt.get();
            UsuarioDTO = modelMapper.map(usu, UsuarioDTO.class);
        }
        return UsuarioDTO;
    }

    public List<UsuarioDTO> get(){
        List<Usuario> Usuarios = (List<Usuario>) usuariorepositorio.findAll();
        List<UsuarioDTO> UsuarioDTOs = Usuarios.stream()
                                                        .map(Usuario -> modelMapper.map(Usuario, UsuarioDTO.class))
                                                        .collect(Collectors.toList());
        return UsuarioDTOs;
    }
    
    public UsuarioDTO save(Usuario Usuarioe){
        Usuario Usuario = Usuarioe;
        Usuario = usuariorepositorio.save(Usuario);
        UsuarioDTO UsuarioDTO = modelMapper.map(Usuario, UsuarioDTO.class);
        return UsuarioDTO;
    }

    public UsuarioDTO update(Usuario Usuarioe){
        Optional<Usuario> UsuarioOptional = usuariorepositorio.findById(Usuarioe.getId_usuario());
    
        if (UsuarioOptional.isPresent()) {
            Usuario UsuarioDB = UsuarioOptional.get();
        
            if (Usuarioe.getNombre() != null) {
                UsuarioDB.setNombre(Usuarioe.getNombre());
            }
            if (Usuarioe.getUsuario() != null) {
                UsuarioDB.setUsuario(Usuarioe.getUsuario());
            }
            if (Usuarioe.getCorreo() != null) {
                UsuarioDB.setCorreo(Usuarioe.getCorreo());
            }
            if (Usuarioe.getContrasena() != null) {
                UsuarioDB.setContrasena(Usuarioe.getContrasena());
            }
            if (Usuarioe.getEdad() != 0) {
                UsuarioDB.setEdad(Usuarioe.getEdad());
            }
            if (Usuarioe.getElimnado() != UsuarioDB.getElimnado()) {
                UsuarioDB.setElimnado(Usuarioe.getElimnado());
            }

            Usuario UsuarioActualizado = usuariorepositorio.save(UsuarioDB);
            UsuarioDTO UsuarioDTO = modelMapper.map(UsuarioActualizado, UsuarioDTO.class);
            return UsuarioDTO;
        } else {
            return null;
        }
    }

    public void delete(Long id){
    Optional<Usuario> UsuarioOpt = usuariorepositorio.findById(id);
        UsuarioOpt.ifPresent(Usuario -> {
            Usuario.setElimnado(true);
            usuariorepositorio.save(Usuario);
        });
    }
}

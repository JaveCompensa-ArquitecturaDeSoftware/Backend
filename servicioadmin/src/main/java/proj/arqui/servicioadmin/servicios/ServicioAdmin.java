package proj.arqui.servicioadmin.servicios;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import proj.arqui.servicioadmin.dtos.AdminDTO;
import proj.arqui.servicioadmin.repositorios.RepositorioAdmin;
import proj.arqui.servicioadmin.entidades.Admin;

@Service
public class ServicioAdmin {
    RepositorioAdmin adminrepositorio;
    ModelMapper modelMapper;

    @Autowired
    ServicioAdmin(RepositorioAdmin adminrepositorio, ModelMapper modelMapper){
        this.adminrepositorio = adminrepositorio;
        this.modelMapper = modelMapper;
    }

    public AdminDTO get(Long id){
        Optional<Admin>AdminOpt = adminrepositorio.findById(id);
        AdminDTO AdminDTO = null;
        if(AdminOpt.isPresent()){
            Admin adminn = AdminOpt.get();
            AdminDTO = modelMapper.map(adminn, AdminDTO.class);
        }
        return AdminDTO;
    }

    public List<AdminDTO> get(){
        List<Admin> Admins = (List<Admin>) adminrepositorio.findAll();
        List<AdminDTO> AdminDTOs = Admins.stream()
                                                        .map(Admin -> modelMapper.map(Admin, AdminDTO.class))
                                                        .collect(Collectors.toList());
        return AdminDTOs;
    }
    
    public AdminDTO save(Admin Admine){
        Admin Admin = Admine;
        Admin = adminrepositorio.save(Admin);
        AdminDTO AdminDTO = modelMapper.map(Admin, AdminDTO.class);
        return AdminDTO;
    }

    public AdminDTO update(Admin Admine){
        Optional<Admin> AdminOptional = adminrepositorio.findById(Admine.getId_usuario());
    
        if (AdminOptional.isPresent()) {
            Admin AdminDB = AdminOptional.get();
        
            if (Admine.getNombre() != null) {
                AdminDB.setNombre(Admine.getNombre());
            }
            if (Admine.getUsuario() != null) {
                AdminDB.setUsuario(Admine.getUsuario());
            }
            if (Admine.getCorreo() != null) {
                AdminDB.setCorreo(Admine.getCorreo());
            }
            if (Admine.getContrasena() != null) {
                AdminDB.setContrasena(Admine.getContrasena());
            }
            if (Admine.getEdad() != 0) {
                AdminDB.setEdad(Admine.getEdad());
            }
            if (Admine.getElimnado() != AdminDB.getElimnado()) {
                AdminDB.setElimnado(Admine.getElimnado());
            }

            Admin AdminActualizado = adminrepositorio.save(AdminDB);
            AdminDTO AdminDTO = modelMapper.map(AdminActualizado, AdminDTO.class);
            return AdminDTO;
        } else {
            return null;
        }
    }

    public void delete(Long id){
    Optional<Admin> AdminOpt = adminrepositorio.findById(id);
        AdminOpt.ifPresent(Admin -> {
            Admin.setElimnado(true);
            adminrepositorio.save(Admin);
        });
    }
}

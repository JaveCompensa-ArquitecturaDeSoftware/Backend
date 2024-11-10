package proj.arqui.serviciosedes.servicios;

import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import proj.arqui.serviciosedes.entidades.Sede;
import proj.arqui.serviciosedes.reporsitorios.RepositorioSede;

@Service
public class ServicioSede {
    private RepositorioSede reposede;
    private ModelMapper modelMapper;

    @Autowired
    ServicioSede(RepositorioSede repositoriosede, ModelMapper modelmapper){
        this.reposede = repositoriosede;
        this.modelMapper = modelmapper;
    }

    public Sede getSede(Long id){
        Optional<Sede>SedeOpt = reposede.findById(id);
        Sede Sede = null;
        if(SedeOpt.isPresent()){
            Sede Sede1 = SedeOpt.get();
            Sede = modelMapper.map(Sede1, Sede.class);
        }
        return Sede;
    }

    public Sede save(Sede Sedee){
        Sede Sede = Sedee;
        Sede = reposede.save(Sedee);
        Sede Sede1 = modelMapper.map(Sede, Sede.class);
        return Sede1;
    }

    public void delete(Long id){
        Optional<Sede> SedeOpt = reposede.findById(id);
        SedeOpt.ifPresent(Sede -> {
            Sede.setElimnado(true);
            reposede.save(Sede);
        });
    }

    public Sede update(Sede Sedee){
        Optional<Sede> SedeOptional = reposede.findById(Sedee.getId_sede());
    
        if (SedeOptional.isPresent()) {
            Sede SedeDB = SedeOptional.get();
        
            if (Sedee.getNombre() != null) {
                SedeDB.setNombre(Sedee.getNombre());
            }
            if (Sedee.getDireccion() != null) {
                SedeDB.setDireccion(Sedee.getDireccion());
            }
            Sede SedeActualizado = reposede.save(SedeDB);
            Sede Sede = modelMapper.map(SedeActualizado, Sede.class);
            return Sede;
        } else {
            return null;
        }
    }
}

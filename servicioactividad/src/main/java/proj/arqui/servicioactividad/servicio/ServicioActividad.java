package proj.arqui.servicioactividad.servicio;

import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import proj.arqui.servicioactividad.entidades.Actividad;
import proj.arqui.servicioactividad.repositorio.RepositorioActividad;

@Service
public class ServicioActividad {
    private RepositorioActividad repoactividad;
    private ModelMapper modelMapper;

    @Autowired
    ServicioActividad(RepositorioActividad RepositorioActividad, ModelMapper modelmapper){
        this.repoactividad = RepositorioActividad;
        this.modelMapper = modelmapper;
    }

    public Actividad getActividad(Long id){
        Optional<Actividad>ActividadOpt = repoactividad.findById(id);
        Actividad Actividad = null;
        if(ActividadOpt.isPresent()){
            Actividad Actividad1 = ActividadOpt.get();
            Actividad = modelMapper.map(Actividad1, Actividad.class);
        }
        return Actividad;
    }

    public Actividad save(Actividad Actividade){
        Actividad Actividad = Actividade;
        Actividad = repoactividad.save(Actividade);
        Actividad Actividad1 = modelMapper.map(Actividad, Actividad.class);
        return Actividad1;
    }

    public void delete(Long id){
        Optional<Actividad> ActividadOpt = repoactividad.findById(id);
        ActividadOpt.ifPresent(Actividad -> {
            Actividad.setElimnado(true);
            repoactividad.save(Actividad);
        });
    }

    public Actividad update(Actividad Actividade){
        Optional<Actividad> ActividadOptional = repoactividad.findById(Actividade.getId_actividad());
    
        if (ActividadOptional.isPresent()) {
            Actividad ActividadDB = ActividadOptional.get();
        
            if (Actividade.getNombre() != null) {
                ActividadDB.setNombre(Actividade.getNombre());
            }
            Actividad ActividadActualizado = repoactividad.save(ActividadDB);
            Actividad Actividad = modelMapper.map(ActividadActualizado, Actividad.class);
            return Actividad;
        } else {
            return null;
        }
    }
}

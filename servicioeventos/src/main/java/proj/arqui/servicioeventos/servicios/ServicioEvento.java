package proj.arqui.servicioeventos.servicios;

import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import proj.arqui.servicioeventos.entidades.Evento;
import proj.arqui.servicioeventos.repositorio.RepositorioEvento;

@Service
public class ServicioEvento {
    private RepositorioEvento repoevento;
    private ModelMapper modelMapper;

    @Autowired
    ServicioEvento(RepositorioEvento RepositorioEvento, ModelMapper modelmapper){
        this.repoevento = RepositorioEvento;
        this.modelMapper = modelmapper;
    }

    public Evento getEvento(Long id){
        Optional<Evento>EventoOpt = repoevento.findById(id);
        Evento Evento = null;
        if(EventoOpt.isPresent()){
            Evento Evento1 = EventoOpt.get();
            Evento = modelMapper.map(Evento1, Evento.class);
        }
        return Evento;
    }

    public Evento save(Evento Eventoe){
        Evento Evento = Eventoe;
        Evento = repoevento.save(Eventoe);
        Evento Evento1 = modelMapper.map(Evento, Evento.class);
        return Evento1;
    }

    public void delete(Long id){
        Optional<Evento> EventoOpt = repoevento.findById(id);
        EventoOpt.ifPresent(Evento -> {
            Evento.setElimnado(true);
            repoevento.save(Evento);
        });
    }

    public Evento update(Evento Eventoe){
        Optional<Evento> EventoOptional = repoevento.findById(Eventoe.getId_evento());
    
        if (EventoOptional.isPresent()) {
            Evento EventoDB = EventoOptional.get();
        
            if (Eventoe.getNombre() != null) {
                EventoDB.setNombre(Eventoe.getNombre());
            }
            Evento EventoActualizado = repoevento.save(EventoDB);
            Evento Evento = modelMapper.map(EventoActualizado, Evento.class);
            return Evento;
        } else {
            return null;
        }
    }
}

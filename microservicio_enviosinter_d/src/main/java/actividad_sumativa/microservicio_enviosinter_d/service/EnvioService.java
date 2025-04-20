package actividad_sumativa.microservicio_enviosinter_d.service;

import actividad_sumativa.microservicio_enviosinter_d.exception.EnvioNotFoundException;
import actividad_sumativa.microservicio_enviosinter_d.model.Envio;
import actividad_sumativa.microservicio_enviosinter_d.repository.EnvioRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import org.springframework.data.domain.Sort;


@Service
public class EnvioService {

    @Autowired
    private EnvioRepository repo;

    public List<Envio> obtenerTodas() {
        return repo.findAll(Sort.by("id").ascending());
    }

    public Envio obtenerPorId(Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new EnvioNotFoundException(id));
    }

    public Envio actualizar(Long id, String envioActualizado) {

        Envio existente = repo.findById(id)
                .orElseThrow(() -> new EnvioNotFoundException(id));

        
        existente.setEstado(envioActualizado);
        

        return repo.save(existente);
    }

    public Envio guardar(Envio envio) {

        if (repo.existsById(envio.getId())) {            
            throw new IllegalArgumentException("Ya existe una película con ID " + envio.getId());
        }
        return repo.save(envio);
    }

    public void eliminar(Long id) {       

        Envio existente = repo.findById(id)
                        .orElseThrow(() -> new EnvioNotFoundException(id));

        repo.delete(existente);
}
}

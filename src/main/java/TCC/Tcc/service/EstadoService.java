package TCC.Tcc.service;

import TCC.Tcc.model.Estado;
import TCC.Tcc.repository.EstadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EstadoService {

    @Autowired
    private EstadoRepository repository;

    public List<Estado> listaEstado(){
        return repository.findAll();
    }

    public Optional<Estado> buscaEstadoId(String id){
        return repository.findById(id);
    }
    public Estado gravaEstado(Estado estado){
        return repository.save(estado);
    }
}

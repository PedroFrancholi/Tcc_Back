package TCC.Tcc.service;

import TCC.Tcc.model.Curso;
import TCC.Tcc.model.Material;
import TCC.Tcc.repository.CursoRepository;
import TCC.Tcc.repository.MaterialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CursoService {

    @Autowired
    private CursoRepository repository;

    public List<Curso> listarCurso(){
        return repository.findAll();
    }

    public Optional<Curso> buscaCursoId(Long id){
        return repository.findById(id);
    }

    public Curso gravaCurso(Curso curso){
        return repository.save(curso);
    }

    public void deleteCurso(Optional<Curso> curso){
        repository.delete(curso.get());
    }
}

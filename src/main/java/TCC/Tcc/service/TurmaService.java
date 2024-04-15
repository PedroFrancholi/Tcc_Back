package TCC.Tcc.service;

import TCC.Tcc.model.Curso;
import TCC.Tcc.model.Turma;
import TCC.Tcc.repository.CursoRepository;
import TCC.Tcc.repository.TurmaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TurmaService {

    @Autowired
    private TurmaRepository turmaRepository;
    @Autowired
    private CursoRepository cursoRepository;

    public List<Turma> listarTurmas(){
        return turmaRepository.findAll();
    }

    public Optional<Turma> buscaTurmaId(Long id){
        return turmaRepository.findById(id);
    }

    public Object gravaTurma(Turma turma){
        Long idCurso = turma.getCurso().getId_curso();

        Optional<Curso> cursoExiste = cursoRepository.findById(idCurso);

        if(cursoExiste.isEmpty()){
            return ("Curso com o id: "+idCurso+" não encontrado!");
        }

        Turma newTurma = new Turma();
        newTurma.setDs_turma(turma.getDs_turma());
        newTurma.setCurso(cursoExiste.get());

        return turmaRepository.save(newTurma);
    }

    public Object alteraTurma(Turma turma){
        return turmaRepository.save(turma);
    }

    public void deleteTurma(Optional<Turma> turma){
        turmaRepository.delete(turma.get());
    }
}

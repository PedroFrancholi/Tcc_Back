package TCC.Tcc.service;

import TCC.Tcc.model.Disciplina;
import TCC.Tcc.model.Grade;
import TCC.Tcc.model.Turma;
import TCC.Tcc.repository.DisciplinaRepository;
import TCC.Tcc.repository.GradeRepository;
import TCC.Tcc.repository.TurmaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GradeService {

    @Autowired
    private GradeRepository gradeRepository;
    @Autowired
    private TurmaRepository turmaRepository;
    @Autowired
    private DisciplinaRepository disciplinaRepository;

    public List<Grade> listarGrades(){
        return gradeRepository.findAll();
    }

    public Optional<Grade> buscaGradeId(Long id){
        return gradeRepository.findById(id);
    }

    public Object gravaGrade(Grade grade){
        Long idDisciplina = grade.getDisciplina().getId_disciplina();
        Long idTurma = grade.getTurma().getId_turma();

        Optional<Disciplina> disciplinaExiste = disciplinaRepository.findById(idDisciplina);
        Optional<Turma> turmaExiste = turmaRepository.findById(idTurma);

        if(disciplinaExiste.isEmpty()){
            return ("Nenhuma disciplina com o id: "+idDisciplina+" encontrada!");
        }

        if(turmaExiste.isEmpty()){
            return ("Nenhuma turma com o id: "+idTurma+" encontrada!");
        }

        Grade newGrade = new Grade();
        newGrade.setNm_professor(grade.getNm_professor());
        newGrade.setNr_cargahr(grade.getNr_cargahr());
        newGrade.setQt_alunos(grade.getQt_alunos());
        newGrade.setDisciplina(disciplinaExiste.get());
        newGrade.setTurma(turmaExiste.get());

        return gradeRepository.save(newGrade);
    }

    public Object alteraGrade(Grade grade){
        return gradeRepository.save(grade);
    }

    public void deleteGrade(Optional<Grade> grade){
        gradeRepository.delete(grade.get());
    }
}

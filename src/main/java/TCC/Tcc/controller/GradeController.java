package TCC.Tcc.controller;

import TCC.Tcc.model.Grade;
import TCC.Tcc.service.GradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/grade")
public class GradeController {

    @Autowired
    private GradeService gradeService;

    @GetMapping
    public ResponseEntity<List<Grade>> listarGrades(){
        return ResponseEntity.status(HttpStatus.OK).body(gradeService.listarGrades());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Grade>> buscaGradeId(@PathVariable(value = "id") Long id){
        return ResponseEntity.status(HttpStatus.OK).body(gradeService.buscaGradeId(id));
    }

    @PostMapping
    public ResponseEntity<Object> gravaGrade(@RequestBody Grade grade){
        return ResponseEntity.status(HttpStatus.OK).body(gradeService.gravaGrade(grade));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> alteraGrade(@PathVariable(value = "id") Long id,@RequestBody Grade grade){
        Optional<Grade> gradeExiste = gradeService.buscaGradeId(id);

        if(gradeExiste.isEmpty()){
            return ResponseEntity.status(HttpStatus.OK).body("Nenhuma grade com o id: "+id+" encontrada!");
        }

        Grade newGrade = gradeExiste.get();
        newGrade.setNm_professor(grade.getNm_professor());
        newGrade.setNr_cargahr(grade.getNr_cargahr());
        newGrade.setQt_alunos(grade.getQt_alunos());

        return ResponseEntity.status(HttpStatus.OK).body(gradeService.alteraGrade(newGrade));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteGrade(@PathVariable(value = "id") Long id){
        Optional<Grade> gradeExiste = gradeService.buscaGradeId(id);

        if(gradeExiste.isEmpty()){
            return ResponseEntity.status(HttpStatus.OK).body("Nenhuma grade com o id: "+id+" encontrada!");
        }

        gradeService.deleteGrade(gradeExiste);
        return ResponseEntity.status(HttpStatus.OK).body("Grade deletada com sucesso!");
    }
}

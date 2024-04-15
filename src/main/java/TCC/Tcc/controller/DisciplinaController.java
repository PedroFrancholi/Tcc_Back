package TCC.Tcc.controller;

import TCC.Tcc.model.Disciplina;
import TCC.Tcc.service.DisciplinaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/disciplina")
public class DisciplinaController {

    @Autowired
    private DisciplinaService service;

    @GetMapping
    public ResponseEntity<List<Disciplina>> listarDisciplinas(){
        return ResponseEntity.status(HttpStatus.OK).body(service.listarDisciplinas());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Disciplina>> buscaMaterialId(@PathVariable(value = "id") Long id){
        return ResponseEntity.status(HttpStatus.OK).body(service.buscaDisciplinaId(id));
    }

    @PostMapping
    public ResponseEntity<Object> gravaDisciplina(@RequestBody Disciplina disciplina){
        return ResponseEntity.status(HttpStatus.OK).body(service.gravaDisciplina(disciplina));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> alterarDisciplina(@PathVariable(value = "id") Long id, @RequestBody Disciplina disciplina){
        Optional<Disciplina> disciplinaExiste = service.buscaDisciplinaId(id);

        if(disciplinaExiste.isEmpty()){
            return ResponseEntity.status(HttpStatus.OK).body("Nenhuma disciplina encontrada com o id: "+id);
        }

        Disciplina newDisciplina = disciplinaExiste.get();
        newDisciplina.setNm_disciplina(disciplina.getNm_disciplina());

        return ResponseEntity.status(HttpStatus.OK).body(service.gravaDisciplina(newDisciplina));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteDisciplina(@PathVariable(value = "id") Long id){
        Optional<Disciplina> disciplinaExiste = service.buscaDisciplinaId(id);

        if(disciplinaExiste.isEmpty()){
            return ResponseEntity.status(HttpStatus.OK).body("Nenhuma disciplina encontrada com o id: "+id);
        }
        service.deleteDisciplina(disciplinaExiste);
        return ResponseEntity.status(HttpStatus.OK).body("Disciplina deletada com sucesso");
    }
}

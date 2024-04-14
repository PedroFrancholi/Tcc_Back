package TCC.Tcc.controller;

import TCC.Tcc.model.Curso;
import TCC.Tcc.model.Material;
import TCC.Tcc.service.CursoService;
import TCC.Tcc.service.MaterialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/curso")
public class CursoController {

    @Autowired
    private CursoService service;

    @GetMapping
    public ResponseEntity<List<Curso>> listarCurso(){
        return ResponseEntity.status(HttpStatus.OK).body(service.listarCurso());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Curso>> buscaCursoId(@PathVariable(value = "id") Long id){
        return ResponseEntity.status(HttpStatus.OK).body(service.buscaCursoId(id));
    }

    @PostMapping
    public ResponseEntity<Object> gravaCurso(@RequestBody Curso curso){
        return ResponseEntity.status(HttpStatus.OK).body(service.gravaCurso(curso));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> alteraCurso(@PathVariable(value = "id") Long id, @RequestBody Curso curso){
        Optional<Curso> cursoExiste = service.buscaCursoId(id);

        if(cursoExiste.isEmpty()){
            return ResponseEntity.status(HttpStatus.OK).body("Nenhum curso encontrado com o id: "+id);
        }

        Curso newCurso = cursoExiste.get();
        newCurso.setDs_curso(curso.getDs_curso());

        return ResponseEntity.status(HttpStatus.OK).body(service.gravaCurso(newCurso));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteCurso(@PathVariable(value = "id") Long id){
        Optional<Curso> cursoExiste = service.buscaCursoId(id);

        if(cursoExiste.isEmpty()){
            return ResponseEntity.status(HttpStatus.OK).body("Nenhum curso encontrado com o id: "+id);
        }

        service.deleteCurso(cursoExiste);
        return ResponseEntity.status(HttpStatus.OK).body("Curso deletado com sucesso!");
    }
}

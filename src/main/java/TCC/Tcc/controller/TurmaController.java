package TCC.Tcc.controller;

import TCC.Tcc.model.Turma;
import TCC.Tcc.service.TurmaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.sound.midi.Track;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/turma")
public class TurmaController {

    @Autowired
    private TurmaService service;

    @GetMapping
    public ResponseEntity<List<Turma>> listarTurmas(){
        return ResponseEntity.status(HttpStatus.OK).body(service.listarTurmas());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Turma>> buscaTurmaId(@PathVariable(value = "id") Long id){
        return ResponseEntity.status(HttpStatus.OK).body(service.buscaTurmaId(id));
    }

    @PostMapping
    public ResponseEntity<Object> gravaTurma(@RequestBody Turma turma){
        return ResponseEntity.status(HttpStatus.OK).body(service.gravaTurma(turma));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> alteraTurma(@PathVariable(value = "id") Long id, @RequestBody Turma turma){
        Optional<Turma> turmaExiste = service.buscaTurmaId(id);

        if(turmaExiste.isEmpty()){
            return ResponseEntity.status(HttpStatus.OK).body("Turma com o id: "+id+" não encontrada!");
        }

        Turma newTurma = turmaExiste.get();
        newTurma.setDs_turma(turma.getDs_turma());

        return ResponseEntity.status(HttpStatus.OK).body(service.alteraTurma(newTurma));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteTurma(@PathVariable(value = "id") Long id){
        Optional<Turma> turmaExiste = service.buscaTurmaId(id);

        if(turmaExiste.isEmpty()){
            return ResponseEntity.status(HttpStatus.OK).body("Turma com o id: "+id+" não encontrada!");
        }

        service.deleteTurma(turmaExiste);
        return ResponseEntity.status(HttpStatus.OK).body("Turma deletada com sucesso!");
    }
}

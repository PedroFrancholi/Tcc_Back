package TCC.Tcc.controller;

import TCC.Tcc.model.Sala;
import TCC.Tcc.service.SalaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/sala")
public class SalaController {

    @Autowired
    private SalaService service;

    @GetMapping
    public ResponseEntity<List<Sala>> listarSalas(){
        return ResponseEntity.status(HttpStatus.OK).body(service.listarSalas());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Sala>> buscarSalaId(@PathVariable(value = "id") Long id){
        return ResponseEntity.status(HttpStatus.OK).body(service.buscarSalaId(id));
    }

    @PostMapping
    public ResponseEntity<Object> gravarSala(@RequestBody Sala sala){
        return ResponseEntity.status(HttpStatus.OK).body(service.gravarSala(sala));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> alteraSala(@PathVariable(value = "id") Long id, @RequestBody Sala sala){
        Optional<Sala> salaExiste = service.buscarSalaId(id);

        if (salaExiste.isEmpty()){
            return ResponseEntity.status(HttpStatus.OK).body("Sala com o id: "+id+" não encontrada!");
        }

        Sala newSala = salaExiste.get();
        newSala.setNm_sala(sala.getNm_sala());
        newSala.setQt_capacvigilancia(sala.getQt_capacvigilancia());

        return ResponseEntity.status(HttpStatus.OK).body(service.alteraSala(newSala));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteSala(@PathVariable(value = "id") Long id){
        Optional<Sala> salaExiste = service.buscarSalaId(id);

        if (salaExiste.isEmpty()){
            return ResponseEntity.status(HttpStatus.OK).body("Sala com o id: "+id+" não encontrada!");
        }

        service.deleteSala(salaExiste);
        return ResponseEntity.status(HttpStatus.OK).body("Sala deletada com sucesso!");
    }
}

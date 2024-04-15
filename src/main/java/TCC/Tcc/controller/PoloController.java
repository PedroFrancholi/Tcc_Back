package TCC.Tcc.controller;

import TCC.Tcc.model.Polo;
import TCC.Tcc.service.PoloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/polo")
public class PoloController {

    @Autowired
    private PoloService service;

    @GetMapping
    public ResponseEntity<List<Polo>> listarPolos(){
        return ResponseEntity.status(HttpStatus.OK).body(service.listarPolos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Polo>> buscaPoloId(@PathVariable(value = "id") Long id){
        return ResponseEntity.status(HttpStatus.OK).body(service.buscaPoloId(id));
    }

    @PostMapping
    public ResponseEntity<Object> gravaPolo(@RequestBody Polo polo){
        return ResponseEntity.status(HttpStatus.OK).body(service.gravaPolo(polo));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> alteraPolo(@PathVariable(value = "id") Long id,@RequestBody Polo polo){
        Optional<Polo> poloExiste = service.buscaPoloId(id);

        if(poloExiste.isEmpty()){
            return ResponseEntity.status(HttpStatus.OK).body("Polo com o id: "+id+" não encontrado!");
        }

        Polo newPolo = poloExiste.get();
        newPolo.setNm_polo(polo.getNm_polo());

        return ResponseEntity.status(HttpStatus.OK).body(service.alteraPolo(newPolo));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deletePolo(@PathVariable(value = "id") Long id){
        Optional<Polo> poloExiste = service.buscaPoloId(id);

        if(poloExiste.isEmpty()){
            return ResponseEntity.status(HttpStatus.OK).body("Polo com o id: "+id+" não encontrado!");
        }

        service.deletePolo(poloExiste);
        return ResponseEntity.status(HttpStatus.OK).body("Polo deletado com sucesso!");
    }
}

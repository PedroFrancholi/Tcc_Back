package TCC.Tcc.controller;

import TCC.Tcc.model.Bloco;
import TCC.Tcc.service.BlocoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/bloco")
public class BlocoController {

    @Autowired
    private BlocoService service;

    @GetMapping
    public ResponseEntity<List<Bloco>> listarBlocos(){
        return ResponseEntity.status(HttpStatus.OK).body(service.listarBlocos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Bloco>> buscarBlocoId(@PathVariable(value = "id") Long id){
        return ResponseEntity.status(HttpStatus.OK).body(service.buscarBlocoId(id));
    }

    @PostMapping
    public ResponseEntity<Object> gravarBloco(@RequestBody Bloco bloco){
        return ResponseEntity.status(HttpStatus.OK).body(service.gravarBloco(bloco));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> alterarBloco(@PathVariable(value = "id") Long id,@RequestBody Bloco bloco){
        Optional<Bloco> blocoExiste = service.buscarBlocoId(id);

        if (blocoExiste.isEmpty()){
            return ResponseEntity.status(HttpStatus.OK).body("Bloco com o id: "+id+" não encontrado!");
        }

        Bloco newBloco = blocoExiste.get();
        newBloco.setNm_bloco(bloco.getNm_bloco());

        return ResponseEntity.status(HttpStatus.OK).body(service.alterarBloco(newBloco));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteBloco(@PathVariable(value = "id") Long id){
        Optional<Bloco> blocoExiste = service.buscarBlocoId(id);

        if (blocoExiste.isEmpty()){
            return ResponseEntity.status(HttpStatus.OK).body("Bloco com o id: "+id+" não encontrado!");
        }

        service.deleteBloco(blocoExiste);
        return ResponseEntity.status(HttpStatus.OK).body("Bloco deletado com sucesso!");
    }
}

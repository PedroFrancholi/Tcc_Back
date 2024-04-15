package TCC.Tcc.controller;

import TCC.Tcc.model.Estado;
import TCC.Tcc.service.EstadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/estado")
public class EstadoController {

    @Autowired
    private EstadoService service;

    @GetMapping
    public ResponseEntity<List<Estado>> listaEstado(){
        return ResponseEntity.status(HttpStatus.OK).body(service.listaEstado());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Estado>> buscaEstadoId(@PathVariable(value = "id") String id){
        return ResponseEntity.status(HttpStatus.OK).body(service.buscaEstadoId(id));
    }

    @PostMapping
    public ResponseEntity<Object> gravaEstado(@RequestBody Estado estado){
        return ResponseEntity.status(HttpStatus.OK).body(service.gravaEstado(estado));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> alteraEstado(@PathVariable(value = "id") String id, @RequestBody Estado estado){
        Optional<Estado> estadoExiste = service.buscaEstadoId(id);

        if(estadoExiste.isEmpty()){
            return ResponseEntity.status(HttpStatus.OK).body("Nenhum estado encontrado com a sigla: "+id);
        }

        Estado newEstado = estadoExiste.get();
        newEstado.setNm_estado(estado.getnm_estado());

        return ResponseEntity.status(HttpStatus.OK).body(service.gravaEstado(newEstado));

    }
}

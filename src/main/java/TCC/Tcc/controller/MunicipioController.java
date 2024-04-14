package TCC.Tcc.controller;

import TCC.Tcc.model.Municipio;
import TCC.Tcc.service.MunicipioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/municipio")
public class MunicipioController {

    @Autowired
    private MunicipioService service;

    @GetMapping
    private ResponseEntity<List<Municipio>> listarMunicipios(){
        return ResponseEntity.status(HttpStatus.OK).body(service.listarMunicipios());
    }

    @GetMapping("/{id}")
    private ResponseEntity<Optional<Municipio>> buscaMunicipioId(@PathVariable(value = "id") Long id){
        return ResponseEntity.status(HttpStatus.OK).body(service.buscaMunicipioId(id));
    }

    @PostMapping
    private ResponseEntity<Object> gravaMunicipio(@RequestBody Municipio municipio){
        return ResponseEntity.status(HttpStatus.OK).body(service.gravaMunicipio(municipio));
    }

    @PutMapping("/{id}")
    private ResponseEntity<Object> alteraMunicipio(@PathVariable(value = "id") Long id, @RequestBody Municipio municipio){
        Optional<Municipio> municipioExiste = service.buscaMunicipioId(id);

        if(municipioExiste.isEmpty()){
            return ResponseEntity.status(HttpStatus.OK).body("Nenhum munícipio encontrado com o ID: "+id);
        }

        Municipio newMunicipio = municipioExiste.get();
        newMunicipio.setNm_municipio(municipio.getNm_municipio());

        return ResponseEntity.status(HttpStatus.OK).body(service.gravaMunicipio(newMunicipio));
    }

    @DeleteMapping("/{id}")
    private ResponseEntity<Object> deleteMunicipio(@PathVariable(value = "id") Long id){
        Optional<Municipio> municipioExiste = service.buscaMunicipioId(id);

        if(municipioExiste.isEmpty()){
            return ResponseEntity.status(HttpStatus.OK).body("Nenhum munícipio encontrado com o ID: "+id);
        }
        service.deleteMunicipio(municipioExiste);
        return ResponseEntity.status(HttpStatus.OK).body("Município deletado com sucesso!");

    }
}

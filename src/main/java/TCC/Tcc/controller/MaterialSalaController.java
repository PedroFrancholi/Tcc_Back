package TCC.Tcc.controller;

import TCC.Tcc.model.Material;
import TCC.Tcc.model.MaterialSala;
import TCC.Tcc.model.Sala;
import TCC.Tcc.service.MaterialSalaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/materialsala")
public class MaterialSalaController {

    @Autowired
    private MaterialSalaService service;

    @GetMapping
    public ResponseEntity<List<MaterialSala>> listarMaterialSala(){
        return ResponseEntity.status(HttpStatus.OK).body(service.listarMaterialSala());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<MaterialSala>> buscarMaterialSalaId(@PathVariable(value = "id") Long id){
        return ResponseEntity.status(HttpStatus.OK).body(service.buscarMaterialSalaId(id));
    }
//    @GetMapping("/material/{id}")
//    public ResponseEntity<Optional<Material>> buscarMaterialId(@PathVariable(value = "id") Long id){
//        return ResponseEntity.status(HttpStatus.OK).body(service.buscarMaterialId(id));
//    }
//
//    @GetMapping("/sala/{id}")
//    public ResponseEntity<Optional<Sala>> buscarSalaId(@PathVariable(value = "id") Long id){
//        return ResponseEntity.status(HttpStatus.OK).body(service.buscarSalaId(id));
//    }

    @PostMapping
    public ResponseEntity<Object> gravaMaterialSala(@RequestBody MaterialSala materialSala){
        return ResponseEntity.status(HttpStatus.OK).body(service.gravaMaterialSala(materialSala));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> alteraMaterialSala(@PathVariable(value = "id") Long id, @RequestBody MaterialSala materialSala){
        Optional<MaterialSala> materialSalaExiste = service.buscarMaterialSalaId(id);

        if(materialSalaExiste.isEmpty()){
            return ResponseEntity.status(HttpStatus.OK).body("Materiais para a sala informada não encontrados!");
        }

        MaterialSala newMaterialSala = materialSalaExiste.get();
        newMaterialSala.setQt_material(materialSala.getQt_material());
        newMaterialSala.setDs_materialSala(materialSala.getDs_materialSala());

        return ResponseEntity.status(HttpStatus.OK).body(service.alteraMaterialSala(newMaterialSala));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteMaterialSala(@PathVariable(value = "id") Long id){
        Optional<MaterialSala> materialSalaExiste = service.buscarMaterialSalaId(id);

        if(materialSalaExiste.isEmpty()){
            return ResponseEntity.status(HttpStatus.OK).body("Materiais para a sala informada não encontrados!");
        }

        service.deleteMaterialSala(materialSalaExiste);

        return ResponseEntity.status(HttpStatus.OK).body("Vínculo de materiais com sala foi deletado com sucesso!");
    }
}

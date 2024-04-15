package TCC.Tcc.controller;

import TCC.Tcc.model.Material;
import TCC.Tcc.service.MaterialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/material")
public class MaterialController {

    @Autowired
    private MaterialService service;

    @GetMapping
    public ResponseEntity<List<Material>> listarMaterial(){
        return ResponseEntity.status(HttpStatus.OK).body(service.listarMaterial());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Material>> buscaMaterialId(@PathVariable(value = "id") Long id){
        return ResponseEntity.status(HttpStatus.OK).body(service.buscaMaterialId(id));
    }

    @PostMapping
    public ResponseEntity<Object> gravaMaterial(@RequestBody Material material){
        return ResponseEntity.status(HttpStatus.OK).body(service.gravaMaterial(material));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> alteraMaterial(@PathVariable(value = "id") Long id, @RequestBody Material material){
        Optional<Material> materialExiste = service.buscaMaterialId(id);

        if(materialExiste.isEmpty()){
            return ResponseEntity.status(HttpStatus.OK).body("Nenhum material encontrado com o id: "+id);
        }

        Material newMaterial = materialExiste.get();
        newMaterial.setDs_material(material.getDs_material());

        return ResponseEntity.status(HttpStatus.OK).body(service.gravaMaterial(newMaterial));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteMaterial(@PathVariable(value = "id") Long id){
        Optional<Material> materialExiste = service.buscaMaterialId(id);

        if(materialExiste.isEmpty()){
        return ResponseEntity.status(HttpStatus.OK).body("Nenhum material encontrado com o id: "+id);
        }

        service.deleteMaterial(materialExiste);
        return ResponseEntity.status(HttpStatus.OK).body("Material deletado com sucesso!");
}
}

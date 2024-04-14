package TCC.Tcc.controller;

import TCC.Tcc.model.Instituicao;
import TCC.Tcc.service.InstituicaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/instituicao")
public class InstituicaoController {

    @Autowired
    private InstituicaoService service;

    @GetMapping
    public ResponseEntity<List<Instituicao>> listaInstituicoes(){
        return ResponseEntity.status(HttpStatus.OK).body(service.listarInstituicoes());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Instituicao>> buscaInstituicaoId(@PathVariable(value = "id") Long id){
        return ResponseEntity.status(HttpStatus.OK).body(service.buscarInstituicaoId(id));
    }

    @PostMapping
    public ResponseEntity<Object> gravaInstituicao(@RequestBody Instituicao instituicao){
        return ResponseEntity.status(HttpStatus.OK).body(service.gravaInstituicao(instituicao));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> alteraInstituicao(@PathVariable(value = "id") Long id, @RequestBody Instituicao instituicao){
        Optional<Instituicao> instituicaoExiste = service.buscarInstituicaoId(id);

        if(instituicaoExiste.isEmpty()){
            return ResponseEntity.status(HttpStatus.OK).body("Nenhuma instituição encontrada com o id:"+id);
        }

        Instituicao newInstituicao = instituicaoExiste.get();
        newInstituicao.setCd_cpfcnpj(instituicao.getCd_cpfcnpj());
        newInstituicao.setNm_fantasia(instituicao.getNm_fantasia());
        newInstituicao.setNm_razaosoc(instituicao.getNm_razaosoc());

        return ResponseEntity.status(HttpStatus.OK).body(service.gravaInstituicao(newInstituicao));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteInstituicao(@PathVariable(value = "id") Long id){
        Optional<Instituicao> instituicaoExiste = service.buscarInstituicaoId(id);

        if(instituicaoExiste.isEmpty()){
            return ResponseEntity.status(HttpStatus.OK).body("Nenhuma instituição encontrada com o id:"+id);
        }
        service.deleteInstituicao(instituicaoExiste);
        return ResponseEntity.status(HttpStatus.OK).body("Instituicao deletada com sucesso!");
    }
}

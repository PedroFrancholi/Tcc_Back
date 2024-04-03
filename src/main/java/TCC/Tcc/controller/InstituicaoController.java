package TCC.Tcc.controller;

import TCC.Tcc.model.Instituicao;
import TCC.Tcc.service.InstituicaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/instituicao")
public class InstituicaoController {

    @Autowired
    private InstituicaoService service;

    @GetMapping
    public ResponseEntity<List<Instituicao>> listaInstituicoes(){
        return ResponseEntity.status(HttpStatus.OK).body(service.listarInstituicoes());
    }

    @PostMapping
    public ResponseEntity<Object> gravaInstituicao(@RequestBody Instituicao instituicao){
        return ResponseEntity.status(HttpStatus.OK).body(service.gravaInstituicao(instituicao));
    }
}

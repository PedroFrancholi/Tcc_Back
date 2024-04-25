package TCC.Tcc.controller;

import TCC.Tcc.model.Usuario;
import TCC.Tcc.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioService service;

    @GetMapping
    public ResponseEntity<List<Usuario>> listarUsuarios(){
        return ResponseEntity.status(HttpStatus.OK).body(service.listarUsuarios());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Usuario>> buscarUsuarioId(@PathVariable(value = "id") Long id){
        return ResponseEntity.status(HttpStatus.OK).body(service.buscarUsuarioId(id));
    }

    @PostMapping
    public ResponseEntity<Object> gravarUsuario(@RequestBody Usuario usuario){
        return ResponseEntity.status(HttpStatus.OK).body(service.gravarUsuario(usuario));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> alterarUsuario(@PathVariable(value = "id") Long id, @RequestBody Usuario usuario){
        Optional<Usuario> usuarioExiste = service.buscarUsuarioId(id);

        if (usuarioExiste.isEmpty()){
            return ResponseEntity.status(HttpStatus.OK).body("Nenhum usuário encontrado com o id: "+id);
        }

        Usuario newUsuario = usuarioExiste.get();
        newUsuario.setNm_usuario(usuario.getNm_usuario());
        newUsuario.setCd_cpfcnpj(usuario.getCd_cpfcnpj());
        newUsuario.setDt_nascimento(usuario.getDt_nascimento());
        newUsuario.setDs_funcao(usuario.getDs_funcao());
        newUsuario.setDs_email(usuario.getDs_email());
        newUsuario.setDs_senha(usuario.getDs_senha());

        return ResponseEntity.status(HttpStatus.OK).body(gravarUsuario(newUsuario));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteUsuario(@PathVariable(value = "id") Long id){
        Optional<Usuario> usuarioExiste = service.buscarUsuarioId(id);

        if (usuarioExiste.isEmpty()){
            return ResponseEntity.status(HttpStatus.OK).body("Nenhum usuário encontrado com o id: "+id);
        }

        service.deleteUsuario(usuarioExiste);
        return ResponseEntity.status(HttpStatus.OK).body("Usuário deletado com sucesso!");
    }
}

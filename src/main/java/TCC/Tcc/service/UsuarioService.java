package TCC.Tcc.service;

import TCC.Tcc.model.Usuario;
import TCC.Tcc.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;
    public List<Usuario> listarUsuarios(){
        return usuarioRepository.findAll();
    }

    public Optional<Usuario> buscarUsuarioId(Long id){
        return usuarioRepository.findById(id);
    }

    public Object gravarUsuario(Usuario usuario){
        String senhaCriptografada = passwordEncoder.encode(usuario.getDs_senha());
        usuario.setDs_senha(senhaCriptografada);
        return usuarioRepository.save(usuario);
    }

    public void deleteUsuario(Optional<Usuario> usuario){
        usuarioRepository.delete(usuario.get());
    }
}

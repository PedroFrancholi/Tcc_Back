package TCC.Tcc.service;

import TCC.Tcc.model.Instituicao;
import TCC.Tcc.repository.InstituicaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InstituicaoService {

    @Autowired
    private InstituicaoRepository repository;

    public List<Instituicao> listarInstituicoes(){
        return repository.findAll();
    }

    public Optional<Instituicao> buscarInstituicaoId(Long id){
        return repository.findById(id);
    }

    public Instituicao gravaInstituicao(Instituicao instituicao){
        return repository.save(instituicao);
    }

    public void deleteInstituicao(Optional<Instituicao> instituicao){
        repository.delete(instituicao.get());
    }
}

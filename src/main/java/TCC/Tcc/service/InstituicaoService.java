package TCC.Tcc.service;

import TCC.Tcc.model.Instituicao;
import TCC.Tcc.repository.InstituicaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InstituicaoService {

    @Autowired
    private InstituicaoRepository repository;

    public List<Instituicao> listarInstituicoes(){
        return repository.findAll();
    }

    public Instituicao gravaInstituicao(Instituicao instituicao){
        return repository.save(instituicao);
    }
}

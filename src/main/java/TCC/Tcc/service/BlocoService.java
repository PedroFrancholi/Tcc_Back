package TCC.Tcc.service;

import TCC.Tcc.model.Bloco;
import TCC.Tcc.repository.BlocoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serial;

@Service
public class BlocoService {

    @Autowired
    private BlocoRepository repository;

    public Bloco gravaBloco(Bloco bloco){
        return repository.save(bloco);
    }
}
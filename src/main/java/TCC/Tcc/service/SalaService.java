package TCC.Tcc.service;

import TCC.Tcc.model.Bloco;
import TCC.Tcc.model.Sala;
import TCC.Tcc.repository.BlocoRepository;
import TCC.Tcc.repository.SalaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SalaService {

    @Autowired
    private SalaRepository salaRepository;
    @Autowired
    private BlocoRepository blocoRepository;

    public List<Sala> listarSalas(){
        return salaRepository.findAll();
    }

    public Optional<Sala> buscarSalaId(Long id){
        return salaRepository.findById(id);
    }

    public Object gravarSala(Sala sala){
        Long idBloco = sala.getBloco().getId_bloco();

        Optional<Bloco> blocoExiste = blocoRepository.findById(idBloco);

        if (blocoExiste.isEmpty()){
            return ("Bloco com o id: "+idBloco+" não encontrado!");
        }

        Sala newSala = new Sala();
        newSala.setNm_sala(sala.getNm_sala());
        newSala.setQt_capacvigilancia(sala.getQt_capacvigilancia());
        newSala.setBloco(blocoExiste.get());

        return salaRepository.save(newSala);
    }

    public Object alteraSala(Sala sala){
        return salaRepository.save(sala);
    }

    public void deleteSala(Optional<Sala> sala){
        salaRepository.delete(sala.get());
    }
}

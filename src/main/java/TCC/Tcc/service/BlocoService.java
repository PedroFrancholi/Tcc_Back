package TCC.Tcc.service;

import TCC.Tcc.model.Bloco;
import TCC.Tcc.model.Polo;
import TCC.Tcc.repository.BlocoRepository;
import TCC.Tcc.repository.PoloRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BlocoService {

    @Autowired
    private BlocoRepository blocoRepository;
    @Autowired
    private PoloRepository poloRepository;

    public List<Bloco> listarBlocos(){
        return blocoRepository.findAll();
    }

    public Optional<Bloco> buscarBlocoId(Long id){
        return blocoRepository.findById(id);
    }

    public Object gravarBloco(Bloco bloco){
        Long idPolo = bloco.getPolo().getId_polo();

        Optional<Polo> poloExiste = poloRepository.findById(idPolo);

        if(poloExiste.isEmpty()){
            return ("Polo com o id: "+idPolo+" não encontrado!");
        }

        Bloco newBloco = new Bloco();
        newBloco.setNm_bloco(bloco.getNm_bloco());
        newBloco.setPolo(poloExiste.get());

        return blocoRepository.save(newBloco);
    }

    public Object alterarBloco(Bloco bloco){
        return blocoRepository.save((bloco));
    }

    public void deleteBloco(Optional<Bloco> bloco){
        blocoRepository.delete(bloco.get());
    }
}

package TCC.Tcc.service;

import TCC.Tcc.model.Instituicao;
import TCC.Tcc.model.Municipio;
import TCC.Tcc.model.Polo;
import TCC.Tcc.repository.InstituicaoRepository;
import TCC.Tcc.repository.MunicipioRepository;
import TCC.Tcc.repository.PoloRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PoloService {

    @Autowired
    private PoloRepository poloRepository;
    @Autowired
    private MunicipioRepository municipioRepository;
    @Autowired
    private InstituicaoRepository instituicaoRepository;

    public List<Polo> listarPolos(){
        return poloRepository.findAll();
    }

    public Optional<Polo> buscaPoloId(Long id){
        return poloRepository.findById(id);
    }

    public Object gravaPolo(Polo polo){
        Long idMunicipio = polo.getMunicipio().getId_municipio();
        Long idInstituicao = polo.getInstituicao().getId_instituicao();

        Optional<Municipio> municipioExiste = municipioRepository.findById(idMunicipio);
        Optional<Instituicao> instituicaoExiste = instituicaoRepository.findById(idInstituicao);

        if(municipioExiste.isEmpty()){
            return ("Munícipio com o id: "+idMunicipio+" não encontrado!");
        }

        if(instituicaoExiste.isEmpty()){
            return ("Instituição com o id: "+idInstituicao+" não encontrada!");
        }

        Polo newPolo = new Polo();
        newPolo.setNm_polo(polo.getNm_polo());
        newPolo.setDs_endereco(polo.getDs_endereco());
        newPolo.setMunicipio(municipioExiste.get());
        newPolo.setInstituicao(instituicaoExiste.get());

        return poloRepository.save(newPolo);
    }

    public Object alteraPolo(Polo polo){
        return poloRepository.save(polo);
    }

    public void deletePolo(Optional<Polo> polo){
        poloRepository.delete(polo.get());
    }

}

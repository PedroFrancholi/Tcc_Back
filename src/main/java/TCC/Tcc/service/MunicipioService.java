package TCC.Tcc.service;

import TCC.Tcc.model.Estado;
import TCC.Tcc.model.Municipio;
import TCC.Tcc.repository.EstadoRepository;
import TCC.Tcc.repository.MunicipioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MunicipioService {

    @Autowired
    private EstadoRepository estadoRepository;
    @Autowired
    private MunicipioRepository municipioRepository;

    public List<Municipio> listarMunicipios(){
//        List<Municipio> municipios = municipioRepository.findAll();
//
//        for (Municipio municipio : municipios){
//            municipio.getEstado().getcd_estado();
//        }
//
//        return municipios;

        return municipioRepository.findAll();
    }

    public Optional<Municipio> buscaMunicipioId(Long id){
        return municipioRepository.findById(id);
    }

    public Object gravaMunicipio(Municipio municipio){
        String cdEstado = municipio.getEstado().getcd_estado();

        Optional<Estado> estadoExiste = estadoRepository.findById(cdEstado);

        if(estadoExiste.isEmpty()){
           return ("Estado com o ID: "+cdEstado+" não encontrado!");
        }

        Municipio newMunicipio = new Municipio();
        newMunicipio.setNm_municipio(municipio.getNm_municipio());
        newMunicipio.setEstado(estadoExiste.get());

        return municipioRepository.save(newMunicipio);
    }

    public void deleteMunicipio(Optional<Municipio> municipio){
        municipioRepository.delete(municipio.get());
    }
}

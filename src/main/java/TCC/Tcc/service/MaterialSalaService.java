package TCC.Tcc.service;

import TCC.Tcc.model.Material;
import TCC.Tcc.model.MaterialSala;
import TCC.Tcc.model.Sala;
import TCC.Tcc.repository.MaterialRepository;
import TCC.Tcc.repository.MaterialSalaRepository;
import TCC.Tcc.repository.SalaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MaterialSalaService {

    @Autowired
    private MaterialSalaRepository materialSalaRepository;
    @Autowired
    private MaterialRepository materialRepository;
    @Autowired
    private SalaRepository salaRepository;

    public List<MaterialSala> listarMaterialSala(){
        return materialSalaRepository.findAll();
    }

    public Optional<Material> buscarMaterialId(Long id){
        return materialRepository.findById(id);
    }

    public Optional<MaterialSala> buscarMaterialSalaId(Long id){
        return materialSalaRepository.findById(id);
    }

    public Optional<Sala> buscarSalaId(Long id){
        return salaRepository.findById(id);
    }

    public Object gravaMaterialSala(MaterialSala materialSala){
        Long idMaterial = materialSala.getMaterial().getId_material();
        Long idSala = materialSala.getSala().getId_sala();

        Optional<Material> materialExiste = materialRepository.findById(idMaterial);
        if(materialExiste.isEmpty()){
            return ("Material com o id: "+idMaterial+" não encontrado!");
        }

        Optional<Sala> salaExiste = salaRepository.findById(idSala);
        if(salaExiste.isEmpty()){
            return ("Sala com o id: "+idSala+" não encontrada!");
        }

        MaterialSala newMaterialSala = new MaterialSala();
        newMaterialSala.setDs_materialSala(materialSala.getDs_materialSala());
        newMaterialSala.setQt_material(materialSala.getQt_material());
        newMaterialSala.setMaterial(materialExiste.get());
        newMaterialSala.setSala(salaExiste.get());


        return materialSalaRepository.save(newMaterialSala);
    }

    public Object alteraMaterialSala(MaterialSala materialSala){
        return materialSalaRepository.save(materialSala);
    }

    public void deleteMaterialSala(Optional<MaterialSala> materialSala){
        materialSalaRepository.delete(materialSala.get());
    }
}
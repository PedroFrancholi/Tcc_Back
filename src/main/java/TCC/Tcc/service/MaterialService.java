package TCC.Tcc.service;

import TCC.Tcc.model.Material;
import TCC.Tcc.repository.MaterialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MaterialService {

    @Autowired
    private MaterialRepository repository;

    public List<Material> listarMaterial(){
        return repository.findAll();
    }

    public Optional<Material> buscaMaterialId(Long id){
        return repository.findById(id);
    }

    public Material gravaMaterial(Material material){
        return repository.save(material);
    }

    public void deleteMaterial(Optional<Material> material){
        repository.delete(material.get());
    }
}

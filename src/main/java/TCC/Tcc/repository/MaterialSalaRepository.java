package TCC.Tcc.repository;

import TCC.Tcc.model.MaterialSala;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MaterialSalaRepository extends JpaRepository<MaterialSala, Long> {
}

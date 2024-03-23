package TCC.Tcc.service;

import TCC.Tcc.repository.BlocoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BlocoService {

    @Autowired
    private BlocoRepository repository;
}

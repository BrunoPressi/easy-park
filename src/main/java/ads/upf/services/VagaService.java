package ads.upf.services;

import ads.upf.model.DTOs.vagaDTOs.VagaCreateDTO;
import ads.upf.model.entities.Vaga;
import ads.upf.model.mappers.VagaMapper;
import ads.upf.repositories.VagaRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

@ApplicationScoped
public class VagaService {

    @Inject
    VagaRepository vagaRepository;

    @Transactional
    public void criarNovaVaga(VagaCreateDTO vagaCreateDTO) {
        Vaga vaga = VagaMapper.INSTANCE.toVaga(vagaCreateDTO);
        vagaRepository.persist(vaga);
    }

}

package ads.upf.repositories;

import ads.upf.model.entities.Vaga;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class VagaRepository implements PanacheRepository<Vaga> {}

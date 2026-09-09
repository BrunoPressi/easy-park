package ads.upf.model.entities;

import ads.upf.model.enums.VagaStatus;
import jakarta.persistence.*;
import jakarta.validation.constraints.Pattern;
import lombok.*;

import java.time.LocalDateTime;

@Entity()
@Table(name = "vagas")
@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
@EqualsAndHashCode (of = "id")
public class Vaga {

    @Id()
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false, unique = true, length = 3)
    private String nome;

    @Enumerated(EnumType.STRING)
    private VagaStatus status;

    private LocalDateTime criadoEm;

    private LocalDateTime atualizadoEm;

    @PostPersist
    void postPersist() {
        this.status = VagaStatus.disponivel;
        this.criadoEm = LocalDateTime.now();
    }

    @PostUpdate
    void postUpdate() {
        this.atualizadoEm = LocalDateTime.now();
    }

}

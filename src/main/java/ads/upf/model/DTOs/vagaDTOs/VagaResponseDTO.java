package ads.upf.model.DTOs.vagaDTOs;


import ads.upf.model.enums.VagaStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class VagaResponseDTO {

    private long id;
    private String nome;
    private VagaStatus status;

}

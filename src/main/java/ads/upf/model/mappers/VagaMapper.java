package ads.upf.model.mappers;

import ads.upf.model.DTOs.vagaDTOs.VagaResponseDTO;
import ads.upf.model.entities.Vaga;
import ads.upf.model.DTOs.vagaDTOs.VagaCreateDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface VagaMapper {

    VagaMapper INSTANCE = Mappers.getMapper( VagaMapper.class );

    @Mapping(source = "nome", target = "nome")
    Vaga toVaga(VagaCreateDTO vagaCreateDTO);

    List<VagaResponseDTO> toDtoList(List<Vaga> vagaList);
}

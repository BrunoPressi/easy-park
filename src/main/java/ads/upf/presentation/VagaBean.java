package ads.upf.presentation;

import ads.upf.model.DTOs.vagaDTOs.VagaCreateDTO;
import ads.upf.model.DTOs.vagaDTOs.VagaResponseDTO;
import ads.upf.services.VagaService;
import jakarta.annotation.PostConstruct;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.exception.ConstraintViolationException;

import java.util.ArrayList;
import java.util.List;

@Named
@ViewScoped
@Getter @Setter
public class VagaBean {

    @Inject
    VagaService vagaService;
    private VagaCreateDTO vagaCreateDTO = new VagaCreateDTO();
    private List<VagaResponseDTO> vagasList = new ArrayList<>();

    @PostConstruct
    private void postConstruct() {
        vagasList = vagaService.listarVagas();
    }

    public void processarVaga() {
        try {
            vagaService.criarNovaVaga(vagaCreateDTO);
            this.vagaCreateDTO = new VagaCreateDTO();
            this.vagasList = vagaService.listarVagas();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Sucesso", "Vaga registrada!"));
        }
        catch (Exception e) {
            if (e instanceof ConstraintViolationException) {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro ao salvar", "Essa vaga já está cadastrada"));
            } else {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro ao salvar", e.getMessage()));
            }
        }
    }

}

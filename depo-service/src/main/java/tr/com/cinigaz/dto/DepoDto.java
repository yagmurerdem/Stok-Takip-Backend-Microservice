package tr.com.cinigaz.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.persistence.Column;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString


public class DepoDto {

    @JsonProperty(value = "depoId")
    private Integer depoId;

    @JsonProperty(value = "depoAdi")
    private String depoAdi;

    @JsonProperty(value = "depoAdresi")
    private String depoAdresi;

    @JsonProperty(value = "depoAciklama")
    private String depoAciklama;
}




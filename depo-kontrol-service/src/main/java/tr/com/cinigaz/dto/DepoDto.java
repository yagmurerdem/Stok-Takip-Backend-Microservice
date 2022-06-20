package tr.com.cinigaz.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor



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




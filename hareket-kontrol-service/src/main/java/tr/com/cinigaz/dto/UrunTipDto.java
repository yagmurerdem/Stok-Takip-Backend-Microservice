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


public class UrunTipDto {

    @JsonProperty(value = "urunTipId")
    private Integer urunTipId;

    @JsonProperty(value = "ustUrunId")
    private Integer ustUrunId;

    @JsonProperty(value = "urunTipAdi")
    private String urunTipAdi;

    @JsonProperty(value = "urunTipAciklama")
    private String urunTipAciklama;

    @JsonProperty(value = "urunVaryant")
    private String urunVaryant;
}
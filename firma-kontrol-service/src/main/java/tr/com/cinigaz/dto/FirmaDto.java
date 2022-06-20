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


public class FirmaDto {

    @JsonProperty(value = "firmaId")
    private Integer firmaId;

    @JsonProperty(value = "firmaAdi")
    private String firmaAdi;

    @JsonProperty(value = "marka")
    private String marka;

    @JsonProperty(value = "firmaAdresi")
    private String firmaAdresi;

    @JsonProperty(value = "firmaTel1")
    private String firmaTel1;

    @JsonProperty(value = "firmaTel2")
    private String firmaTel2;

    @JsonProperty(value = "firmaVergiKimlikNo")
    private String firmaVergiKimlikNo;

    @JsonProperty(value = "firmaFax")
    private String firmaFax;

    @JsonProperty(value = "firmaYetkiliAd")
    private String firmaYetkiliAd;

    @JsonProperty(value = "firmaAciklama")
    private String firmaAciklama;
}

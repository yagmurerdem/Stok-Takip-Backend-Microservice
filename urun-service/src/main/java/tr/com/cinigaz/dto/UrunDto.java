package tr.com.cinigaz.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor


public class UrunDto {

    @JsonProperty(value = "urunId")
    private Integer urunId;

    @JsonProperty(value = "urunAdi")
    private String urunAdi;

    @JsonProperty(value = "urunKodu")
    private String urunKodu;

    @JsonProperty(value = "urunAciklama")
    private String urunAciklama;

    @JsonProperty(value = "urunBirimi")
    private String urunBirimi;

    @JsonProperty(value = "urunVaryant")
    private String urunVaryant ;

    @JsonProperty(value = "urunTipId")
    private Integer urunTipId;

//    @JsonProperty(value = "ust_tip_id")
//    private Integer ustTipId ;

    @JsonProperty(value = "ustUrunId")//üst tip id
    private Integer ustUrunId ;



}


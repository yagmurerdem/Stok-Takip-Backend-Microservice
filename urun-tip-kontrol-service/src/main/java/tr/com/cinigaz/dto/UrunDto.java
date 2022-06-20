package tr.com.cinigaz.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of={"urun_id"})

public class UrunDto {
    @JsonProperty(value = "urun_id")
    private Integer urunId;

    @JsonProperty(value = "urun_adi")
    private String urunAdi;

    @JsonProperty(value = "urun_kodu")
    private String urunKodu;

    @JsonProperty(value = "urun_aciklama")
    private String urunAciklama;

    @JsonProperty(value = "urun_birimi")
    private String urunBirimi;

    @JsonProperty(value = "urun_varyant")
    private String urunVaryant ;

    @JsonProperty(value = "urun_tip_id")
    private Integer urunTipId;

    @JsonProperty(value = "ust_urun_id")
    private Integer ustUrunId ;

}


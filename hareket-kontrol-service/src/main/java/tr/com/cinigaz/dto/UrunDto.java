package tr.com.cinigaz.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of={"urun_id"})

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
}

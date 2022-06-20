package tr.com.cinigaz.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.Date;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor


public class UrunHareketDto {


    @JsonProperty(value = "urunHareketId") //urun_hareket_id //
    private Integer urunHareketId;

    @JsonProperty(value = "hareketAmac")  //urun_hareket_amaci //
    private String hareketAmac;

    @JsonProperty(value = "tarih") //urun_hareket_tarihi
    private Date tarih;

    @JsonProperty(value = "hareketTuru") // urun_hareket_islem_turu //
    private String hareketTuru;

    @JsonProperty(value = "cikisDepoId") //urun_hareket_cikis_depo
    private Integer cikisDepoId;
    //
    @JsonProperty(value = "girisDepoId") //urun_hareket_giris_depo
    private Integer girisDepoId;

    @JsonProperty(value = "miktar") //hareket_eden_urun_miktari //
    private float miktar;

    @JsonProperty(value = "birim") //hareket_eden_urun_miktari //
    private String birim;

    @JsonProperty(value = "urunId") //
    private Integer urunId;

    @JsonProperty(value = "seriNoTakibi")
    private boolean seriNoTakibi;

    @JsonProperty(value = "firmaId") //
    private Integer firmaId;

}

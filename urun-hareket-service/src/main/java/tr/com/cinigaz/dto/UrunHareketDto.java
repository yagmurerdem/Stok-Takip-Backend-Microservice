package tr.com.cinigaz.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor


public class UrunHareketDto {

//    @JsonProperty(value = "urunHareketId") //urun_hareket_id
//    private Integer urunHareketId;

//    @JsonProperty(value = "urunHareketAmac")  //urun_hareket_amaci
//    private String urunHareketAmac;


//    @JsonProperty(value = "tarih")  //urun_hareket_amaci
//    private Date tarih;
//
//
//    @JsonProperty(value = "urunId")  //urun_hareket_amaci
//    private Integer urunId;


    //    @JsonProperty(value = "urun_hareket_tarihi")
//    private Date tarih;
//    @JsonProperty(value = "marka") // urun_hareket_islem_turu
//    private String marka;

//    @JsonProperty(value = "islemTuru") // urun_hareket_islem_turu
//    private String islemTuru;

//    @JsonProperty(value = "urun_hareket_cikis_depo")
//    private Integer cikisDepoId;
//
//    @JsonProperty(value = "urun_hareket_giris_depo")
//    private Integer girisDepoId;

//    @JsonProperty(value = "miktar") //hareket_eden_urun_miktari
//    private String miktar;

//    @JsonProperty(value = "urun_id")
//    private Integer urunId;

    //@JsonProperty(value = "seri_no_takibi")
    //private boolean seriNoTakibi;

//    @JsonProperty(value = "islem_firma_id")
//    private Integer islemFirmaId;
//
//    @JsonProperty(value = "marka_firma_id")
//    private Integer markaFirmaId;

    //  @JsonProperty(value = "birim")
    // private String birim;

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

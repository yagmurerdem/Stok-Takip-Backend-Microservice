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


public class UrunHareketDetayDto {


    @JsonProperty(value = "urun_hareket_detay_id")
    private Integer UrunHareketDetayId;

    @JsonProperty(value = "urun_hareket_detay_adi")
    private String UrunHareketDetayAdi;

    @JsonProperty(value = "urun_hareket_id")
    private Integer urunHareketId;
}

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


public class HareketTarihceDto {
    @JsonProperty(value = "hareket_tarihce_id")
    private Integer hareketTarihceId;

    @JsonProperty(value = "hareket_amaci")
    private String hareketAmaci;

    @JsonProperty(value = "seri_nolu_urun_id")
    private Integer seriNoluUrunId;

    @JsonProperty(value = "tarih")
    private Date tarih;





}

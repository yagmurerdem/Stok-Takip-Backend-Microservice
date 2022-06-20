package tr.com.cinigaz.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;
import java.util.Date;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor


public class SeriNoluUrunDto {

    @JsonProperty(value = "seriNoluUrunId")
    private Integer seriNoluUrunId;

    @JsonProperty(value= "seriNoluUrunAdi")
    private String seriNoluUrunAdi;

    @JsonProperty(value = "seriNoluUrunSeriNo")
    private String seriNoluUrunSeriNo;

    @JsonProperty(value = "seriNoluUrunSonKalibrasyonTarihi")
    private Date seriNoluUrunSonKalibrasyonTarihi;

    @JsonProperty(value = "seriNoluUrunUretimTarihi")
    @Temporal(TemporalType.DATE)
    private Date seriNoluUrunUretimTarihi;

    @JsonProperty(value = "seriNoluUrunMiktari")
    private Integer seriNoluUrunMiktari;

}

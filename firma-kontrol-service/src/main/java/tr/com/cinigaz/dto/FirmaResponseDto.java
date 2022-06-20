package tr.com.cinigaz.dto;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

public class FirmaResponseDto {
    @JsonProperty("mesajKodu")
    private int mesajKodu; // 0 Basarili
    @JsonProperty("mesaj")
    private String mesaj; // null basarili
    @JsonProperty("dto")
    private FirmaDto dto;

}


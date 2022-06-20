package tr.com.cinigaz.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor


public class DepoResponseDto {
    @JsonProperty("mesajKodu")
    private int mesajKodu; // 0 Basarili
    @JsonProperty("mesaj")
    private String mesaj; // null basarili
    @JsonProperty("dto")
    private DepoDto dto;
}
/*
    private int mesajKodu; // 0 Basarili
    private String mesaj; // null basarili
    private DepoDto dto;


 */
package tr.com.cinigaz.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter



public class FirmaListResponseDto {
    private int mesajKodu; // 0 Basarili
    private String mesaj; // null basarili
    private FirmaDto[] dto;


}

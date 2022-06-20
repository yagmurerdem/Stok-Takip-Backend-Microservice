package tr.com.cinigaz.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class FirmaResponseDto {
    private int mesajKodu; // 0 Basarili
    private String mesaj; // null basarili
    private FirmaDto dto;
}

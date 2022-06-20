package tr.com.cinigaz.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString

public class DepoResponseDto {
    private int mesajKodu; // 0 Basarili
    private String mesaj; // null basarili
    private DepoDto dto;

}

package tr.com.cinigaz.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.http.ResponseEntity;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor




public class GetIdDepoResponse {

    private int mesajKodu; // 0 Basarili
    private String mesaj; // null basarili
    private ResponseEntity<DepoDto> dto;



}

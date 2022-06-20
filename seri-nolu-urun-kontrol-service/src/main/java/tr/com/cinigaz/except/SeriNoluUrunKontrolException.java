package tr.com.cinigaz.except;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class SeriNoluUrunKontrolException {
    private int exceptKodu;
    private String exceptAciklama;


    public void printStackTree() {
        System.out.println(exceptAciklama);
    }
}

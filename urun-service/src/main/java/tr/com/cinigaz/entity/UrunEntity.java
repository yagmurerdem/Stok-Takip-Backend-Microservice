package tr.com.cinigaz.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Entity
@Table(name = "urun")

public class UrunEntity extends MainEntity {

    @Id
    @SequenceGenerator(sequenceName = "seq_urun", allocationSize = 1, initialValue = 1, name = "seq_urun")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_urun")
    @Column(name = "urun_id", nullable = false)
    private Integer urunId;

    @Column(name = "urun_adi", length = 60)
    private String urunAdi;

    @Column(name = "urun_kodu")
    private String urunKodu;

    @Column(name = "urun_aciklama", length = 120)
    private String urunAciklama;

    @Column(name = "urun_birimi", length = 10)
    private String urunBirimi;

    @Column(name = "urun_varyant", length = 1, nullable = false, insertable = true, updatable = true) //@FIXME : S ise serinolu ürün N ise Seri no ile takip edilmeyen ürün
    private String urunVaryant ;

    @Column(name = "urun_tip_id")
    private Integer urunTipId ;

    @Column(name = "ust_urun_id")
    private Integer ustUrunId ;




//    @Column(name = "urun_tip_id", length = 60)
//    private String urunTip;



}

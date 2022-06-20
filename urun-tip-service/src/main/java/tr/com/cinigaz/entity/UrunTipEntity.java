package tr.com.cinigaz.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Entity
@Table(name = "urun_tip")

public class UrunTipEntity extends MainEntity {
    @Id
    @SequenceGenerator(sequenceName = "seq_urun_tip", allocationSize = 1, initialValue = 1, name = "seq_urun_tip")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_urun_tip")
    @Column(name = "urun_tip_id", nullable = false)
    private Integer urunTipId;

    @Column(name = "ust_urun_id")//üst tip id
    private Integer ustUrunId;

    @Column(name = "urun_tip_adi", length = 60)
    private String urunTipAdi;

    @Column(name = "urun_tip_aciklama", length = 60)
    private String urunTipAciklama;

    @Column(name = "urun_varyant", length = 1, nullable = false, insertable = true, updatable = true) //@FIXME : S ise serinolu ürün N ise Seri no ile takip edilmeyen ürün
    private String urunVaryant;

}

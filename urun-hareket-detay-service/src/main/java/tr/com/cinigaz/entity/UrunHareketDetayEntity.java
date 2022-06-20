package tr.com.cinigaz.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Entity
@Table(name = "urun_hareket_detay")

public class UrunHareketDetayEntity extends MainEntity {
    @Id
    @SequenceGenerator(sequenceName = "seq_urun_hareket_detay", allocationSize = 1, initialValue = 1, name = "seq_urun_hareket_detay")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_urun_hareket_detay")
    @Column(name = "urun_hareket_detay_id", nullable = false)
    private Integer UrunHareketDetayId;

    @Column(name = "marka", length = 30)
    private String marka;

    @Column(name = "seri_no")
    private Long seriNo;

   @Column(name = "urun_hareket_id")
   private Integer urunHareketId;

}

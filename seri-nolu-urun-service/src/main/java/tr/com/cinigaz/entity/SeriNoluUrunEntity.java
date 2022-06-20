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
@Table(name = "seri_nolu_urun")

public class SeriNoluUrunEntity extends MainEntity {
    @Id
    @SequenceGenerator(sequenceName = "seq_seri_nolu_urun", allocationSize = 1, initialValue = 1, name = "seq_seri_nolu_urun")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_seri_nolu_urun")
    @Column(name = "seri_nolu_urun_id")
    private Integer seriNoluUrunId;

    @Column(name = "seri_nolu_urun_adi", length = 60)
    private String seriNoluUrunAdi;

    @Column(name = "seri_nolu_urun_seri_no", length = 60)
    private String seriNoluUrunSeriNo;

    @Column(name = "seri_nolu_urun_son_kalibrasyon_tarihi")
    @Temporal(TemporalType.DATE)
    private Date seriNoluUrunSonKalibrasyonTarihi;


    @Column(name = "seri_nolu_urun_uretim_tarihi")
    @Temporal(TemporalType.DATE)
    private Date seriNoluUrunUretimTarihi;

    @Column(name = "seri_nolu_urun_miktari", length = 60)
    private Integer seriNoluUrunMiktari;

}


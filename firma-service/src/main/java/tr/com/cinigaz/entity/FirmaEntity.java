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
@Table(name = "firma")

public class FirmaEntity extends MainEntity {
    @Id
    @SequenceGenerator(sequenceName = "seq_firma", allocationSize = 1, initialValue = 1, name = "seq_firma")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_firma")
    @Column(name = "firma_id", nullable = false)
    private Integer firmaId;

    @Column(name = "firma_adi", length = 60)
    private String firmaAdi;

    @Column(name = "marka", length = 10)
    private String marka;

    @Column(name = "firma_adresi", length = 60)
    private String firmaAdresi;

    @Column(name = "firma_tel1", length = 60)
    private String firmaTel1;

    @Column(name = "firma_tel2", length = 60)
    private String firmaTel2;

    @Column(name = "firma_vergi_kimlik_no", length = 60)
    private String firmaVergiKimlikNo;

    @Column(name = "firma_fax", length = 60)
    private String firmaFax;

    @Column(name = "firma_yetkili_ad", length = 60)
    private String firmaYetkiliAd;

    @Column(name = "firma_aciklama", length = 60)
    private String firmaAciklama;
}

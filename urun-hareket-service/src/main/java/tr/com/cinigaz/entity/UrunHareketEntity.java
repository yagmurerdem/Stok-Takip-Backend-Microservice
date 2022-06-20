package tr.com.cinigaz.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
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
@Table(name = "urun_hareket")

public class UrunHareketEntity extends MainEntity {
    @Id
    @SequenceGenerator(sequenceName = "seq_urnh", allocationSize = 1, initialValue = 1, name = "seq_urnh")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_urnh")

    @Column(name = "urun_hareket_id", nullable = false)
    private Integer urunHareketId;

    @Column(name = "urun_id")
    private Integer urunId;

    @Column(name = "tarih")
    private Date tarih;

    @Column(name = "hareket_turu", length = 1) // @FIXME : Sadece G ve C alacak
    private String hareketTuru;

    @Column(name = "hareket_amac")
    private String hareketAmac;

    @Column(name = "seri_no_takibi")
    private boolean seriNoTakibi;

    @Column(name = "cikis_depo")
    private Integer cikisDepoId;

    @Column(name = "giris_depo")
    private Integer girisDepoId;

    @Column(name = "birim")
    private String birim;

    @Column(name = "miktar")
    private float miktar;

//
    @Column(name = "firma_id")
    private Integer firmaId;
//
//    @Column(name = "marka_firma_id")
//    private Integer markaFirmaId;


}

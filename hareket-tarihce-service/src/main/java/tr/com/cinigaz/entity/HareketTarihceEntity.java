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
@Table(name = "hareket_tarihce")

public class HareketTarihceEntity extends MainEntity {
    @Id
    @SequenceGenerator(sequenceName = "seq_hareket_tarihce", allocationSize = 1, initialValue = 1, name = "seq_hareket_tarihce")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_hareket_tarihce")
    @Column(name = "hareket_tarihce_id", nullable = false)
    private Integer hareketTarihceId;

    @Column(name = "hareket_amaci", length = 60)
    private String hareketAmaci;

    @Column(name = "seri_nolu_urun_id")
    private Integer seriNoluUrunId;

    @Column(name = "tarih")
    private Date tarih;


}

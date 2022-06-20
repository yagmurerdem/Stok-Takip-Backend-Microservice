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
@Table(name = "depo")

public class DepoEntity extends MainEntity {
    @Id
    @SequenceGenerator(sequenceName = "seq_depo", allocationSize = 1, initialValue = 1, name = "seq_depo")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_depo")

    @Column(name = "depo_id", nullable = false)
    private Integer depoId;

    @Column(name = "depo_adi", length = 60)
    private String depoAdi;

    @Column(name = "depo_adresi", length = 60)
    private String depoAdresi;

    @Column(name = "depo_aciklama", length = 60)
    private String depoAciklama;
}

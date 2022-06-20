package tr.com.cinigaz.entity;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

@MappedSuperclass

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode


public class MainEntity {
    @Column(name = "created_by")
    private String createdBy;
    @Column(name = "created_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;
    @Column(name = "updated_by")
    private String updatedBy;
    @Column(name = "updated_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;
}

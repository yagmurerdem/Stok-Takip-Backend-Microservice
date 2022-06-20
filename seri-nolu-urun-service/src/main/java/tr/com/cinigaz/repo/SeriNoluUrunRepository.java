package tr.com.cinigaz.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import tr.com.cinigaz.entity.SeriNoluUrunEntity;


@Repository

public interface SeriNoluUrunRepository extends JpaRepository <SeriNoluUrunEntity,Integer>{

    String SQL1 = "Select * From seri_nolu_urun Where seri_nolu_urun_seri_no = :seriNoluUrunSeriNo";
    @Query(value = SQL1, nativeQuery = true)
    public SeriNoluUrunEntity getEntityByUrunAdi(@Param("seriNoluUrunSeriNo") String seriNoluUrunSeriNo);

}


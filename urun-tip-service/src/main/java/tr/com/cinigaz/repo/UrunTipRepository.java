package tr.com.cinigaz.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import tr.com.cinigaz.entity.UrunTipEntity;
import tr.com.cinigaz.entity.UrunTipEntity;

import java.util.List;


@Repository

public interface UrunTipRepository extends JpaRepository <UrunTipEntity,Integer>{


//
//    String SQL1 = "Select * From urun Where urun_adi = :urunadi";
//    @Query(value = SQL1, nativeQuery = true)
//    public UrunEntity getEntityByUrunAdi(@Param("urunadi") String urunAdi);



    //String SQL1 = "Select count(1) From urun_tip Where ust_urun_id = :uruntipid";
    String SQL1 = "Select * From urun_tip Where ust_urun_id = :urunTipId";
    @Query(value = SQL1, nativeQuery = true)
    public List<UrunTipEntity> getEntityByUstUrunId(@Param("urunTipId") Integer urunTipId
    );



}


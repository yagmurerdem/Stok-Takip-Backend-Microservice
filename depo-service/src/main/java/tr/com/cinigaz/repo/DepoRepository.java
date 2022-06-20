package tr.com.cinigaz.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import tr.com.cinigaz.entity.DepoEntity;



@Repository

public interface DepoRepository extends JpaRepository <DepoEntity,Integer>{

    String SQL1 = "Select * From depo Where depo_adi = :depoAdi";
    @Query(value = SQL1, nativeQuery = true)
    public DepoEntity getEntityByDepoAdi(@Param("depoAdi") String depoAdi);

}


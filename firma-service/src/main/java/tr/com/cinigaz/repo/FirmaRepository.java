package tr.com.cinigaz.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import tr.com.cinigaz.entity.FirmaEntity;




@Repository

public interface FirmaRepository extends JpaRepository <FirmaEntity,Integer>{



    String SQL1 = "Select * From firma Where firma_adi like :firmaAdi order by firma_adi limit 1";
    @Query(value = SQL1, nativeQuery = true)
    public FirmaEntity getEntityByFirmaAdi(@Param("firmaAdi") String firmaAdi);



    String SQL2 = "Select * From firma Where firma_tel1 = :firmaTel1";
    @Query(value = SQL2, nativeQuery = true)
    public FirmaEntity getEntityByFirmaTel1(@Param("firmaTel1") String firmaTel1);



    String SQL3 = "Select * From firma Where firma_tel2 = :firmaTel2";
    @Query(value = SQL3, nativeQuery = true)
    public FirmaEntity getEntityByFirmaTel2(@Param("firmaTel2") String firmaTel2);



    String SQL4 = "Select * From firma Where firma_fax = :firmaFax";
    @Query(value = SQL4, nativeQuery = true)
    public FirmaEntity getEntityByFirmaFax(@Param("firmaFax") String firmaFax);



    String SQL5 = "Select * From firma Where firma_vergi_kimlik_no = :firmaVergiKimlikNo";
    @Query(value = SQL5, nativeQuery = true)
    public FirmaEntity getEntityByFirmaVergiKimlikNo(@Param("firmaVergiKimlikNo") String firmaVergiKimlikNo);

}


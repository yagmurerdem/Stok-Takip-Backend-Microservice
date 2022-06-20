package tr.com.cinigaz.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import tr.com.cinigaz.entity.UrunEntity;

import javax.transaction.Transactional;
import java.util.List;


@Repository

public interface UrunRepository extends JpaRepository <UrunEntity,Integer>{

    String SQL1 = "Select * From urun Where urun_adi = :urunAdi";
    @Query(value = SQL1, nativeQuery = true)
    public UrunEntity getEntityByUrunAdi(@Param("urunAdi") String urunAdi);



    String SQL2="Select * From urun Where urun_kodu = :urunKodu";
    @Query(value = SQL2, nativeQuery = true)
    public UrunEntity getEntityByUrunKodu(@Param("urunKodu") String urunKodu);



    String SQL3="Select * From urun Where urun_tip_id = :urunTipId"; //mesela, tipi 5 /*ama üst ürün tipine bak (:uruntipid = 2)*/ seçilmiş bir ürün var mı varsa bu tip altına alt tip eklenemez
    @Query(value = SQL3, nativeQuery = true)
    public List<UrunEntity> getEntityByUrunCek(@Param("urunTipId") Integer urunTipId);



    String SQL4="Update urun Set urun_tip_id=:urunTipId Where urun_tip_id = :ustUrunId"; //Select count(*) from urun where urun_tip = 2 (2 nolu ürün tip idsine ait ürünüm var mı ?)-->	1. İşlem Diğer ürünler bu kategoriye alınsın mı;-->		a. Evet -> Update Urun Set Urun_tip = 5 Where urun_tip = 2b.	Hayır -> Bu ürün tipi kaydedilemez
    @Transactional
    @Modifying
    @Query(value = SQL4, nativeQuery = true)
    public void getByUrunTipIdCek(@Param("urunTipId") Integer urunTipId, @Param("ustUrunId") Integer ustUrunId);




  /*  String SQL5 = "Select * From urun Where depo_id = :depoid"; //bu depo_id ye ait urun var mı
    @Query(value = SQL5, nativeQuery = true)
    public List<UrunEntity> getByDepodanUrunCek(@Param("depoid") Integer depoId);
*/

   // public UrunEntity findByUrunAdi(String urunAdi);
    //public UrunEntity findByUrunKodu(String urunKodu);


}


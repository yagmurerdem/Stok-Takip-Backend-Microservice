package tr.com.cinigaz.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import tr.com.cinigaz.entity.UrunHareketEntity;


@Repository

public interface UrunHareketRepository extends JpaRepository <UrunHareketEntity,Integer>{


    String SQL01 = "Select \n" +
            "  sum(giris_adet) - sum(cikis_adet) as kalan_miktar \n" +
            "From \n" +
            "  (\n" +
            "    Select \n" +
            "      Case When giris_depo = :pGirisDepo then U.Miktar else 0 End giris_adet, \n" +
            "      Case When cikis_depo = :pGirisDepo then U.Miktar else 0 End cikis_adet \n" +
            "    From \n" +
            "      Urun_Hareket as U \n" +
            "    Where \n" +
            "      urun_id = :pUrunId \n" +
            "      And (\n" +
            "        giris_depo = :pGirisDepo \n" +
            "        Or cikis_depo = :pGirisDepo)\n" +
            " UNION ALL Select 0 giris_adet, 0 cikis_adet " +
            "      ) X";

    @Query(value = SQL01, nativeQuery = true)
    public float getUrunDepoMiktar(@Param("pGirisDepo") Integer cikisDepoId, @Param("pUrunId") Integer urunId);



    String SQL02 = "Select Count(1) As adet From Urun_Hareket where giris_depo = :depo or cikis_depo = :depo";
    @Query(value = SQL02, nativeQuery = true)
    public long getDepoByRecordValue(@Param("depo")  Integer depo);
}






















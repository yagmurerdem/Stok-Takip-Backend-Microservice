package tr.com.cinigaz.service;

import tr.com.cinigaz.dto.UrunHareketDto;
import tr.com.cinigaz.dto.UrunHareketDto;

import java.util.List;

public interface UrunHareketService {


    UrunHareketDto save(UrunHareketDto dto);
    UrunHareketDto update(Integer urunHareketId,UrunHareketDto dto);
    Boolean delete(Integer urunHareketId);
    UrunHareketDto getById(Integer urunId);
    List<UrunHareketDto> getAll();
    Float getByDepodaKalanUrunMiktar(Integer cikisDepoId, Integer urunId);
    long getDepoByHareket(Integer depo);
}

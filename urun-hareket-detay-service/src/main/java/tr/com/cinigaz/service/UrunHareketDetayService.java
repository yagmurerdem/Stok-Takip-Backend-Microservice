package tr.com.cinigaz.service;



import tr.com.cinigaz.dto.UrunHareketDetayDto;

import java.util.List;

public interface UrunHareketDetayService {


    UrunHareketDetayDto save(UrunHareketDetayDto dto);
    UrunHareketDetayDto update(UrunHareketDetayDto dto);
    Boolean delete(UrunHareketDetayDto dto);
    UrunHareketDetayDto getById(Integer urunId);
    List<UrunHareketDetayDto> getAll();
}

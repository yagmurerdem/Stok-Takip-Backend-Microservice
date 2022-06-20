package tr.com.cinigaz.service;

import tr.com.cinigaz.dto.UrunDto;

import java.util.List;

public interface UrunService {




    UrunDto save(UrunDto dto);
    UrunDto update(Integer urunId,UrunDto dto);
    Boolean delete(Integer urunId);
    UrunDto getById(Integer urunId);
    List<UrunDto> getAll();
    UrunDto getUrunByAdi(String urunAdi);
    UrunDto getByUrunKodu(String urunKodu);
    List<UrunDto> getByUrunCek(Integer urunTipId);
    Boolean getByUrunTipIdCek(Integer urunTipId, Integer ustUrunId);
 /*   List<UrunDto> getByDepodanUrunCek(Integer depoId);*/
}

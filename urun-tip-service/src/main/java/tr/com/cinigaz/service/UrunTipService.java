package tr.com.cinigaz.service;

import tr.com.cinigaz.dto.UrunTipDto;

import java.util.List;

public interface UrunTipService {


    UrunTipDto save(UrunTipDto dto);
    UrunTipDto update(Integer urunTipId , UrunTipDto dto);
    Boolean delete(Integer urunTipId);
    UrunTipDto getById(Integer urunTipId);
    List<UrunTipDto> getAll();
    List<UrunTipDto> getByUrunTip(Integer urunTipId);
}

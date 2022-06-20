package tr.com.cinigaz.service;

import tr.com.cinigaz.dto.HareketTarihceDto;

import java.util.List;

public interface HareketTarihceService {


    HareketTarihceDto save(HareketTarihceDto dto);
    HareketTarihceDto update(HareketTarihceDto dto);
    Boolean delete(HareketTarihceDto dto);
    HareketTarihceDto getById(Integer hareketTarihceId);
    List<HareketTarihceDto> getAll();
}

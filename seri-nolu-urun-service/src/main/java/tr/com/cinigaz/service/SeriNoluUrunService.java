package tr.com.cinigaz.service;

import tr.com.cinigaz.dto.SeriNoluUrunDto;

import java.util.List;

public interface SeriNoluUrunService {


    SeriNoluUrunDto save(SeriNoluUrunDto dto);
    SeriNoluUrunDto update(Integer seriNoluUrunId , SeriNoluUrunDto dto);
    Boolean delete(Integer seriNoluUrunId);
    SeriNoluUrunDto getById(Integer seriNoluUrunId);
    List<SeriNoluUrunDto> getAll();
    SeriNoluUrunDto getBySeriNoCek(String seriNoluUrunSeriNo);
}

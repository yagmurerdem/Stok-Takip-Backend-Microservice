package tr.com.cinigaz.service;

import org.springframework.http.ResponseEntity;
import tr.com.cinigaz.dto.DepoDto;
import tr.com.cinigaz.dto.DepoResponseDto;

import java.util.List;

public interface DepoService {


    DepoDto save(DepoDto dto);
    ResponseEntity<DepoResponseDto> update(Integer depoId, DepoDto dto);
    Boolean delete(Integer depoId);
    DepoDto getById(Integer depoId);
    List<DepoDto> getAll();
    DepoDto getByDepoAdi(String depoAdi);
    DepoResponseDto getByDepoId(Integer depoId);


}

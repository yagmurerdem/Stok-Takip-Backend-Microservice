package tr.com.cinigaz.service;

import tr.com.cinigaz.dto.FirmaDto;
import tr.com.cinigaz.dto.FirmaResponseDto;
import java.util.List;

public interface FirmaService {


    FirmaDto save(FirmaDto dto);
    FirmaDto update(Integer firmaId,FirmaDto dto);
    Boolean delete(Integer firmaId);
    FirmaDto getById(Integer firmaId);
    List<FirmaDto> getAll();
    FirmaDto getByFirmaAdi(String firmaAdi);
    FirmaDto getByFirmaTel1(String firmaTel1);
    FirmaDto getByFirmaTel2(String firmaTel2);
    FirmaDto getByFirmaFax(String firmaFax);
    FirmaDto getByFirmafirmaVergiKimlikNo(String firmaVergiKimlikNo);
    FirmaResponseDto getByFirmaId(Integer firmaId);
}

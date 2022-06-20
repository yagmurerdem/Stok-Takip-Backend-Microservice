package tr.com.cinigaz.api;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tr.com.cinigaz.dto.FirmaDto;
import tr.com.cinigaz.dto.FirmaResponseDto;
import tr.com.cinigaz.service.FirmaService;
import tr.com.cinigaz.service.FirmaService;
import tr.com.cinigaz.util.ApiAdresses;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping(name = ApiAdresses.FirmaControllerAdress.ANA, value = ApiAdresses.FirmaControllerAdress.ANA)

public class FirmaController {

    private FirmaService service;

    public FirmaController(FirmaService service) {
        this.service = service;
    }

    @GetMapping(ApiAdresses. FirmaControllerAdress.TUMLISTE)
    public ResponseEntity<List<FirmaDto>> getAllFirma() {
        return ResponseEntity.ok(service.getAll());
    }

    @PostMapping(ApiAdresses.FirmaControllerAdress.EKLE)
    public ResponseEntity<FirmaDto> saveFirma(@Valid @RequestBody FirmaDto dto) {
        return ResponseEntity.ok(service.save(dto));
    }

    @PutMapping(ApiAdresses.FirmaControllerAdress.DEGISTIR)
    public ResponseEntity<FirmaDto>  putFirma(@Valid @PathVariable("firmaId") Integer firmaId, @Valid  @RequestBody FirmaDto dto){
        FirmaDto updated_Firma = service.update(firmaId,dto);
        return ResponseEntity.ok((updated_Firma));
    }

    @DeleteMapping(ApiAdresses.FirmaControllerAdress.SIL)
    public ResponseEntity<Boolean> deleteFirma(@Valid @PathVariable("firmaId") Integer firmaId){
        return ResponseEntity.ok((service.delete(firmaId)));
    }

    @GetMapping(ApiAdresses.FirmaControllerAdress.CEK)
    public ResponseEntity<FirmaDto> getById(@Valid @PathVariable("firmaId") Integer firmaId){
        return ResponseEntity.ok(service.getById(firmaId));
    }

    @GetMapping(ApiAdresses.FirmaControllerAdress.ADICEK)  ///Firma/{productName}
    public ResponseEntity<FirmaDto> getByFirmaAdi(@Valid @PathVariable("firmaAdi") String firmaAdi){
        return ResponseEntity.ok(service.getByFirmaAdi(firmaAdi));
    }


    @GetMapping(ApiAdresses.FirmaControllerAdress.TEL1CEK)
    public ResponseEntity<FirmaDto> getByFirmaTel1(@Valid @PathVariable("firmaTel1") String firmaTel1){
        return ResponseEntity.ok(service.getByFirmaTel1(firmaTel1));
    }

    @GetMapping(ApiAdresses.FirmaControllerAdress.TEL2CEK)
    public ResponseEntity<FirmaDto> getByFirmaTel2(@Valid @PathVariable("firmaTel2") String firmaTel2){
        return ResponseEntity.ok(service.getByFirmaTel2(firmaTel2));
    }


    @GetMapping(ApiAdresses.FirmaControllerAdress.FAXCEK)
    public ResponseEntity<FirmaDto> getByFirmaFax(@Valid @PathVariable("firmaFax") String firmaFax){
        return ResponseEntity.ok(service.getByFirmaFax(firmaFax));
    }

    @GetMapping(ApiAdresses.FirmaControllerAdress.VKNCEK)
    public ResponseEntity<FirmaDto> getByFirmafirmaVergiKimlikNo(@Valid @PathVariable("firmaVergiKimlikNo") String firmaVergiKimlikNo){
        return ResponseEntity.ok(service.getByFirmafirmaVergiKimlikNo(firmaVergiKimlikNo));
    }

    @GetMapping(ApiAdresses.FirmaControllerAdress.IDCEK)
    public FirmaResponseDto getByIdCek(@Valid @PathVariable("firmaId") Integer firmaId) {
        FirmaDto firmaDto = new FirmaDto();
        return service.getByFirmaId(firmaId);

    }




}


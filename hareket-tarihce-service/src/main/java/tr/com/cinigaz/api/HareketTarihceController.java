package tr.com.cinigaz.api;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tr.com.cinigaz.dto.HareketTarihceDto;
import tr.com.cinigaz.service.HareketTarihceService;
import tr.com.cinigaz.util.ApiAdresses;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(name = ApiAdresses.HareketTarihceControllerAdress.ANA, value = ApiAdresses.HareketTarihceControllerAdress.ANA)

public class HareketTarihceController {

    private HareketTarihceService service;

    public HareketTarihceController(HareketTarihceService service) {
        this.service = service;
    }

    @GetMapping(ApiAdresses. HareketTarihceControllerAdress.TUMLISTE)
    public ResponseEntity<List<HareketTarihceDto>> getAllUrun() {
        return ResponseEntity.ok(service.getAll());
    }

    @PostMapping(ApiAdresses.HareketTarihceControllerAdress.EKLE)
    public ResponseEntity<HareketTarihceDto> saveUrun(@Valid @RequestBody HareketTarihceDto dto) {
        return ResponseEntity.ok(service.save(dto));
    }

    @PutMapping(ApiAdresses.HareketTarihceControllerAdress.DEGISTIR)
    public ResponseEntity<HareketTarihceDto>  putUrun(@Valid  @RequestBody HareketTarihceDto dto){
        HareketTarihceDto updated_Urun = service.update(dto);
        return ResponseEntity.ok((updated_Urun));

    }

    @DeleteMapping(ApiAdresses.HareketTarihceControllerAdress.SIL)
    public ResponseEntity<Boolean> deleteUrun(@Valid @RequestBody HareketTarihceDto dto){
        return ResponseEntity.ok((service.delete(dto)));
    }

    @GetMapping(ApiAdresses.HareketTarihceControllerAdress.CEK)
    public ResponseEntity<HareketTarihceDto> getById(@Valid @PathVariable("hareketTarihceId") Integer hareketTarihceId){
        return ResponseEntity.ok(service.getById(hareketTarihceId));
    }

//    @GetMapping(ApiAdresses.UrunControllerAdress.ADICEK)  ///Urun/{productName}
//    public ResponseEntity<UrunDto> getByName(@Valid @RequestBody  UrunDto dto){
//        return ResponseEntity.ok(service.getByName(dto));
//    }

}





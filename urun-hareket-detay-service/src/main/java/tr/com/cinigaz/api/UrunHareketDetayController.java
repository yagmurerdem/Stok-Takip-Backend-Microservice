package tr.com.cinigaz.api;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tr.com.cinigaz.dto.UrunHareketDetayDto;
import tr.com.cinigaz.service.UrunHareketDetayService;
import tr.com.cinigaz.util.ApiAdresses;

import java.util.List;

import javax.validation.Valid;



@RestController
@RequestMapping(name = ApiAdresses.UrunHareketDetayControllerAdress.ANA, value = ApiAdresses.UrunHareketDetayControllerAdress.ANA)

public class UrunHareketDetayController {
    private UrunHareketDetayService service;

    public UrunHareketDetayController(UrunHareketDetayService service) {
        this.service = service;
    }


    @GetMapping(ApiAdresses. UrunHareketDetayControllerAdress.TUMLISTE)
    public ResponseEntity<List<UrunHareketDetayDto>> getAllUrunHareketDetay() {
        return ResponseEntity.ok(service.getAll());
    }

    @PostMapping(ApiAdresses.UrunHareketDetayControllerAdress.EKLE)
    public ResponseEntity<UrunHareketDetayDto> saveUrunHareketDetay(@Valid @RequestBody UrunHareketDetayDto dto) {
        return ResponseEntity.ok(service.save(dto));
    }

    @PutMapping(ApiAdresses.UrunHareketDetayControllerAdress.DEGISTIR)
    public ResponseEntity<UrunHareketDetayDto>  putUrunHareketDetay(@Valid  @RequestBody UrunHareketDetayDto dto){
        UrunHareketDetayDto updated_UrunHareketDetay = service.update(dto);
        return ResponseEntity.ok((updated_UrunHareketDetay));

    }

    @DeleteMapping(ApiAdresses.UrunHareketDetayControllerAdress.SIL)
    public ResponseEntity<Boolean> deleteUrunHareketDetay(@Valid @RequestBody UrunHareketDetayDto dto){
        return ResponseEntity.ok((service.delete(dto)));
    }

    @GetMapping(ApiAdresses.UrunHareketDetayControllerAdress.CEK)
    public ResponseEntity<UrunHareketDetayDto> getById(@Valid @PathVariable("urunHareketDetayId") Integer urunHareketDetayId){
        return ResponseEntity.ok(service.getById(urunHareketDetayId));
    }

//    @GetMapping(ApiAdresses.UrunHareketDetayControllerAdress.ADICEK)  ///UrunHareketDetay/{productName}
//    public ResponseEntity<UrunHareketDetayDto> getByName(@Valid @RequestBody  UrunHareketDetayDto dto){
//        return ResponseEntity.ok(service.getByName(dto));
//    }

}


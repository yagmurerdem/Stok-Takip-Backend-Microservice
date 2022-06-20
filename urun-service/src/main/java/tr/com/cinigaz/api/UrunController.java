package tr.com.cinigaz.api;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tr.com.cinigaz.dto.UrunDto;
import tr.com.cinigaz.service.UrunService;
import tr.com.cinigaz.util.ApiAdresses;

import java.util.List;

import javax.validation.Valid;

@CrossOrigin("*")
@RestController
@RequestMapping(name = ApiAdresses.UrunControllerAdress.ANA, value = ApiAdresses.UrunControllerAdress.ANA)

public class UrunController {

    private UrunService service;

    public  UrunController(UrunService service) {
        this.service = service;
    }

    @GetMapping(ApiAdresses. UrunControllerAdress.TUMLISTE)
    public ResponseEntity<List<UrunDto>> getAllUrun() {
        return ResponseEntity.ok(service.getAll());
    }

    @PostMapping(ApiAdresses.UrunControllerAdress.EKLE)
    public ResponseEntity<UrunDto> saveUrun(@Valid @RequestBody UrunDto dto) {
        return ResponseEntity.ok(service.save(dto));
    }

    @PutMapping(ApiAdresses.UrunControllerAdress.DEGISTIR)
    public ResponseEntity<UrunDto>  putUrun(@Valid @PathVariable("urunId") Integer urunId, @Valid  @RequestBody UrunDto dto){
        UrunDto updated_Urun = service.update(urunId,dto);
        return ResponseEntity.ok((updated_Urun));
    }

    @DeleteMapping(ApiAdresses.UrunControllerAdress.SIL)
    public ResponseEntity<Boolean> deleteUrun(@Valid @PathVariable("urunId") Integer urunId){
        return ResponseEntity.ok((service.delete(urunId)));
    }

    @GetMapping(ApiAdresses.UrunControllerAdress.CEK)
    public ResponseEntity<UrunDto> getById(@Valid @PathVariable("urunId") Integer urunId){
        return ResponseEntity.ok(service.getById(urunId));
    }

    @GetMapping(ApiAdresses.UrunControllerAdress.ADICEK)
    public ResponseEntity<UrunDto> getUrunByAdi(@Valid @PathVariable("urunAdi") String urunAdi){
        return ResponseEntity.ok(service.getUrunByAdi(urunAdi));
    }


    @GetMapping(ApiAdresses.UrunControllerAdress.URUNKODUCEK)
    public ResponseEntity<UrunDto> getByUrunKodu(@Valid @PathVariable("urunKodu") String urunKodu){
        return ResponseEntity.ok(service.getByUrunKodu(urunKodu));
    }


    @GetMapping(ApiAdresses.UrunControllerAdress.URUNCEK) //gönderilen urun_tip_id ye ait ürün var mı yoksa 1.işlem bu ürünler kategoriye alınsın mı a:evet --> urun_tip_id=kaydedilmek istenen id b -->bu ürün tipi kaydedilemez
    public ResponseEntity<List<UrunDto>> getByUrunCek(@Valid @PathVariable("urunTipId") Integer urunTipId){
        return ResponseEntity.ok(service.getByUrunCek(urunTipId));
    }


    @GetMapping(ApiAdresses.UrunControllerAdress.URUNTIPIDCEK +"/{ustUrunId}")
    public ResponseEntity<Boolean> getByUrunTipIdCek(@Valid @PathVariable("urunTipId") Integer urunTipId, @Valid @PathVariable("ustUrunId") Integer ustUrunId){
        return ResponseEntity.ok(service.getByUrunTipIdCek(urunTipId, ustUrunId));
    }


  /*  @GetMapping(ApiAdresses.UrunControllerAdress.DEPODANURUNCEK) //gönderilen urun_tip_id ye ait ürün var mı yoksa 1.işlem bu ürünler kategoriye alınsın mı a:evet --> urun_tip_id=kaydedilmek istenen id b -->bu ürün tipi kaydedilemez
    public ResponseEntity<List<UrunDto>> getByDepodanUrunCek(@Valid @PathVariable("depoId") Integer depoId){
        return ResponseEntity.ok(service.getByDepodanUrunCek(depoId));
    }*/


//    @GetMapping(ApiAdresses.UrunControllerAdress.ADICEK)  ///Urun/{productName}
//    public ResponseEntity<UrunDto> getByName(@Valid @RequestBody  UrunDto dto){
//        return ResponseEntity.ok(service.getByName(dto));
//    }

}


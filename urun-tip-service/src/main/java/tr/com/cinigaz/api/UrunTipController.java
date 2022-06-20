package tr.com.cinigaz.api;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tr.com.cinigaz.dto.UrunTipDto;
import tr.com.cinigaz.service.UrunTipService;
import tr.com.cinigaz.util.ApiAdresses;

import javax.validation.Valid;
import java.util.List;


@CrossOrigin("*")
@RestController
@RequestMapping(name = ApiAdresses.UrunTipControllerAdress.ANA, value = ApiAdresses.UrunTipControllerAdress.ANA)


public class UrunTipController {
    private UrunTipService service;

    public UrunTipController(UrunTipService service) {
        this.service = service;
    }


    @GetMapping(ApiAdresses. UrunTipControllerAdress.TUMLISTE)
    public ResponseEntity<List<UrunTipDto>> getAllUrunTip() {
        return ResponseEntity.ok(service.getAll());
    }


    @PostMapping(ApiAdresses.UrunTipControllerAdress.EKLE)
    public ResponseEntity<UrunTipDto> saveUrunTip(@Valid @RequestBody UrunTipDto dto) {
        return ResponseEntity.ok(service.save(dto));
    }

    @PutMapping(ApiAdresses.UrunTipControllerAdress.DEGISTIR)
    public ResponseEntity<UrunTipDto>  putUrunTip(@Valid @PathVariable("urunTipId") Integer urunTipId, @Valid  @RequestBody UrunTipDto dto){
        UrunTipDto updated_UrunTip = service.update(urunTipId,dto);
        return ResponseEntity.ok((updated_UrunTip));
    }


    @DeleteMapping(ApiAdresses.UrunTipControllerAdress.SIL)
    public ResponseEntity<Boolean> deleteUrunTip(@Valid @PathVariable("urunTipId") Integer urunTipId){
        return ResponseEntity.ok((service.delete(urunTipId)));
    }


    @GetMapping(ApiAdresses.UrunTipControllerAdress.CEK)
    public ResponseEntity<UrunTipDto> getById(@Valid @PathVariable("urunTipId") Integer urunTipId){
        return ResponseEntity.ok(service.getById(urunTipId));
    }


    @GetMapping(ApiAdresses.UrunTipControllerAdress.URUNTIPSAYI) // ürüntip id ye ait aynı üst ürün id var mı varsa alt tipi bulunuyor demektir.Bu ürün tipini seçemezsin.
    public ResponseEntity<List<UrunTipDto>> getByUrunTip(@Valid @PathVariable("urunTipId") Integer urunTipId){
        System.out.println(urunTipId);
        //UrunTipDto dto =
        return ResponseEntity.ok(service.getByUrunTip(urunTipId));

    }




//    @GetMapping(ApiAdresses.UrunTipControllerAdress.ADICEK)  ///UrunTip/{productName}
//    public ResponseEntity<UrunTipDto> getByName(@Valid @RequestBody  UrunTipDto dto){
//        return ResponseEntity.ok(service.getByName(dto));
//    }

}


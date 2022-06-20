package tr.com.cinigaz.api;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tr.com.cinigaz.dto.UrunHareketDto;
import tr.com.cinigaz.service.UrunHareketService;
import tr.com.cinigaz.util.ApiAdresses;
import java.util.List;
import javax.validation.Valid;



@RestController
@RequestMapping(name = ApiAdresses.UrunHareketControllerAdress.ANA, value = ApiAdresses.UrunHareketControllerAdress.ANA)


public class UrunHareketController {

    private UrunHareketService service;

    public UrunHareketController(UrunHareketService service) {
        this.service = service;
    }

    @GetMapping(ApiAdresses. UrunHareketControllerAdress.TUMLISTE)
    public ResponseEntity<List<UrunHareketDto>> getAllUrunHareket() {
        return ResponseEntity.ok(service.getAll());
    }


//    @PostMapping(ApiAdresses.UrunHareketControllerAdress.EKLE)
//    public ResponseEntity<UrunHareketDto> saveUrunHareket(@Valid @RequestBody UrunHareketDto dto) {
//        return ResponseEntity.ok(service.save(dto));
//    }

    @PostMapping(ApiAdresses.UrunHareketControllerAdress.EKLE) // /ekle
    public ResponseEntity<UrunHareketDto> saveUrunHareket(@Valid @RequestBody UrunHareketDto dto) {
        return ResponseEntity.ok(service.save(dto));
    }


    @PutMapping(ApiAdresses.UrunHareketControllerAdress.DEGISTIR)
    public ResponseEntity<UrunHareketDto>  putUrunHareket(@Valid @PathVariable("urunHareketId") Integer urunHareketId, @Valid  @RequestBody UrunHareketDto dto){
        UrunHareketDto updated_UrunHareket = service.update(urunHareketId,dto);
        return ResponseEntity.ok((updated_UrunHareket));

    }

    @DeleteMapping(ApiAdresses.UrunHareketControllerAdress.SIL)
    public ResponseEntity<Boolean> deleteUrunHareket(@Valid @PathVariable("urunHareketId") Integer urunHareketId){
        return ResponseEntity.ok((service.delete(urunHareketId)));
    }

    @GetMapping(ApiAdresses.UrunHareketControllerAdress.CEK)
    public ResponseEntity<UrunHareketDto> getById(@Valid @PathVariable("urunHareketId") Integer urunHareketId){
        return ResponseEntity.ok(service.getById(urunHareketId));
    }

//    @GetMapping(ApiAdresses.UrunHareketControllerAdress.ADICEK)  ///UrunHareket/{productName}
//    public ResponseEntity<UrunHareketDto> getByName(@Valid @RequestBody  UrunHareketDto dto){
//        return ResponseEntity.ok(service.getByName(dto));
//    }

    @GetMapping(ApiAdresses.UrunHareketControllerAdress.DEPODAKALANURUNMIKTARCEK +"/{urunId}") //çıkış deposunda kalan ürün miktarı
    public Float getByDepodaKalanUrunMiktar(@Valid @PathVariable("cikisDepoId") Integer cikisDepoId, @Valid @PathVariable("urunId") Integer urunId){
        float sayi= service.getByDepodaKalanUrunMiktar(cikisDepoId, urunId);

        return sayi;
    }


    @GetMapping(ApiAdresses.UrunHareketControllerAdress.DEPOHAREKET)
    public ResponseEntity<Long> getDepoHareket(@Valid @PathVariable("depoId") Integer depo) {
        return ResponseEntity.ok(service.getDepoByHareket(depo));
    }
}


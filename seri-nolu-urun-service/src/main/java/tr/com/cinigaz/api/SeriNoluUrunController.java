package tr.com.cinigaz.api;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tr.com.cinigaz.dto.SeriNoluUrunDto;
import tr.com.cinigaz.service.SeriNoluUrunService;
import tr.com.cinigaz.util.ApiAdresses;

import java.util.List;

import javax.validation.Valid;

@RestController
@RequestMapping(name = ApiAdresses.SeriNoluUrunControllerAdress.ANA, value = ApiAdresses.SeriNoluUrunControllerAdress.ANA)

public class SeriNoluUrunController {

    private SeriNoluUrunService service;

    public  SeriNoluUrunController(SeriNoluUrunService service) {
        this.service = service;
    }


    @GetMapping(ApiAdresses. SeriNoluUrunControllerAdress.TUMLISTE)
    public ResponseEntity<List<SeriNoluUrunDto>> getAllSeriNoluUrun() {
        return ResponseEntity.ok(service.getAll());
    }

    @PostMapping(ApiAdresses.SeriNoluUrunControllerAdress.EKLE)
    public ResponseEntity<SeriNoluUrunDto> saveSeriNoluUrun(@Valid @RequestBody SeriNoluUrunDto dto) {
        return ResponseEntity.ok(service.save(dto));
    }


    @PutMapping(ApiAdresses.SeriNoluUrunControllerAdress.DEGISTIR)
    public ResponseEntity<SeriNoluUrunDto>  putSeriNoluUrun(@Valid @PathVariable("seriNoluUrunId") Integer seriNoluUrunId, @Valid  @RequestBody SeriNoluUrunDto dto){
        SeriNoluUrunDto updated_SeriNoluUrun = service.update(seriNoluUrunId,dto);
        return ResponseEntity.ok((updated_SeriNoluUrun));

    }

    @DeleteMapping(ApiAdresses.SeriNoluUrunControllerAdress.SIL)
    public ResponseEntity<Boolean> deleteSeriNoluUrun(@Valid @PathVariable("seriNoluUrunId") Integer seriNoluUrunId){
        return ResponseEntity.ok((service.delete(seriNoluUrunId)));
    }

    @GetMapping(ApiAdresses.SeriNoluUrunControllerAdress.CEK)
    public ResponseEntity<SeriNoluUrunDto> getById(@Valid @PathVariable("seriNoluUrunId") Integer seriNoluUrunId){
        return ResponseEntity.ok(service.getById(seriNoluUrunId));
    }

    @GetMapping(ApiAdresses.SeriNoluUrunControllerAdress.SERINOCEK) //seri no çek
    public ResponseEntity<SeriNoluUrunDto> getBySeriNoCek(@Valid @PathVariable("seriNoluUrunSeriNo") String seriNoluUrunSeriNo){
        return ResponseEntity.ok(service.getBySeriNoCek(seriNoluUrunSeriNo));
    }


//    @GetMapping(ApiAdresses.SeriNoluUrunControllerAdress.ADICEK)  ///SeriNoluUrun/{productName}
//    public ResponseEntity<SeriNoluUrunDto> getByName(@Valid @RequestBody  SeriNoluUrunDto dto){
//        return ResponseEntity.ok(service.getByName(dto));
//    }

}


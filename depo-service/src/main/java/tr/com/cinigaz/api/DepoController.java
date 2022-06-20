package tr.com.cinigaz.api;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tr.com.cinigaz.dto.DepoDto;
import tr.com.cinigaz.dto.DepoResponseDto;
import tr.com.cinigaz.service.DepoService;
import tr.com.cinigaz.util.ApiAdresses;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping(name = ApiAdresses.DepoControllerAdress.ANA, value = ApiAdresses.DepoControllerAdress.ANA)

public class DepoController {
    private DepoService service;

    public DepoController(DepoService service) {
        this.service = service;
    }


    @GetMapping(ApiAdresses.DepoControllerAdress.TUMLISTE) // /tumliste
    public ResponseEntity<List<DepoDto>> getAllDepo() {
        return ResponseEntity.ok(service.getAll());
    }

    @PostMapping(ApiAdresses.DepoControllerAdress.EKLE) // /ekle
    public ResponseEntity<DepoDto> saveDepo(@Valid @RequestBody DepoDto dto) {
        return ResponseEntity.ok(service.save(dto));
    }

    @PostMapping(ApiAdresses.DepoControllerAdress.DEGISTIR)
    public ResponseEntity<DepoResponseDto> putDepo(@Valid @PathVariable("depoId") Integer depoId, @Valid @RequestBody DepoDto dto) {
        // DepoDto updated_Depo = service.update(depoId,dto);
        //return ResponseEntity.ok((updated_Depo));
        return service.update(depoId, dto);
    }

    @DeleteMapping(ApiAdresses.DepoControllerAdress.SIL)
    public ResponseEntity<Boolean> deleteDepo(@Valid @PathVariable("depoId") Integer depoId) {
        return ResponseEntity.ok((service.delete(depoId)));
    }

    @GetMapping(ApiAdresses.DepoControllerAdress.CEK)
    public ResponseEntity<DepoDto> getById(@Valid @PathVariable("depoId") Integer depoId) {
        return ResponseEntity.ok(service.getById(depoId));
    }

    @GetMapping(ApiAdresses.DepoControllerAdress.ADICEK)
    public ResponseEntity<DepoDto> getByDepoAdi(@Valid @PathVariable("depoAdi") String depoAdi) {
        return ResponseEntity.ok(service.getByDepoAdi(depoAdi));
    }

    @GetMapping(ApiAdresses.DepoControllerAdress.IDCEK)
    public DepoResponseDto getByIdCek(@Valid @PathVariable("depoId") Integer depoId) {
        DepoDto depoDto = new DepoDto();
        return service.getByDepoId(depoId);
    }






//    @GetMapping(ApiAdresses.DepoControllerAdress.ADICEK)  ///Depo/{productName}
//    public ResponseEntity<DepoDto> getByName(@Valid @RequestBody  DepoDto dto){
//        return ResponseEntity.ok(service.getByName(dto));
//    }

}


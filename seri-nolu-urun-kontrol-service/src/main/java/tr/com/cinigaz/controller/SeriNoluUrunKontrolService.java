package tr.com.cinigaz.controller;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import tr.com.cinigaz.dto.SeriNoluUrunDto;

import tr.com.cinigaz.except.SeriNoluUrunKontrolException;

import java.util.Arrays;
import java.util.List;


@CrossOrigin("*")
@RestController


public class SeriNoluUrunKontrolService {

    private static final String url1 = "http://localhost:9140/serinoluurun/seriNoluUrunSeriNo";
    private static final String url2 = "http://localhost:9140/serinoluurun/ekle";
    private static final String url3 = "http://localhost:9140/serinoluurun/tumliste";
    private static final String url4 = "http://localhost:9140/serinoluurun/guncelle";
    private static final String url5 = "http://localhost:9140/serinoluurun/sil";
    private static final String url6 = "http://localhost:9140/serinoluurun/cek";




    RestTemplate restTemplate;


    public SeriNoluUrunKontrolService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }


    public SeriNoluUrunKontrolException seriNoluUrunKontrol(String seriNoluUrunSeriNo) {
        RestTemplate rest = new RestTemplate();
        SeriNoluUrunKontrolException ex1 = new SeriNoluUrunKontrolException();


        SeriNoluUrunDto dto = rest.getForObject(url1 + "/" + String.valueOf(seriNoluUrunSeriNo), SeriNoluUrunDto.class);

        if (dto.getSeriNoluUrunId() != null) {

            if (dto.getSeriNoluUrunSeriNo().equals(seriNoluUrunSeriNo)) {
                ex1.setExceptKodu(-20000);
                ex1.setExceptAciklama("Aynı seri no ya ait ürün eklenemez.");
                ex1.printStackTree();

            }

            else {
                ex1.setExceptKodu(0);
                ex1.setExceptAciklama("aynı seri no ya ürün  bulunmamaktadır.Ürünü ekleyebilirsiniz");
                ex1.printStackTree();
            }
        }

        else {
            ex1.setExceptKodu(0);
            ex1.setExceptAciklama("aynı seri no ya ürün  bulunmamaktadır.Ürünü ekleyebilirsiniz");
            ex1.printStackTree();
        }
        return ex1;
    }




    @PostMapping("serinoluurunekle")
    public ResponseEntity<SeriNoluUrunDto> saveSeriNo(@RequestBody  SeriNoluUrunDto dto) {

        RestTemplate rest = new RestTemplate();
        SeriNoluUrunKontrolException ex1 = seriNoluUrunKontrol(dto.getSeriNoluUrunSeriNo());


        if (ex1.getExceptKodu() == 0 ) {

            // kayıt işlemlerini yaz.
            SeriNoluUrunDto res = rest.postForObject(url2, dto, SeriNoluUrunDto.class);

        }
        else
        {
            return ResponseEntity.ok(new SeriNoluUrunDto());
        }
        return ResponseEntity.ok(dto);
    }



    @GetMapping(value = "serinoluuruntumliste")
    public List<Object> getSeriNoluUrun(){

        Object[] depos=restTemplate.getForObject(url3,Object[].class);
        return Arrays.asList(depos);
    }


    @DeleteMapping("/serinoluurunsil/{seriNoluUrunId}")
    public ResponseEntity<Boolean> sil(@PathVariable("seriNoluUrunId")  Integer seriNoluUrunId){
        restTemplate.delete(url5+"/"+String.valueOf(seriNoluUrunId));
        return ResponseEntity.ok(Boolean.TRUE);
    }


    @GetMapping("/serinoluurunidgetir/{seriNoluUrunId}")
    public ResponseEntity<SeriNoluUrunDto> getirId(@PathVariable("seriNoluUrunId") Integer seriNoluUrunId){
        ResponseEntity<SeriNoluUrunDto> response = restTemplate.getForEntity(url6+"/"+String.valueOf(seriNoluUrunId),SeriNoluUrunDto.class);
        return response;
    }


    @PutMapping("/serinoluurunguncelle/{seriNoluUrunId}")
    public ResponseEntity<SeriNoluUrunDto> guncelle(@PathVariable("seriNoluUrunId") Integer seriNoluUrunId,  @RequestBody SeriNoluUrunDto seriNoluUrunDto){

        HttpEntity<SeriNoluUrunDto> update= new HttpEntity<>(seriNoluUrunDto);
        ResponseEntity<SeriNoluUrunDto> response=restTemplate.exchange(url4+"/"+String.valueOf(seriNoluUrunId), HttpMethod.PUT,update,SeriNoluUrunDto.class);
        return response;

    }





}

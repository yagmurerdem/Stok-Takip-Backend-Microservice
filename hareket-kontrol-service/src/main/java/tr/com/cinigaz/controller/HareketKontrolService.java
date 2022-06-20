
package tr.com.cinigaz.controller;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import tr.com.cinigaz.dto.UrunHareketDto;
import tr.com.cinigaz.except.HareketKontrolException;

import java.util.Arrays;
import java.util.List;


@CrossOrigin("*")
@RestController


public class HareketKontrolService {

    private static final String url1 = "http://localhost:9114/urun_hareket/depodakalanurunmiktar";
    private static final String url2 = "http://localhost:9114/urun_hareket/ekle";
    private static final String url3 = "http://localhost:9114/urun_hareket/tumliste";
    private static final String url4 = "http://localhost:9114/urun_hareket/sil";
    private static final String url5 = "http://localhost:9114/urun_hareket/getir";
    private static final String url6 = "http://localhost:9114/urun_hareket/guncelle";
    private static final String url7 = "http://localhost:9114/urun_hareket/depo";



    RestTemplate restTemplate;


    public HareketKontrolService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public HareketKontrolException depodaKalanUrunMiktar(Integer cikisDepoId, Integer urunId, Float miktar) {

        RestTemplate rest = new RestTemplate();
        HareketKontrolException ex1 = new HareketKontrolException();


        Float depodakalanmiktar = rest.getForObject(url1 +  "/" + String.valueOf(cikisDepoId) + "/" + String.valueOf(urunId), Float.class);

        if (depodakalanmiktar > 0) {

            if (depodakalanmiktar >= miktar) {
                ex1.setExceptKodu(0);
                ex1.setExceptAciklama("Depoda hareketi sağlayacak adette ürün bulunmaktadır.Hareket kaydı sağlanabilir.");
                ex1.printStackTree();

            }
            else {
                ex1.setExceptKodu(1);
                ex1.setExceptAciklama("Depoda bu kadar adette ürün bulunmamaktadır.Kayıt yapılamaz");
                ex1.printStackTree();
            }
        }
        else
        {
            ex1.setExceptKodu(1);
            ex1.setExceptAciklama("depoda ürün bulunmamaktadır.Kayıt yapılamaz");
            ex1.printStackTree();
        }
          /*  if (dto.getUrunAdi().equals(urunAdi)) {
                ex1.setExceptKodu(-20000);
                ex1.setExceptAciklama("Aynı ürün adında ekleme yapılmaz.");
                ex1.printStackTree();

            }*/

      /*      if (depodakalanmiktar <= 0) {
                ex1.setExceptKodu(0);
                ex1.setExceptAciklama("depoda bu üründen kalmamıştır");
                ex1.printStackTree();

            }


            else {
                ex1.setExceptKodu(0);
                ex1.setExceptAciklama("depoda bu üründen kalmamıştır");
                ex1.printStackTree();
            }*/

      /*  else {
            ex1.setExceptKodu(1);
            ex1.setExceptAciklama("Depoda ürün bulunmaktadır.");
            ex1.printStackTree();
        }*/
        return ex1;
    }


    @PostMapping("hareketekle")
    public ResponseEntity<UrunHareketDto> saveDepo(@RequestBody UrunHareketDto dto) {

        RestTemplate rest = new RestTemplate();
        HareketKontrolException ex1 = depodaKalanUrunMiktar(dto.getCikisDepoId(), dto.getUrunId(),dto.getMiktar());


        if (ex1.getExceptKodu() == 0) {

            // kayıt işlemlerini yaz.
            UrunHareketDto res = rest.postForObject(url2, dto, UrunHareketDto.class);

        }
        else
        {
            return ResponseEntity.ok(new UrunHareketDto());
        }
        return ResponseEntity.ok(dto);
    }

    @GetMapping(value = "harekettumliste")
    public List<Object> getDepo(){

        Object[] depos=restTemplate.getForObject(url3,Object[].class);
        return Arrays.asList(depos);
    }


    @DeleteMapping("/hareketsil/{urunHareketId}")
    public ResponseEntity<Boolean> sil(@PathVariable("urunHareketId")  Integer urunHareketId){
        restTemplate.delete(url4+"/"+String.valueOf(urunHareketId));
        return ResponseEntity.ok(Boolean.TRUE);
    }


    @GetMapping("/hareketidgetir/{urunHareketId}")
    public ResponseEntity<UrunHareketDto> getirId(@PathVariable("urunHareketId") Integer urunHareketId){
        ResponseEntity<UrunHareketDto> response = restTemplate.getForEntity(url5+"/"+String.valueOf(urunHareketId),UrunHareketDto.class);
        return response;
    }


    @PutMapping("/hareketguncelle/{urunHareketId}")
    public ResponseEntity<UrunHareketDto> guncelle(@PathVariable("urunHareketId") Integer urunHareketId,  @RequestBody UrunHareketDto urunHareketDto){

        HttpEntity<UrunHareketDto> update= new HttpEntity<>(urunHareketDto);
        ResponseEntity<UrunHareketDto> response=restTemplate.exchange(url6+"/"+String.valueOf(urunHareketId), HttpMethod.PUT,update,UrunHareketDto.class);
        return response;

    }
}
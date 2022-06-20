package tr.com.cinigaz.controller;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import tr.com.cinigaz.dto.UrunDto;
import tr.com.cinigaz.dto.UrunTipDto;
import tr.com.cinigaz.except.UrunException;

import java.util.Arrays;
import java.util.List;


@CrossOrigin("*")
@RestController


public class UrunKontrolService {
    private static final String url1 = "http://localhost:9113/urun/getir";
    private static final String url2 = "http://localhost:9113/urun/sil";
    private static final String url3 = "http://localhost:9113/urun/tumliste";
    private static final String url4 = "http://localhost:9113/urun/ekle";
    private static final String url5 = "http://localhost:9113/urun/urunkodu";
    private static final String url6 = "http://localhost:9116/urun_tip/urun_tip_sayi"; // ürüntip id ye ait aynı üst ürün id var mı varsa alt tipi bulunuyor demektir.Bu ürün tipini seçemezsin.
    private static final String url7 = "http://localhost:9113/urun/guncelle";
    private static final String url8 = "http://localhost:9113/urun/urunadicek";


    RestTemplate restTemplate;


    public UrunKontrolService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }


    public UrunException kontrolUrunAdi(String urunAdi) {
        RestTemplate rest = new RestTemplate();
        UrunException ex1 = new UrunException();


        UrunDto dto = rest.getForObject(url8 + "/" + String.valueOf(urunAdi), UrunDto.class);

        if (dto.getUrunId() != null) {

            if (dto.getUrunAdi().equals(urunAdi)) {
                ex1.setExceptKodu(-20000);
                ex1.setExceptAciklama("Aynı ürün adında ekleme yapılmaz.");
                ex1.printStackTree();

            } else {
                ex1.setExceptKodu(0);
                ex1.setExceptAciklama("aynı ürün adına ait ürün bulunmamaktadır.Ürünü ekleyebilirsiniz");
                ex1.printStackTree();
            }
        } else {
            ex1.setExceptKodu(0);
            ex1.setExceptAciklama("aynı ürün adına ait ürün bulunmamaktadır.Ürünü ekleyebilirsiniz");
            ex1.printStackTree();
        }
        return ex1;
    }


    public UrunException kontrolUrunKodu(String urunKodu) {
        RestTemplate rest = new RestTemplate();
        UrunException ex2 = new UrunException();


        UrunDto dto = rest.getForObject(url5 + "/" + String.valueOf(urunKodu), UrunDto.class);
//        Boolean kontrol = dto != null && dto.getUrunKodu().equals(urunKodu);

        if (dto.getUrunId() != null) {
            if (dto.getUrunKodu().equals(urunKodu)) {
                ex2.setExceptKodu(-30000);
                ex2.setExceptAciklama("Aynı ürün kodunda Ekleme yapılamaz.");
                ex2.printStackTree();

            } else {
                ex2.setExceptKodu(1);
                ex2.setExceptAciklama("Aynı ürün koduna ait ürün bulunmamaktadır. Ürünü ekleyebilirsiniz");
                ex2.printStackTree();
            }
        } else {
            ex2.setExceptKodu(1);
            ex2.setExceptAciklama("Aynı ürün koduna ait ürün bulunmamaktadır. Ürünü ekleyebilirsiniz");
            ex2.printStackTree();
        }
        return ex2;
    }


    public UrunException kontrolUrunTip(Integer urunTipId) {
        RestTemplate rest = new RestTemplate();
        UrunException ex3 = new UrunException();


        UrunTipDto[] dto = rest.getForObject(url6 + "/" + String.valueOf(urunTipId), UrunTipDto[].class);

        if (dto != null) {

            if (dto.length > 0) {
                ex3.setExceptKodu(-40000);
                ex3.setExceptAciklama("Bu ürüne ait alt tip mevcuttur.Bu tip seçilemez");
                ex3.printStackTree();

            } else {
                ex3.setExceptKodu(2);
                ex3.setExceptAciklama("Bu ürün tip id ile ürünü kaydedebilirsiniz.");
                ex3.printStackTree();
            }
        } else {
            ex3.setExceptKodu(2);
            ex3.setExceptAciklama("Bu ürün tip id ile ürünü kaydedebilirsiniz.");
            ex3.printStackTree();
        }
        return ex3;
    }

    @PostMapping("urunekle")
    public ResponseEntity<UrunDto> saveUrun(@RequestBody UrunDto dto) {

        RestTemplate rest = new RestTemplate();
        UrunException ex1 = kontrolUrunAdi(dto.getUrunAdi());
        UrunException ex2 = kontrolUrunKodu(dto.getUrunKodu());
        UrunException ex3 = kontrolUrunTip(dto.getUrunTipId());


        if (ex1.getExceptKodu() == 0 && ex2.getExceptKodu() == 1 && ex3.getExceptKodu() == 2) {

            // kayıt işlemlerini yaz.
            UrunDto res = rest.postForObject(url4, dto, UrunDto.class);

        } else
        {
            return ResponseEntity.ok(new UrunDto());
        }
        return ResponseEntity.ok(dto);
    }


    @GetMapping(value = "uruntumliste")
    public List<Object> getUrun() {

        Object[] uruns = restTemplate.getForObject(url3, Object[].class);
        return Arrays.asList(uruns);
    }


    @DeleteMapping("/urunsil/{urunId}")
    public ResponseEntity<Boolean> sil(@PathVariable("urunId") Integer urunId) {
        restTemplate.delete(url2 + "/" + String.valueOf(urunId));
        return ResponseEntity.ok(Boolean.TRUE);
    }


    @GetMapping("/urunidgetir/{urunId}")
    public ResponseEntity<UrunDto> getirId(@PathVariable("urunId") Integer urunId) {
        ResponseEntity<UrunDto> response = restTemplate.getForEntity(url1 + "/" + String.valueOf(urunId), UrunDto.class);
        return response;
    }


    @PutMapping("/urunguncelle/{urunId}")
    public ResponseEntity<UrunDto> guncelle(@PathVariable("urunId") Integer urunId, @RequestBody UrunDto urunDto) {

        HttpEntity<UrunDto> update = new HttpEntity<>(urunDto);
        ResponseEntity<UrunDto> response = restTemplate.exchange(url7 + "/" + String.valueOf(urunId), HttpMethod.PUT, update, UrunDto.class);
        return response;

    }
}

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


public class UrunTipKontrolService {


    private static final String url1 = "http://localhost:9113/urun/uruncek";//mesela, tipi 5 /*ama üst ürün tipine bak (:uruntipid = 2)*/ seçilmiş bir ürün var mı varsa bu tip altına alt tip eklenemez
    private static final String url2 = "http://localhost:9116/urun_tip/ekle";
    private static final String url3 = "http://localhost:9113/urun/uruntipid";
    private static final String url4 = "http://localhost:9116/urun_tip/tumliste";
    private static final String url5 = "http://localhost:9116/urun_tip/guncelle";
    private static final String url6 = "http://localhost:9116/urun_tip/sil";
    private static final String url7 = "http://localhost:9116/urun_tip/urun_tip_id_cek";
    private static final String url8 = "http://localhost:9116/urun_tip/urun_tip_sayi";


    RestTemplate restTemplate;


    public UrunTipKontrolService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }



    public UrunException kontrolUrunTip(Integer urunTipId) {
        RestTemplate rest = new RestTemplate();
        UrunException ex1 = new UrunException();


        UrunDto[] dto = rest.getForObject(url1 + "/" + String.valueOf(urunTipId), UrunDto[].class); //dto null dan farklıysa bu tip kaydedilemez.

        if (dto.length > 0) {

            if (dto.length > 0) {
                ex1.setExceptKodu(4);
                ex1.setExceptAciklama("Bu tipe ait ürün bulunmaktadır");
                ex1.printStackTree();

            } else {
                ex1.setExceptKodu(1);
                ex1.setExceptAciklama("Bu tip kaydedilemez1.");
                ex1.printStackTree();
            }
        } else {
            ex1.setExceptKodu(0);
            ex1.setExceptAciklama("Bu tip kaydedilebilir");
            ex1.printStackTree();
        }
        return ex1;
    }

//ürünler bu kategoriye alınsın mı update urun set urun_tip_id=5 where urun_tip_id=2 (5 id li ürün tip kaydını yaparken üst ürün olarak 2 numaralı ürün_tip_id yi seçtiğimde)

    public UrunException urununKategoriAlimi(Integer urunTipId, Integer ustUrunId) {
        RestTemplate rest = new RestTemplate();
        UrunException ex2 = new UrunException();


        // UrunDto dto = rest.getForObject(url3 + "/" + String.valueOf(urunTipId)+ "/" + String.valueOf(ustTipId), UrunDto.class); //dto null dan farklıysa bu tip kaydedilemez.

        Boolean dto = rest.getForObject(url3 + "/" + String.valueOf(urunTipId) + "/" + String.valueOf(ustUrunId), Boolean.class); //dto null dan farklıysa bu tip kaydedilemez.

        //  String cevap = "ürünler bu kategoriye alınsın mı ?";
        // System.out.println(cevap);
        //if (cevap=="EVET" || cevap=="evet") {

        if (dto.equals(true)) {
            if (dto.equals(true)) {
                ex2.setExceptKodu(2);
                ex2.setExceptAciklama("Ürünleri Kategoriye Aldınız");
                ex2.printStackTree();


            } else {
                ex2.setExceptKodu(3);
                ex2.setExceptAciklama("Ürünler Kategoriye Alınmadı");
                ex2.printStackTree();
            }
        } else {
            ex2.setExceptKodu(3);
            ex2.setExceptAciklama("Ürünler Kategoriye Alınamaz.");
            ex2.printStackTree();
        }

//        if (dto.getUrunId() == null) {
//            if (dto.getUrunAdi() == null) {
//                ex1.setExceptKodu(-20000);
//                ex1.setExceptAciklama("Bu tipi kaydedebilirsin.");
//                ex1.printStackTree();
//
//            }
//            else {
//                ex1.setExceptKodu(0);
//                ex1.setExceptAciklama("Bu tip kaydedilemez1.");
//                ex1.printStackTree();
//            }
//        }
//        else {
//            ex1.setExceptKodu(0);
//            ex1.setExceptAciklama("Bu tip kaydedilemez2.");
//            ex1.printStackTree();
//        }
        return ex2;
    }

    @PostMapping("uruntipekle")

    ResponseEntity<UrunTipDto> saveDepo(@RequestBody UrunTipDto  dto) {
        RestTemplate rest = new RestTemplate();
        UrunException ex1 = kontrolUrunTip(dto.getUrunTipId());
        UrunException ex2 = urununKategoriAlimi(dto.getUrunTipId(), dto.getUstUrunId());

        if (ex1.getExceptKodu() == 4) {
            if (ex2.getExceptKodu() == 2) {
                // kayıt işlemlerini yaz.
                UrunTipDto res = rest.postForObject(url2, dto, UrunTipDto.class);

            }
            else {
                return ResponseEntity.ok(new UrunTipDto());
            }

        }
        else {
            return ResponseEntity.ok(new UrunTipDto());
        }
        return ResponseEntity.ok(dto);
    }


    @GetMapping(value = "uruntiptumliste")
    public List<Object> getUrunTipTumListe()
    {

        Object[] urunTips=restTemplate.getForObject(url4,Object[].class);
        return Arrays.asList(urunTips);
    }


    @DeleteMapping("/uruntipsil/{urunTipId}")
    public ResponseEntity<Boolean> sil(@PathVariable("urunTipId")  Integer urunTipId){
        restTemplate.delete(url6+"/"+String.valueOf(urunTipId));
        return ResponseEntity.ok(Boolean.TRUE);
    }


    @GetMapping("/uruntipidgetir/{urunTipId}")
    public ResponseEntity<UrunTipDto> getirId(@PathVariable("urunTipId") Integer urunTipId){
        ResponseEntity<UrunTipDto> response = restTemplate.getForEntity(url7+"/"+String.valueOf(urunTipId),UrunTipDto.class);
        return response;
    }


    @PutMapping("/uruntipguncelle/{urunTipId}")
    public ResponseEntity<UrunTipDto> guncelle(@PathVariable("urunTipId") Integer urunTipId,  @RequestBody UrunTipDto uruntipdto){

        HttpEntity<UrunTipDto> update= new HttpEntity<>(uruntipdto);
        ResponseEntity<UrunTipDto> response=restTemplate.exchange(url5+"/"+String.valueOf(urunTipId), HttpMethod.PUT,update,UrunTipDto.class);
        return response;

    }



}




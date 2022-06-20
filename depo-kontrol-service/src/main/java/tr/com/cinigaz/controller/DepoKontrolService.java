package tr.com.cinigaz.controller;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import tr.com.cinigaz.dto.*;
import tr.com.cinigaz.except.DepoException;
import tr.com.cinigaz.util.Util;

import java.util.Arrays;
import java.util.List;


@CrossOrigin("*")
@RestController


public class DepoKontrolService {

    private static final String url1 = "http://localhost:9115/depo/depoadicek";
    private static final String url2 = "http://localhost:9115/depo/ekle";
    private static final String url3 = "http://localhost:9115/depo/tumliste";
    private static final String url4 = "http://localhost:9115/depo/sil";
    private static final String url5 = "http://localhost:9115/depo/getir";
    private static final String url6 = "http://localhost:9115/depo/guncelle";
    private static final String url7 = "http://localhost:9114/urun_hareket/depohareket";
    private static final String url8 = "http://localhost:9115/depo/getirid";


    RestTemplate restTemplate;


    public DepoKontrolService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }


    public DepoException depoUrunAdi(String depoAdi) {
        RestTemplate rest = new RestTemplate();
        DepoException ex1 = new DepoException();


        DepoDto dto = rest.getForObject(url1 + "/" + String.valueOf(depoAdi), DepoDto.class);

        if (dto.getDepoAdi() != null) {

            if (dto.getDepoAdi().equals(depoAdi)) {
                ex1.setExceptKodu(-20000);
                ex1.setExceptAciklama("Aynı depo adında ekleme yapılmaz.");
                ex1.printStackTree();

            } else {
                ex1.setExceptKodu(0);
                ex1.setExceptAciklama("aynı depo adına ait ürün bulunmamaktadır. Depoyu ekleyebilirsiniz");
                ex1.printStackTree();
            }
        }
        else {
            ex1.setExceptKodu(0);
            ex1.setExceptAciklama("aynı depo adına ait ürün bulunmamaktadır. Depoyu ekleyebilirsiniz");
            ex1.printStackTree();
        }
        return ex1;
    }



    /*@PostMapping("depoekle")
    public DepoDto saveDepo(DepoDto dto) {

        RestTemplate rest = new RestTemplate();
        DepoException ex1 = depoUrunAdi(dto.getDepoAdi());



        if (ex1.getExceptKodu() == 0 ) {

            // kayıt işlemlerini yaz.
            DepoDto res = rest.postForObject(url2, dto, DepoDto.class);

        }
        else
        {
            return new DepoDto();
        }
        return dto;
    }*/


    @PostMapping("depoekle")

   /* public ResponseEntity<DepoDto> saveDepo(@RequestBody DepoDto dto) {

        RestTemplate rest = new RestTemplate();
        DepoException ex1 = depoUrunAdi(dto.getDepoAdi());



        if (ex1.getExceptKodu() == 0 ) {

            // kayıt işlemlerini yaz.
            DepoDto res = rest.postForObject(url2, dto, DepoDto.class);

        }
        else
        {
            return ResponseEntity.ok(new DepoDto());
        }
        return ResponseEntity.ok(dto);
    }*/


    public DepoResponseDto saveDepo(@RequestBody DepoDto dto) {
        DepoResponseDto responseDto = new DepoResponseDto();
        RestTemplate rest = new RestTemplate();
        DepoException ex1 = depoUrunAdi(dto.getDepoAdi());


        if (ex1.getExceptKodu() == 0) {

            // kayıt işlemlerini yaz.
            DepoDto res = rest.postForObject(url2, dto, DepoDto.class);
            responseDto.setMesajKodu(0);
            responseDto.setDto(res);

        }
        else
        {
            responseDto.setMesajKodu(404);
            responseDto.setMesaj(Util.setValuesIfNullForString(ex1.getExceptAciklama(), "</br>"));
            responseDto.setDto(null); //new FirmaDto());
        }
        return responseDto;
    }


    public DepoException depoHareket(Integer depoId) {
        RestTemplate rest = new RestTemplate();
        DepoException ex2 = new DepoException();


        long dto = rest.getForObject(url7 + "/" + String.valueOf(depoId),long.class);

        if (dto >0) {

            if (dto>0) {
                ex2.setExceptKodu(-30000);
                ex2.setExceptAciklama("Depoda hareket var silinemez ");
                ex2.printStackTree();

            } else {
                ex2.setExceptKodu(1);
                ex2.setExceptAciklama("Depoda hareket yok silinebilir");
                ex2.printStackTree();
            }
        }

        else {
            ex2.setExceptKodu(1);
            ex2.setExceptAciklama("Depoda hareket yok silinebilir");
            ex2.printStackTree();
        }
        return ex2;


       /* if (dto.getDepoAdi() != null) {

            if (dto.getDepoAdi().equals(depoAdi)) {
                ex1.setExceptKodu(-20000);
                ex1.setExceptAciklama("Aynı depo adında ekleme yapılmaz.");
                ex1.printStackTree();

            } else {
                ex1.setExceptKodu(0);
                ex1.setExceptAciklama("aynı depo adına ait ürün bulunmamaktadır. Depoyu ekleyebilirsiniz");
                ex1.printStackTree();
            }
        } else {
            ex1.setExceptKodu(0);
            ex1.setExceptAciklama("aynı depo adına ait ürün bulunmamaktadır. Depoyu ekleyebilirsiniz");
            ex1.printStackTree();
        }
        return ex1;*/
    }

    @GetMapping(value = "depotumliste")
    public DepoListResponseDto getDepo() {
        DepoListResponseDto responseDto = new DepoListResponseDto();
        DepoDto[] res = restTemplate.getForObject(url3, DepoDto[].class);
        List<Object> yeni = Arrays.asList(res);

        if (Arrays.stream(res).count() == 0) {
            responseDto.setMesajKodu(404);
            responseDto.setMesaj(Util.setValuesIfNullForString("listelenecek veri yok", "</br>"));
            responseDto.setDto(null);
        }
        else {
            responseDto.setMesajKodu(0);
            responseDto.setDto(res);
            responseDto.setMesaj("veriler listelendi");
        }
        return responseDto;

    }


  /* @GetMapping(value = "depotumliste")
    public List<Object> getDepo(){

        Object[] depos=restTemplate.getForObject(url3,Object[].class);
        return Arrays.asList(depos);
    }*/


    @DeleteMapping("/deposil/{depoId}")
    public DepoResponseDto sil(@PathVariable("depoId") Integer depoId) {
        DepoResponseDto responseDto = new DepoResponseDto();


        // :TODO : Bu depoda ürün varmı kontrolü gerekiyor.

        RestTemplate rest = new RestTemplate();
        //ResponseEntity<DepoDto> response = restTemplate.getForEntity(url7 + "/" + String.valueOf(depoId), DepoDto.class);
        DepoException ex2 = depoHareket(depoId);

        if (ex2.getExceptKodu() == 1) {
         //   ResponseEntity<DepoDto> response = restTemplate.getForEntity(url5 + "/" + String.valueOf(depoId), DepoDto.class);
           // if(response!=null){
            restTemplate.delete(url4 + "/" + String.valueOf(depoId));
            responseDto.setMesajKodu(0);
            responseDto.setMesaj("silindi");

        }
   // }
        else {
            responseDto.setMesajKodu(404);
            responseDto.setMesaj(Util.setValuesIfNullForString("hareket var silinemez", "</br>"));


        }
        return responseDto;

    }


    /*@DeleteMapping("/deposil/{depoId}")
    public ResponseEntity<Boolean> sil(@PathVariable("depoId")  Integer depoId){
        restTemplate.delete(url4+"/"+String.valueOf(depoId));
        return ResponseEntity.ok(Boolean.TRUE);
    }*/


   /* @GetMapping("/depoidgetir/{depoId}")
    public ResponseEntity<DepoDto> getirId(@PathVariable("depoId") Integer depoId) {
        ResponseEntity<DepoDto> response = restTemplate.getForEntity(url5 + "/" + String.valueOf(depoId), DepoDto.class);
        return response;
    }*/


    @GetMapping("/depoidgetir/{depoId}")
    public ResponseEntity<DepoResponseDto> getirId(@PathVariable("depoId") Integer depoId) {

        DepoResponseDto depoResponseDto=new DepoResponseDto();
        ResponseEntity<DepoResponseDto> response = restTemplate.getForEntity(url8 + "/" + String.valueOf(depoId), DepoResponseDto.class);

        if(response!=null) {
            depoResponseDto.setMesaj("veri çekildi");
            depoResponseDto.setMesajKodu(0);


        }
        else{
            depoResponseDto.setMesajKodu(404);
            depoResponseDto.setMesaj(Util.setValuesIfNullForString("veri yok", "</br>"));
            depoResponseDto.setDto(null); //new FirmaDto());
        }

            return response;
        }

           /* responseDto.setMesajKodu(404);
            responseDto.setMesaj(Util.setValuesIfNullForString(ex1.getExceptAciklama(), "</br>"));
            responseDto.setDto(null); //new FirmaDto());*/


  /*  @PutMapping("/depoguncelle/{depoId}")
    public GetIdDepoResponse guncelle(@PathVariable("depoId") Integer depoId, @RequestBody DepoDto depoDto) {

        GetIdDepoResponse depoResponseDto=new GetIdDepoResponse();

        HttpEntity<DepoDto> update = new HttpEntity<>(depoDto);
        ResponseEntity<DepoDto> response = restTemplate.exchange(url6 + "/" + String.valueOf(depoId), HttpMethod.PUT, update, DepoDto.class);

        if(response!=null) {
            depoResponseDto.setMesaj("güncellendi");
            depoResponseDto.setMesajKodu(0);
            depoResponseDto.setDto(response);

        }
        else{
            depoResponseDto.setMesajKodu(404);
            depoResponseDto.setMesaj(Util.setValuesIfNullForString("veri yok", "</br>"));
            depoResponseDto.setDto(null); //new FirmaDto());
        }

        return depoResponseDto;

    }*/




    @PostMapping("/depoguncelle/{depoId}")
    public  DepoResponseDto guncelle(@PathVariable("depoId") Integer depoId, @RequestBody DepoDto depoDto) {

        DepoResponseDto depoResponseDto=new DepoResponseDto();

        DepoResponseDto response = restTemplate.postForObject(url6 + "/" + String.valueOf(depoId), depoDto, DepoResponseDto.class);



        if(response.getMesajKodu()==0) {
            depoResponseDto.setMesaj("güncellendi");
            depoResponseDto.setMesajKodu(0);
            depoResponseDto.setDto(response.getDto());
        }


        else{
            depoResponseDto.setMesajKodu(404);
            depoResponseDto.setMesaj(Util.setValuesIfNullForString("veri yok", "</br>"));
            depoResponseDto.setDto(null); //new FirmaDto());
        }

        return depoResponseDto;

    }


}

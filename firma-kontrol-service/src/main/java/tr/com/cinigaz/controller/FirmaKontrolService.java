package tr.com.cinigaz.controller;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import tr.com.cinigaz.dto.FirmaDto;
import tr.com.cinigaz.dto.FirmaListResponseDto;
import tr.com.cinigaz.dto.FirmaResponseDto;
import tr.com.cinigaz.except.FirmaKontrolException;
import tr.com.cinigaz.util.Util;

import java.util.Arrays;
import java.util.List;


@CrossOrigin("*")
@RestController


public class FirmaKontrolService {

    private static final String url1 = "http://localhost:9117/firma/firmaadi";
    private static final String url2 = "http://localhost:9117/firma/ekle";
    private static final String url3 = "http://localhost:9117/firma/firmatel1";
    private static final String url4 = "http://localhost:9117/firma/firmatel2";
    private static final String url5 = "http://localhost:9117/firma/firmafax";
    private static final String url6 = "http://localhost:9117/firma/firmavkn";
    private static final String url7 = "http://localhost:9117/firma/tumliste";
    private static final String url8 = "http://localhost:9117/firma/sil";
    private static final String url9 = "http://localhost:9117/firma/firmaidcek";
    private static final String url10 = "http://localhost:9117/firma/guncelle";
    private static final String url11 = "http://localhost:9117/firma/firmaidsinicek";

    RestTemplate restTemplate;


    public FirmaKontrolService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }




    public FirmaKontrolException firmaUrunAdi(String firmaAdi) {

        RestTemplate rest = new RestTemplate();
        FirmaKontrolException ex1 = new FirmaKontrolException();

        /*int sayac = 1;

        for(int i = 0; i < firmaAdi.length(); i++)
        {
            if(firmaAdi.charAt(i) == ' ') {
                sayac++;
            }
        }*/

        FirmaDto dto = rest.getForObject(url1 + "/" + String.valueOf(firmaAdi), FirmaDto.class);

       /* if(sayac==1)
        {

            if(dto.getFirmaId()!= null)
            {
                ex1.setExceptKodu(-20000);
                ex1.setExceptAciklama(" aynı firma eklenemez.");
                ex1.printStackTree();
            }
            else
            {
                ex1.setExceptKodu(0);
                ex1.setExceptAciklama(" firma eklenebilir.");
                ex1.printStackTree();
            }
        }*/


        if (dto.getFirmaId() != null) { //kayıt varsa

            ex1.setExceptKodu(-20000);
            ex1.setExceptAciklama(" aynı firma eklenemez.");
            ex1.printStackTree();
            return ex1;
        }

        if (dto.getFirmaId() == null) { //kayıt yoksa
            /*if (dto.getFirmaAdi().equals(firmaAdi)) {
                ex1.setExceptKodu(-20000);
                ex1.setExceptAciklama(" aynı firma eklenemez.");
                ex1.printStackTree();
                return ex1;
            }*/

            String ara = "";
            if (firmaAdi.split(" ").length == 1)
                ara = firmaAdi.split(" ")[0] ;
            if (firmaAdi.split(" ").length > 1)
                ara = firmaAdi.split(" ")[0] + " " + firmaAdi.split(" ")[1];
            else ara = firmaAdi;
            FirmaDto dto1 = rest.getForObject(url1 + "/" + String.valueOf(ara), FirmaDto.class);
            if (dto1.getFirmaId() != null) {
                ex1.setExceptKodu(-21000);
                ex1.setExceptAciklama("İlk iki kelimesi aynı olan firma eklenemez.");
            }
            /*if (dto.getFirmaId() == null) {
                String[] gelenfirmaadi = firmaAdi.split(" ");
                String gelenfirmailkkelime = gelenfirmaadi[0].toString();
                String gelenfirmaikincikelime = gelenfirmaadi[1].toString();
                String yenikelime = gelenfirmailkkelime + " " + gelenfirmaikincikelime + " ";
                FirmaDto dto1 = rest.getForObject(url1 + "/" + String.valueOf(yenikelime), FirmaDto.class);

                String[] varolanfirmaadi = dto1.getFirmaAdi().split(" ");

                String varolanfirmailkkelime = varolanfirmaadi[0];
                String varolanfirmaikincikelime = varolanfirmaadi[1];

                if (gelenfirmailkkelime.equals(varolanfirmailkkelime) && gelenfirmaikincikelime.equals(varolanfirmaikincikelime)) {
                    ex1.setExceptKodu(14);
                    ex1.setExceptAciklama("firma adının ilk iki kelimesi aynı olamaz ");
                    ex1.printStackTree();
                } else {
                    ex1.setExceptKodu(0);
                    ex1.setExceptAciklama("aynı firma adına ait firma bulunmamaktadır2. Firmayı ekleyebilirsiniz");
                    ex1.printStackTree();
                }
            }*/
        }
        return ex1;
    }


    public FirmaKontrolException firmaTel1(String firmaTel1) {
        RestTemplate rest = new RestTemplate();
        FirmaKontrolException ex2 = new FirmaKontrolException();

        if (firmaTel1.length() == 11) {

            ex2.setExceptKodu(7);
            ex2.setExceptAciklama("tel1 11 hanelidir.");
            ex2.printStackTree();

            FirmaDto dto = rest.getForObject(url3 + "/" + String.valueOf(firmaTel1), FirmaDto.class);

            if (dto.getFirmaId() != null) {

                if (dto.getFirmaTel1().equals(firmaTel1)) {
                    ex2.setExceptKodu(-30000);
                    ex2.setExceptAciklama("firma Tel 1 kaydı bulunmaktadır, eklenemez.");
                    ex2.printStackTree();

                } else {
                    ex2.setExceptKodu(1);
                    ex2.setExceptAciklama("Firma Tel1 e ait kayıt bulunmamaktadır. Firmayı ekleyebilirsiniz");
                    ex2.printStackTree();
                }
            } else {
                ex2.setExceptKodu(1);
                ex2.setExceptAciklama("Firma Tel1 e ait kayıt bulunmamaktadır. Firmayı ekleyebilirsiniz");
                ex2.printStackTree();
            }

        } else {
            ex2.setExceptKodu(8);
            ex2.setExceptAciklama("firma tel1 11 haneli olmalıdır");
            ex2.printStackTree();
        }
        return ex2;
    }

    public FirmaKontrolException firmaTel2(String firmaTel2) {

        RestTemplate rest = new RestTemplate();
        FirmaKontrolException ex3 = new FirmaKontrolException();

        if (firmaTel2.length() == 11) {

            ex3.setExceptKodu(9);
            ex3.setExceptAciklama("tel2 11 hanelidir.");
            ex3.printStackTree();

            FirmaDto dto = rest.getForObject(url4 + "/" + String.valueOf(firmaTel2), FirmaDto.class);

            if (dto.getFirmaId() != null) {

                if (dto.getFirmaTel2().equals(firmaTel2)) {
                    ex3.setExceptKodu(-40000);
                    ex3.setExceptAciklama("firma tel 2 kaydı bulunmaktadır, eklenemez.");
                    ex3.printStackTree();

                } else {
                    ex3.setExceptKodu(2);
                    ex3.setExceptAciklama("Firma Tel2 ye ait kayıt bulunmamaktadır. Firmayı ekleyebilirsiniz");
                    ex3.printStackTree();
                }
            } else {
                ex3.setExceptKodu(2);
                ex3.setExceptAciklama("Firma Tel2 ye ait kayıt bulunmamaktadır. Firmayı ekleyebilirsiniz");
                ex3.printStackTree();
            }

        } else {
            ex3.setExceptKodu(10);
            ex3.setExceptAciklama("Firma Tel2 11 haneli olmalıdır");
            ex3.printStackTree();
        }
        return ex3;
    }

    public FirmaKontrolException firmaFax(String firmaFax) {

        RestTemplate rest = new RestTemplate();
        FirmaKontrolException ex4 = new FirmaKontrolException();

        if (firmaFax.length() == 10) {

            ex4.setExceptKodu(13);
            ex4.setExceptAciklama("fax 10 hanelidir.");
            ex4.printStackTree();

            FirmaDto dto = rest.getForObject(url5 + "/" + String.valueOf(firmaFax), FirmaDto.class);

            if (dto.getFirmaId() != null) {

                if (dto.getFirmaFax().equals(firmaFax)) {
                    ex4.setExceptKodu(-50000);
                    ex4.setExceptAciklama("Aynı fax numarası eklenemez.");
                    ex4.printStackTree();

                } else {
                    ex4.setExceptKodu(3);
                    ex4.setExceptAciklama("Eklediğiniz fax numarası bulunmamaktadır. Firmayı ekleyebilirsiniz");
                    ex4.printStackTree();
                }
            } else {
                ex4.setExceptKodu(3);
                ex4.setExceptAciklama("Eklediğiniz fax numarası bulunmamaktadır. Firmayı ekleyebilirsiniz");
                ex4.printStackTree();
            }

        } else {
            ex4.setExceptKodu(12);
            ex4.setExceptAciklama("Fax 10 haneli olmalıdır.");
            ex4.printStackTree();
        }
        return ex4;
    }

    public FirmaKontrolException firmaVkn(String firmaVergiKimlikNo) {

        RestTemplate rest = new RestTemplate();
        FirmaKontrolException ex5 = new FirmaKontrolException();

        if (firmaVergiKimlikNo.length() == 10) {

            ex5.setExceptKodu(5);
            ex5.setExceptAciklama("vkn 10 hanelidir.");
            ex5.printStackTree();

            FirmaDto dto = rest.getForObject(url6 + "/" + String.valueOf(firmaVergiKimlikNo), FirmaDto.class);


            if (dto.getFirmaId() != null) {

                if (dto.getFirmaVergiKimlikNo().equals(firmaVergiKimlikNo)) {
                    ex5.setExceptKodu(-60000);
                    ex5.setExceptAciklama("Aynı vkn eklenemez.");
                    ex5.printStackTree();

                } else {
                    ex5.setExceptKodu(4);
                    ex5.setExceptAciklama("Eklediğiniz vkn bulunmamaktadır. Firmayı ekleyebilirsiniz");
                    ex5.printStackTree();
                }
            } else {
                ex5.setExceptKodu(4);
                ex5.setExceptAciklama("Eklediğiniz vkn bulunmamaktadır. Firmayı ekleyebilirsiniz");
                ex5.printStackTree();
            }

        } else {
            ex5.setExceptKodu(6);
            ex5.setExceptAciklama("vkn 10 haneli olmalıdır.");
            ex5.printStackTree();
        }
        return ex5;
    }

    @PostMapping("firmaniekle")
    public FirmaResponseDto saveFirma(@RequestBody FirmaDto dto) {
        FirmaResponseDto responseDto = new FirmaResponseDto();
        RestTemplate rest = new RestTemplate();
        System.out.println(dto.getFirmaAdi());
        FirmaKontrolException ex1 = firmaUrunAdi(dto.getFirmaAdi());
        FirmaKontrolException ex2 = firmaTel1(dto.getFirmaTel1());
        FirmaKontrolException ex3 = firmaTel2(dto.getFirmaTel2());
        FirmaKontrolException ex4 = firmaFax(dto.getFirmaFax());
        FirmaKontrolException ex5 = firmaVkn(dto.getFirmaVergiKimlikNo());

        if (ex1.getExceptKodu() == 0 && ex2.getExceptKodu() == 1 && ex3.getExceptKodu() == 2 && ex4.getExceptKodu() == 3 && ex5.getExceptKodu() == 4) {

            FirmaDto res = rest.postForObject(url2, dto, FirmaDto.class);
            responseDto.setMesajKodu(0);
            responseDto.setDto(res);

        }
        else {
            responseDto.setMesajKodu(404);
            responseDto.setMesaj(Util.setValuesIfNullForString(ex1.getExceptAciklama(),"</br>")+ex2.getExceptAciklama()+"</br>"+ex3.getExceptAciklama()+"</br>"+ex4.getExceptAciklama()+"</br>"+ex5.getExceptAciklama()+"</br>");
            responseDto.setDto(null); //new FirmaDto());
        }
        return responseDto;
    }


    @GetMapping(value = "firmatumliste")
    public FirmaListResponseDto  getFirma(){
        FirmaListResponseDto firmaListResponseDto=new FirmaListResponseDto();
        FirmaDto[] firmaDtos = restTemplate.getForObject(url7,FirmaDto[].class);

        if(Arrays.stream(firmaDtos).count() == 0)

        {
            firmaListResponseDto.setDto(null);
            firmaListResponseDto.setMesaj("veri yok");
            firmaListResponseDto.setMesajKodu(404);
        }

        else
        {
            firmaListResponseDto.setDto(firmaDtos);
            firmaListResponseDto.setMesaj("veriler listelendi");
            firmaListResponseDto.setMesajKodu(0);
        }


        return firmaListResponseDto ;
    }


    @DeleteMapping("/firmasil/{firmaId}")
    public ResponseEntity<Boolean> sil(@PathVariable("firmaId")  Integer firmaId){
        restTemplate.delete(url8+"/"+String.valueOf(firmaId));
        return ResponseEntity.ok(Boolean.TRUE);
    }



    @GetMapping("/firmaidgetir/{firmaId}")
    public ResponseEntity<FirmaResponseDto> getirId(@PathVariable("firmaId") Integer firmaId){
       FirmaResponseDto firmaResponseDto=new FirmaResponseDto();
        ResponseEntity<FirmaResponseDto> response = restTemplate.getForEntity(url9+"/"+String.valueOf(firmaId),FirmaResponseDto.class);

        if(response!=null){

           firmaResponseDto.setMesaj(Util.setValuesIfNullForString("veri yok", "</br>"));
           firmaResponseDto.setMesajKodu(0);
       }

       else{
           firmaResponseDto.setMesaj("veri yok");
           firmaResponseDto.setDto(null);
           firmaResponseDto.setMesajKodu(404);
       }
        return response;
    }


    @PutMapping("/firmaguncelle/{firmaId}")
    public ResponseEntity<FirmaDto> guncelle(@PathVariable("firmaId") Integer firmaId,  @RequestBody FirmaDto firmaDto){

        HttpEntity<FirmaDto> update= new HttpEntity<>(firmaDto);
        ResponseEntity<FirmaDto> response=restTemplate.exchange(url10+"/"+String.valueOf(firmaId), HttpMethod.PUT,update,FirmaDto.class);
        return response;

    }



}

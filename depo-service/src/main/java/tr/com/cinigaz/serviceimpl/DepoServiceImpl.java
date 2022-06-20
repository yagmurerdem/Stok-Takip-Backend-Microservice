package tr.com.cinigaz.serviceimpl;


import com.fasterxml.jackson.databind.util.JSONPObject;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import tr.com.cinigaz.dto.DepoDto;
import tr.com.cinigaz.dto.DepoResponseDto;
import tr.com.cinigaz.entity.DepoEntity;
import tr.com.cinigaz.repo.DepoRepository;
import tr.com.cinigaz.service.DepoService;
import tr.com.cinigaz.dto.DepoDto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service

public class DepoServiceImpl implements DepoService {

    private DepoRepository repo;
    private ModelMapper map;

    public DepoServiceImpl(DepoRepository repo, ModelMapper map) {
        this.repo = repo;
        this.map = map;
    }


    @Override
    public DepoDto save(DepoDto dto) {
        DepoEntity gelen = map.map(dto, DepoEntity.class);
        gelen.setCreatedAt(new Date());
        gelen.setCreatedBy("yagmur");
        gelen = repo.save(gelen);
        DepoDto dtogelen = map.map(gelen, DepoDto.class);
        return dtogelen;
    }

    @Override
    public ResponseEntity<DepoResponseDto> update(Integer depoId, DepoDto dto) {

        Optional<DepoEntity> idcontrol = repo.findById(depoId);

        DepoResponseDto mainDto = new DepoResponseDto();

        if (!idcontrol.isPresent()) {
            mainDto.setDto(null);
            mainDto.setMesaj("veri yok");
            mainDto.setMesajKodu(404);
            return ResponseEntity.ok(mainDto);
        }
        else {
            DepoEntity depoEntity = map.map(dto, DepoEntity.class);
            idcontrol.get().setDepoAdi(depoEntity.getDepoAdi());
            idcontrol.get().setDepoAdresi(depoEntity.getDepoAdresi());
            idcontrol.get().setDepoAciklama(depoEntity.getDepoAciklama());
            idcontrol.get().setUpdatedBy("yagmur");
            idcontrol.get().setUpdatedAt(new Date());

            depoEntity = repo.save(idcontrol.get());
            DepoDto depoDtoCevap=new DepoDto();
            map.map(depoEntity, depoDtoCevap);
            mainDto.setDto(depoDtoCevap);
            mainDto.setMesajKodu(0);
            mainDto.setMesaj("veriler güncellendi");
            System.out.println(depoDtoCevap.toString());
            System.out.println(mainDto);
            System.out.println();
            return ResponseEntity.ok(mainDto);

        }

    }
//        DepoEntity gelen = map.map(dto, DepoEntity.class);
//        gelen.setUpdatedBy("yagmur");
//        gelen.setUpdatedAt(new Date());
//        gelen = repo.save(gelen);
//        dto = map.map(gelen, DepoDto.class);
//        return dto;


    @Override
    public Boolean delete(Integer depoId) {
//        DepoEntity gelen = map.map(dto, DepoEntity.class);
//        try {
//            repo.delete(gelen);
//            return true;
//        } catch (Exception e) {
//            e.printStackTrace();
//            return false;
//        }
        Optional<DepoEntity> depoEntity = repo.findById(depoId);
        if (depoEntity.isPresent()) {
            repo.deleteById(depoEntity.get().getDepoId());
            return true;
        } else
            return false;
    }

    @Override
    public DepoDto getById(Integer depoId) {

        Optional<DepoEntity> opt;
        opt = repo.findById(depoId);

        if (opt == null)
            return new DepoDto();
        DepoDto dto1 = new DepoDto();
        map.map(opt.get(), dto1);
        return dto1;
    }

//    @Override
//    public DepoDto getByName(DepoDto dto) {
//
//        DepoEntity DepoEntity=repo.getByUrunName(dto.getUrunName());
//        DepoDto DepoDto=map.map(DepoEntity,DepoDto.class);
//
//        return DepoDto;
//    }

    @Override
    public List<DepoDto> getAll() {
        List<DepoEntity> entAll = repo.findAll();
        List<DepoDto> dtoAll = new ArrayList<>();
        for (DepoEntity a : entAll) {
            dtoAll.add(map.map(a, DepoDto.class));
        }
        System.out.println(dtoAll);
        return dtoAll;
    }


    @Override
    public DepoDto getByDepoAdi(String depoAdi) {
        DepoEntity entity = repo.getEntityByDepoAdi(depoAdi);
        DepoDto dto = new DepoDto();
        if (entity != null) {
            dto = map.map(entity, DepoDto.class);
        }
        return dto;
    }


    @Override
    public DepoResponseDto getByDepoId(Integer depoId) {


        Optional<DepoEntity> opt = repo.findById(depoId);
        DepoResponseDto mainDto = new DepoResponseDto();

        if (!opt.isPresent()) {
            mainDto.setMesajKodu(404);
            mainDto.setMesaj("Kayıt Bulunamadı");
            mainDto.setDto(null);
            return mainDto;

        }
        else {
            DepoDto dto1 = new DepoDto();
            map.map(opt.get(), dto1);
            mainDto.setMesajKodu(0);
            mainDto.setDto(dto1);
            mainDto.setMesaj("veri listelendi");
            return mainDto;
        }
    }


}
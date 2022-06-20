package tr.com.cinigaz.serviceimpl;


import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import tr.com.cinigaz.dto.FirmaDto;
import tr.com.cinigaz.dto.FirmaResponseDto;
import tr.com.cinigaz.entity.FirmaEntity;
import tr.com.cinigaz.repo.FirmaRepository;
import tr.com.cinigaz.service.FirmaService;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;


@Service

public class FirmaServiceImpl implements FirmaService {

    private FirmaRepository repo;
    private ModelMapper map;

    public FirmaServiceImpl(FirmaRepository repo, ModelMapper map) {
        this.repo = repo;
        this.map = map;
    }


    @Override
    public FirmaDto save(FirmaDto dto) {
        FirmaEntity gelen = map.map(dto, FirmaEntity.class);
        gelen.setCreatedAt(new Date());
        gelen.setCreatedBy("yagmur");
        gelen = repo.save(gelen);
        FirmaDto dtogelen = map.map(gelen, FirmaDto.class);
        return dtogelen;
    }


    @Override
    public Boolean delete(Integer firmaId) {
    /*    FirmaEntity gelen = map.map(dto, FirmaEntity.class);
        try {
            repo.delete(gelen);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }*/


        Optional<FirmaEntity> firmaEntity = repo.findById(firmaId);
        if (firmaEntity.isPresent()) {
            repo.deleteById(firmaEntity.get().getFirmaId());
            return true;
        } else
            return false;
    }


    @Override
    public FirmaDto getById(Integer firmaId) {

        Optional<FirmaEntity> opt;
        opt = repo.findById(firmaId);

        FirmaDto dto1 = new FirmaDto();
        map.map(opt.get(), dto1);
        return dto1;
    }


    @Override
    public FirmaResponseDto getByFirmaId(Integer firmaId) {

        FirmaResponseDto firmaResponseDto = new FirmaResponseDto();
        Optional<FirmaEntity> opt;
        opt = repo.findById(firmaId);


        if (!opt.isPresent()) {
            firmaResponseDto.setMesajKodu(404);
            firmaResponseDto.setMesaj("veri yok1");
            firmaResponseDto.setDto(null);
            return firmaResponseDto;
        }

        else {
            FirmaDto firmaDtoCevap = new FirmaDto();
            map.map(opt.get(), firmaDtoCevap);
            firmaResponseDto.setDto(firmaDtoCevap);
            firmaResponseDto.setMesajKodu(0);
            firmaResponseDto.setMesaj("veri listelendi1");
            return firmaResponseDto;
        }

    }



//    @Override
//    public FirmaDto getByName(FirmaDto dto) {
//
//        FirmaEntity FirmaEntity=repo.getByUrunName(dto.getUrunName());
//        FirmaDto FirmaDto=map.map(FirmaEntity,FirmaDto.class);
//
//        return FirmaDto;
//    }

    @Override
    public List<FirmaDto> getAll() {
        List<FirmaEntity> entAll = repo.findAll();
        List<FirmaDto> dtoAll = new ArrayList<>();
        for (FirmaEntity a : entAll) {
            dtoAll.add(map.map(a, FirmaDto.class));
        }
        System.out.println(dtoAll);
        return dtoAll;
    }


    @Override
    public FirmaDto getByFirmaAdi(String firmaAdi) {
        FirmaEntity entity = repo.getEntityByFirmaAdi(firmaAdi+"%");
        FirmaDto dto = new FirmaDto();
        if (entity != null) {
            dto = map.map(entity, FirmaDto.class);
        }
        return dto;
}

    @Override
    public FirmaDto getByFirmaTel1(String firmaTel1) {
        FirmaEntity entity = repo.getEntityByFirmaTel1(firmaTel1);
        FirmaDto dto = new FirmaDto();
        if (entity != null) {
            dto = map.map(entity, FirmaDto.class);
        }
        return dto;
    }


    @Override
    public FirmaDto getByFirmaTel2(String firmaTel2) {
        FirmaEntity entity = repo.getEntityByFirmaTel2(firmaTel2);
        FirmaDto dto = new FirmaDto();
        if (entity != null) {
            dto = map.map(entity, FirmaDto.class);
        }
        return dto;
    }


    @Override
    public FirmaDto getByFirmaFax(String firmaFax) {
        FirmaEntity entity = repo.getEntityByFirmaFax(firmaFax);
        FirmaDto dto = new FirmaDto();
        if (entity != null) {
            dto = map.map(entity, FirmaDto.class);
        }
        return dto;
    }

    @Override
    public FirmaDto getByFirmafirmaVergiKimlikNo(String firmaVergiKimlikNo) {
        FirmaEntity entity = repo.getEntityByFirmaVergiKimlikNo(firmaVergiKimlikNo);
        FirmaDto dto = new FirmaDto();
        if (entity != null) {
            dto = map.map(entity, FirmaDto.class);
        }
        return dto;
    }

    /*@Override
    public FirmaDto update(FirmaDto dto) {
        FirmaEntity gelen = map.map(dto, FirmaEntity.class);
        gelen.setUpdatedBy("yagmur");
        gelen.setUpdatedAt(new Date());
        gelen = repo.save(gelen);
        dto = map.map(gelen, FirmaDto.class);
        return dto;
    }*/




    @Override
    public FirmaDto update(Integer firmaId,FirmaDto dto) {

        Optional<FirmaEntity> idcontrol = repo.findById(firmaId);

        if(idcontrol.isPresent())
        {
            FirmaEntity firmaEntity=map.map(dto,FirmaEntity.class);


            idcontrol.get().setFirmaAdi(firmaEntity.getFirmaAdi());
            idcontrol.get().setMarka(firmaEntity.getMarka());
            idcontrol.get().setFirmaAdresi(firmaEntity.getFirmaAdresi());

            idcontrol.get().setFirmaTel1(firmaEntity.getFirmaTel1());
            idcontrol.get().setFirmaTel2(firmaEntity.getFirmaTel2());
            idcontrol.get().setFirmaVergiKimlikNo(firmaEntity.getFirmaVergiKimlikNo());

            idcontrol.get().setFirmaFax(firmaEntity.getFirmaFax());
            idcontrol.get().setFirmaYetkiliAd(firmaEntity.getFirmaYetkiliAd());
            idcontrol.get().setFirmaAciklama(firmaEntity.getFirmaAciklama());

            idcontrol.get().setUpdatedBy("yagmur");
            idcontrol.get().setUpdatedAt(new Date());

            firmaEntity=repo.save(idcontrol.get());
            FirmaDto firmaDto =map.map(firmaEntity,FirmaDto.class);
            return firmaDto;
        }
        else
        {
            return null;
        }

//        DepoEntity gelen = map.map(dto, DepoEntity.class);
//        gelen.setUpdatedBy("yagmur");
//        gelen.setUpdatedAt(new Date());
//        gelen = repo.save(gelen);
//        dto = map.map(gelen, DepoDto.class);
//        return dto;
    }
}



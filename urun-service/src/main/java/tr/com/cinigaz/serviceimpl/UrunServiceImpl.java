package tr.com.cinigaz.serviceimpl;


import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;


import tr.com.cinigaz.dto.UrunDto;
import tr.com.cinigaz.entity.UrunEntity;
import tr.com.cinigaz.repo.UrunRepository;
import tr.com.cinigaz.service.UrunService;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service

public class UrunServiceImpl implements UrunService {

    private UrunRepository repo;
    private ModelMapper map;

    public UrunServiceImpl(UrunRepository repo, ModelMapper map) {
        this.repo = repo;
        this.map = map;
    }


    @Override
    public UrunDto save(UrunDto dto) {
        UrunEntity gelen = map.map(dto, UrunEntity.class);
        gelen.setCreatedAt(new Date());
        gelen.setCreatedBy("yagmur");
        gelen = repo.save(gelen);
        UrunDto dtogelen = map.map(gelen, UrunDto.class);
        return dtogelen;
    }


    @Override
    public UrunDto update(Integer urunId, UrunDto dto) {
        Optional<UrunEntity> idcontrol = repo.findById(urunId);

        if (idcontrol.isPresent()) {
            UrunEntity urunEntity = map.map(dto, UrunEntity.class);


            idcontrol.get().setUrunAdi(urunEntity.getUrunAdi());
            idcontrol.get().setUrunKodu(urunEntity.getUrunKodu());
            idcontrol.get().setUrunAciklama(urunEntity.getUrunAciklama());
            idcontrol.get().setUpdatedBy("yagmur");
            idcontrol.get().setUpdatedAt(new Date());

            urunEntity = repo.save(idcontrol.get());
            UrunDto urunDto = map.map(urunEntity, UrunDto.class);
            return urunDto;
        } else {
            return null;
        }
//        UrunEntity gelen = map.map(dto, UrunEntity.class);
//        gelen.setUpdatedBy("yagmur");
//        gelen.setUpdatedAt(new Date());
//        gelen = repo.save(gelen);
//        dto = map.map(gelen, UrunDto.class);
//        return dto;
    }

    @Override
    public Boolean delete(Integer urunId) {
//        UrunEntity gelen = map.map(dto, UrunEntity.class);
//        try {
//            repo.delete(gelen);
//            return true;
//        } catch (Exception e) {
//            e.printStackTrace();
//            return false;
//        }
        Optional<UrunEntity> urunEntity = repo.findById(urunId);
        if (urunEntity.isPresent()) {
            repo.deleteById(urunEntity.get().getUrunId());
            return true;
        } else
            return false;
    }

    @Override
    public UrunDto getById(Integer id) {

        Optional<UrunEntity> opt;
        opt = repo.findById(id);

        UrunDto dto1 = new UrunDto();
        map.map(opt.get(), dto1);
        return dto1;
    }

//    @Override
//    public UrunDto getByName(UrunDto dto) {
//
//        UrunEntity UrunEntity=repo.getByUrunName(dto.getUrunName());
//        UrunDto UrunDto=map.map(UrunEntity,UrunDto.class);
//
//        return UrunDto;
//    }

    @Override
    public List<UrunDto> getAll() {
        List<UrunEntity> entAll = repo.findAll();
        List<UrunDto> dtoAll = new ArrayList<>();
        for (UrunEntity a : entAll) {
            dtoAll.add(map.map(a, UrunDto.class));
        }
        System.out.println(dtoAll);
        return dtoAll;
    }

    @Override
    public UrunDto getUrunByAdi(String urunAdi) {
        UrunEntity entity = repo.getEntityByUrunAdi(urunAdi);
        UrunDto dto = new UrunDto();
        if (entity != null) {
            dto = map.map(entity, UrunDto.class);
        }
        return dto;
    }

    @Override
    public UrunDto getByUrunKodu(String urunKodu) {
        UrunEntity entity = repo.getEntityByUrunKodu(urunKodu);
        UrunDto dto = new UrunDto();
        if (entity != null) {
            dto = map.map(entity, UrunDto.class);
        }
        return dto;
    }



    @Override
    public List<UrunDto> getByUrunCek(Integer urunTipId) {

        List<UrunEntity> entity = repo.getEntityByUrunCek(urunTipId);
        List<UrunDto> dtoAll = new ArrayList<>();
        for (UrunEntity a : entity) {
            dtoAll.add(map.map(a, UrunDto.class));
        }
        System.out.println(dtoAll);
        return dtoAll;
    }



    @Override
    public Boolean getByUrunTipIdCek(Integer urunTipId, Integer ustUrunId) {
        try {
            repo.getByUrunTipIdCek(urunTipId, ustUrunId);
            return true;
        }
        catch(
   Exception e)
    {
        e.printStackTrace();
        return false;
    }


}

/*
    @Override
    public List<UrunDto> getByDepodanUrunCek(Integer depoId) {

        List<UrunEntity> entity = repo.getByDepodanUrunCek(depoId);
        List<UrunDto> dtoAll = new ArrayList<>();
        for (UrunEntity a : entity) {
            dtoAll.add(map.map(a, UrunDto.class));
        }
        System.out.println(dtoAll);
        return dtoAll;
    }*/
}
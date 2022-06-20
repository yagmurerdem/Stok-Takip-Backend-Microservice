package tr.com.cinigaz.serviceimpl;


import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import tr.com.cinigaz.dto.UrunHareketDetayDto;
import tr.com.cinigaz.entity.UrunHareketDetayEntity;
import tr.com.cinigaz.repo.UrunHareketDetayRepository;
import tr.com.cinigaz.service.UrunHareketDetayService;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service

public class UrunHareketDetayServiceImpl implements UrunHareketDetayService {

    private UrunHareketDetayRepository repo;
    private ModelMapper map;

    public UrunHareketDetayServiceImpl(UrunHareketDetayRepository repo, ModelMapper map) {
        this.repo = repo;
        this.map = map;
    }


    @Override
    public UrunHareketDetayDto save(UrunHareketDetayDto dto) {
        UrunHareketDetayEntity gelen = map.map(dto, UrunHareketDetayEntity.class);
        gelen.setCreatedAt(new Date());
        gelen.setCreatedBy("yagmur");
        gelen = repo.save(gelen);
        UrunHareketDetayDto dtogelen = map.map(gelen, UrunHareketDetayDto.class);
        return dtogelen;
    }

    @Override
    public UrunHareketDetayDto update(UrunHareketDetayDto dto) {
        UrunHareketDetayEntity gelen = map.map(dto, UrunHareketDetayEntity.class);
        gelen.setUpdatedBy("yagmur");
        gelen.setUpdatedAt(new Date());
        gelen = repo.save(gelen);
        dto = map.map(gelen, UrunHareketDetayDto.class);
        return dto;
    }

    @Override
    public Boolean delete(UrunHareketDetayDto dto) {
        UrunHareketDetayEntity gelen = map.map(dto, UrunHareketDetayEntity.class);
        try {
            repo.delete(gelen);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public UrunHareketDetayDto getById(Integer id) {

        Optional<UrunHareketDetayEntity> opt;
        opt = repo.findById(id);

        UrunHareketDetayDto dto1 = new UrunHareketDetayDto();
        map.map(opt.get(), dto1);
        return dto1;
    }

//    @Override
//    public UrunHareketDetayDto getByName(UrunHareketDetayDto dto) {
//
//        UrunHareketDetayEntity UrunHareketDetayEntity=repo.getByUrunName(dto.getUrunName());
//        UrunHareketDetayDto UrunHareketDetayDto=map.map(UrunHareketDetayEntity,UrunHareketDetayDto.class);
//
//        return UrunHareketDetayDto;
//    }

    @Override
    public List<UrunHareketDetayDto> getAll() {
        List<UrunHareketDetayEntity> entAll = repo.findAll();
        List<UrunHareketDetayDto> dtoAll = new ArrayList<>();
        for (UrunHareketDetayEntity a : entAll) {
            dtoAll.add(map.map(a, UrunHareketDetayDto.class));
        }
        System.out.println(dtoAll);
        return dtoAll;
    }

}
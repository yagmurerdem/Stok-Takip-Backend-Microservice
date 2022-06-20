package tr.com.cinigaz.serviceimpl;


import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import tr.com.cinigaz.dto.HareketTarihceDto;
import tr.com.cinigaz.entity.HareketTarihceEntity;
import tr.com.cinigaz.repo.HareketTarihceRepository;
import tr.com.cinigaz.service.HareketTarihceService;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service

public class HareketTarihceServiceImpl implements HareketTarihceService {

    private HareketTarihceRepository repo;
    private ModelMapper map;

    public HareketTarihceServiceImpl(HareketTarihceRepository repo, ModelMapper map) {
        this.repo = repo;
        this.map = map;
    }


    @Override
    public HareketTarihceDto save(HareketTarihceDto dto) {
        HareketTarihceEntity gelen = map.map(dto, HareketTarihceEntity.class);
        gelen.setCreatedAt(new Date());
        gelen.setCreatedBy("yagmur");
        gelen = repo.save(gelen);
        HareketTarihceDto dtogelen = map.map(gelen, HareketTarihceDto.class);
        return dtogelen;
    }

    @Override
    public HareketTarihceDto update(HareketTarihceDto dto) {
        HareketTarihceEntity gelen = map.map(dto, HareketTarihceEntity.class);
        gelen.setUpdatedBy("yagmur");
        gelen.setUpdatedAt(new Date());
        gelen = repo.save(gelen);
        dto = map.map(gelen, HareketTarihceDto.class);
        return dto;
    }

    @Override
    public Boolean delete(HareketTarihceDto dto) {
        HareketTarihceEntity gelen = map.map(dto, HareketTarihceEntity.class);
        try {
            repo.delete(gelen);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public HareketTarihceDto getById(Integer id) {

        Optional<HareketTarihceEntity> opt;
        opt = repo.findById(id);

        HareketTarihceDto dto1 = new HareketTarihceDto();
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
    public List<HareketTarihceDto> getAll() {
        List<HareketTarihceEntity> entAll = repo.findAll();
        List<HareketTarihceDto> dtoAll = new ArrayList<>();
        for (HareketTarihceEntity a : entAll) {
            dtoAll.add(map.map(a, HareketTarihceDto.class));
        }
        System.out.println(dtoAll);
        return dtoAll;
    }

}
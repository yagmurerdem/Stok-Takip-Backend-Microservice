package tr.com.cinigaz.serviceimpl;


import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import tr.com.cinigaz.dto.UrunTipDto;
import tr.com.cinigaz.entity.UrunTipEntity;
import tr.com.cinigaz.repo.UrunTipRepository;
import tr.com.cinigaz.service.UrunTipService;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service

public class UrunTipServiceImpl implements UrunTipService {

    private UrunTipRepository repo;
    private ModelMapper map;

    public UrunTipServiceImpl(UrunTipRepository repo, ModelMapper map) {
        this.repo = repo;
        this.map = map;
    }


    @Override
    public UrunTipDto save(UrunTipDto dto) {
        UrunTipEntity gelen = map.map(dto, UrunTipEntity.class);
        gelen.setCreatedAt(new Date());
        gelen.setCreatedBy("yagmur");
        gelen = repo.save(gelen);
        UrunTipDto dtogelen = map.map(gelen, UrunTipDto.class);
        return dtogelen;
    }

    @Override
    public UrunTipDto update(Integer urunTipId , UrunTipDto dto) {
        Optional<UrunTipEntity> idcontrol = repo.findById(urunTipId);

        if(idcontrol.isPresent())
        {
            UrunTipEntity uruntipEntity=map.map(dto,UrunTipEntity.class);


            idcontrol.get().setUrunTipAdi(uruntipEntity.getUrunTipAdi());
            idcontrol.get().setUrunTipAciklama(uruntipEntity.getUrunTipAciklama());
            idcontrol.get().setUpdatedBy("yagmur");
            idcontrol.get().setUpdatedAt(new Date());

            uruntipEntity=repo.save(idcontrol.get());
            UrunTipDto uruntip =map.map(uruntipEntity,UrunTipDto.class);
            return uruntip;
        }
        else
        {
            return null;
        }
    }

    @Override
    public Boolean delete(Integer urunTipId) {
        Optional<UrunTipEntity> urunTipEntity=repo.findById(urunTipId);
        if(urunTipEntity.isPresent())
        {
            repo.deleteById(urunTipEntity.get().getUrunTipId());
            return true;
        }
        else
            return false;
    }

    @Override
    public UrunTipDto getById(Integer id) {

        Optional<UrunTipEntity> opt;
        opt = repo.findById(id);

        UrunTipDto dto1 = new UrunTipDto();
        map.map(opt.get(), dto1);
        return dto1;
    }

//    @Override
//    public UrunTipDto getByName(UrunTipDto dto) {
//
//        UrunTipEntity UrunTipEntity=repo.getByUrunName(dto.getUrunName());
//        UrunTipDto UrunTipDto=map.map(UrunTipEntity,UrunTipDto.class);
//
//        return UrunTipDto;
//    }

    @Override
    public List<UrunTipDto> getAll() {
        List<UrunTipEntity> entAll = repo.findAll();
        List<UrunTipDto> dtoAll = new ArrayList<>();

        for (UrunTipEntity a : entAll) {
            dtoAll.add(map.map(a, UrunTipDto.class));
        }
        System.out.println(dtoAll);
        return dtoAll;
    }


    @Override
    public List<UrunTipDto> getByUrunTip(Integer urunTipId) {
        List<UrunTipEntity> entity = repo.getEntityByUstUrunId(urunTipId);
        List<UrunTipDto> dtoAll = new ArrayList<>();
        if (entity != null) {
            for (UrunTipEntity a : entity) {
                dtoAll.add(map.map(a, UrunTipDto.class));
            }
            System.out.println(dtoAll);
            return dtoAll;
        }
        return dtoAll;
    }

}
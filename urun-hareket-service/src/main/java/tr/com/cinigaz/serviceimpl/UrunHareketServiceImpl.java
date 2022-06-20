package tr.com.cinigaz.serviceimpl;


import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import tr.com.cinigaz.dto.UrunHareketDto;
import tr.com.cinigaz.entity.UrunHareketEntity;
import tr.com.cinigaz.repo.UrunHareketRepository;
import tr.com.cinigaz.service.UrunHareketService;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service

public class UrunHareketServiceImpl implements UrunHareketService {

    private UrunHareketRepository repo;
    private ModelMapper map;

    public UrunHareketServiceImpl(UrunHareketRepository repo, ModelMapper map) {
        this.repo = repo;
        this.map = map;
    }


  /*  @Override
    public UrunHareketDto save(UrunHareketDto dto) {
        UrunHareketEntity gelen = map.map(dto, UrunHareketEntity.class);
        gelen.setCreatedAt(new Date());
        gelen.setCreatedBy("yagmur");
        gelen = repo.save(gelen);
        UrunHareketDto dtogelen = map.map(gelen, UrunHareketDto.class);
        return dtogelen;
    }*/

    @Override
    public UrunHareketDto save(UrunHareketDto dto) {
        UrunHareketEntity gelen = map.map(dto, UrunHareketEntity.class);
        gelen.setCreatedAt(new Date());
        gelen.setCreatedBy("yagmur");
        gelen = repo.save(gelen);
        UrunHareketDto dtogelen = map.map(gelen, UrunHareketDto.class);
        return dtogelen;
    }



    @Override
    public UrunHareketDto update(Integer urunHareketId,UrunHareketDto dto) {


        Optional<UrunHareketEntity> idcontrol = repo.findById(urunHareketId);

        if (idcontrol.isPresent()) {
            UrunHareketEntity urunHareketEntity = map.map(dto, UrunHareketEntity.class);


            idcontrol.get().setUrunId(urunHareketEntity.getUrunId());
            idcontrol.get().setGirisDepoId(urunHareketEntity.getGirisDepoId());
            idcontrol.get().setCikisDepoId(urunHareketEntity.getCikisDepoId());
            idcontrol.get().setFirmaId(urunHareketEntity.getFirmaId());
            idcontrol.get().setBirim(urunHareketEntity.getBirim());
            idcontrol.get().setMiktar(urunHareketEntity.getMiktar());
            idcontrol.get().setHareketAmac(urunHareketEntity.getHareketAmac());
            idcontrol.get().setTarih(urunHareketEntity.getTarih());


            idcontrol.get().setUpdatedBy("yagmur");
            idcontrol.get().setUpdatedAt(new Date());

            urunHareketEntity = repo.save(idcontrol.get());
            UrunHareketDto urunHareketDto = map.map(urunHareketEntity, UrunHareketDto.class);
            return urunHareketDto;
        }
        else
        {
            return null;
        }
    }
    @Override
    public Boolean delete(Integer urunHareketId) {
        Optional<UrunHareketEntity> urunHareketEntity=repo.findById(urunHareketId);
        if(urunHareketEntity.isPresent())
        {
            repo.deleteById(urunHareketEntity.get().getUrunHareketId());
            return true;
        }
        else
            return false;
    }

    @Override
    public UrunHareketDto getById(Integer id) {

        Optional<UrunHareketEntity> opt;
        opt = repo.findById(id);

        UrunHareketDto dto1 = new UrunHareketDto();
        map.map(opt.get(), dto1);
        return dto1;
    }

//    @Override
//    public UrunHareketDto getByName(UrunHareketDto dto) {
//
//        UrunHareketEntity UrunHareketEntity=repo.getByUrunName(dto.getUrunName());
//        UrunHareketDto UrunHareketDto=map.map(UrunHareketEntity,UrunHareketDto.class);
//
//        return UrunHareketDto;
//    }

    @Override
    public List<UrunHareketDto> getAll() {
        List<UrunHareketEntity> entAll = repo.findAll();
        List<UrunHareketDto> dtoAll = new ArrayList<>();
        for (UrunHareketEntity a : entAll) {
            dtoAll.add(map.map(a, UrunHareketDto.class));
        }
        System.out.println(dtoAll);
        return dtoAll;
    }

    @Override
    public Float getByDepodaKalanUrunMiktar(Integer cikisDepoId, Integer urunId) {
       // try {
           float deger= repo.getUrunDepoMiktar(cikisDepoId, urunId);
            return deger;
        //}
       // catch
       // (
        //        Exception e)
        //{
         //   e.printStackTrace();
           // return deger;
        }

    @Override
    public long getDepoByHareket(Integer depo) {
        return repo.getDepoByRecordValue(depo);
    }
}
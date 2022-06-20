package tr.com.cinigaz.serviceimpl;


import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;


import tr.com.cinigaz.dto.SeriNoluUrunDto;
import tr.com.cinigaz.entity.SeriNoluUrunEntity;
import tr.com.cinigaz.repo.SeriNoluUrunRepository;
import tr.com.cinigaz.service.SeriNoluUrunService;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service

public class SeriNoluUrunServiceImpl implements SeriNoluUrunService {

    private SeriNoluUrunRepository repo;
    private ModelMapper map;

    public SeriNoluUrunServiceImpl(SeriNoluUrunRepository repo, ModelMapper map) {
        this.repo = repo;
        this.map = map;
    }


    @Override
    public SeriNoluUrunDto save(SeriNoluUrunDto dto) {
        SeriNoluUrunEntity gelen = map.map(dto, SeriNoluUrunEntity.class);
        gelen.setCreatedAt(new Date());
        gelen.setCreatedBy("yagmur");
        gelen = repo.save(gelen);
        SeriNoluUrunDto dtogelen = map.map(gelen, SeriNoluUrunDto.class);
        return dtogelen;
    }

    @Override
    public SeriNoluUrunDto update(Integer seriNoluUrunId, SeriNoluUrunDto dto) {
        Optional<SeriNoluUrunEntity> idcontrol = repo.findById(seriNoluUrunId);

        if (idcontrol.isPresent()) {
            SeriNoluUrunEntity seriNoluUrunEntity = map.map(dto, SeriNoluUrunEntity.class);


            idcontrol.get().setSeriNoluUrunAdi(seriNoluUrunEntity.getSeriNoluUrunAdi());
            idcontrol.get().setSeriNoluUrunSeriNo(seriNoluUrunEntity.getSeriNoluUrunSeriNo());
            idcontrol.get().setSeriNoluUrunSonKalibrasyonTarihi(new Date());
            idcontrol.get().setSeriNoluUrunUretimTarihi(new Date());
            idcontrol.get().setSeriNoluUrunMiktari(seriNoluUrunEntity.getSeriNoluUrunMiktari());
            idcontrol.get().setUpdatedBy("yagmur");
            idcontrol.get().setUpdatedAt(new Date());

            seriNoluUrunEntity = repo.save(idcontrol.get());
            SeriNoluUrunDto seriNoluUrunDto = map.map(seriNoluUrunEntity, SeriNoluUrunDto.class);
            return seriNoluUrunDto;
        } else {
            return null;
        }
    }
        @Override
        public Boolean delete (Integer seriNoluUrunId){
            Optional<SeriNoluUrunEntity> seriNoluUrunEntity=repo.findById(seriNoluUrunId);
            if(seriNoluUrunEntity.isPresent())
            {
                repo.deleteById(seriNoluUrunEntity.get().getSeriNoluUrunId());
                return true;
            }
            else
                return false;
        }

        @Override
        public SeriNoluUrunDto getById (Integer id){

            Optional<SeriNoluUrunEntity> opt;
            opt = repo.findById(id);

            SeriNoluUrunDto dto1 = new SeriNoluUrunDto();
            map.map(opt.get(), dto1);
            return dto1;
        }

//    @Override
//    public SeriNoluUrunDto getByName(SeriNoluUrunDto dto) {
//
//        SeriNoluUrunEntity SeriNoluUrunEntity=repo.getBySeriNoluUrunName(dto.getSeriNoluUrunName());
//        SeriNoluUrunDto SeriNoluUrunDto=map.map(SeriNoluUrunEntity,SeriNoluUrunDto.class);
//
//        return SeriNoluUrunDto;
//    }

        @Override
        public List<SeriNoluUrunDto> getAll () {
            List<SeriNoluUrunEntity> entAll = repo.findAll();
            List<SeriNoluUrunDto> dtoAll = new ArrayList<>();
            for (SeriNoluUrunEntity a : entAll) {
                dtoAll.add(map.map(a, SeriNoluUrunDto.class));
            }
            System.out.println(dtoAll);
            return dtoAll;
        }

        @Override
        public SeriNoluUrunDto getBySeriNoCek (String seriNoluUrunSeriNo){
            SeriNoluUrunEntity entity = repo.getEntityByUrunAdi(seriNoluUrunSeriNo);
            SeriNoluUrunDto dto = new SeriNoluUrunDto();
            if (entity != null) {
                dto = map.map(entity, SeriNoluUrunDto.class);
            }
            return dto;
        }
    }
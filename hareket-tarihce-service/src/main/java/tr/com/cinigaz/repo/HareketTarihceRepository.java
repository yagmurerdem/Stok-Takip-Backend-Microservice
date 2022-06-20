package tr.com.cinigaz.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tr.com.cinigaz.entity.HareketTarihceEntity;


@Repository

public interface HareketTarihceRepository extends JpaRepository <HareketTarihceEntity,Integer>{

}


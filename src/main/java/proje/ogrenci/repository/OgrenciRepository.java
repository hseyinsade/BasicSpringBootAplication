package proje.ogrenci.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import proje.ogrenci.entities.Ogrenci;

import java.util.List;

@Repository
public interface OgrenciRepository extends JpaRepository<Ogrenci, Long> {

    @Override
    List<Ogrenci> findAll();

    @Override
    <S extends Ogrenci> S saveAndFlush(S s);
}

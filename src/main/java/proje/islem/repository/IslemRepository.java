package proje.islem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import proje.islem.entities.Islem;

import java.util.List;

@Repository
public interface IslemRepository extends JpaRepository<Islem, Long> {
    @Override
    List<Islem> findAll();

    @Override
    <S extends Islem> S saveAndFlush(S s);
}

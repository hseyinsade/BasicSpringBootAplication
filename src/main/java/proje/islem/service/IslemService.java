package proje.islem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import proje.islem.entities.Islem;
import proje.islem.repository.IslemRepository;

import java.util.List;

@Service
public class IslemService {

    @Autowired
    private IslemRepository islemRepository;

    public List<Islem> findAll() {
        return islemRepository.findAll();
    }

    public void saveAndFlush(Islem islem) {
        islemRepository.saveAndFlush(islem);
    }


}

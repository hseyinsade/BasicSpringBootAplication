package proje.ogrenci.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import proje.ogrenci.entities.Ogrenci;
import proje.ogrenci.repository.OgrenciRepository;

import java.util.List;

@Service
public class OgrenciService {

    @Autowired
    public OgrenciRepository ogrenciRepository;

    public List<Ogrenci> findAll() {
        return ogrenciRepository.findAll();
    }

    public void saveAndFlush(Ogrenci ogrenci) {
        ogrenciRepository.saveAndFlush(ogrenci);
    }
}

package proje.ogrenci.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import proje.ogrenci.entities.Ogrenci;
import proje.ogrenci.repository.OgrenciRepository;
import proje.ogrenci.service.OgrenciService;

import java.util.List;

@RestController
@RequestMapping("/ogrenci")
public class OgrenciController {

    @Autowired
    private OgrenciService ogrenciService;

    @GetMapping()
    public List<Ogrenci> findAll() {
        return ogrenciService.findAll();
    }


    @PostMapping
    public void save(@RequestBody Ogrenci ogrenci) {
        ogrenci.setYeniMi(true);
        ogrenciService.saveAndFlush(ogrenci);
    }

}

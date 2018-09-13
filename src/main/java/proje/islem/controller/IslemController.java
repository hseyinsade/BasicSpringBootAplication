package proje.islem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import proje.islem.entities.Islem;
import proje.islem.repository.IslemRepository;
import proje.islem.service.IslemService;
import proje.ogrenci.entities.Ogrenci;

import java.util.List;

@RestController
@RequestMapping("/islem")
public class IslemController {

    @Autowired
    private IslemService islemService;

    @GetMapping()
    public List<Islem> findAll() {
        return islemService.findAll();
    }

    @PostMapping
    public void save(@RequestBody Islem islem) {
        islemService.saveAndFlush(islem);
    }
}

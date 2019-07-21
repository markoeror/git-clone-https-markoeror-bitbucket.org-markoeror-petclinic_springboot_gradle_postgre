package com.eror.controller;

import com.eror.dto.SpecijalnostDTO;
import com.eror.entity.Specijalnost;
import com.eror.service.SpecijalnostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/specijalnost")
public class SpecijalnostControler {

    private final SpecijalnostService specijalnostService;

    @Autowired
    public SpecijalnostControler(SpecijalnostService specijalnostService) {
        this.specijalnostService = specijalnostService;
    }

    @PostMapping("/kreiraj")
    public ResponseEntity<Specijalnost> kreirajSpecijalnost(@RequestBody Specijalnost specijalnost) {
        Specijalnost specijalnost1 = specijalnostService.kreirajSpecijalnost(specijalnost);
        return new ResponseEntity<>(specijalnost1, HttpStatus.OK);
    }

    @GetMapping("/listaSpecijalnosti")
    public ResponseEntity<List<SpecijalnostDTO>> listaSpecijalnosti() {
        List<SpecijalnostDTO> listaSpecijalnostiDTO = specijalnostService.listaSpecijalnost();
        return new ResponseEntity<>(listaSpecijalnostiDTO, HttpStatus.OK);
    }
}

package com.eror.controller;

import com.eror.dto.VeterinarFasada;
import com.eror.entity.Veterinar;
import com.eror.service.ValidatorService;
import com.eror.service.VeterinarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("api/veterinar")
public class VeterinarControler {
    private final VeterinarFasada veterinarFasada;
    private final ValidatorService validatorService;
    private final VeterinarService veterinarService;

    @Autowired
    public VeterinarControler(VeterinarFasada veterinarFasada, ValidatorService validatorService, VeterinarService veterinarService) {
        this.veterinarFasada = veterinarFasada;
        this.validatorService = validatorService;
        this.veterinarService = veterinarService;
    }

    @PostMapping("/kreiraj/{idSpecijalizacije}/{idLjubimca}")
    public ResponseEntity<?> kreirajVeterinara(@RequestBody Veterinar veterinar, @PathVariable Integer idSpecijalizacije, @PathVariable Integer idLjubimca, @Valid BindingResult bindingResult) {
        ResponseEntity<?> errorMap = validatorService.validacijaServisa(bindingResult);
        if (errorMap != null) return errorMap;
        String ime = veterinar.getIme();
        Veterinar veterinarDto = veterinarFasada.kreirajVeterinara(veterinar, idSpecijalizacije, idLjubimca);
        return new ResponseEntity<String>("Veterinar " + ime + " je kreiran", HttpStatus.OK);
    }
}

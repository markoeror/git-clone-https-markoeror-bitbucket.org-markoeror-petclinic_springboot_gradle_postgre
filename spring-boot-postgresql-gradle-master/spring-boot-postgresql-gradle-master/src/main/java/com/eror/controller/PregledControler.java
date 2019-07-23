package com.eror.controller;

import com.eror.dto.PregledDto;
import com.eror.entity.Pregled;
import com.eror.service.PregledService;
import com.eror.service.ValidatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/pregled")
public class PregledControler {

    private final PregledService pregledService;
    private final ValidatorService validatorService;

    @Autowired
    public PregledControler(PregledService pregledService, ValidatorService validatorService) {
        this.pregledService = pregledService;
        this.validatorService = validatorService;
    }

    @PostMapping("/kreiraj/{idTipPregleda}")
    public ResponseEntity<?> kreirajPregled(@Valid @RequestBody Pregled pregled, @PathVariable Integer idTipPregleda, BindingResult bindingResult) {
        ResponseEntity<?> errorMap = validatorService.validacijaServisa(bindingResult);
        if (errorMap != null) return errorMap;
        PregledDto pregledDto = pregledService.sacuvajPregled(pregled, idTipPregleda);
        return new ResponseEntity<PregledDto>(pregledDto, HttpStatus.ACCEPTED);
    }

    @GetMapping("/listaPregleda")
    public ResponseEntity<List<PregledDto>> listaPregleda() {
        List<PregledDto> listaPregledaDTO = pregledService.listaPregledaDTO();
        return new ResponseEntity<>(listaPregledaDTO, HttpStatus.OK);
    }
}

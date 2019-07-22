package com.eror.controller;

import com.eror.dto.TipPregledaDTO;
import com.eror.entity.Pregled;
import com.eror.mapper.TipPregledaMapper;
import com.eror.service.TipPregledaService;
import com.eror.service.ValidatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/tipPregleda")
public class TipPregledaControler {

    private final TipPregledaService tipPregledaService;
    private final TipPregledaMapper tipPregledaMapper;
    private final ValidatorService validatorService;
    @Autowired
    public TipPregledaControler(TipPregledaService tipPregledaService, TipPregledaMapper tipPregledaMapper,ValidatorService validatorService) {
        this.tipPregledaService = tipPregledaService;
        this.tipPregledaMapper = tipPregledaMapper;
        this.validatorService=validatorService;
    }

    @PostMapping("/kreiraj")
    public ResponseEntity<?>kreirajPregled(@Valid @RequestBody Pregled tipPregleda, BindingResult bindingResult){
        ResponseEntity<?> errorMap = validatorService.validacijaServisa(bindingResult);
        if (errorMap != null) return errorMap;
        TipPregledaDTO tipPregledaDTO= tipPregledaService.sacuvajTipPregleda(tipPregleda);

        return new ResponseEntity<>(tipPregledaDTO, HttpStatus.ACCEPTED);
    }
}

package com.eror.controller;

import com.eror.entity.LjubimacTip;
import com.eror.service.LjubimacTipService;
import com.eror.service.ValidatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/ljubimacTip")
public class LjubimacTipControler {

    private final LjubimacTipService ljubimacTipService;
    private final ValidatorService validatorService;

    @Autowired
    public LjubimacTipControler(ValidatorService validatorService, LjubimacTipService ljubimacTipService) {

        this.ljubimacTipService = ljubimacTipService;
        this.validatorService = validatorService;
    }

    @PostMapping("/kreirajLjubimacTip")
    public ResponseEntity<?> kreirajLjubimacTip(@Valid @RequestBody LjubimacTip ljubimacTip, BindingResult bindingResult) {
        ResponseEntity<?> errorMap = validatorService.validacijaServisa(bindingResult);
        if (errorMap != null) return errorMap;
        LjubimacTip ljubimacTip2 = ljubimacTipService.save(ljubimacTip);
        return new ResponseEntity<>(ljubimacTip2, HttpStatus.ACCEPTED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<LjubimacTip> vratiLjubimacTip(@PathVariable Integer id) {
        LjubimacTip ljubimacTip = ljubimacTipService.findLjubimacTipById(id);
        return new ResponseEntity<>(ljubimacTip, HttpStatus.OK);

    }
}

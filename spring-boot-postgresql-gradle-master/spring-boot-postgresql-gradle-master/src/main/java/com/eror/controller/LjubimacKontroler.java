package com.eror.controller;

import com.eror.dto.LjubimacDTO;
import com.eror.dto.LjubimacFasada;
import com.eror.dto.VlasnikDTO;
import com.eror.entity.LjubimacTip;
import com.eror.mapper.LjubimacMapper;
import com.eror.mapper.VlasnikMapper;
import com.eror.service.LjubimacService;
import com.eror.service.LjubimacTipService;
import com.eror.service.ValidatorService;
import com.eror.service.VlasnikService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping("/api/ljubimci")
public class LjubimacKontroler {
    private final LjubimacMapper ljubimacMapper;
    private final ValidatorService validatorService;
    private final LjubimacService ljubimacService;
    private final VlasnikMapper vlasnikMapper;
    private final VlasnikService vlasnikService;
    private final LjubimacTipService ljubimacTipService;
    private final LjubimacFasada ljubimacFasada;

    @Autowired
    public LjubimacKontroler(ValidatorService validatorService, LjubimacService ljubimacService, LjubimacMapper ljubimacMapper, LjubimacFasada ljubimacFasada, VlasnikMapper vlasnikMapper, VlasnikService vlasnikService, LjubimacTipService ljubimacTipService) {
        super();
        this.validatorService = validatorService;
        this.ljubimacFasada = ljubimacFasada;
        this.ljubimacService = ljubimacService;
        this.ljubimacMapper = ljubimacMapper;
        this.vlasnikMapper = vlasnikMapper;
        this.vlasnikService = vlasnikService;
        this.ljubimacTipService = ljubimacTipService;
    }

    @GetMapping("/listaLjubimaca")
    public ResponseEntity<List<LjubimacDTO>> findAll() {
        List<LjubimacDTO> listDto = ljubimacMapper.toLjubimacDtos(ljubimacService.listaLjubimaca());
        return new ResponseEntity<List<LjubimacDTO>>(listDto, HttpStatus.OK);
    }

    @GetMapping("/vlasnik/{id}/listaLjubimaca")
    public ResponseEntity<VlasnikDTO> listaLjubimacaZaVlasnika(@PathVariable Integer id) {
        VlasnikDTO vlasnikDto = vlasnikService.findVlasnikByDtoId(id);
        return new ResponseEntity<VlasnikDTO>(vlasnikDto, HttpStatus.OK);

    }

    @GetMapping("/listaTipLjubimaca")
    public ResponseEntity<List<LjubimacTip>> findAllTip() {
        return new ResponseEntity<List<LjubimacTip>>(ljubimacTipService.listaTipovaLjubimaca(), HttpStatus.OK);
    }

    @PostMapping("kreirajLjubimca/{idVlasnika}/{idLjubimacTip}")
    public ResponseEntity<?> insertLjubimac(@PathVariable Integer idVlasnika, @PathVariable Integer idLjubimacTip, @Valid @RequestBody LjubimacDTO ljubimacDto, BindingResult bindingResult) {
        ResponseEntity<?> errorMap = validatorService.validacijaServisa(bindingResult);
        if (errorMap != null) return errorMap;
        ljubimacDto = ljubimacFasada.save(idVlasnika, idLjubimacTip, ljubimacDto);
        return new ResponseEntity<LjubimacDTO>(ljubimacDto, HttpStatus.OK);
    }

    @DeleteMapping("/deleteLjubimac")
    public ResponseEntity<String> obrisiLjubimce(@RequestBody List<LjubimacDTO> lista) {
        ljubimacService.deleteAll(lista);
        return new ResponseEntity<String>("Obrisani ljubimci", HttpStatus.OK);
    }

    @PutMapping("/updateLjubimca/{idVlasnika}/{idLjubimacTip}")
    public ResponseEntity<LjubimacDTO> updateLjubimca(@PathVariable Integer idVlasnika, @PathVariable Integer idLjubimacTip, @RequestBody LjubimacDTO ljubimacDto) {
        ljubimacDto = ljubimacService.updateLjubimca(ljubimacDto, idVlasnika, idLjubimacTip);
        return new ResponseEntity<LjubimacDTO>(ljubimacDto, HttpStatus.ACCEPTED);
    }


}

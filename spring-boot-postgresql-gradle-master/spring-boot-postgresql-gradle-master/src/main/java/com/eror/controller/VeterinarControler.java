package com.eror.controller;

import com.eror.dto.VeterinarDTO;
import com.eror.dto.VeterinarFasada;
import com.eror.entity.Veterinar;
import com.eror.mapper.VeterinarMapper;
import com.eror.service.ValidatorService;
import com.eror.service.VeterinarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("api/veterinar")
public class VeterinarControler {
    private final VeterinarFasada veterinarFasada;
    private final ValidatorService validatorService;
    private final VeterinarService veterinarService;
    private final VeterinarMapper veterinarMapper;

    @Autowired
    public VeterinarControler(VeterinarFasada veterinarFasada, ValidatorService validatorService, VeterinarService veterinarService,VeterinarMapper veterinarMapper) {
        this.veterinarFasada = veterinarFasada;
        this.validatorService = validatorService;
        this.veterinarService = veterinarService;
        this.veterinarMapper=veterinarMapper;
    }

    @PostMapping("/kreiraj/{idSpecijalizacije}")
    public ResponseEntity<?> kreirajVeterinara(@RequestBody Veterinar veterinar, @PathVariable Integer idSpecijalizacije, @Valid BindingResult bindingResult) {
        ResponseEntity<?> errorMap = validatorService.validacijaServisa(bindingResult);
        if (errorMap != null) return errorMap;
        String ime = veterinar.getIme();
        Veterinar veterinar1 = veterinarFasada.kreirajVeterinara(veterinar, idSpecijalizacije);
        VeterinarDTO veterinarDTO= veterinarMapper.toVeterinarDTO(veterinar1);
        return new ResponseEntity<VeterinarDTO>(veterinarDTO, HttpStatus.OK);
    }

    @GetMapping("/{idVeterinara}")
    public ResponseEntity<VeterinarDTO>listaVeterinara(@PathVariable Integer idVeterinara){
        VeterinarDTO veterinarDTO=veterinarService.vratiVeterinaraById(idVeterinara);
        return  new ResponseEntity<>(veterinarDTO,HttpStatus.OK);
    }
    @GetMapping("/listaVeterinara")
    public ResponseEntity<?>listaVeterinara(){
        List<VeterinarDTO> listaVeterinaraDTO=veterinarService.vratiListuVeterinaraDTO();
    return new ResponseEntity< List<VeterinarDTO>>(listaVeterinaraDTO,HttpStatus.OK);
    }

    @PostMapping("/dodajLjubimca/{idVeterinara}/{idLjubimca}")
    public ResponseEntity<String>dodavanjeLjubimcaVeterinaru(@PathVariable Integer idVeterinara,@PathVariable Integer idLjubimca){
          VeterinarDTO veterinarDTO=  veterinarService.dodajLjubimcaVeterinaru(idVeterinara,idLjubimca);
        return new ResponseEntity<>("Ljubimac sa Id-em "+idLjubimca+" je dodat veterinaru "+veterinarDTO.getIme(),HttpStatus.OK);
    }
}

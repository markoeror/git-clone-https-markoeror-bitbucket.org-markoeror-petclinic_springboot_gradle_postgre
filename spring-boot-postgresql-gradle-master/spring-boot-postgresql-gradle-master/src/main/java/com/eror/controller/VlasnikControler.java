package com.eror.controller;

import com.eror.dto.VlasnikDTO;
import com.eror.entity.Vlasnik;
import com.eror.mapper.VlasnikMapper;
import com.eror.service.ValidatorService;
import com.eror.service.VlasnikService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Set;


@RestController
@RequestMapping("api/vlasnik")
public class VlasnikControler {
    private final ValidatorService validatorService;
    private final VlasnikService vlasnikService;
    private final VlasnikMapper vlasnikMapper;

    @Autowired
    public VlasnikControler(VlasnikService vlasnikService, ValidatorService validatorService,VlasnikMapper vlasnikMapper) {
        super();
        this.vlasnikService = vlasnikService;
        this.validatorService = validatorService;
        this.vlasnikMapper=vlasnikMapper;
    }

    /* VALIDACIJA */
    @PostMapping("/kreiraj")
    public ResponseEntity<?> kreirajVlasnika(@Valid @RequestBody Vlasnik vlasnik, BindingResult bindingResult) {
        //	OVIME PREKO @Valid i BindingResulta proveravamo dal je uradjena validacija i ako ima gresaka da se napravi Mapu gresaka
        ResponseEntity<?> errorMap = validatorService.validacijaServisa(bindingResult);
        if (errorMap != null) return errorMap;
        Vlasnik vlasnik2 = vlasnikService.Save(vlasnik);
        return new ResponseEntity<Vlasnik>(vlasnik2, HttpStatus.CREATED);
    }


    @GetMapping("/listaVlasnika")
    public ResponseEntity<Set<Vlasnik>> prikaziVlasnike() {
        Set<Vlasnik> setVlasnika = vlasnikService.setVlasnika();
        return new ResponseEntity<Set<Vlasnik>>(setVlasnika, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<VlasnikDTO> vratiVlasnika(@PathVariable Integer id) {
        Vlasnik vlasnik = vlasnikService.findVlasnikById(id);
        VlasnikDTO vlasnikDTO=vlasnikMapper.toVlasnikDto(vlasnik);
        return new ResponseEntity<VlasnikDTO>(vlasnikDTO, HttpStatus.OK);
    }

    @GetMapping("/prezime/{prezime}")
    public ResponseEntity<List<Vlasnik>> vratiVlasnikaPoPrezimenu(@PathVariable String prezime) {
        List<Vlasnik> listaVlasnika = vlasnikService.findListaVlasnikaByPrezime(prezime);
        return new ResponseEntity<List<Vlasnik>>(listaVlasnika, HttpStatus.OK);
    }


    @PutMapping("/{id}")
    public ResponseEntity<Vlasnik> updateVlasnik(@PathVariable Integer id, @RequestBody Vlasnik vlasnik) {
        Vlasnik vlasnik1 = vlasnikService.update(id, vlasnik);
        return new ResponseEntity<Vlasnik>(vlasnik1, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteVlasnik(@PathVariable Integer id) {
        vlasnikService.delete(id);
        return new ResponseEntity<String>("Vlasnik sa " + id + " je obrisan", HttpStatus.OK);

    }



    /*
     * private List<Vlasnik> listaVlasnika;
     *
     * @PostConstruct // ovime stavljamo da se nakon ucitavanja konstruktora ova
     * metoda pokrene public void ucitajVLasnike() { listaVlasnika = new
     * ArrayList<Vlasnik>(); Vlasnik vlasnik = new Vlasnik(); vlasnik.setId(1);
     * vlasnik.setIme("Marko"); vlasnik.setPrezime("Eror");
     * vlasnik.setAdresa("Sarajevsska 55"); vlasnik.setGrad("Beograd");
     * vlasnik.setTelefon("06588855"); listaVlasnika.add(vlasnik); Vlasnik vlasnik1
     * = new Vlasnik(); vlasnik1.setId(2); vlasnik1.setIme("Boza");
     * vlasnik1.setPrezime("Bozic"); vlasnik1.setAdresa("Durmitorska 55");
     * vlasnik1.setGrad("Beograd"); vlasnik1.setTelefon("065255988");
     * listaVlasnika.add(vlasnik1);
     *
     * }
     *
     * @GetMapping("/listaVlasnika") public List<Vlasnik> prikaziVlasnike() { return
     * listaVlasnika; }
     *
     * @GetMapping("/{id}") public Vlasnik vratiVlasnika(@PathVariable Integer id) {
     * if ((id > listaVlasnika.size()) || id < 0) { throw new
     * VlasnikNotFoundException("Id za vlasnika ne postoji " + id); } Vlasnik
     * vlasnik = listaVlasnika.get(id); return vlasnik; }
     */
}

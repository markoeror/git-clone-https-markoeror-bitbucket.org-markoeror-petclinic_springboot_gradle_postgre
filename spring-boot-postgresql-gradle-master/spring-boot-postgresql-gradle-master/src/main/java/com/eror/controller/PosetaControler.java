package com.eror.controller;

import com.eror.dto.PosetaDto;
import com.eror.dto.VlasnikDTO;
import com.eror.service.PosetaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/posete/")
public class PosetaControler {

	private final PosetaService posetaService;
	
	
	@Autowired
	public PosetaControler(PosetaService posetaService) {
		super();
		this.posetaService = posetaService;
	}

	@GetMapping("{idVlasnika}")
	public ResponseEntity<VlasnikDTO> vrati(@PathVariable Integer idVlasnika){
		return new ResponseEntity<VlasnikDTO>(posetaService.vrati(idVlasnika),HttpStatus.OK);
	}
	@DeleteMapping("{idPosete}")
	public ResponseEntity<String>obrisiPosetu(@PathVariable Integer idPosete){
		posetaService.deletePoseta(idPosete);
		return new ResponseEntity<String>("Obrisana poseta", HttpStatus.OK);		
	}
	@PutMapping("update/{idLjubimca}")
	public ResponseEntity<PosetaDto>updatePosete(@PathVariable Integer idLjubimca, @RequestBody PosetaDto posetaDto ){
		PosetaDto posetaDto1= posetaService.update(posetaDto,idLjubimca);
		return new ResponseEntity<PosetaDto>(posetaDto1,HttpStatus.OK);
		
	}
}

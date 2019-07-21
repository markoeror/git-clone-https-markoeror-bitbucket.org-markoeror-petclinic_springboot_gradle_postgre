package com.eror.dto;


import java.util.List;

public class VlasnikDTO {

	private int id;
	private String imeVlasnika;
	private List<LjubimacDTO>listaLjubDto;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getImeVlasnika() {
		return imeVlasnika;
	}
	public void setImeVlasnika(String imeVlasnika) {
		this.imeVlasnika = imeVlasnika;
	}
	public List<LjubimacDTO> getListaLjubDto() {
		return listaLjubDto;
	}
	public void setListaLjubDto(List<LjubimacDTO> listaLjubDto) {
		this.listaLjubDto = listaLjubDto;
	}
	
}

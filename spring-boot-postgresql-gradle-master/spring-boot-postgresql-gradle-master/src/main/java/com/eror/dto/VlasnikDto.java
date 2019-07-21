package com.eror.dto;


import java.util.List;

public class VlasnikDto {

	private int id;
	private String imeVlasnika;
	private List<LjubimacDto>listaLjubDto;
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
	public List<LjubimacDto> getListaLjubDto() {
		return listaLjubDto;
	}
	public void setListaLjubDto(List<LjubimacDto> listaLjubDto) {
		this.listaLjubDto = listaLjubDto;
	}
	
}

package com.eror.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
@Entity
public class Ljubimac extends ImeEntity{
		@JoinColumn(name="id_vlasnik")
		@ManyToOne(fetch = FetchType.LAZY)
		private Vlasnik vlasnik;
		@ManyToOne(fetch = FetchType.LAZY)
		@JoinColumn(name="id_tip")
		private LjubimacTip ljubimacTip;
		public LjubimacTip getLjubimacTip() {
			return ljubimacTip;
		}

		public void setLjubimacTip(LjubimacTip ljubimacTip) {
			this.ljubimacTip = ljubimacTip;
		}

		public Vlasnik getVlasnik() {
			return vlasnik;
		}

		public void setVlasnik(Vlasnik vlasnik) {
			this.vlasnik = vlasnik;
		}
		
	
}

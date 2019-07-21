package com.eror.entity;

import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;


@Entity
public class Vlasnik extends BazniEntitet {
    @NotBlank(message = "ime more imati vrednost")
    private String ime;
    @NotBlank(message = "prezime more imati vrednost")
    private String prezime;
    @NotBlank(message = "grad more imati vrednost")
    private String grad;
    private String adresa;
    @Size(min = 10, max = 15, message = "unesite ispravan broj telefona")
    private String telefon;
    @OneToMany(mappedBy = "vlasnik", cascade = CascadeType.ALL, orphanRemoval = true)

    private List<Ljubimac> listLjubimac = new ArrayList<>();

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public String getGrad() {
        return grad;
    }

    public void setGrad(String grad) {
        this.grad = grad;
    }

    public String getAdresa() {
        return adresa;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }


    public void addLjubimca(Ljubimac ljubimac) {
        listLjubimac.add(ljubimac);
        ljubimac.setVlasnik(this);
    }

    public void removeLjubimca(Ljubimac ljubimac) {
        listLjubimac.remove(ljubimac);
        ljubimac.setVlasnik(null);
    }

    public List<Ljubimac> getListLjubimac() {
        return listLjubimac;
    }

    public void setListLjubimac(List<Ljubimac> listLjubimac) {
        this.listLjubimac = listLjubimac;
    }
}

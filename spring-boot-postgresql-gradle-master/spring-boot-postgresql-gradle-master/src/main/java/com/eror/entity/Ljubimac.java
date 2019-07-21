package com.eror.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class Ljubimac extends ImeEntity {
    @JoinColumn(name = "id_vlasnik")
    @ManyToOne(fetch = FetchType.LAZY)
    private Vlasnik vlasnik;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_tip")
    private LjubimacTip ljubimacTip;

    @OneToMany(mappedBy = "ljubimac", orphanRemoval = true, cascade = CascadeType.ALL)
    private List<Poseta> listaPoseta = new ArrayList<>();

    @ManyToMany(mappedBy = "setLjubimaca")
    private Set<Veterinar> setVeterinara = new HashSet<Veterinar>();

    public Set<Veterinar> getSetVeterinara() {
        return setVeterinara;
    }

    public void setSetVeterinara(Set<Veterinar> setVeterinara) {
        this.setVeterinara = setVeterinara;
    }

    public List<Poseta> getListaPoseta() {
        return listaPoseta;
    }

    public void setListaPoseta(List<Poseta> listaPoseta) {
        this.listaPoseta = listaPoseta;
    }

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


    //Metode za sinhronizaciju ljubimaca i poseta
    public void addPosetu(Poseta poseta) {
        listaPoseta.add(poseta);
        poseta.setLjubimac(this);
    }

    public void removePoseta(Poseta poseta) {
        listaPoseta.remove(poseta);
        poseta.setLjubimac(null);
    }
}

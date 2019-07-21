package com.eror.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Veterinar extends  ImeEntity{
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_specijalnosti")
    private Specijalnost specijalnost;

    @ManyToMany(fetch = FetchType.LAZY,cascade = {CascadeType.PERSIST,CascadeType.MERGE,CascadeType.REFRESH})
    @JoinTable(name="veterinar_ljubimac", joinColumns = @JoinColumn(name="id_veterinar"),inverseJoinColumns = @JoinColumn(name="id_ljubimca"))
    private Set<Ljubimac> listaLjubimaca= new HashSet<>();

    public Specijalnost getSpecijalnost() {
        return specijalnost;
    }
    public void setSpecijalnost(Specijalnost specijalnost) {
        this.specijalnost = specijalnost;
    }
    public Set<Ljubimac> getListaLjubimaca() {
        return listaLjubimaca;
    }
    public void setListaLjubimaca(Set<Ljubimac> listaLjubimaca) {
        this.listaLjubimaca = listaLjubimaca;
    }

    @Override
    public int hashCode() {

        return 31;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Veterinar other = (Veterinar) obj;
        if (getId() == null) {
            if (getId() != null)
                return false;
        } else if (!getId().equals(getId()))
            return false;
        return true;
    }
}

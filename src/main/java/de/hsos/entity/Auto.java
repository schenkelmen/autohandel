package de.hsos.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;

@Entity
public class Auto extends PanacheEntity {
    private String marke;

    @OneToOne(cascade = CascadeType.ALL)
    private Hersteller hersteller;

    public Auto(String marke, Hersteller hersteller) {
        this.marke = marke;
        this.hersteller = hersteller;
    }

    public Auto() {

    }

    public String getMarke() {
        return marke;
    }

    public void setMarke(String marke) {
        this.marke = marke;
    }

    public Hersteller getHersteller() {
        return hersteller;
    }

    public void setHersteller(Hersteller hersteller) {
        this.hersteller = hersteller;
    }
}

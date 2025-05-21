package de.hsos.boundary.dto;

import de.hsos.entity.Hersteller;
import jakarta.json.bind.annotation.JsonbCreator;

import java.util.Objects;

public class NewAutoDTO {
    private String marke;
    private Hersteller hersteller;

    @JsonbCreator
    public NewAutoDTO(String marke, Hersteller hersteller){
        this.marke = Objects.requireNonNull(marke, "Marke darf nicht leer sein.");
        this.hersteller = hersteller;
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
}

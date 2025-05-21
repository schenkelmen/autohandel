package de.hsos.boundary.dto;

import de.hsos.entity.Hersteller;
import jakarta.json.bind.annotation.JsonbCreator;
import jakarta.json.bind.annotation.JsonbProperty;

public class HerstellerDTO {
    private String name;
    private String ort;

    @JsonbCreator
    public HerstellerDTO(@JsonbProperty("name") String name, @JsonbProperty("ort") String ort) {
        this.name = name;
        this.ort = ort;
    }

    public static HerstellerDTO from(Hersteller hersteller) {
        return new HerstellerDTO(hersteller.getName(), hersteller.getOrt());
    }

    public String getName() {
        return name;
    }

    public String getOrt() {
        return ort;
    }
}

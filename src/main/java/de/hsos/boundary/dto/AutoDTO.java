package de.hsos.boundary.dto;

import de.hsos.entity.Auto;
import de.hsos.entity.Hersteller;
import jakarta.json.bind.annotation.JsonbCreator;

public class AutoDTO {
    private Long id;
    private String marke;
    private HerstellerDTO hersteller;

    @JsonbCreator
    public AutoDTO(Long id, String marke, HerstellerDTO hersteller) {
        this.id = id;
        this.marke = marke;
        this.hersteller = hersteller;
    }

    public static AutoDTO toDTO(Auto auto) {
        Hersteller hersteller = auto.getHersteller();
        HerstellerDTO herstellerDTO = hersteller != null ? HerstellerDTO.from(hersteller) : null;
        return new AutoDTO(auto.id, auto.getMarke(), herstellerDTO);
    }

    public Long getId() {
        return id;
    }

    public String getMarke() {
        return marke;
    }

    public HerstellerDTO getHersteller() {
        return hersteller;
    }
}

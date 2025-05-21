package de.hsos.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.json.bind.annotation.JsonbCreator;
import jakarta.persistence.Entity;

@Entity
public class Hersteller extends PanacheEntity {
    private String name;
    private String ort;

    @JsonbCreator
    public Hersteller(@JsonProperty("name") String name, @JsonProperty("ort") String ort) {
        this.name = name;
        this.ort = ort;
    }

    public Hersteller() {}


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOrt() {
        return ort;
    }

    public void setOrt(String ort) {
        this.ort = ort;
    }
}

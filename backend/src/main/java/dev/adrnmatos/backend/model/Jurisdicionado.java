package dev.adrnmatos.backend.model;

import javax.persistence.Embeddable;

@Embeddable
public class Jurisdicionado {

    private String name;

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }


}

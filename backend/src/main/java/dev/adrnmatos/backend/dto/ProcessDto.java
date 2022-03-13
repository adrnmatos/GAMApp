package dev.adrnmatos.backend.dto;

import dev.adrnmatos.backend.model.Jurisdicionado;
import dev.adrnmatos.backend.model.Process.Status;
import dev.adrnmatos.backend.model.Process.Type;

public class ProcessDto {

    private String processNumber;
    private Type type;
    private String parentNumber;
    private Jurisdicionado jurisdicionado;
    private Status status;
    

    public String getProcessNumber() {
        return this.processNumber;
    }

    public void setProcessNumber(String processNumber) {
        this.processNumber = processNumber;
    }

    public Type getType() {
        return this.type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public String getParentNumber() {
        return this.parentNumber;
    }

    public void setParentNumber(String parentNumber) {
        this.parentNumber = parentNumber;
    }

    public Jurisdicionado getJurisdicionado() {
        return this.jurisdicionado;
    }

    public void setJurisdicionado(Jurisdicionado jurisdicionado) {
        this.jurisdicionado = jurisdicionado;
    }

    public Status getStatus() {
        return this.status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

}

package dev.adrnmatos.backend.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Process {
    
    @Id
    @GeneratedValue(generator = "ID_GENERATOR")
    private Long id;
    
    @Column(unique=true)
    private String processNumber;

    private Type type;

    @OneToOne(
        fetch = FetchType.LAZY,
        optional = true,
        cascade = CascadeType.PERSIST
    )
    @JoinColumn(unique = false)
    private Process parent;
    
    private Jurisdicionado jurisdicionado;
    private Status status;
    
    public Long getId() {
        return this.id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
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
    
    public Process getParent() {
        return this.parent;
    }
    
    public void setParent(Process parent) {
        this.parent = parent;
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

    public enum Type {
        REPRESENTACAO("representacao", 15),
        RECURSO("recurso", 5);

        private String typeName;
        private int deadline;

        Type(String typeName, int deadline) {
            this.typeName = typeName;
            this.deadline = deadline;
        }

        public String getTypeName() {
            return typeName;
        }

        public int getDeadline() {
           return deadline; 
        }
    }

    public enum Status {
        ATIVO,
        INATIVO
    }
    
}

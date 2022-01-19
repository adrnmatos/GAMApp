package dev.adrnmatos.backend.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "Servidor", uniqueConstraints = {
    @UniqueConstraint(name="uniqueEmailAndEhAtivo", columnNames = {"email", "ehAtivo"})
})
public class User {

    @Id
    @GeneratedValue(generator = "ID_GENERATOR")
    private Long id;

    @Column(length = 50)
    private String name;

    @Column(unique=true)
    private String matricula;

    private LocalDate dataAdmissao;

    private String email;

    private String telefone;

    private boolean ehAtivo;

    @Enumerated(EnumType.STRING)
    private Cargo cargo;

    @Enumerated(EnumType.STRING)
    private Funcao funcao;

    @Enumerated(EnumType.STRING)
    private Formacao formacao;

    // private List <String> interesses = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public LocalDate getDataAdmissao() {
        return dataAdmissao;
    }

    public void setDataAdmissao(LocalDate dataAdmissao) {
        this.dataAdmissao = dataAdmissao;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public boolean getEhAtivo() {
        return ehAtivo;
    }

    public void setEhAtivo(boolean ehAtivo) {
        this.ehAtivo = ehAtivo;
    }

    public Cargo getCargo() {
        return cargo;
    }

    public void setCargo(Cargo cargo) {
        this.cargo = cargo;
    }

    public Funcao getFuncao() {
        return funcao;
    }

    public void setFuncao(Funcao funcao) {
        this.funcao = funcao;
    }

    public Formacao getFormacao() {
        return formacao;
    }

    public void setFormacao(Formacao formacao) {
        this.formacao = formacao;
    }

    // public List<String> getInteresses() {
    //     return interesses;
    // }

    // public void setInteresses(List<String> interesses) {
    //     this.interesses = interesses;
    // }

    //enums

    @Override
    public String toString() {
        return "User [name=" + this.name + ", id=" + this.name + "]";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null)
            return false;
        if (getClass() != o.getClass())
            return false;
        User other = (User) o;
        if (id == null) {
            return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        return 29;
    }

    public enum Cargo {
        SERVIDOR,
        ESTAGIARIO;
    }

    public enum Funcao {
        DIRETOR,
        GAM,
        AUDITOR,
        ESTAGIARIO;
    }

    public enum Formacao {
        CIVIL,
        ELETRICISTA,
        MECANCO;
    }
}


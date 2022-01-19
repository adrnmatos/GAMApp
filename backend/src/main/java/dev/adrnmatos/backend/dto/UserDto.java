package dev.adrnmatos.backend.dto;

import java.time.LocalDate;

import javax.validation.constraints.Email;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import dev.adrnmatos.backend.model.User.Cargo;
import dev.adrnmatos.backend.model.User.Formacao;
import dev.adrnmatos.backend.model.User.Funcao;
import lombok.Data;

@Data
public class UserDto {

    @Size(min=3, max=30)
    private String name;
    private String matricula;
    @PastOrPresent
    private LocalDate dataAdmissao;
    @Email(regexp=".+@tce.am.gov.br", message="apenas emails no dominio tce.am.gov.br")
    private String email;
    @Pattern(regexp="0[0-9]{2}9?[8-9][0-9]{7}")
    private String telefone;
    private boolean ehAtivo;
    private Cargo cargo;
    private Funcao funcao;
    private Formacao formacao;

}

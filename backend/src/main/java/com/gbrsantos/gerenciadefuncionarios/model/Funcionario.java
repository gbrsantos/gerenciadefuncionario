package com.gbrsantos.gerenciadefuncionarios.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Funcionario implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable = false)
    private Long id;
    private String nome;
    private String cargo;
    private String email;
    private String telefone;
    private String imageUrl;
    @Column(nullable = false, updatable = false)
    private String codigoFuncionario;

    public Funcionario() {
    }

    public Funcionario(Long id, String nome, String cargo, String email, String telefone, String imageUrl, String codigoFuncionario) {
        this.id = id;
        this.nome = nome;
        this.cargo = cargo;
        this.email = email;
        this.telefone = telefone;
        this.imageUrl = imageUrl;
        this.codigoFuncionario = codigoFuncionario;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
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

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getCodigoFuncionario() {
        return codigoFuncionario;
    }

    public void setCodigoFuncionario(String codigoFuncionario) {
        this.codigoFuncionario = codigoFuncionario;
    }
}

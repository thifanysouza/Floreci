package com.api.florecicontrol.models;

import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name="TB_FLORECI")
public class FloreciModel implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    @Column(nullable = false, unique = true, length = 10)
    private String tipoDePlanta;
    @Column(nullable = false, unique = true, length = 10)
    private String mesDePlantacao;
    @Column(nullable = false, length = 10)
    private String expectativaColheita;
    @Column(nullable = false, length = 5)
    private int numeroDeMudas;
    @Column(nullable = false, length = 10)
    private String nomeDaPlanta;
    @Column(nullable = false)
    private LocalDateTime registrationDate;



    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getTipoDePlanta() {
        return tipoDePlanta;
    }

    public void setTipoDePlanta(String tipoDePlanta) {
        this.tipoDePlanta = tipoDePlanta;
    }

    public String getMesDePlantacao() {
        return mesDePlantacao;
    }

    public void setMesDePlantacao(String mesDePlantacao) {
        this.mesDePlantacao = mesDePlantacao;
    }

    public String getExpectativaColheita() {
        return expectativaColheita;
    }

    public void setExpectativaColheita(String expectativaColheita) {
        this.expectativaColheita = expectativaColheita;
    }

    public int getNumeroDeMudas() {
        return numeroDeMudas;
    }

    public void setNumeroDeMudas(int numeroDeMudas) {
        this.numeroDeMudas = numeroDeMudas;
    }

    public String getNomeDaPlanta() {
        return nomeDaPlanta;
    }

    public void setNomeDaPlanta(String nomeDaPlanta) {
        this.nomeDaPlanta = nomeDaPlanta;
    }

    public LocalDateTime getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(LocalDateTime registrationDate) {
        this.registrationDate = registrationDate;
    }
}

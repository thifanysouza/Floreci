package com.api.florecicontrol.Dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;


public class FloreciDto {

    @NotBlank
    @Size(max = 10 )
    private String tipoDePlanta;
    @NotBlank
    @Size(max =10)
    private String mesDePlantacao;
    @NotBlank
    @Size(max =10)
    private String expectativaColheita;
    @NotBlank
    @Size(max =5)
    private int numeroDeMudas;
    @NotBlank
    @Size(max =10)
    private String nomeDaPlanta;


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
}

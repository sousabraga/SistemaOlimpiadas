/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.estacio.sistemaolimpiada.util;

/**
 *
 * @author Matheus Braga
 * @author João Lucas
 * @author Felipe Bruno
 */
public class EsporteComMedalhas implements Comparable<EsporteComMedalhas> {

    private String nome;
    
    private int medalhasOuro;
    
    private int medalhasPrata;
    
    private int medalhasBronze;

    private int totalMedalhas;
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getMedalhasOuro() {
        return medalhasOuro;
    }

    public void setMedalhasOuro(int medalhasOuro) {
        this.medalhasOuro = medalhasOuro;
    }

    public int getMedalhasPrata() {
        return medalhasPrata;
    }

    public void setMedalhasPrata(int medalhasPrata) {
        this.medalhasPrata = medalhasPrata;
    }

    public int getMedalhasBronze() {
        return medalhasBronze;
    }

    public void setMedalhasBronze(int medalhasBronze) {
        this.medalhasBronze = medalhasBronze;
    }
    
    public int getTotalMedalhas() {
        return medalhasOuro + medalhasPrata + medalhasBronze;
    }
    
    @Override
    public int compareTo(EsporteComMedalhas outroEsporteComMedalhas) {
        if (this.getTotalMedalhas() < outroEsporteComMedalhas.getTotalMedalhas())
            return 1;
        else if (this.getTotalMedalhas() > outroEsporteComMedalhas.getTotalMedalhas())
            return -1;
        else 
            return 0;
    }
}

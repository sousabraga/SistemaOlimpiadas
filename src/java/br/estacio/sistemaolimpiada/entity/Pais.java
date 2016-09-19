/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.estacio.sistemaolimpiada.entity;

/**
 *
 * @author Matheus Braga
 * @author João Lucas
 * @author Felipe Bruno
 */
public class Pais implements Comparable<Pais> {
    
    private long codigo;
    
    private String nome;
    
    private int qtdMedalhas;
    
    private int qtdMedalhasOuro;
    
    private int qtdMedalhasPrata;
    
    private int qtdMedalhasBronze;
    
    public long getCodigo() {
        return codigo;
    }
    
    public void setCodigo(long codigo) {
        this.codigo = codigo;
    }
    
    public String getNome() {
        return nome;
    }
    
    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public int getQtdMedalhas() {
        return qtdMedalhas;
    }
    
    public void setQtdMedalhas(int qtdMedalhas) {
        this.qtdMedalhas = qtdMedalhas;
    }

    public int getQtdMedalhasOuro() {
        return qtdMedalhasOuro;
    }

    public void setQtdMedalhasOuro(int qtdMedalhasOuro) {
        this.qtdMedalhasOuro = qtdMedalhasOuro;
    }

    public int getQtdMedalhasPrata() {
        return qtdMedalhasPrata;
    }

    public void setQtdMedalhasPrata(int qtdMedalhasPrata) {
        this.qtdMedalhasPrata = qtdMedalhasPrata;
    }

    public int getQtdMedalhasBronze() {
        return qtdMedalhasBronze;
    }

    public void setQtdMedalhasBronze(int qtdMedalhasBronze) {
        this.qtdMedalhasBronze = qtdMedalhasBronze;
    }
    
    @Override
    public int compareTo(Pais outroPais) {
        if (this.getQtdMedalhas() < outroPais.getQtdMedalhas())
            return 1;
        else if (this.qtdMedalhas > outroPais.getQtdMedalhas())
            return -1;
        else 
            return 0;
    }
    
}

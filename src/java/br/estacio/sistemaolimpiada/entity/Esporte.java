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

public class Esporte {
    
    private long codigo;
    
    private String nome;
    
    public void setCodigo(long codigo) {
        this.codigo = codigo;
    }
    
    public long getCodigo() {
        return codigo;
    }
    
    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public String getNome() {
        return nome;
    }
    
}

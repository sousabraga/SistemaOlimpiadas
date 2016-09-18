/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.estacio.sistemaolimpiada.entity;

/**
 *
 * @author matheus
 */
public enum Medalha {
    
    OURO(1, "Ouro"), PRATA(2, "Prata"), BRONZE(3, "Bronze");
    
    private final int codigo;
    private final String descricao;
    
    Medalha(int codigo, String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }
    
    public int getCodigo() {
        return codigo;
    }
    
    public String getDescricao() {
        return descricao;
    }
   
}

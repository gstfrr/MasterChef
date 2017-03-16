/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufla.dcc.masterchef;

/**
 *
 * @author aluno
 */
public class ItemDaReceita {

    private Ingrediente ingrediente;
    private double quantidade;

    public ItemDaReceita(Ingrediente ingrediente, double quantidade) {
        this.ingrediente = ingrediente;
        this.quantidade = quantidade;
    }

    public double obterCustoItem() {
        return quantidade * ingrediente.getValor();
    }

    public Ingrediente getIngrediente() {
        return ingrediente;
    }

    public double getQuantidade() {
        return quantidade;
    }

}

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
public class Ingrediente {

    private String nome;
    private String desc;
    private String unidade;
    private double valor;

    public Ingrediente(String nome, String desc, String unidade, double valor) {
        this.nome = nome;
        this.desc = desc;
        this.unidade = unidade;
        this.valor = valor;
    }

    public String getNome() {
        return nome;
    }

    public String getDesc() {
        return desc;
    }

    public String getUnidade() {
        return unidade;
    }

    public double getValor() {
        return valor;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public void setUnidade(String unidade) {
        this.unidade = unidade;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

}

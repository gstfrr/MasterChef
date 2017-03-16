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
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Receita {

    private String titulo;
    private String modoPreparo;
    private double rendimento;
    private ArrayList<ItemDaReceita> itens;

    public Receita(String titulo, double rendimento) {
        this.titulo = titulo;
        this.rendimento = rendimento;
        this.itens = new ArrayList<ItemDaReceita>();
    }

    public double obterValorTotal() {
        double soma = 0.0;
        for (ItemDaReceita idr : itens) {
            soma = soma + idr.obterCustoItem();
        }
        return soma;
    }

    public double obterValorPorPorcao() {
        return (obterValorTotal() / rendimento);
    }

    public void setModoPreparo(String modoPreparo) {
        this.modoPreparo = modoPreparo;
    }

    public void adicionarItem(ItemDaReceita idr) {
        itens.add(idr);
    }

    public List<ItemDaReceita> getItens() {
        // Torna a lista de itens da receita não-modificável.
        return Collections.unmodifiableList(itens);
    }

    public String getTitulo() {
        return titulo;
    }

    public String getModoPreparo() {
        return modoPreparo;
    }

    public double getRendimento() {
        return rendimento;
    }

}

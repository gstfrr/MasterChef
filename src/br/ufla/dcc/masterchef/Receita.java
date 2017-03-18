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
import java.util.List;

public class Receita {

    private String titulo;
    private String modoPreparo;
    private double rendimento;
    private ArrayList<ItemDaReceita> itens;

    public Receita(String titulo, double rendimento) {
        this.titulo = titulo;
        this.rendimento = rendimento;
        this.itens = new ArrayList<>();
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

    public void removerItem(String nome) {
        List itens;
        itens = getItens();
        for (int i = 0; i < itens.size(); i++) {
            Receita r = (Receita) itens.get(i);
            if (r.getTitulo().contains(nome)) {
                itens.remove(i);
            }
        }
    }

    public void alterarItem (String nome, double qtd) {
        List itens;
        itens = getItens();
        for (int i = 0; i < itens.size(); i++) {
            Receita r = (Receita) itens.get(i);
            if (r.getTitulo().contains(nome)) {
                ((ItemDaReceita) itens.get(i)).setQuantidade(qtd);
            }
        }
    }

    public List<ItemDaReceita> getItens() {
        // Torna a lista de itens da receita não-modificável.
        //return Collections.unmodifiableList(itens);
        return itens;
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
    
    
    
    
    ////////////temporário
        public void ImprimirReceita() {
        System.out.printf("Receita: %s\nIngrediente(s):\n",
                this.getTitulo());
        this.getItens().stream().forEach((idr) -> {
            System.out.printf("\t%.2f %s de %s (R$ %.2f)\n", idr.getQuantidade(),
                    idr.getIngrediente().getUnidade(),
                    idr.getIngrediente().getNome(),
                    idr.obterCustoItem());
        });
        System.out.printf("Modo de preparo: %s\nRendimento: %.2f porção(ões)\n",
                this.getModoPreparo(), this.getRendimento());
        System.out.printf("Valor total da receita: R$ %.2f\nValor por porção: R$ %.2f\n",
                this.obterValorTotal(), this.obterValorPorPorcao());
    }

}

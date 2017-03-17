/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufla.dcc.masterchef;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author aluno
 */
public class Principal {

    private static HashMap<String, Ingrediente> ingredientes;
    

    public static void main(String[] args) {

        ingredientes = new HashMap<>();

        getIngredientes().put("miojo",new Ingrediente("Macarrão instantâneo", "", "Pacote", 1.10));
        getIngredientes().put("queijo", new Ingrediente("Muçarela", "", "gramas", 0.075));
        getIngredientes().put("presunto", new Ingrediente("Presunto", "", "gramas", 0.016));
        getIngredientes().put("egg", new Ingrediente("Ovo", "", "unidade", 0.1));
        getIngredientes().put("farinha", new Ingrediente("Polvilho", "", "grama", 0.003));
        getIngredientes().put("leite", new Ingrediente("Leite", "", "litro", 5.8));

        Usuario u1 = new Usuario("Augusto Ferreira", "augusto", "1234");

        u1.CadastrarReceita();

        //listar receitas
        List receitas = u1.GetReceitas();
        System.out.println("\n" + receitas.size() + " receitas:");
        for (int i = 0; i < receitas.size(); i++) {
            Receita r = (Receita) receitas.get(i);
            System.out.println(r.getTitulo());
        }

        //u1.BuscarReceita("POO");
        //u1.ImprimirReceita(u1.BuscarReceita("POO"));
        u1.RemoverReceita("POO");

        System.out.println("\n" + receitas.size() + " receitas:");
        for (int i = 0; i < receitas.size(); i++) {
            Receita r = (Receita) receitas.get(i);
            System.out.println(r.getTitulo());
        }

        u1.RemoverReceita("Miojo");

        System.out.println("\n" + receitas.size() + " receitas:");
        for (int i = 0; i < receitas.size(); i++) {
            Receita r = (Receita) receitas.get(i);
            System.out.println(r.getTitulo());
        }

    }

    /**
     * @return the ingredientes
     */
    public static HashMap<String, Ingrediente> getIngredientes() {
        return ingredientes;
    }

}

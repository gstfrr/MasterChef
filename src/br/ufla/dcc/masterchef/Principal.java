/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufla.dcc.masterchef;

import java.util.List;

/**
 *
 * @author aluno
 */
public class Principal {

    public static void main(String[] args) {

        Usuario u1 = new Usuario("augusto", "1234");

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

}

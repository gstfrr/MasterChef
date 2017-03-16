package br.ufla.dcc.masterchef;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Usuario {

    private String Nome;
    private String Senha;
    private String Login;
    private ArrayList<Receita> receitas;

    public Usuario(String Nome, String Senha, String Login) {
        this.Nome = Nome;
        this.Senha = Senha;
        this.Login = Login;
    }

    public void CadastrarReceita(Receita r) {
        receitas.add(r);
    }

    public void RemoverReceita() {

    }

    public void EditarReceita() {

    }

    public void BuscarReceita() {

    }

    public List<Receita> ListarReceitas() {
        return Collections.unmodifiableList(receitas);
    }

    public void ExibirReceita(Receita receita) {
        System.out.printf("Receita: %s\nIngrediente(s):\n",
                receita.getTitulo());
        for (ItemDaReceita idr : receita.getItens()) {
            System.out.printf("\t%.2f %s de %s (R$ %.2f)\n", idr.getQuantidade(),
                    idr.getIngrediente().getUnidade(),
                    idr.getIngrediente().getNome(),
                    idr.obterCustoItem());
        }
        System.out.printf("Modo de preparo: %s\nRendimento: %.2f porção(ões)\n",
                receita.getModoPreparo(), receita.getRendimento());
        System.out.printf("Valor total da receita: R$ %.2f\nValor por porção: R$ %.2f\n",
                receita.obterValorTotal(), receita.obterValorPorPorcao());
    }

}

package br.ufla.dcc.masterchef;

import java.util.ArrayList;
import java.util.List;

public class Usuario {

    private String Nome;
    private String Login;
    private String Senha;

    private ArrayList<Receita> receitas = new ArrayList<Receita>();

    public Usuario(String Nome, String Login, String Senha) {
        this.Nome = Nome;
        this.Login = Login;
        this.Senha = Senha;
    }

    public void CadastrarReceita() {
        Ingrediente i1 = new Ingrediente("Macarrão instantâneo", "", "Pacote", 1.10);
        Ingrediente i2 = new Ingrediente("Muçarela", "", "gramas", 0.075);
        Ingrediente i3 = new Ingrediente("Presunto", "", "gramas", 0.016);
        Ingrediente i4 = new Ingrediente("Ovo", "", "unidade", 0.1);
        Ingrediente i5 = new Ingrediente("Polvilho", "", "grama", 0.003);
        Ingrediente i6 = new Ingrediente("Leite", "", "litro", 5.8);

        Receita r = new Receita("Miojo gourmet", 1);
        r.setModoPreparo("Cozinhe o macarrão por 3 minutos. Escorra-o, tempere com o tempero\npronto e adicione presunto e muçarela cortados em cubos.");
        r.adicionarItem(new ItemDaReceita(i1, 1));
        r.adicionarItem(new ItemDaReceita(i2, 50));
        r.adicionarItem(new ItemDaReceita(i3, 50));
        receitas.add(r);

        Receita r1 = new Receita("Pão-de-queijo POO", 30);
        r1.setModoPreparo("Misture tudo e ponha para assar em forno pré-aquecido a 120 graus.");
        r1.adicionarItem(new ItemDaReceita(i2, 800));
        r1.adicionarItem(new ItemDaReceita(i4, 3));
        r1.adicionarItem(new ItemDaReceita(i5, 500));
        r1.adicionarItem(new ItemDaReceita(i6, 0.2));
        receitas.add(r1);
    }

    public void RemoverReceita(String nome) {
        List receitaTemp;
        receitaTemp = GetReceitas();
        for (int i = 0; i < receitaTemp.size(); i++) {
            Receita r = (Receita) receitaTemp.get(i);
            if (r.getTitulo().contains(nome)) {
                receitaTemp.remove(i);
            }
        }
    }

    public void EditarReceita() {

    }

    public Receita BuscarReceita(String nome) {
        List receitas = GetReceitas();
        for (int i = 0; i < receitas.size(); i++) {
            Receita r = (Receita) receitas.get(i);
            if (r.getTitulo().toString().contains(nome)) {
                return r;
            }
        }
        return null; //tratar exceção
    }

    public List<Receita> GetReceitas() {
        //return Collections.unmodifiableList(receitas);
        return receitas;
    }

    public void ImprimirReceita(Receita receita) {
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

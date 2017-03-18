package br.ufla.dcc.masterchef;

import java.util.ArrayList;
import java.util.List;

public class Usuario {

    private String Nome;
    private String Login;
    private String Senha;

    private ArrayList<Receita> receitas = new ArrayList<>();

    public Usuario(String Nome, String Login, String Senha) {
        this.Nome = Nome;
        this.Login = Login;
        this.Senha = Senha;
    }

    public void CadastrarReceita() {
        

        Receita r = new Receita("Miojo gourmet", 1);
        r.setModoPreparo("Cozinhe o macarrão por 3 minutos. Escorra-o, tempere com o tempero\npronto e adicione presunto e muçarela cortados em cubos.");
        r.adicionarItem(new ItemDaReceita(Principal.getIngredientes().get("miojo"), 1));
        r.adicionarItem(new ItemDaReceita(Principal.getIngredientes().get("muçarela"), 50));
        r.adicionarItem(new ItemDaReceita(Principal.getIngredientes().get("presunto"), 50));
        receitas.add(r);

        Receita r1 = new Receita("Pão-de-queijo POO", 30);
        r1.setModoPreparo("Misture tudo e ponha para assar em forno pré-aquecido a 120 graus.");
        r1.adicionarItem(new ItemDaReceita(Principal.getIngredientes().get("muçarela"), 800));
        r1.adicionarItem(new ItemDaReceita(Principal.getIngredientes().get("ovo"), 3));
        r1.adicionarItem(new ItemDaReceita(Principal.getIngredientes().get("polvilho"), 500));
        r1.adicionarItem(new ItemDaReceita(Principal.getIngredientes().get("leite"), 0.2));
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
        List tempReceitas = GetReceitas();
        for (int i = 0; i < tempReceitas.size(); i++) {
            Receita r = (Receita) tempReceitas.get(i);
            if (r.getTitulo().contains(nome)) {
                return r;
            }
        }
        return null; //tratar exceção
    }

    public List<Receita> GetReceitas() {
        //return Collections.unmodifiableList(receitas);
        return receitas;
    }


}

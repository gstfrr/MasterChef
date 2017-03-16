package br.ufla.dcc.masterchef.gui;

import br.ufla.dcc.masterchef.imagens.GerenciadorDeImagens;
import br.ufla.dcc.masterchef.seguranca.SessaoUsuario;
import br.ufla.dcc.masterchef.util.Utilidades;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JRootPane;

/**
 * Classe que representa a Tela Principal
 * @author Julio
 */
public class TelaPrincipal {

    // objeto de controle de sessão (autenticação) do usuário
    private final SessaoUsuario sessaoUsuario;
    // tela de autenticação (login) de usuário
    private final TelaAutenticacao telaAutenticacao;
    // tela de cadastro de usuário
    private final TelaCadastroUsuario telaCadastroUsuario;
    // tela de gestão dos filmes
    //private final TelaMeusFilmes telaMeusFilmes;

    // janela da tela principal
    private JFrame janela;

    // Menus principais da tela    
    private JMenuBar menuPrincipal;
    private JMenu menuInicio;
    private JMenu menuAjuda;

    // Submenus da tela
    private JMenuItem menuEntrar;
    private JMenuItem menuCadastrarUsuario;
    private JMenuItem menuSair;
    private JMenuItem menuSobre;

    // Itens de menu específicos para usuários logados no sistema    
    private JMenuItem menuLogout;
    private JMenuItem menuMeusFilmes;

    /**
     * Construtor; incializa as demais telas e sessão de usuário.
     */
    public TelaPrincipal() {
        telaAutenticacao = new TelaAutenticacao(this);
        telaCadastroUsuario = new TelaCadastroUsuario(this);
        //telaMeusFilmes = new TelaMeusFilmes(this);
        sessaoUsuario = SessaoUsuario.obterInstancia();
    }

    /**
     * Inicializa a tela
     */
    public void inicializar() {
        // Serve para o caso em que o usuário
        // decidiu mudar o idioma da aplicação.
        if (janela != null) {
            janela.dispose();
        }
        construirTela();
        configurarEventosTela();
        exibirTela();
    }

    /**
     * Configura os eventos da tela.
     */
    private void configurarEventosTela() {
        menuSair.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (Utilidades.msgConfirmacao("I18N.obterConfirmacaoSaida()")) {
                    System.exit(0);
                }
            }
        });

        menuEntrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                telaAutenticacao.inicializar();
            }
        });

        menuLogout.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sessaoUsuario.invalidarSessao();
                inicializar();
            }
        });

        menuCadastrarUsuario.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                telaCadastroUsuario.inicializar();
            }
        });

        menuSobre.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Utilidades.msgInformacao("I18N.obterMensagemSobre()");
            }
        });

        janela.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                if (Utilidades.msgConfirmacao("I18N.obterConfirmacaoSaida()")) {
                    System.exit(0);
                }
            }
        });
    }

    /**
     * Contrói o Menu Início, trata internacionalização
     */
    private void construirMenuInicio() {
        menuInicio = new JMenu("I18N.obterMenuInicio()");
        menuEntrar = new JMenuItem("I18N.obterMenuEntrar()", GerenciadorDeImagens.ENTRAR);
        menuCadastrarUsuario = new JMenuItem("I18N.obterMenuCadastrarUsuario()", GerenciadorDeImagens.CADASTRAR_USUARIO);
        menuLogout = new JMenuItem("I18N.obterMenuLogout()", GerenciadorDeImagens.LOGOUT);
        menuMeusFilmes = new JMenuItem("I18N.obterMenuMeusFilmes()", GerenciadorDeImagens.MEUS_FILMES);

        if (!sessaoUsuario.estahLogado()) {
            menuInicio.add(menuEntrar);
            menuInicio.add(menuCadastrarUsuario);
        } else {            
            // Aqui você poderá adicionar outros itens de menu, se necessário.
            
            menuInicio.add(menuMeusFilmes);
            menuInicio.add(menuLogout);
        }

        menuSair = new JMenuItem("I18N.obterMenuSair()", GerenciadorDeImagens.SAIR);
        menuInicio.addSeparator();
        menuInicio.add(menuSair);
        menuPrincipal.add(menuInicio);
    }

    /**
     * Constrói o menu Ajuda, trata internacionalização.
     */
    private void construirMenuAjuda() {
        menuAjuda = new JMenu("I18N.obterMenuAjuda()");
        menuSobre = new JMenuItem("Obter menu sobre", GerenciadorDeImagens.SOBRE);
        menuAjuda.add(menuSobre);
        menuPrincipal.add(menuAjuda);
    }

    /**
     * Constrói o menu Usuário, trata internacionalização.
     */
    private void construirMenuUsuario() {
        menuPrincipal = new JMenuBar();
        construirMenuInicio();
        
        if (sessaoUsuario.estahLogado()) {
             // Aqui você poderá adicionar outros menus adequados
             // ao seu projeto que serão exibidos quando o
             // usuário estiver logado no sistema.
         }        
        
        construirMenuAjuda();
        janela.setJMenuBar(menuPrincipal);
    }

    /**
     * Constrói a tela.
     */
    private void construirTela() {
        janela = new JFrame("Minhas Receitas");
        janela.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        construirMenuUsuario();
    }

    /**
     * Exibe a tela.
     */
    private void exibirTela() {
        janela.setExtendedState(JFrame.MAXIMIZED_BOTH);
        
        // Permite que apenas o botão de fechar esteja disponível na janela.        
        janela.setUndecorated(true);
        janela.getRootPane().setWindowDecorationStyle(JRootPane.PLAIN_DIALOG);
        
        janela.setVisible(true);
    }

    /**
     * Método main, inicializa o programa.
     * 
     * @param args Argumentos passados na execução do programa.
     */
    public static void main(String[] args) {
        new TelaPrincipal().inicializar();
    }

    /**
     * Retorna uma referência para a janela
     * 
     * @return 
     */
    public JFrame obterJanela() {
        return this.janela;
    }

}
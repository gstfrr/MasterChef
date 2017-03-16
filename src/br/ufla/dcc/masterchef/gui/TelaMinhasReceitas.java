package br.ufla.dcc.masterchef.gui;

import br.ufla.dcc.masterchef.imagens.GerenciadorDeImagens;
import br.ufla.dcc.masterchef.util.Utilidades;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 * Classe que representa a tela Meus Receitas
 * 
 * @author Julio Alves e Paulo Jr.
 */
public class TelaMinhasReceitas {

    // referência para a tela principal
    private final TelaPrincipal telaPrincipal;
            
    // componentes da tela
    private JDialog janela;
    private GridBagLayout layout;
    private GridBagConstraints gbc;
    private JButton btnNovaReceita;
    private JButton btnEditarReceita;
    private JButton btnDeletarReceita;
    private JButton btnSalvarReceita;
    private JButton btnCancelar;
    private JTable tbReceitas;
    private JLabel lbTitulos;
    private JLabel lbRendimento;
    private JLabel lbModoDePreparo;
    private JTextField txtTitulo;
    private JTextField txtRendimento;
    private JTextArea taModoDePreparo;

     /**
     * Constrói a tela Meus Receitas guardando a referência da tela principal.
     * 
     * @param telaPrincipal Referência da tela principal.
     */
    public TelaMinhasReceitas(TelaPrincipal telaPrincipal) {
        this.telaPrincipal = telaPrincipal;
    }

    /**
     * Inicializa a tela, construindo seus componentes, configurando os eventos
     * e, ao final, exibe a tela.
     */
    public void inicializar() {
        construirTela();
        configurarEventosTela();
        exibirTela();
    }

    /**
     * Constrói a janela tratando internacionalização, componentes e layout.
     */
    private void construirTabela() {
        Object[] titulosColunas = {
            "I18N.obterRotuloReceitaNome()"
        };

        // Dados "fake"
        Object[][] dados = {
            {"Gravidade"},
            {"Shrek"}
        };

        tbReceitas = new JTable(dados, titulosColunas);
        tbReceitas.setPreferredScrollableViewportSize(new Dimension(500, 70));
        tbReceitas.setFillsViewportHeight(true);
    }

    /**
     * Adiciona um componente à tela.
     */
    private void adicionarComponente(Component c,
            int anchor, int fill, int linha,
            int coluna, int largura, int altura) {
        gbc.anchor = anchor;
        gbc.fill = fill;
        gbc.gridy = linha;
        gbc.gridx = coluna;
        gbc.gridwidth = largura;
        gbc.gridheight = altura;
        gbc.insets = new Insets(5, 5, 5, 5);
        layout.setConstraints(c, gbc);
        janela.add(c);
    }

    /**
     * Trata o estado inicial da tela
     */
    private void prepararComponentesEstadoInicial() {
        tbReceitas.clearSelection();
        tbReceitas.setEnabled(true);

        txtTitulo.setText("");
        txtRendimento.setText("");
        taModoDePreparo.setText("");

        txtTitulo.setEditable(false);
        txtRendimento.setEditable(false);
        taModoDePreparo.setEditable(false);

        btnNovaReceita.setEnabled(true);
        btnEditarReceita.setEnabled(false);
        btnSalvarReceita.setEnabled(false);
        btnDeletarReceita.setEnabled(false);
        btnCancelar.setEnabled(true);
    }

    /**
     * Trata o estado da tela para seleção de filmes
     */
    private void prepararComponentesEstadoSelecaoReceita() {
        txtTitulo.setEditable(false);
        txtRendimento.setEditable(false);
        taModoDePreparo.setEditable(false);

        btnNovaReceita.setEnabled(true);
        btnEditarReceita.setEnabled(true);
        btnSalvarReceita.setEnabled(false);
        btnDeletarReceita.setEnabled(true);
        btnCancelar.setEnabled(true);
    }

    /**
     * Trata o estado da tela para cadastro de novo filme
     */
    private void prepararComponentesEstadoNovoReceita() {
        tbReceitas.clearSelection();
        tbReceitas.setEnabled(false);

        txtTitulo.setText("");
        txtRendimento.setText("");
        taModoDePreparo.setText("");

        txtTitulo.setEditable(true);
        txtRendimento.setEditable(true);
        taModoDePreparo.setEditable(true);

        btnNovaReceita.setEnabled(false);
        btnEditarReceita.setEnabled(false);
        btnSalvarReceita.setEnabled(true);
        btnDeletarReceita.setEnabled(false);
        btnCancelar.setEnabled(true);
    }

    /**
     * Trata o estado da tela para cadastro receita editada
     */
    private void prepararComponentesEstadoEditouReceita() {
        tbReceitas.setEnabled(false);

        txtTitulo.setEditable(true);
        txtRendimento.setEditable(true);
        taModoDePreparo.setEditable(true);

        btnNovaReceita.setEnabled(false);
        btnEditarReceita.setEnabled(false);
        btnSalvarReceita.setEnabled(true);
        btnDeletarReceita.setEnabled(false);
        btnCancelar.setEnabled(true);
    }

    /**
     * Adiciona os componentes da tela tratando layout e internacionalização
     */
    private void adicionarComponentes() {
        construirTabela();
        JScrollPane scrollPaneTabela = new JScrollPane(tbReceitas);
        adicionarComponente(scrollPaneTabela,
                GridBagConstraints.CENTER,
                GridBagConstraints.NONE,
                0, 0, 4, 1);

        lbTitulos = new JLabel("I18N.obterRotuloReceitaNome()");
        adicionarComponente(lbTitulos,
                GridBagConstraints.LINE_END,
                GridBagConstraints.NONE,
                1, 0, 1, 1);

        txtTitulo= new JTextField(25);
        adicionarComponente(txtTitulo,
                GridBagConstraints.LINE_START,
                GridBagConstraints.HORIZONTAL,
                1, 1, 3, 1);

        lbRendimento = new JLabel("I18N.obterRotuloReceitaRendimento()");
        adicionarComponente(lbRendimento,
                GridBagConstraints.LINE_END,
                GridBagConstraints.NONE,
                3, 0, 1, 1);

        txtRendimento = new JTextField(8);
        adicionarComponente(txtRendimento,
                GridBagConstraints.LINE_START,
                GridBagConstraints.HORIZONTAL,
                3, 1, 1, 1);

        lbModoDePreparo = new JLabel("I18N.obterRotuloReceitaModoDePreparo()");
        adicionarComponente(lbModoDePreparo,
                GridBagConstraints.LINE_END,
                GridBagConstraints.NONE,
                4, 0, 1, 1);

        taModoDePreparo = new JTextArea(7, 25);
        JScrollPane scrollPaneDescricao = new JScrollPane(taModoDePreparo,
                JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        adicionarComponente(scrollPaneDescricao,
                GridBagConstraints.LINE_START,
                GridBagConstraints.HORIZONTAL,
                4, 1, 3, 1);

        btnNovaReceita = new JButton("I18N.obterBotaoNovo()",
                GerenciadorDeImagens.NOVO);

        btnEditarReceita = new JButton("I18N.obterBotaoEditar()",
                GerenciadorDeImagens.EDITAR);

        btnSalvarReceita = new JButton("I18N.obterBotaoSalvar()",
                GerenciadorDeImagens.OK);

        btnDeletarReceita = new JButton("I18N.obterBotaoDeletar()",
                GerenciadorDeImagens.DELETAR);

        btnCancelar = new JButton("I18N.obterBotaoCancelar()",
                GerenciadorDeImagens.CANCELAR);

        prepararComponentesEstadoInicial();

        JPanel painelBotoes = new JPanel();
        painelBotoes.add(btnNovaReceita);
        painelBotoes.add(btnEditarReceita);
        painelBotoes.add(btnSalvarReceita);
        painelBotoes.add(btnDeletarReceita);
        painelBotoes.add(btnCancelar);

        adicionarComponente(painelBotoes,
                GridBagConstraints.CENTER,
                GridBagConstraints.NONE,
                6, 0, 4, 1);
    }

    /**
     * Trata a selação de filmes na grade.
     */
    private void selecionouReceita() {
        // Dados "fake"
        String texto = String.format("Linha selecionada: %d", tbReceitas.getSelectedRow());
        txtTitulo.setText(texto);
        txtRendimento.setText(texto);
        taModoDePreparo.setText(texto);
    }

    /**
     * Configura os eventos da tela.
     */
    private void configurarEventosTela() {
        btnCancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                janela.dispose();
            }
        });

        tbReceitas.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                prepararComponentesEstadoSelecaoReceita();
                selecionouReceita();
            }
        });

        btnEditarReceita.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                prepararComponentesEstadoEditouReceita();
            }
        });

        btnSalvarReceita.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                prepararComponentesEstadoInicial();
            }
        });

        btnNovaReceita.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                prepararComponentesEstadoNovoReceita();
            }
        });

        btnDeletarReceita.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (Utilidades.msgConfirmacao("I18N.obterConfirmacaoDeletar()")) {
                    // Remover filme!
                }
            }
        });
    }

    /**
     * Constrói a janela tratando internacionalização, componentes e layout.
     */
    private void construirTela() {
        janela = new JDialog();
        janela.setTitle("I18N.obterTituloTelaMinhasReceitas()");
        layout = new GridBagLayout();
        gbc = new GridBagConstraints();
        janela.setLayout(layout);
        adicionarComponentes();
        janela.pack();
    }

    /**
     * Exibe a tela.
     */
    private void exibirTela() {
        janela.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        janela.setLocationRelativeTo(telaPrincipal.obterJanela());
        janela.setModal(true);
        janela.setVisible(true);
        janela.setResizable(false);
    }
}

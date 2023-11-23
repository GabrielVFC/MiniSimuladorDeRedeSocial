package UI;

import dominio.Conta;
import dominio.Administrador;
import dominio.Usuario;
import facade.ContasFacade;
import facade.ContasFacadeImpl;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RedeSocialForm extends JFrame {

    private ContasFacade contasFacade = new ContasFacadeImpl();
    
    private RedeSocialForm that = this;
    private JPanel painel = new JPanel();
    private JButton jButtonCadastro = new JButton("Cadastre-se!");
    private JButton jButtonLogin = new JButton("Entrar!");

    private JanelaAmigoForm janelaAmigoForm = new JanelaAmigoForm();

    public RedeSocialForm() {
        this.setTitle("Mini simulador de rede social");
        this.setSize(400, 200);
        painel.setLayout(new FlowLayout(FlowLayout.CENTER, 100, 20));
        painel.setBackground(new Color(174, 88, 205));
        jButtonCadastro.setFont(new Font("Arial", 1, 16));
        jButtonCadastro.setForeground(new Color(0, 0, 0));
        jButtonCadastro.setRequestFocusEnabled(false);
        jButtonCadastro.setRolloverEnabled(false);
        painel.add(jButtonCadastro);
        
        jButtonCadastro.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nome = JOptionPane.showInputDialog(null, "Digite seu nome:");
                String email = JOptionPane.showInputDialog(null, "Digite seu email:");
                String senha = JOptionPane.showInputDialog(null, "Digite sua senha:");

                String eAdmin = JOptionPane.showInputDialog(null, "É uma conta administrativa? (Y/N)");

                Conta contaEncontrada = null;
                Conta contaParaCadastro = null;
                switch (eAdmin.toLowerCase()) {
                    case "y":
                        contaParaCadastro = new Administrador();
                        contaParaCadastro.setNome(nome);
                        contaParaCadastro.setEmail(email);
                        contaParaCadastro.setSenha(senha);

                        contaEncontrada = contasFacade.obterContaPorEmail(contaParaCadastro.getEmail());
                        break;
                    case "n":
                        contaParaCadastro = new Usuario();
                        contaParaCadastro.setNome(nome);
                        contaParaCadastro.setEmail(email);
                        contaParaCadastro.setSenha(senha);


                        contaEncontrada = contasFacade.obterContaPorEmail(contaParaCadastro.getEmail());
                        break;
                    default:
                        break;
                }

                if (contaEncontrada != null) {
                    if (!contaEncontrada.getEmail().equals(email)) {
                        contasFacade.cadastrarConta(contaParaCadastro);
                        JOptionPane.showMessageDialog(null, "Usuário cadastrado!");
                    } else {
                        JOptionPane.showMessageDialog(null, "Este e-mail ja existe!");
                    }
                } else {
                    contasFacade.cadastrarConta(contaParaCadastro);
                    JOptionPane.showMessageDialog(null, "Usuário cadastrado!");
                }
            }
        });

        jButtonLogin.setFont(new Font("Arial", 1, 16));
        jButtonLogin.setForeground(new Color(0, 0, 0));
        jButtonLogin.setRequestFocusEnabled(false);
        jButtonLogin.setRolloverEnabled(false);

        painel.add(jButtonLogin);

        jButtonLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String email = JOptionPane.showInputDialog(null, "Digite seu email:");
                String senha = JOptionPane.showInputDialog(null, "Digite sua senha:");

                Conta contaEncontrada = contasFacade.obterContaPorEmail(email);

                if (contaEncontrada != null) {
                    if (contaEncontrada.getSenha().equals(senha)) {
                        JOptionPane.showMessageDialog(null, "Logado com sucesso!");

                        janelaAmigoForm.setUsuarioLogado(contaEncontrada);
                        janelaAmigoForm.setUsuariosCadastrados(contasFacade.obterContas());
                        janelaAmigoForm.setRedeSocialForm(that);
                        janelaAmigoForm.setVisible(true);
                        setVisible(false);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Senha ou e-mail incorreta!");
                }
            }
        });

        this.getContentPane().add(painel);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        janelaAmigoForm.setVisible(false);
        this.setVisible(true);
    }


    public static void main(String[] args) {
        new RedeSocialForm();
    }
}

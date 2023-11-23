package UI;

import java.util.List;
import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import dominio.Administrador;
import dominio.Conta;
import java.awt.Font;

public class JanelaAmigoForm extends JFrame {
    private JPanel painel = new JPanel();

    private JButton jButtonListaDeAmigos = new JButton("Lista de Amigos!");
    private JButton jButtonAdicionarAmigo = new JButton("Adicionar amigo!");
    private JButton jButtonRemoverAmigo = new JButton("Remover amigo!");
    private JButton jButtonLoggout = new JButton("Sair da conta");

    // Atributos da tela anterior
    private RedeSocialForm redeSocialForm;
    private Conta usuarioLogado;
    private List<Conta> usuariosCadastrados;

    public JanelaAmigoForm() {
        this.setTitle("Instagram");
        this.setSize(800, 600);
        painel.setLayout(new FlowLayout(FlowLayout.CENTER, 100, 20));
        painel.setBackground(new Color(174, 88, 205));

        jButtonListaDeAmigos.setFont(new Font("Arial", 1, 16));
        jButtonListaDeAmigos.setForeground(new Color(0, 0, 0));
        jButtonListaDeAmigos.setRequestFocusEnabled(false);
        jButtonListaDeAmigos.setRolloverEnabled(false);
        painel.add(jButtonListaDeAmigos);

        jButtonListaDeAmigos.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                String amigos = "";
                for (Conta usuario : usuarioLogado.listaDeAmigos()) {
                    amigos += "\n" + usuario.getNome() + " - " + usuario.getTipo().getDescricao();
                }

                JOptionPane.showMessageDialog(null, "Lista de Amigos: %s".format(amigos));

            }

        });
        painel.add(jButtonAdicionarAmigo);

        jButtonAdicionarAmigo.setFont(new Font("Arial", 1, 16));
        jButtonAdicionarAmigo.setForeground(new Color(0, 0, 0));
        jButtonAdicionarAmigo.setRequestFocusEnabled(false);
        jButtonAdicionarAmigo.setRolloverEnabled(false);

        jButtonAdicionarAmigo.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                while (true) {
                    String amigo = JOptionPane.showInputDialog(null,
                            "Digite o nome do usuário para ser adicionado (Digite -1 para cancelar):");

                    Conta usuarioEncontrado = null;
                    for (Conta usuario : usuariosCadastrados) {
                        if (usuario.getNome().equals(amigo)) {
                            usuarioEncontrado = usuario;
                        }
                    }

                    if (usuarioEncontrado != null) {
                        if (!usuarioLogado.getEmail().equals(usuarioEncontrado.getEmail())) {
                            usuarioLogado.adicionarAmigo(usuarioEncontrado);
                            JOptionPane.showMessageDialog(null, "Usuário adicionado com sucesso!");
                        } else {
                            JOptionPane.showMessageDialog(null, "Você não pode adicionar a sí mesmo...");
                        }
                    } else {
                        if (amigo.equals("-1")) {
                            break;
                        } else {
                            JOptionPane.showMessageDialog(null, "Usuário não encontrado!");
                        }
                    }
                }
            }
        });
        painel.add(jButtonRemoverAmigo);

        jButtonRemoverAmigo.setFont(new Font("Arial", 1, 16));
        jButtonRemoverAmigo.setForeground(new Color(0, 0, 0));
        jButtonRemoverAmigo.setRequestFocusEnabled(false);
        jButtonRemoverAmigo.setRolloverEnabled(false);

        jButtonRemoverAmigo.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                while (true) {
                    String removerAmigo = JOptionPane.showInputDialog(null,
                            "Escreva o nome de usuário que deseja remover (Digite -1 para cancelar):");

                    Conta usuarioEncontrado = null;
                    for (Conta usuario : usuariosCadastrados) {
                        if (usuario.getNome().equals(removerAmigo)) {
                            usuarioEncontrado = usuario;
                        }
                    }

                    if (usuarioEncontrado != null) {
                        usuarioLogado.removerAmigo(usuarioEncontrado);
                        JOptionPane.showMessageDialog(null, "Usuário removido com sucesso!");
                    } else {
                        if (removerAmigo.equals("-1")) {
                            break;
                        } else {
                            JOptionPane.showMessageDialog(null, "Usuário não encontrado!");
                        }
                    }
                }

            }

        });


        painel.add(jButtonLoggout);

        jButtonLoggout.setFont(new Font("Arial", 1, 16));
        jButtonLoggout.setForeground(new Color(0, 0, 0));
        jButtonLoggout.setRequestFocusEnabled(false);
        jButtonLoggout.setRolloverEnabled(false);

        jButtonLoggout.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent arg0) {
                JOptionPane.showMessageDialog(null, "Desconectou-se da conta!");

                redeSocialForm.setVisible(true);
                setVisible(false);
            }

        });

        this.getContentPane().add(painel);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    public void setUsuarioLogado(Conta usuarioLogado) {
        this.usuarioLogado = usuarioLogado;
    }

    public void setRedeSocialForm(RedeSocialForm redeSocialForm) {
        this.redeSocialForm = redeSocialForm;
    }

    public void setUsuariosCadastrados(List<Conta> usuariosCadastrados) {
        this.usuariosCadastrados = usuariosCadastrados;
    }

}
